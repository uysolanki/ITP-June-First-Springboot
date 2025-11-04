package com.itp.ITPJuneFirstSpringboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyWebSecurity extends WebSecurityConfigurerAdapter
{

	@Override  //for Authentication
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication()
			.withUser("virat")
			.password("virat123")		// cleartext
	  		.authorities("ADMIN")		//roles
	  		.and()
	  		.withUser("rohit")
	  		.password("rohit123")		// cleartext
	  		.authorities("USER");		//role

	}
	
	@Override //for Authorisation
	protected void configure(HttpSecurity http) throws Exception {
		  http.authorizeRequests()
	        .anyRequest().authenticated()
	        .and()        
	        .formLogin().loginProcessingUrl("/login").successForwardUrl("/getAllProducts").permitAll()
	        .and()
	        .cors().and().csrf().disable();

	}
	
	@Bean
 	public PasswordEncoder getPasswordEncoder()
 	{
 		return NoOpPasswordEncoder.getInstance();
 	}

}
