package com.avereon.farragut.adapter.api;

import com.avereon.farragut.core.model.Company;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface CompanyApiMapper {

	com.avereon.farragut.adapter.api.model.Company toApi( Company company );

	Company toModel( com.avereon.farragut.adapter.api.model.Company api );

	default Page toApiPage( Page<Company> page ) {
		return page.map( this::toApi );
	}

}
