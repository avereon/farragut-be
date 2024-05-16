package com.avereon.farragut.port.outbound;

import com.avereon.farragut.core.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyStorage {

	Page<Company> findAll( Pageable pageable );

}
