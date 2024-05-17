package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Company;
import com.avereon.farragut.port.inbound.CompanyCommand;
import com.avereon.farragut.port.outbound.CompanyStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyCommandService implements CompanyCommand {

	private final CompanyStorage storage;

	@Override
	public Company createCompany( Company company ) {
		company.setId( UUID.randomUUID() );
		return storage.save( company );
	}

}
