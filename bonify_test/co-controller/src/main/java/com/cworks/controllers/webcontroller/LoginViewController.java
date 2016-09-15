package com.cworks.controllers.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller is responsible for display the Login View
 * Created by cthammana on 08.09.2016.
 */
@Controller
public class LoginViewController
{

	/**
	 * This will return Login view
	 *
	 * @return View
	 */
	@RequestMapping(value = { "/", "/home" },
					method = RequestMethod.GET)
	public String getLoginView()
	{
		System.out.println("Inside Home");
		return "home";
	}

	/**
	 * This is a return view
	 *
	 * @return String View
	 */
	@RequestMapping(value = { "/user/login" },
					method = RequestMethod.GET)
	public String getHomeView()
	{
		System.out.println("Inside Home");
		return "home";
	}

}