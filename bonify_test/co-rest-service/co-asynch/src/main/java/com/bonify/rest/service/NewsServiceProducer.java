package com.bonify.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cworks.persistence.entities.NewsEntity;

/**
 * This class is responsible for Providing data to this producer
 * Created by cthammana on 13.09.2016.
 */
@Component
@Configurable
@EnableAsync
@EnableScheduling
public class NewsServiceProducer
{

	private static final String NEWS_BERLIN = "NEWS_BERLIN";
	private static final String NEWS_BAMBERG = "NEWS_BAMBERG";
	private int i = 0;

	private JmsTemplate jmsTemplate;

	/**
	 * Empty constructor
	 */
	public NewsServiceProducer()
	{

	}

	private NewsEntity getNewsEntity(int i, String region)
	{
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setNewsData("TestNews" + i);
		newsEntity.setRegion(region);
		return newsEntity;
	}

	/**
	 * Computes a result, or throws an exception if unable to do so.
	 *
	 * @return computed result
	 * @throws Exception if unable to compute a result
	 */
	@Scheduled(cron = "0 0/1 * 1/1 * ? *")
	public void call() throws Exception
	{
		try
		{
			// Send a message with a POJO - the template reuse the message converter
			System.out.println("Sending for Message.News Berlin");
			NewsEntity newsEntity = this.getNewsEntity(i, NEWS_BERLIN);
			this.jmsTemplate.convertAndSend(NEWS_BAMBERG, newsEntity);
			i++;
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{

		}
	}

	@Scheduled(cron = "0 0/1 * 1/1 * ? *")
	public void sendBambergNews() throws Exception
	{
		try
		{
			// Send a message with a POJO - the template reuse the message converter
			System.out.println("Sending for Message.News Bamberg");
			NewsEntity newsEntity = this.getNewsEntity(i, NEWS_BAMBERG);
			this.jmsTemplate.convertAndSend(NEWS_BAMBERG, newsEntity);
			i++;
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{

		}
	}

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate)
	{
		this.jmsTemplate = jmsTemplate;
	}
}