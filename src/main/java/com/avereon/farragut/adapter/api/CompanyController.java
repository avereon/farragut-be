package com.avereon.farragut.adapter.api;

import com.avereon.farragut.adapter.api.model.Company;
import com.avereon.farragut.adapter.api.model.Page;
import com.avereon.farragut.adapter.api.model.Person;
import com.avereon.farragut.port.inbound.CompanyQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.avereon.farragut.adapter.api.Configuration.API_ROOT;

@RestController
@RequiredArgsConstructor
public class CompanyController implements CompanyApi {

	public static final String COMPANY_API_ROOT = API_ROOT + "/company";

	public static final String COMPANY_QUERY = COMPANY_API_ROOT + "?page={page}&size={size}";

	private final CompanyQuery companyQuery;

	private final CompanyApiMapper companyMapper;

	@Override
	public ResponseEntity<Page> getCompanies( Pageable pageable ) {
		return ResponseEntity.ok( companyMapper.toApiPage( companyQuery.findAll( pageable ) ) );
	}

	@Override
	public ResponseEntity<Company> getCompany( String id ) {
		return ResponseEntity.ok( companyMapper.toApi( companyQuery.find( UUID.fromString( id ) ) ) );
	}

	@Override
	public ResponseEntity<List<Person>> getCompanyPersons( String id ) {
		return ResponseEntity.ok( List.of() );
	}

}
