package com.cworks.dao.model;

import com.cworks.api.model.User;

/**
 * This is User Resource which is used in User interface
 * Created by cthammana on 08.09.2016.
 */
public class UserResource extends AbstractGenericResource implements User
{
	private Long id;

	private String username;

	private String password;

	/**
	 * Instantiates a new User resource.
	 *
	 * @param user the app user
	 */
	public UserResource(User user)
	{
		this.username = user.getUsername();
		this.password = user.getUsername();
		this.id = user.getId();
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}