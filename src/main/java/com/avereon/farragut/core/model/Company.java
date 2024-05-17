package com.avereon.farragut.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors( chain = true )
@EqualsAndHashCode
public class Company {

	@EqualsAndHashCode.Exclude
	private UUID id;

	private String name;

	private Integer year;

	//private Person commander;

	//private Person assistant;

	// private Set<Person> members;

}
