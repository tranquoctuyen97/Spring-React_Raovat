package com.tranquoctuyen.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tranquoctuyen.entity.SubCategory;
import com.tranquoctuyen.repositories.SubCategoryRepository;
import com.tranquoctuyen.services.SubCategoryService;
@Service
public class SubCategoryServiceImpl implements SubCategoryService{
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	
	@Override
	public Optional<SubCategory> findById(UUID id) {
		
		return subCategoryRepository.findById(id);
	}

	@Override
	public SubCategory save(SubCategory p) {
		
		return subCategoryRepository.save(p);
	}

	@Override
	public void deleteById(UUID id) {
		subCategoryRepository.deleteById(id);
		
	}

	@Override
	public List<SubCategory> findByName(String name) {
		
		return subCategoryRepository.findByName(name);
	}

	@Override
	public Page<SubCategory> findAll(Pageable pageable) {
		
		return subCategoryRepository.findAll(pageable);
	}

	

}
