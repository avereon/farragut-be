package com.avereon.farragut.core.model;

import org.mapstruct.Mapper;

@Mapper( componentModel = "spring" )
public interface CompanyMapper {

	Company copy( Company company );

}
