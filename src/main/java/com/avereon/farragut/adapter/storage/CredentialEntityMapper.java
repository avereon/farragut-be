package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Credential;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface CredentialEntityMapper {

	CredentialEntity map( Credential credential );

	Credential map( CredentialEntity entity );

	default Page<Credential> mapPage( Page<CredentialEntity> page ) {
		return page.map( this::map );
	}

}
