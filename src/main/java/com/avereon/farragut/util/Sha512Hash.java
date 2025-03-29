package com.avereon.farragut.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Sha512Hash {

	/**
	 * Generate an SHA-512 hash in Base64 format.
	 *
	 * @param input The data to hash
	 * @return The hash code
	 */
	public static String generate( String input ) {
		try {
			MessageDigest digest = MessageDigest.getInstance( "SHA-512" );
			byte[] buffer = digest.digest( input.getBytes() );
			return HexFormat.of().formatHex( buffer );
		} catch( NoSuchAlgorithmException e ) {
			throw new RuntimeException( e );
		}
	}

}
