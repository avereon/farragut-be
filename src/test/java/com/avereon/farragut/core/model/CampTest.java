package com.avereon.farragut.core.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CampTest {

	@Test
	void constructor() {
		// given
		Camp camp = new Camp();

		// then
		assertThat( camp.getId() ).isNull();
	}

}
