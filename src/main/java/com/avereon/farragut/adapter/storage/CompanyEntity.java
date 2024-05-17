package com.avereon.farragut.adapter.storage;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "company")
public class CompanyEntity {

	@Id
	private UUID id;

	private String name;

	private Integer establishedYear;

}
