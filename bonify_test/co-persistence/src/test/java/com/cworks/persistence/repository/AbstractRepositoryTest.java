package com.cworks.persistence.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cworks.persistence.entities.ChannelEntity;
import com.cworks.persistence.entities.NewsEntity;
import com.cworks.persistence.entities.UserEntity;

/**
 * This is abstract test class
 * Created by cthammana on 08.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao-application-context.xml" })
@Transactional
public abstract class AbstractRepositoryTest
{
	@Autowired
	private ChannelRepository channelRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NewsRepository newsRepository;

	protected ChannelEntity saveChannel(String name)
	{
		return this.channelRepository.saveAndFlush(new ChannelEntity(name));
	}

	protected UserEntity saveUser(String username, String password)
	{
		return this.userRepository.saveAndFlush(new UserEntity(username, password));
	}

	protected NewsEntity saveNews(String data, ChannelEntity channelEntity, String region)
	{
		return this.newsRepository.saveAndFlush(new NewsEntity(data, channelEntity, region));
	}
}