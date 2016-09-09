package com.cworks.dao.model;

import com.cworks.api.model.Channel;

/**
 * Channel Resource is a Classes
 * Created by cthammana on 08.09.2016.
 */
public class ChannelResource extends GenericResource implements Channel
{
	private Integer id;

	private String name;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}