package com.bonify.rest.model;

import com.cworks.persistence.entities.ChannelEntity;

/**
 * This class holds all the values of QueueLister
 * Created by cthammana on 14.09.2016.
 */

public class ListenerProperties
{
	private String queueName;

	private boolean stop;

	private String threadName;

	private ChannelEntity channelId;


	public String getQueueName()
	{
		return queueName;
	}

	public void setQueueName(String queueName)
	{
		this.queueName = queueName;
	}

	public ChannelEntity getChannelId()
	{
		return channelId;
	}

	public void setChannelId(ChannelEntity channelId)
	{
		this.channelId = channelId;
	}

	public boolean isStop()
	{
		return stop;
	}

	public void setStop(boolean stop)
	{
		this.stop = stop;
	}

	public String getThreadName()
	{
		return threadName;
	}

	public void setThreadName(String threadName)
	{
		this.threadName = threadName;
	}
}
