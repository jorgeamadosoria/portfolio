package org.jasr.portfolio;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PortfolioApplication implements WebMvcConfigurer {

	@Autowired
	private DataSource dataSource;

	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfig() {
		return new WebSecurityConfigurerAdapter() {
			@Override
			protected void configure(HttpSecurity http) throws Exception {
				http.authorizeRequests().antMatchers("/admin/**").authenticated().and().antMatcher("/**").anonymous().and().logout().permitAll().and().formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/admin/index").permitAll();
			}

			@Override
			protected void configure(AuthenticationManagerBuilder builder) throws Exception {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);//.withUser("admin").password("admin").roles("USER");
			}
		};
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}
}
