package org.jasr.portfolio;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").authenticated().and().antMatcher("/**").anonymous().and().logout().permitAll().and().formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/admin/index").permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("------------------------------------------- " + passwordEncoder.encode("admin"));
		builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
	}

}
