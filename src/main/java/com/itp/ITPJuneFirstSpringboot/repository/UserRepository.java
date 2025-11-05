package com.itp.ITPJuneFirstSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.ITPJuneFirstSpringboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
		
	public User findByUsername(String username);
}
