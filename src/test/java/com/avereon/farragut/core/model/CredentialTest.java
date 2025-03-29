package com.avereon.farragut.core.model;

import com.avereon.farragut.core.config.Argon2PasswordEncoderWrapper;
import com.avereon.farragut.core.config.PasswordEncoder;
import com.avereon.farragut.util.IdUtil;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CredentialTest {

	@Test
	void testCredential() {
		String username = "admin";
		String password = "n*q7%tL8PNnpGzN2";
		PasswordEncoder encoder = new Argon2PasswordEncoderWrapper();

		System.out.println( "CredId=" + IdUtil.generate( username ) );
		System.out.println( "Secret=" + encoder.encode( password ) );

		System.out.println( "AccountId=" + UUID.randomUUID() );

		//String credId = "21232f29-7a57-35a7-8389-4a0e4a801fc3";
		//String secret = "$argon2id$v=19$m=60000,t=10,p=1$Xds5cqjwnz/X3l53FccDZw$98OlTmwBNPb+U7LSU2wGzpuvjlfDJFjcfyHtItLIShc";
		//String accountId = "17a7805c-72e6-47f5-b579-f0988c3a7317";
	}

}
