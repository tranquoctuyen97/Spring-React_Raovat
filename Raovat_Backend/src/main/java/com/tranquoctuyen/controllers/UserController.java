package com.tranquoctuyen.controllers;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;
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
import com.tranquoctuyen.entity.*;
import com.tranquoctuyen.services.UserService;
import com.tranquoctuyen.utils.DateHelper;
import com.tranquoctuyen.utils.Reponse;
import com.tranquoctuyen.utils.ResourceNotFoundException;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired(required = true)
	private UserService userService;

	@GetMapping
	Page<User> list(@RequestParam int page, @RequestParam int limit) throws ResourceNotFoundException {
		if (page <= 0) {
			throw new ResourceNotFoundException("page is invalid");
		}
		if (limit <= 0) {
			throw new ResourceNotFoundException("Limit is invalid");
		}
		Pageable pageable = PageRequest.of(page - 1, limit);
		Page<User> getListUsers = userService.findAll(pageable);
		return getListUsers;
	}

	@PostMapping
	public User createUser(@Valid @RequestBody User user) {
		user.setCreatedAt(DateHelper.convertDatetoTimestmp(new Date()));
		return userService.save(user);
	}

	@GetMapping("/{id}")
	public Optional<User> getUserbyId(@PathVariable UUID id) {
//		System.out.println(UUD.);
		Optional<User> user = userService.findById(id);
		return user;
	}

	@DeleteMapping("/{id}")
	public Reponse deleteUserbyId(@PathVariable UUID id) throws ResourceNotFoundException {
		try {
			userService.deleteById(id);
			return Reponse.returnSuccess("Deleted User have id " + id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Delete error Id " + id);
		}
	}
	@PutMapping("/{id}/changeActive")
	public User changeActive(@PathVariable UUID id) {
	Optional<User> userOp =	userService.findById(id);
	userOp.get().setActive(!userOp.get().isActive());
	return userService.save(userOp.get());
	}


}
