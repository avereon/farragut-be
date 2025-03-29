package com.avereon.farragut.adapter.api;

import com.avereon.farragut.BaseIT;
import com.avereon.farragut.core.model.Credential;
import com.avereon.farragut.port.outbound.CredentialStorage;
import com.avereon.farragut.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CredentialControllerIT extends BaseIT {

	@Autowired
	private CredentialStorage storage;

	@Test
	void get() {
		// given
		Credential credential = new Credential();
		credential.setId( IdUtil.random() );
		storage.save( credential );

		// when
		var result = restTemplate.getForEntity( CredentialController.CREDENTIAL_API_ROOT + "/" + credential.getId(), Credential.class );

		// then
		//assertThat( result.getStatusCode() ).isEqualTo( OK );
		//assertThat( result.getBody() ).isEqualTo( credential );
	}

}
