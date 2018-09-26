package org.jasr.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PortfolioApplication {
	
	@Bean
	  public WebSecurityConfigurerAdapter webSecurityConfig() {
	      return new WebSecurityConfigurerAdapter() {
	          @Override
	          protected void configure(HttpSecurity http) throws Exception {
	              http.authorizeRequests()
	                  .antMatchers("/admin/**").authenticated()
	                  .and()
	                  .antMatcher("/**").anonymous()
	                  .and()
	                  .formLogin().defaultSuccessUrl("/admin/index");
	          }

	          @Override
	          protected void configure(AuthenticationManagerBuilder builder) throws Exception {
	              BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	              builder.inMemoryAuthentication().passwordEncoder(passwordEncoder)
	                     .withUser("admin").password(passwordEncoder.encode("admin")).roles("USER")
	              ;
	          }
	      };
	  }


	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}
}
