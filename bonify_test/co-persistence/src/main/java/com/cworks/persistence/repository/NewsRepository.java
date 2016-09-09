package com.cworks.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cworks.persistence.entities.NewsEntity;

/**
 * This is newsRepository
 * Created by cthammana on 09.09.2016.
 */
@Transactional
public interface NewsRepository extends JpaRepository<NewsEntity, Long>
{
	/*@Query("FROM NewsEntity WHERE channel_id=?1 order by created desc LIMIT 10")
	List<NewsEntity> findNextNews(Integer channelId);*/

	@Query("FROM NewsEntity WHERE channel_id=?1 order by created desc")
	List<NewsEntity> findByChannelId(Integer channelId, Pageable pageable);

	@Query("FROM NewsEntity WHERE channel_id=?1 AND region=?2 order by created desc ")
	List<NewsEntity> findByChannelIdAndRegion(Integer channelId, String region, Pageable pageable);
}