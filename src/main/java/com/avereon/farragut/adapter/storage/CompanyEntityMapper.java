package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Company;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface CompanyEntityMapper {

	CompanyEntity toEntity( Company company );

	Company toModel( CompanyEntity entity );

	default Page<Company> mapPage( Page<CompanyEntity> page ) {
		return page.map( this::toModel );
	}
}
