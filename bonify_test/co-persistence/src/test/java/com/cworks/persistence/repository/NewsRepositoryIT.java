package com.cworks.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import com.cworks.api.constants.RegionModel;
import com.cworks.persistence.entities.ChannelEntity;
import com.cworks.persistence.entities.NewsEntity;

/**
 * This is Repository Test
 * Created by cthammana on 09.09.2016.
 */
public class NewsRepositoryIT extends AbstractRepositoryTest
{

	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private ChannelRepository channelRepository;

	private ChannelEntity channelEntity;

	private NewsEntity newsEntity;

	@Before
	public void setUp() throws Exception
	{
		this.channelEntity = super.saveChannel("TEST_CHANNEL_23");
		List<NewsEntity> list = new ArrayList<>();
		list.add(new NewsEntity("TEST NEWS1", channelEntity, RegionModel.BAMBERG));
		list.add(new NewsEntity("TEST NEWS2", channelEntity, RegionModel.BAMBERG));
		list.add(new NewsEntity("TEST NEWS3", channelEntity, RegionModel.BAMBERG));
		list.add(new NewsEntity("TEST NEWS4", channelEntity, RegionModel.BAMBERG));
		this.newsRepository.save(list);
		this.newsRepository.flush();
	}

	@Test
	public void findByChannelId() throws Exception
	{
		PageRequest pageRequest = new PageRequest(0, 10);
		List<NewsEntity> entities = this.newsRepository.findByChannelId(this.channelEntity.getId(), pageRequest);
		Assert.assertTrue(entities.size() > 1);
	}
}