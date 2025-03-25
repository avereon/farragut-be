package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.User;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper( componentModel = "spring" )
public interface UserEntityMapper {

	UserEntity map( User user );

	User map( UserEntity entity );

	default Page<User> mapPage( Page<UserEntity> page ) {
		return page.map( this::map );
	}

}
