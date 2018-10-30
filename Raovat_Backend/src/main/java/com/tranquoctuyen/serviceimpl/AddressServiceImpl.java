package com.tranquoctuyen.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tranquoctuyen.entity.Address;
import com.tranquoctuyen.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressService addressService;

	@Override
	public Optional<Address> findById(UUID id) {

		return addressService.findById(id);
	}

	@Override
	public Address save(Address p) {

		return addressService.save(p);
	}

	@Override
	public void deleteById(UUID id) {
		addressService.deleteById(id);

	}

	@Override
	public List<Address> findByName(String name) {

		return addressService.findByName(name);
	}

	@Override
	public Page<Address> findAll(Pageable pageable) {

		return addressService.findAll(pageable);
	}

}
