package com.cworks.persistence.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SubscriptionEntity
 * Created by cthammana on 08.09.2016.
 */

@Entity
@Table(name = "user_channel_subscription")
public class SubscriptionEntity
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

	public void setUserId(UserEntity userId)
	{
		this.subscriptionEntityKey.setUserId(userId);
	}

	public ChannelEntity getChannelId()
	{
		return this.subscriptionEntityKey.getChannelId();
	}

	public void setChannelId(ChannelEntity channelId)
	{
		this.subscriptionEntityKey.setChannelId(channelId);
	}

}
