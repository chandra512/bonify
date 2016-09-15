package com.bonify.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.cworks.persistence.entities.NewsEntity;
import com.google.gson.Gson;

/**
 * This class is responsible for Providing data to this producer
 * Created by cthammana on 13.09.2016.
 */

@Component
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

	public static void main(String[] args) throws InterruptedException
	{
		int i = 1;
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/async-context.xml");
		JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
		Gson gson = new Gson();
		while (true)
		{
			jmsTemplate.convertAndSend("NEWS_BERLIN", getNewsEntity(i).toString());
			i++;
			Thread.sleep(3000);
		}
	}

	private static NewsEntity getNewsEntity(int i)
	{
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setNewsData("TestNews" + i);
		newsEntity.setRegion("Berlin");
		return newsEntity;
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
	public void sendBambergNews() throws Exception
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

	/**
	 * This method is responsible for sending belrin news
	 *
	 * @throws Exception Exception
	 */
	public void sendBerlinNews() throws Exception
	{
		try
		{
			//Send a message with a POJO - the template reuse the message converter
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