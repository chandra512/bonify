package com.cworks.persistence.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cworks.persistence.entities.ChannelEntity;
import com.cworks.persistence.entities.SubscriptionEntity;
import com.cworks.persistence.entities.SubscriptionEntityKey;
import com.cworks.persistence.entities.UserEntity;

/**
 * This is Test
 * Created by cthammana on 08.09.2016.
 */
public class SubscriptionRepositoryTest extends AbstractRepositoryTest
{

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Test
	@Rollback
	@Ignore
	public void save() throws Exception
	{
		ChannelEntity channelEntity = super.saveChannel("TestChannel1");
		ChannelEntity channelEntity2 = super.saveChannel("TestChannel2");

		UserEntity appUser = super.saveUser("TestUser1", "test1234");
		UserEntity appUser2 = super.saveUser("TestUser2", "test1234");

		SubscriptionEntity subscriptionEntity = this.getSubscriptionEntity(channelEntity, appUser);
		subscriptionEntity = this.getSubscriptionEntity(channelEntity2, appUser);
		subscriptionEntity = this.getSubscriptionEntity(channelEntity, appUser2);

		List<SubscriptionEntity> enitites = this.subscriptionRepository.finByUserId(appUser.getId());
		Assert.assertTrue(enitites.size() > 1);
		enitites = this.subscriptionRepository.finByUserId(appUser2.getId());
		Assert.assertTrue(enitites.size() == 1);
	}

	private SubscriptionEntity getSubscriptionEntity(ChannelEntity channelEntity, UserEntity appUser2)
	{
		SubscriptionEntityKey subscriptionEntityKey = new SubscriptionEntityKey(appUser2, channelEntity);
		SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
		subscriptionEntity.setSubscriptionEntityKey(subscriptionEntityKey);
		return this.subscriptionRepository.saveAndFlush(subscriptionEntity);
	}

}