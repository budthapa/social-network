/**
 * 
 */
package com.budthapa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.budthapa.service.UserService;

/**
 * @author budthapa
 * Feb 18, 2017
 * 
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired 
	UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/register").permitAll()
				.antMatchers("/js/*","/css/*","/img/*").permitAll()
				.antMatchers("/viewstatus").hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
			.logout().permitAll();
	}
	/*
	 * Only Needed for inmemory authentication. Remove this code after implementing the real user in database
	 */
	/*
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("buddhi").password("123456").roles("USER");
	}
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}
	
	/*
	@Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
	  auth.inMemoryAuthentication().withUser("buddhi").password("123456").roles("USER");
	 }
	*/

	
}
