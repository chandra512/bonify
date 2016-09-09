package com.cworks.restservice;

import javax.jms.Destination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("bankAccountJmsProducer")
public class NewsJmsProducer
{
	private static Logger LOG = LoggerFactory.getLogger(NewsJmsProducer.class);

	@Autowired
	private JmsTemplate template;

	@Autowired
	private Destination destination;

}
