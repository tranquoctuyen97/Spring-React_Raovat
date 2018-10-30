package com.tranquoctuyen.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tranquoctuyen.entity.*;

public interface PostService {
	Page<Post> findAll(Pageable pageable);

	Optional<Post> findById(UUID id);

	Post save(Post p);

    void deleteById(UUID id);
}
