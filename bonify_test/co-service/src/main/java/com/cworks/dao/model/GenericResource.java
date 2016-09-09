package com.cworks.dao.model;

import java.util.Map;

/**
 * This is Generic Resource
 * Created by cthammana on 08.09.2016.
 */
public class GenericResource
{
	private Map<String, Object> additionalInfo;

	/**
	 * Gets additional info.
	 *
	 * @return the additional info
	 */
	public Map<String, Object> getAdditionalInfo()
	{
		return additionalInfo;
	}

	/**
	 * Sets additional info.
	 *
	 * @param additionalInfo the additional info
	 */
	public void setAdditionalInfo(Map<String, Object> additionalInfo)
	{
		this.additionalInfo = additionalInfo;
	}
}