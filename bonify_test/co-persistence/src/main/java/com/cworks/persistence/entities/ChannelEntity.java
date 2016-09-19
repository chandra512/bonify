package com.cworks.persistence.entities;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cworks.api.model.Channel;

/**
 * This is entity class
 * Created by cthammana on 08.09.2016.
 */
@Entity
@Table(name = "channel")
public class ChannelEntity implements Channel
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	public ChannelEntity()
	{

	}

	public ChannelEntity(String name)
	{
		super();
		this.name = name;
	}

	public ChannelEntity(Integer id, String name)
	{
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public int hashCode()
	{
		return id;
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