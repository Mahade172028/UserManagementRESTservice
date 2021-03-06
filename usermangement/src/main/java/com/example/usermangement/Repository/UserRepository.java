package com.example.usermangement.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.usermangement.Entity.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
	
	Page<User> findAll(Pageable pagin);

}
