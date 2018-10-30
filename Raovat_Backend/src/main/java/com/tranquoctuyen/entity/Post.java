package com.tranquoctuyen.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Post {
	@Id
	@Column(columnDefinition = "BINARY(16) NOT NULL")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(value = "_id", access = JsonProperty.Access.READ_ONLY)
	private UUID id;
	
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addressId")
	private Address address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subCategoryId")
	private SubCategory subCategory;
	
	private String description;
	
	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId")
	private User user;
	
	private boolean isAccept;
	
	private Timestamp createdAt;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="post",fetch = FetchType.EAGER)
	private List<PostPhoto> photos;
	

	public List<PostPhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PostPhoto> photos) {
		this.photos = photos;
	}

	public Post() {
		super();
	}

	public Post(UUID id, String title, Address address, SubCategory subCategory, String description, double price,
			User user, boolean isAccept, Timestamp createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.address = address;
		this.subCategory = subCategory;
		this.description = description;
		this.price = price;
		this.user = user;
		this.isAccept = isAccept;
		this.createdAt = createdAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAccept() {
		return isAccept;
	}

	public void setAccept(boolean isAccept) {
		this.isAccept = isAccept;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}
