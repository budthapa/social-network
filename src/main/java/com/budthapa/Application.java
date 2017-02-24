/**
 * 
 */
package com.budthapa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author budthapa
 * Feb 12, 2017
 * 
 */
@SpringBootApplication
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	
	@Bean
	PasswordEncoder getEncoder(){
		return new BCryptPasswordEncoder();
	}

}
