package com.avereon.farragut.core.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompanyTest {

	@Test
	void constructor() {
		Company company = new Company();

		assertThat( company.getId() ).isNull();
	}

}
