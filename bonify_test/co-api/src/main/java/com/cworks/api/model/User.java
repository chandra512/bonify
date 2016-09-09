package com.cworks.api.model;

/**
 * This is Specification of User entity Api
 * Created by cthammana on 08.09.2016.
 */
public interface User
{

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	Long getId();

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	void setId(Long id);

	/**
	 * Gets username.
	 *
	 * @return the username
	 */
	String getUsername();

	/**
	 * Sets username.
	 *
	 * @param username the username
	 */
	void setUsername(String username);

	/**
	 * Gets password.
	 *
	 * @return the password
	 */
	String getPassword();

	/**
	 * Sets password.
	 *
	 * @param password the password
	 */
	void setPassword(String password);

}
