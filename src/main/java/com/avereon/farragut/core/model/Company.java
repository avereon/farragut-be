package com.avereon.farragut.core.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors( chain = true )
public class Company {

	private UUID id;

	private String name;

	private Integer year;

	//private Person commander;

	//private Person assistant;

	// private Set<Person> members;

}
