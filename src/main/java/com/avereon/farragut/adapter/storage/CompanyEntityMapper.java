package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Company;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyEntityMapper {

	CompanyEntity toEntity( Company company );

	Company toModel( CompanyEntity entity );

}
