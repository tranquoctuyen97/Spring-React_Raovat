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

import com.tranquoctuyen.entity.SubCategory;
import com.tranquoctuyen.services.SubCategoryService;
import com.tranquoctuyen.utils.ResourceNotFoundException;

@RestController
@RequestMapping("/subCategories")
public class SubcategoryController {
	@Autowired
	private SubCategoryService subCategoryRepository;
	@GetMapping
	public Page<SubCategory> getListCategories (@RequestParam int page, @RequestParam int limit) throws ResourceNotFoundException {
		if (page <= 0) {
			throw new ResourceNotFoundException("page is invalid");
		}
		if (limit <= 0) {
			throw new ResourceNotFoundException("Limit is invalid");
		}
		Pageable pageable = PageRequest.of(page - 1, limit);
		return subCategoryRepository.findAll(pageable);
	}
	@PostMapping
	public SubCategory createCategory (@Valid @RequestBody SubCategory subCategory) {
		return subCategoryRepository.save(subCategory);
	}
	@PutMapping("/{id}")
	public SubCategory updateCategory (@PathVariable UUID id, @RequestBody SubCategory subCategory) {
		subCategory.setId(id);
		return subCategoryRepository.save(subCategory);
	}
	@DeleteMapping("/{id}")
	public void deleteCategory (@PathVariable UUID id) {
		subCategoryRepository.deleteById(id);
	}
}
