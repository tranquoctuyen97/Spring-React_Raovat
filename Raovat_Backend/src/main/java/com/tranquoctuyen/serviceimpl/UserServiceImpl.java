package com.tranquoctuyen.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tranquoctuyen.entity.User;
import com.tranquoctuyen.repositories.UserRepository;
import com.tranquoctuyen.services.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<User> findById(UUID id) {
		
		return userRepository.findById(id);
	}

	@Override
	public User save(User p) {
		
		return userRepository.save(p);
	}

	@Override
	public void deleteById(UUID id) {
	userRepository.deleteById(id);
		
	}

	@Override
	public List<User> findByName(String name) {
		
		return userRepository.findByName(name);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		
		return userRepository.findAll(pageable);
	}

	

}
