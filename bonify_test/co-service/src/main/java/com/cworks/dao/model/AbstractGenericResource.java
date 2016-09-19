package com.cworks.dao.model;

import java.io.Serializable;
import java.util.Map;

/**
 * This is Generic Resource
 * Created by cthammana on 08.09.2016.
 */
public abstract class AbstractGenericResource
{
	private Map<Serializable, Serializable> additionalInfo;

	/**
	 * Gets additional info.
	 *
	 * @return the additional info
	 */
	public Map<Serializable, Serializable> getAdditionalInfo()
	{
		return additionalInfo;
	}

	/**
	 * Sets additional info.
	 *
	 * @param additionalInfo the additional info
	 */
	public void setAdditionalInfo(Map<Serializable, Serializable> additionalInfo)
	{
		this.additionalInfo = additionalInfo;
	}
}