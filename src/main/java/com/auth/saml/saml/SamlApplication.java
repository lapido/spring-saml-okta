package com.auth.saml.saml;

import com.github.ulisesbocchio.spring.boot.security.saml.annotation.EnableSAMLSSO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSAMLSSO
public class SamlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamlApplication.class, args);
	}

}
