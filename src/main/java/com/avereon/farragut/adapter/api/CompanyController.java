package com.avereon.farragut.adapter.api;

import com.avereon.farragut.adapter.api.model.Company;
import com.avereon.farragut.adapter.api.model.Page;
import com.avereon.farragut.port.inbound.CompanyQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompanyController implements CompanyApi {

	private final CompanyQuery companyQuery;

	private final CompanyApiMapper mapper;

	@Override
	public ResponseEntity<Page> getCompanies( Pageable pageable ) {
		System.err.println( "pageable: " + pageable);
		return ResponseEntity.ok( mapper.toApiPage( companyQuery.findAll( pageable ) ) );
	}

	@Override
	public ResponseEntity<Company> getCompany( String id ) {
		return null;
	}

}
