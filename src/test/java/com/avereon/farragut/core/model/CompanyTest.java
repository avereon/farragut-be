package com.avereon.farragut.core.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompanyTest {

	@Test
	void constructor() {
		// given
		Company company = new Company();

		// then
		assertThat( company.getId() ).isNull();
	}

}
