package com.avereon.farragut.port.inbound;

import com.avereon.farragut.core.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CompanyQuery {

	Page<Company> findAll( Pageable pageable );

	Company find( UUID UUID );

}
