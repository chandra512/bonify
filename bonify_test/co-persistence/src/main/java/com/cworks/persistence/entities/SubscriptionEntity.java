package com.cworks.persistence.entities;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cworks.api.model.Channel;
import com.cworks.api.model.Subscription;
import com.cworks.api.model.User;

/**
 * SubscriptionEntity
 * Created by cthammana on 08.09.2016.
 */

@Entity
@Table(name = "user_channel_subscription")
public class SubscriptionEntity implements Subscription
{
	@EmbeddedId
	private SubscriptionEntityKey subscriptionEntityKey;

	public SubscriptionEntityKey getSubscriptionEntityKey()
	{
		return this.subscriptionEntityKey;
	}

	public void setSubscriptionEntityKey(SubscriptionEntityKey subscriptionEntityKey)
	{
		this.subscriptionEntityKey = subscriptionEntityKey;
	}

	public UserEntity getUserId()
	{
		return this.subscriptionEntityKey.getUserId();
	}

	public void setUserId(User userId)
	{
		this.subscriptionEntityKey.setUserId((UserEntity) userId);
	}

	public ChannelEntity getChannelId()
	{
		return this.subscriptionEntityKey.getChannelId();
	}

	public void setChannelId(Channel channelId)
	{
		this.subscriptionEntityKey.setChannelId((ChannelEntity) channelId);
	}

	@Override
	public Map<Serializable, Serializable> getAdditionalInfo()
	{
		return null;
	}

	/**
	 * Sets additional info.
	 *
	 * @param additionalInfo the additional info
	 */
	@Override
	public void setAdditionalInfo(Map<Serializable, Serializable> additionalInfo)
	{

	}
}
