package com.tranquoctuyen.utils;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 8244901843545715053L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message) {
		super(message);
	}
}
