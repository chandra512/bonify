package com.cworks.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cworks.persistence.entities.UserNewsNotificationEntity;
import com.cworks.persistence.entities.UserNewsNotificationKey;

/**
 * This is Repository
 * Created by cthammana on 09.09.2016.
 */
@Transactional
public interface UserNewsNotificationRepository extends JpaRepository<UserNewsNotificationEntity, UserNewsNotificationKey>
{

	@Query("FROM UserNewsNotificationEntity WHERE user_id=?1 AND channel_id=?2")
	Long findCount(Long userEntity, Integer channelEntityId);

	@Query("FROM UserNewsNotificationEntity WHERE user_id=?1 AND channel_id=?2 AND read=?3")
	List<UserNewsNotificationEntity> findByChannelIdAndUserId(Long userEntityId, Integer channelEntityId, boolean read);
}