package com.example.OnlineDukan.DataBase;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OnlineDukan.model.Users;

public interface UserRepo extends JpaRepository <Users ,Long>{
	

}
