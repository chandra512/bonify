package com.cworks.api.dao;

import com.cworks.api.model.User;

/**
 * This is UserEntity Daoi Layer
 * Created by cthammana on 08.09.2016.
 */
public interface UserDao
{

	User findById(Long id);

	User saveUser(User user);

}
