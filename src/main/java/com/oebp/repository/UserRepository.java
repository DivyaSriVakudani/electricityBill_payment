package com.oebp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oebp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findUserByUserName(String userName);

}