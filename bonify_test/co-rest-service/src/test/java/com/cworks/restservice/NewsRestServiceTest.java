package com.cworks.restservice;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cthammana on 09.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "rabbitmq-context.xml" })
public class NewsRestServiceTest
{

	@Autowired
	@Qualifier(value = "jmsTemplate")
	private JmsTemplate jmsTemplate;

	@Autowired
	@Qualifier(value = "destination")
	private Destination destination;

	@Before
	public void setUp() throws Exception
	{

	}

	@Test
	public void test()
	{
		// sending a message
		jmsTemplate.convertAndSend(this.destination, "Hi");

		// receiving a message
		Object msg = jmsTemplate.receive(destination);
		if (msg instanceof TextMessage)
		{
			try
			{
				System.out.println(((TextMessage) msg).getText());
			}
			catch (JMSException e)
			{
				System.out.println(e);
			}
		}

	}

}