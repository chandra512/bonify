package com.cworks.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This is News Entity class which stores all the news
 * Created by cthammana on 09.09.2016.
 */
@Entity
@Table(name = "news")
public class NewsEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "news_data",
			length = 2000)
	private String newsData;

	@OneToOne
	@JoinColumn(name = "channel_id",
				referencedColumnName = "id")
	private ChannelEntity channelId;

	@Column(name = "region")
	private String region;

	@Column(name = "created")
	private Date createdDate;

	public NewsEntity(String newsData, ChannelEntity channelId, String region)
	{
		this.newsData = newsData;
		this.channelId = channelId;
		this.region = region;
		this.createdDate = new Date(System.currentTimeMillis());
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;

	}

	public String getNewsData()
	{
		return newsData;
	}

	public void setNewsData(String newsData)
	{
		this.newsData = newsData;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion(String region)
	{
		this.region = region;
	}

	public ChannelEntity getChannelId()
	{
		return channelId;
	}

	public void setChannelId(ChannelEntity channelId)
	{
		this.channelId = channelId;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}
}