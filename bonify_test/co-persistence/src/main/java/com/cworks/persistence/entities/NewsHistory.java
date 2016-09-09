package com.cworks.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is news History table
 * Created by cthammana on 09.09.2016.
 */
@Entity
@Table(name = "news_history")
public class NewsHistory
{
	@Id
	private Long id;

	@Column(name = "news_data")
	private String newsData;

	@Column(name = "channel_id")
	private Integer channelId;

	@Column(name = "region")
	private String region;

	@Column(name = "created")
	private Date createdDate;

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

	public Integer getChannelId()
	{
		return channelId;
	}

	public void setChannelId(Integer channelId)
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