package com.cworks.persistence.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cworks.persistence.entities.UserEntity;

/**
 * Created by cthammana on 08.09.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao-application-context.xml" })
@Transactional
public class UserRepositoryTest
{
	@Autowired
	private UserRepository userRepository;

	@Test
	@Rollback
	public void save()
	{
		UserEntity appUser = new UserEntity("Test", "test1234");
		Assert.assertNotNull(this.userRepository.save(appUser).getId());
		Assert.assertEquals(appUser.getUsername(), this.userRepository.save(appUser).getUsername());
	}

	@Test
	@Rollback
	public void get()
	{
		UserEntity appUser = new UserEntity("Test", "test1234");
		appUser = this.userRepository.saveAndFlush(appUser);
		this.userRepository.flush();
		UserEntity appUser2 = this.userRepository.getOne(appUser.getId());
		Assert.assertEquals(appUser.getUsername(), appUser2.getUsername());
	}
}