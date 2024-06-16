package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface CompanyEntityMapper {

	@Mapping( target = "establishedYear", source="year" )
	CompanyEntity toEntity( Company company );

	@Mapping( target = "year", source = "establishedYear" )
	Company toCore( CompanyEntity entity );

	default Page<Company> mapPage( Page<CompanyEntity> page ) {
		return page.map( this::toCore );
	}
}
