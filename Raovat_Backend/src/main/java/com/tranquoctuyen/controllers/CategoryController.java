package com.tranquoctuyen.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tranquoctuyen.entity.Category;
import com.tranquoctuyen.services.CategoryService;
import com.tranquoctuyen.utils.ResourceNotFoundException;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryRepository;

	@GetMapping
	public Page<Category> getListCategories (@RequestParam int page, @RequestParam int limit) throws ResourceNotFoundException {
		if (page <= 0) {
			throw new ResourceNotFoundException("page is invalid");
		}
		if (limit <= 0) {
			throw new ResourceNotFoundException("Limit is invalid");
		}
		Pageable pageable = PageRequest.of(page - 1, limit);
		return categoryRepository.findAll(pageable);
	}
	@PostMapping
	public Category createCategory (@Valid @RequestBody Category category) {
		return categoryRepository.save(category);
	}
	@PutMapping("/{id}")
	public Category updateCategory (@PathVariable UUID id, @RequestBody Category category) {
		category.setId(id);
		return categoryRepository.save(category);
	}
	@DeleteMapping("/{id}")
	public void deleteCategory (@PathVariable UUID id) {
		categoryRepository.deleteById(id);
	}
	
}
