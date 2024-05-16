package com.avereon.farragut.core.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Company {

	private UUID id;

	private String year;

	private String name;

	private Person commander;

	private Person assistant;

	// private Set<Person> members;

}
