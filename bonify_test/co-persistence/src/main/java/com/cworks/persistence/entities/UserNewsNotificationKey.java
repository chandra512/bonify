package com.cworks.persistence.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * UserNewsNotificationKey
 * Created by cthammana on 09.09.2016.
 */
@Embeddable
public class UserNewsNotificationKey implements Serializable
{
	static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "user_id",
				referencedColumnName = "id")
	private UserEntity userId;

	@ManyToOne
	@JoinColumn(name = "news_id",
				referencedColumnName = "id")
	private NewsEntity newId;

	@ManyToOne
	@JoinColumn(name = "channel_id",
				referencedColumnName = "id")
	private ChannelEntity channelId;

	public UserNewsNotificationKey()
	{

	}

	public UserNewsNotificationKey(UserEntity userId, NewsEntity newId, ChannelEntity channelId)
	{
		super();
		this.userId = userId;
		this.newId = newId;
		this.channelId = channelId;
	}

	public UserEntity getUserId()
	{
		return userId;
	}

	public void setUserId(UserEntity userId)
	{
		this.userId = userId;
	}

	public NewsEntity getNewId()
	{
		return newId;
	}

	public void setNewId(NewsEntity newId)
	{
		this.newId = newId;
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
