package com.cworks.persistence.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cworks.persistence.entities.ChannelEntity;

/**
 * This is a AbstractClass
 * Created by cthammana on 08.09.2016.
 */
public class ChannelRepositoryTest extends AbstractRepositoryTest
{
	@Autowired
	private ChannelRepository channelRepository;

	@Test
	@Rollback
	public void save()
	{
		ChannelEntity appUser = new ChannelEntity("Test");
		appUser = this.channelRepository.saveAndFlush(appUser);
		Assert.assertNotNull(appUser);
	}

}