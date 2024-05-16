package com.avereon.farragut.core.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Person {

	private UUID id;

	private Company company;

	private String regiment;

	private String battalion;

}
