package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Company;
import com.avereon.farragut.port.inbound.CompanyQuery;
import com.avereon.farragut.port.outbound.CompanyStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyQueryService implements CompanyQuery {

	private final CompanyStorage storage;

	public Page<Company> findAll( Pageable pageable ) {
		System.err.println( "pageable: " + pageable );
		return storage.findAll( pageable );
	}

}
