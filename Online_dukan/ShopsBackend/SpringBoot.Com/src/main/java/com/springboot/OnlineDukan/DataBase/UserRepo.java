package com.springboot.OnlineDukan.DataBase;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.OnlineDukan.model.Users;

public interface UserRepo extends JpaRepository <Users ,Long>{
	

}
