package com.cworks.persistence.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This is User Notifcation entity
 * Created by cthammana on 09.09.2016.
 */
@Entity
@Table(name = "user_news_channel_notification")
public class UserNewsNotificationEntity
{

	@EmbeddedId
	private UserNewsNotificationKey userNewsNotificationKey;

	@Column(name = "notified")
	private Boolean read;

	public UserNewsNotificationEntity()
	{
	}

	public UserNewsNotificationEntity(UserNewsNotificationKey userNewsNotificationKey, boolean read)
	{
		super();
		this.userNewsNotificationKey = userNewsNotificationKey;
		this.read = read;
	}

	public UserNewsNotificationKey getUserNewsNotificationKey()
	{
		return userNewsNotificationKey;
	}

	public void setUserNewsNotificationKey(UserNewsNotificationKey userNewsNotificationKey)
	{
		this.userNewsNotificationKey = userNewsNotificationKey;
	}

	public UserEntity getUserId()
	{
		return this.userNewsNotificationKey.getUserId();
	}

	public void setUserId(UserEntity userId)
	{
		this.userNewsNotificationKey.setUserId(userId);
	}

	public NewsEntity getNewId()
	{
		return this.userNewsNotificationKey.getNewId();
	}

	public void setNewId(NewsEntity newId)
	{
		this.userNewsNotificationKey.setNewId(newId);
	}

	public ChannelEntity getChannelId()
	{
		return this.userNewsNotificationKey.getChannelId();
	}

	public void setChannelId(ChannelEntity channelId)
	{
		this.userNewsNotificationKey.setChannelId(channelId);
	}

	public Boolean isRead()
	{
		return read;
	}

	public void setRead(Boolean read)
	{
		this.read = read;
	}
}