package com.tranquoctuyen.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class PostPhoto {
	@Id
	@Column(columnDefinition = "BINARY(16) NOT NULL")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(value = "_id", access = JsonProperty.Access.READ_ONLY)
	private UUID id;
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postId")
	private Post post;
	public PostPhoto() {
		super();
	}
	public PostPhoto(UUID id, String name, Post post) {
		super();
		this.id = id;
		this.name = name;
		this.post = post;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
}
