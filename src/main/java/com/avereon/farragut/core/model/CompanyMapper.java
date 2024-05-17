package com.avereon.farragut.core.model;

import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {

	Company copy( Company company );

}
