package com.tranquoctuyen.services;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tranquoctuyen.entity.*;

public interface SubCategoryService {
	Page<SubCategory> findAll(Pageable pageable);

	Optional<SubCategory> findById(UUID id);

	SubCategory save(SubCategory p);

    void deleteById(UUID id);

    List<SubCategory> findByName(String name);
}
