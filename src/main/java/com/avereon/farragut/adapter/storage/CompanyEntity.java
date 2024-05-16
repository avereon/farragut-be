package com.avereon.farragut.adapter.storage;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class CompanyEntity {

	@Id
	private UUID id;

	private String name;

}
