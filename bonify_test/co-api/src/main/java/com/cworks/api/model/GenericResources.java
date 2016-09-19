package com.cworks.api.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Generice Service
 * Created by cthammana on 19.09.2016.
 */
public interface GenericResources
{

	Map<Serializable, Serializable> getAdditionalInfo();

	/**
	 * Sets additional info.
	 *
	 * @param additionalInfo the additional info
	 */
	void setAdditionalInfo(Map<Serializable, Serializable> additionalInfo);

}
