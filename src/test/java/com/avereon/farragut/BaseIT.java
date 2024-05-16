package com.avereon.farragut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseIT {

	protected static final String API_ROOT = "";

	@Autowired
	protected TestRestTemplate restTemplate;

}
