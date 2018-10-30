package com.tranquoctuyen.services;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tranquoctuyen.entity.*;

public interface UserService {
	Page<User> findAll(Pageable pageable);

	Optional<User> findById(UUID id);

    User save(User p);

    void deleteById(UUID id);

    List<User> findByName(String name);
}
