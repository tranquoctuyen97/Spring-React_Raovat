package com.tranquoctuyen.repositories;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tranquoctuyen.entity.Post;
import com.tranquoctuyen.entity.User;
import java.lang.String;
import java.util.List;
import java.util.Optional;


public interface PostRepository extends CrudRepository<Post, UUID> , PagingAndSortingRepository<Post, UUID> {
	
	
	
}
