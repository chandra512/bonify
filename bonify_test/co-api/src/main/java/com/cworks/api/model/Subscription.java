package com.cworks.api.model;

/**
 * This class holds data which is used for holding dataof subscription
 * Created by cthammana on 16.09.2016.
 */
public interface Subscription extends GenericResources
{

	User getUserId();

	void setUserId(User userId);

	Channel getChannelId();

	void setChannelId(Channel channelId);

}
