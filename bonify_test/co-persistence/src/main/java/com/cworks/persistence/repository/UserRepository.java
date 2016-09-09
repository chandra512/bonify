package com.cworks.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cworks.persistence.entities.UserEntity;

/**
 * This is UserEntity Repository
 * Created by cthammana on 08.09.2016.
 */
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long>
{
}
