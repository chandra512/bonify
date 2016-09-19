package com.cworks.dao.model;

import java.io.Serializable;

import com.cworks.api.model.Channel;

/**
 * Channel Resource is a Classes
 * Created by cthammana on 08.09.2016.
 */
public class ChannelResource extends AbstractGenericResource implements Channel, Serializable
{

	private static final long serialVersionUID = 5994069659371546469L;
	private Integer id;

	private String name;

	public ChannelResource(Integer id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	public ChannelResource()
	{
	}

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