package com.avereon.farragut.adapter.api;

import com.avereon.farragut.BaseIT;
import com.avereon.farragut.adapter.api.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

public class CompanyControllerIT extends BaseIT {

	private static final String COMPANY_API_ROOT = API_ROOT + "/company";

	@Test
	void getCompaniesByPage() {
		// given

		// when
		ResponseEntity<?> result = restTemplate.getForEntity( COMPANY_API_ROOT, Object.class );

		// then
		assertThat( result.getStatusCode() ).isEqualTo( OK );
		// FIXME Should I use my own Page object to avoid the deserialization issues?
		Map<?,?> page = (Map<?,?>)result.getBody();
		//assertThat( result.getBody() ).isNotNull();
	}

}
