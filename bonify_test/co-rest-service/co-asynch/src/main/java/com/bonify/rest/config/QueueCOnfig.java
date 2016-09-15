package com.bonify.rest.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bonify.rest.model.ListenerProperties;
import com.bonify.rest.service.NewsServiceConsumer;
import com.cworks.persistence.entities.ChannelEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * This is Queuonfig
 * Created by cthammana on 14.09.2016.
 */
@Component
public class QueueConfig
{
	private ActiveMQConnectionFactory connectionFactory;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private RestTemplate restTemplate;

	private ExecutorService executors = Executors.newFixedThreadPool(10);

	/**
	 * If we want to make creation of queues more dynamic
	 * this could be helpful to make more queues
	 */
	@PostConstruct
	public void createDynamicQueue() throws InterruptedException, IOException
	{
		this.getChannels();
	}

	private void getChannels() throws InterruptedException, IOException
	{
		String json = this.restTemplate.getForObject("http://localhost:8080/channel/findall", String.class);
		List<ChannelEntity> list = new ObjectMapper()
			.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, ChannelEntity.class));
		this.invokeListners(list);
	}

	private void invokeListners(final List<ChannelEntity> channelEntities) throws InterruptedException
	{
		List<NewsServiceConsumer> consumers = this.createListenerProperties(channelEntities);
		this.executors.invokeAll(consumers);
	}

	@PreDestroy
	public void stop()
	{
		this.executors.shutdown();
	}

	private List<NewsServiceConsumer> createListenerProperties(final List<ChannelEntity> channelEntities)
	{
		List<NewsServiceConsumer> consumers = new ArrayList<>();
		for (ChannelEntity entity : channelEntities)
		{
			ListenerProperties listenerProperties = new ListenerProperties();
			listenerProperties.setChannelId(entity);
			listenerProperties.setQueueName(entity.getName());
			listenerProperties.setStop(false);
			listenerProperties.setThreadName("THREAD_" + entity.getName());
			NewsServiceConsumer newsServiceConsumer =(NewsServiceConsumer) this.applicationContext.getBean(NewsServiceConsumer.class);
			newsServiceConsumer.setListenerProperties(listenerProperties);
			consumers.add(newsServiceConsumer);
		}
		return consumers;
	}

	public static void main(String[] args) throws InterruptedException
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/async-context.xml");
	}

	@Autowired
	public void setConnectionFactory(ActiveMQConnectionFactory connectionFactory)
	{
		this.connectionFactory = connectionFactory;
	}
}