package com.cworks.persistence.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * This object holds referencing columns
 * Created by cthammana on 08.09.2016.
 */
@Embeddable
public class SubscriptionEntityKey implements Serializable
{
	static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userId;

	@ManyToOne
	@JoinColumn(name = "channel_id")
	private ChannelEntity channelId;

	public SubscriptionEntityKey()
	{

	}

	public SubscriptionEntityKey(UserEntity userEntity, ChannelEntity channelEntity)
	{
		super();
		this.userId = userEntity;
		this.channelId = channelEntity;
	}

	public UserEntity getUserId()
	{
		return userId;
	}

	public void setUserId(UserEntity userId)
	{
		this.userId = userId;
	}

	public ChannelEntity getChannelId()
	{
		return channelId;
	}

	public void setChannelId(ChannelEntity channelId)
	{
		this.channelId = channelId;
	}
}
