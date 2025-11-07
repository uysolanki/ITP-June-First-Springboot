package com.itp.ITPJuneFirstSpringboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyWebSecurity //extends WebSecurityConfigurerAdapter
{

//	@Override  //for Authentication
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 auth.inMemoryAuthentication()
//			.withUser("virat")
//			.password("virat123")		// cleartext
//	  		.authorities("ADMIN")		//roles
//	  		.and()
//	  		.withUser("rohit")
//	  		.password("rohit123")		// cleartext
//	  		.authorities("USER");		//role
		
//		auth.authenticationProvider(myAuthenticationProvider());

//	}
	
	@Configuration
	public class SecurityConfiguration {

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    	http.authorizeRequests()
	        .requestMatchers("/","/addProductForm","/getAllProducts","/403").hasAnyAuthority("USER","ADMIN")
	        .requestMatchers("/deleteProduct/**","/updateProductForm/**").hasAuthority("ADMIN")
	        .anyRequest().authenticated()
	        .and()
	        .formLogin().loginProcessingUrl("/login").successForwardUrl("/getAllProducts").permitAll()
	        .and()
	        .logout().logoutSuccessUrl("/login").permitAll()
	        .and()
	        .exceptionHandling().accessDeniedPage("/403")
	        .and()
	        .cors().and().csrf().disable();
	    	
	    	http.authenticationProvider(myAuthenticationProvider());
	        return http.build();
	    }

	}
	
	@Bean
	public AuthenticationProvider myAuthenticationProvider() {
		DaoAuthenticationProvider daoProvider=new DaoAuthenticationProvider();
		daoProvider.setUserDetailsService(mySetUserDetailsService());
		daoProvider.setPasswordEncoder(mysetPasswordEncoder());
		return daoProvider;
	}

	@Bean
	public PasswordEncoder mysetPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService mySetUserDetailsService() {
		return new MyUserDetailsService();
	}

//	@Override //for Authorisation
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//        .antMatchers("/","/addProductForm","/getAllProducts","/403").hasAnyAuthority("USER","ADMIN")
//        .antMatchers("/deleteProduct/**","/updateProductForm/**").hasAuthority("ADMIN")
//        .anyRequest().authenticated()
//        .and()
//        .formLogin().loginProcessingUrl("/login").successForwardUrl("/getAllProducts").permitAll()
//        .and()
//        .logout().logoutSuccessUrl("/login").permitAll()
//        .and()
//        .exceptionHandling().accessDeniedPage("/403")
//        .and()
//        .cors().and().csrf().disable();
//
//	}
	
//	@Bean
// 	public PasswordEncoder getPasswordEncoder()
// 	{
// 		return NoOpPasswordEncoder.getInstance();
// 	}

}
