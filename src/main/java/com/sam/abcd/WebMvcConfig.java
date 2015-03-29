package com.sam.abcd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sam.abcd.data.service.UserService;

public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	/***
    public @Override void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources");
    }
***/
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/access").setViewName("access");
	}
	
	@Bean
	public ApplicationSecurity applicationSecurity() {
		return new ApplicationSecurity();
	}

	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Configuration
	protected static class AuthenticationSecurity extends
	WebSecurityConfigurerAdapter {

		
		@Autowired
		private UserDetailsService userService;
		
		private static PasswordEncoder encoder;
		  
		//@Autowired
		//private DataSource dataSource;  //extends WebSecurityConfigurerAdapter
		
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			// @formatter:off
			auth.inMemoryAuthentication().withUser("admin").password("admin")
					.roles("ADMIN", "USER").and().withUser("user").password("user")
					.roles("USER");
			
			// @formatter:on
			
			//auth.userDetailsService(this.getAuthenticationService()).passwordEncoder(this.getPasswordEncoder());
			
			//auth.jdbcAuthentication().dataSource(this.dataSource);
			
			auth.userDetailsService(userService)
		        .passwordEncoder(getPasswordEncoder());
			
		}
		
		@Bean(name = "passwordEncoder")
	    public PasswordEncoder getPasswordEncoder() {
			if(encoder == null) {
			      encoder = new BCryptPasswordEncoder();
			    }
			 return encoder;
	    }

	}

	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest();
			
			http.authorizeRequests().antMatchers("/login").permitAll().anyRequest()
					.fullyAuthenticated().and().formLogin().loginPage("/login")
					.failureUrl("/login?error").and().logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
					.exceptionHandling().accessDeniedPage("/access?error");
			// @formatter:on
		}

	}

}