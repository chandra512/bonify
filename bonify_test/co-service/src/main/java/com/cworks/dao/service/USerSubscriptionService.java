package com.cworks.dao.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cworks.api.model.Subscription;
import com.cworks.api.model.User;
import com.cworks.dao.model.ChannelResource;
import com.cworks.dao.model.SubscriptionResource;
import com.cworks.persistence.entities.ChannelEntity;
import com.cworks.persistence.entities.SubscriptionEntity;
import com.cworks.persistence.repository.ChannelRepository;
import com.cworks.persistence.repository.SubscriptionRepository;

/**
 * Created by cthammana on 16.09.2016.
 */
@Service
public class USerSubscriptionService
{

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private ChannelRepository channelRepository;

	private void saveSubscription(Map<Serializable, Serializable> map, User user)
	{
		List<SubscriptionEntity> list = new ArrayList<>();
		for (Map.Entry<Serializable, Serializable> entry : map.entrySet())
		{
			ChannelResource resource = (ChannelResource) entry.getKey();
			SubscriptionEntity subscription = new SubscriptionEntity();
			subscription.setUserId(user);
			subscription.setChannelId(new ChannelEntity(resource.getId(), resource.getName()));
			list.add(subscription);
		}
		this.subscriptionRepository.save(list);
	}

	public Subscription getAllSubscription(Long id)
	{
		List<ChannelEntity> channelEntities = this.channelRepository.findAll();

		List<SubscriptionEntity> subscribedList = this.subscriptionRepository.finByUserId(id);

		Set<ChannelEntity> subscribedSet = subscribedList.stream().map(SubscriptionEntity::getChannelId).collect(Collectors.toSet());

		Map<Serializable, Serializable> map = new HashMap<>();
		for (ChannelEntity entity : channelEntities)
		{
			ChannelResource channelResource = new ChannelResource(entity.getId(), entity.getName());
			map.put(channelResource, Boolean.valueOf(subscribedSet.contains(entity)));
		}
		Subscription subscription = new SubscriptionResource();
		subscription.setAdditionalInfo(map);
		return subscription;
	}
}