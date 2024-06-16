package com.avereon.farragut.port.inbound;

import com.avereon.farragut.core.model.Camp;

public interface CampCommand {

	Camp createCamp( Camp camp );

}
