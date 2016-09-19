package com.cworks.dao.model;

import com.cworks.api.model.Channel;
import com.cworks.api.model.Subscription;
import com.cworks.api.model.User;

/**
 * This is Resource
 * Created by cthammana on 16.09.2016.
 */
public class SubscriptionResource extends AbstractGenericResource implements Subscription
{

	@Override
	public User getUserId()
	{
		return null;
	}

	@Override
	public void setUserId(User userId)
	{

	}

	@Override
	public Channel getChannelId()
	{
		return null;
	}

	@Override
	public void setChannelId(Channel channelId)
	{

	}
}
