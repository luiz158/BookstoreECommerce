package com.bookstore.utility;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {
	// Salt should be protected carefully
	private static final String SALT = "salt";

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}

	@Bean
	public static String randomPasswordGenerator() {
		String SALTCHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random random = new Random();

		while (salt.length() < 18) {
			int index = (int) (random.nextFloat() * SALTCHAR.length());
			salt.append(SALTCHAR).charAt(index);
		}
		String saltStr = salt.toString();
		return saltStr;
	}
}
