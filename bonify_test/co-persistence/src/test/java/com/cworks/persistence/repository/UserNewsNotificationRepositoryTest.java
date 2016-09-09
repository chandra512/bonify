package com.cworks.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cworks.api.constants.RegionModel;
import com.cworks.persistence.entities.ChannelEntity;
import com.cworks.persistence.entities.NewsEntity;
import com.cworks.persistence.entities.UserEntity;
import com.cworks.persistence.entities.UserNewsNotificationEntity;
import com.cworks.persistence.entities.UserNewsNotificationKey;

/**
 * This is User Notifcation
 * Created by cthammana on 09.09.2016.
 */
public class UserNewsNotificationRepositoryTest extends AbstractRepositoryTest
{

	@Autowired
	private UserNewsNotificationRepository userNewsNotificationRepository;

	private UserEntity userEntity;

	private ChannelEntity channelEntity;

	@Before
	public void setUp() throws Exception
	{
		this.userEntity = super.saveUser("TESTUSER1", "TEST123456");
		this.channelEntity = super.saveChannel("TESTCHANNEL1");
	}

	@Test
	public void test()
	{
		List<UserNewsNotificationEntity> userNewsNotificationEntities = new ArrayList<>();
		userNewsNotificationEntities.add(
			this.getNotificationEntity(super.saveNews("TestNews5", this.channelEntity, RegionModel.BAMBERG), this.channelEntity, this.userEntity));
		userNewsNotificationEntities.add(
			this.getNotificationEntity(super.saveNews("TestNews5", this.channelEntity, RegionModel.BAMBERG), this.channelEntity, this.userEntity));
		userNewsNotificationEntities.add(
			this.getNotificationEntity(super.saveNews("TestNews5", this.channelEntity, RegionModel.BAMBERG), this.channelEntity, this.userEntity));

		this.userNewsNotificationRepository.save(userNewsNotificationEntities);
		this.userNewsNotificationRepository.flush();
		List<UserNewsNotificationEntity> list = this.userNewsNotificationRepository
			.findByChannelIdAndUserId(userEntity.getId(), channelEntity.getId(), false);
		Assert.assertTrue(list.size() == 3);
	}

	private UserNewsNotificationEntity getNotificationEntity(NewsEntity newsEntity, ChannelEntity channelEntity, UserEntity userEntity)
	{
		UserNewsNotificationKey userNewsNotificationKey = new UserNewsNotificationKey(this.userEntity, newsEntity, this.channelEntity);
		return new UserNewsNotificationEntity(userNewsNotificationKey, false);
	}
}