package com.tranquoctuyen.repositories;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tranquoctuyen.entity.User;
import java.lang.String;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, UUID> , PagingAndSortingRepository<User, UUID> {
	List<User> findByName(String name);
	
	
}
