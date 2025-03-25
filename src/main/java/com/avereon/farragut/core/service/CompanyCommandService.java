package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Company;
import com.avereon.farragut.port.inbound.CompanyCommand;
import com.avereon.farragut.port.outbound.CompanyStorage;
import com.avereon.farragut.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyCommandService implements CompanyCommand {

	private final CompanyStorage storage;

	@Override
	public Company createCompany( Company company ) {
		company.setId( IdUtil.random() );
		return storage.save( company );
	}

}
