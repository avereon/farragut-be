package com.avereon.farragut.core.model;

import org.mapstruct.Mapper;

@Mapper( componentModel = "spring" )
public interface CampMapper {

	Camp copy( Camp company );

}
