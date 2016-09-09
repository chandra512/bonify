package com.cworks.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cworks.persistence.entities.SubscriptionEntity;
import com.cworks.persistence.entities.SubscriptionEntityKey;

/**
 * Created by cthammana on 08.09.2016.
 */
@Transactional
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, SubscriptionEntityKey>
{
	@Query("FROM SubscriptionEntity WHERE user_id=?1")
	List<SubscriptionEntity> finByUserId(Long userid);
}
