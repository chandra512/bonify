package com.bonify.rest.service;

import java.util.Date;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.bonify.rest.model.AsynchConstants;
import com.bonify.rest.model.ListenerProperties;
import com.cworks.persistence.entities.NewsEntity;

/**
 * This Class is Consumer class for the JMSQueue
 * Created by cthammana on 13.09.2016.
 */
@Component
@Scope(value = "prototype")
public class NewsServiceConsumer implements Callable<Long>
{
	private ListenerProperties listenerProperties;

	private JmsTemplate jmsTemplate;

	/**
	 * Empty constructor
	 */
	public NewsServiceConsumer()
	{

	}

	public boolean saveListnerStatus()
	{
		return false;
	}

	@Override
	public String toString()
	{
		return this.listenerProperties.getThreadName();
	}

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate)
	{
		this.jmsTemplate = jmsTemplate;
	}

	public void setListenerProperties(ListenerProperties listenerProperties)
	{
		this.listenerProperties = listenerProperties;
	}

	/**
	 * Computes a result, or throws an exception if unable to do so.
	 *
	 * @return computed result
	 * @throws Exception if unable to compute a result
	 */
	@Override
	public Long call() throws Exception
	{
		Long count = new Long(0);
		try
		{
			while (!this.listenerProperties.isStop())
			{
				System.out.println(" Waiting for Message !");
				String message = (String) this.jmsTemplate.receiveAndConvert(this.listenerProperties.getQueueName());
				if (message != null)
				{
					NewsEntity newsEntity = AsynchConstants.GSONMAPPER.fromJson(message, NewsEntity.class);
					newsEntity.setChannelId(this.listenerProperties.getChannelId());
					newsEntity.setCreatedDate(new Date(System.currentTimeMillis()));
					this.saveNews(newsEntity);
					count++;
				}
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException e)
		{

		}
		return count;
	}

	private void saveNews(final NewsEntity newsEntity)
	{
		/**
		 * @TODO Need to be implemented
		 */
	}
}