package com.tranquoctuyen.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tranquoctuyen.entity.Category;
import com.tranquoctuyen.repositories.CategoryRepository;
import com.tranquoctuyen.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Optional<Category> findById(UUID id) {
		
		return categoryRepository.findById(id);
	}

	@Override
	public Category save(Category p) {
		
		return categoryRepository.save(p);
	}

	@Override
	public void deleteById(UUID id) {
	categoryRepository.deleteById(id);
		
	}

	@Override
	public List<Category> findByName(String name) {
		
		return categoryRepository.findByName(name);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		
		return categoryRepository.findAll(pageable);
	}

	

}
