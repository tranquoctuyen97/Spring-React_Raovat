package com.tranquoctuyen.serviceimpl;

import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tranquoctuyen.entity.Post;
import com.tranquoctuyen.repositories.PostRepository;
import com.tranquoctuyen.services.PostService;
@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Optional<Post> findById(UUID id) {
		
		return postRepository.findById(id);
	}

	@Override
	public Post save(Post p) {
		
		return postRepository.save(p);
	}

	@Override
	public void deleteById(UUID id) {
		postRepository.deleteById(id);
		
	}

	

	@Override
	public Page<Post> findAll(Pageable pageable) {
		
		return postRepository.findAll(pageable);
	}

	

}
