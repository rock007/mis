package com.sam.abcd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sam.abcd.data.service.UserAuthService;

public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/access").setViewName("access");
	}
	
	@Bean
	public ApplicationSecurity applicationSecurity() {
		return new ApplicationSecurity();
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Autowired
		private SecurityProperties security;

		@Autowired
		private UserAuthService userAuthService;
		
		private static PasswordEncoder encoder;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest()
					.fullyAuthenticated().and().formLogin().loginPage("/login")
					.failureUrl("/login?error").permitAll();
			
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			
			auth.userDetailsService(userAuthService)
		        .passwordEncoder(getPasswordEncoder());
			
			//auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		}
		
		@Bean(name = "passwordEncoder")
	    public PasswordEncoder getPasswordEncoder() {
			if(encoder == null) {
			      encoder = new BCryptPasswordEncoder();
			    }
			 return encoder;
	    }

	}

}