package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Company;
import com.avereon.farragut.port.outbound.CompanyStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyStorageService implements CompanyStorage {

	private final CompanyRepository repo;

	private final CompanyEntityMapper mapper;

	@Override
	public Page<Company> findAll( Pageable pageable ) {
		return mapper.mapPage( repo.findAll( pageable ) );
	}

}
