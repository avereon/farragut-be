package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

	UserEntity map( User user );

	User map( UserEntity entity );

}
