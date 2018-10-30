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
public class Address {
	@Id
	@Column(columnDefinition = "BINARY(16) NOT NULL")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(value = "_id", access = JsonProperty.Access.READ_ONLY)
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wardId")
	private Ward ward;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "districId")
	private Distric distric;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cityId")
	private City city;

	public Address() {
		super();
	}

	public Address(UUID id, Ward ward, Distric distric, City city) {
		super();
		this.id = id;
		this.ward = ward;
		this.distric = distric;
		this.city = city;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public Distric getDistric() {
		return distric;
	}

	public void setDistric(Distric distric) {
		this.distric = distric;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
