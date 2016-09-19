package com.cworks.controllers.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cworks.persistence.entities.NewsEntity;
import com.cworks.persistence.repository.ChannelRepository;
import com.cworks.persistence.repository.NewsRepository;
import com.google.gson.Gson;

/**
 * This is Rest Controller, used for exposing Rest Enf points
 * Created by cthammana on 14.09.2016.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController
{

	private Gson gson = new Gson();

	private ChannelRepository channelRepository;

	private NewsRepository newsRepository;

	//Welcome page, non-rest
	@RequestMapping("/ping")
	public String welcome()
	{
		return "{\"ping\":\"ok\"}";
	}

	@RequestMapping("/channel/findall")
	public String getAllChannels()
	{
		return this.gson.toJson(this.channelRepository.findAll());
	}

	@Transactional
	@RequestMapping(value = "/channel/save",
					method = RequestMethod.POST)
	public NewsEntity saveNews(@RequestParam(name = "news") NewsEntity newsEntity)
	{
		return this.newsRepository.save(newsEntity);
	}

	@Autowired
	public void setChannelRepository(ChannelRepository channelRepository)
	{
		this.channelRepository = channelRepository;
	}
}

