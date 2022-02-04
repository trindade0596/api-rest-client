package com.brasilprev.test.brasilprevtest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .httpBasic()
        .and()
        .csrf().disable();
    }
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	 PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 auth.inMemoryAuthentication()
	  .withUser("user").password(encoder.encode("java")).roles("USER")
	  .and()
	  .withUser("admin").password(encoder.encode("java")).roles("USER", "ADMIN");
	}

}
