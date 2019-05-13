package com.lifebank.model.repository;


import org.springframework.data.repository.CrudRepository;

import com.lifebank.model.entity.User;

public interface UserRepository extends CrudRepository<User, Long> 
{
	User findByUserAndPassword (String usr,String pass) ;
	
	User findByUser (String usr) ;
}
