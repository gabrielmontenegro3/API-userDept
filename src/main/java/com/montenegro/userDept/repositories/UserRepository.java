package com.montenegro.userDept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.montenegro.userDept.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	
}
