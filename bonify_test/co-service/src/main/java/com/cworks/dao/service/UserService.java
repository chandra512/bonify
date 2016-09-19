package com.cworks.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cworks.api.model.Subscription;
import com.cworks.api.model.User;
import com.cworks.dao.model.UserResource;
import com.cworks.persistence.repository.UserRepository;

/**
 * This is a service class
 * Created by cthammana on 08.09.2016.
 */
@Service
public class UserService
{

	private UserRepository userRepository;

	private USerSubscriptionService uSerSubscriptionService;

	/**
	 * This will return User Object
	 *
	 * @param id Long
	 * @return APpUser object
	 */
	public User getUser(Long id)
	{
		return new UserResource(this.userRepository.findOne(id));
	}

	/**
	 * This will returns the User Subscription
	 *
	 * @param id User ID
	 * @return UserSubscription
	 */
	public Subscription getUserResource(Long id)
	{
		User user = this.userRepository.findOne(id);
		return this.uSerSubscriptionService.getAllSubscription(id);
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
}