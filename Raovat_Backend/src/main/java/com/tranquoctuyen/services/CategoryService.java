package com.tranquoctuyen.services;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tranquoctuyen.entity.*;

public interface CategoryService {
	Page<Category> findAll(Pageable pageable);

	Optional<Category> findById(UUID id);

	Category save(Category p);

    void deleteById(UUID id);

    List<Category> findByName(String name);
}
