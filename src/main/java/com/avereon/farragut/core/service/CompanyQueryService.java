package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Company;
import com.avereon.farragut.port.inbound.CompanyQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyQueryService implements CompanyQuery {

	public Page<Company> findAll( Pageable pageable ) {
		return Page.empty();
	}

}
