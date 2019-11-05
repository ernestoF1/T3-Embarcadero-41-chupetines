package pe.edu.upn.embarcadero41.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private PersonalDetailsService personalDetailsService;
	@Autowired
	private ClienteDetailsService clienteDetailsService;
	
	@Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/index.html").permitAll()
				
				.antMatchers("/categoria/nuevo").hasRole("ADMIN")
				.antMatchers("/categoria/del/**").hasRole("ADMIN")
				.antMatchers("/categoria/edit/**").hasRole("ADMIN")
				.antMatchers("/categoria/**/nuevomodelo").hasRole("ADMIN")
				
				.antMatchers("/modelo/nuevo").hasRole("ADMIN")
				.antMatchers("/modelo/del/**").hasRole("ADMIN")
				.antMatchers("/modelo/edit/**").hasRole("ADMIN")
				.antMatchers("/modelo/**/nuevoproducto").hasRole("ADMIN")
				
				.antMatchers("/producto/nuevo").hasRole("ADMIN")
				.antMatchers("/producto/del/**").hasRole("ADMIN")
				.antMatchers("/producto/edit/**").hasRole("ADMIN")
				
				.antMatchers("/usuario/del/**").hasRole("ADMIN")
				/*
				.antMatchers("/medico").authenticated()
				*/
				
				
				/*.antMatchers("/categoria/**").authenticated()   .hasRole("ADMIN")*/
				
				/* la opcion nuevo tienes que ser admin para entrar por url */
				/*
				
				.antMatchers("/medico/del/**").hasRole("ADMIN")
				*/
			.and()
			.formLogin()
				.loginProcessingUrl("/signin")
				.loginPage("/login").permitAll()
				.usernameParameter("inputUsername")
                .passwordParameter("inputPassword")
			.and()
	        .logout()
	        	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        	.logoutSuccessUrl("/")
	        .and()
            .rememberMe()
            	.tokenValiditySeconds(2592000)
            	.key("Cl4v3.")
            	.rememberMeParameter("checkRememberMe")
            	.userDetailsService(personalDetailsService)
            	.userDetailsService(clienteDetailsService)
            .and()
                .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler);
		
	}
	
	@Bean
	PasswordEncoder passwordEncoder( ) {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.personalDetailsService);
        daoAuthenticationProvider.setUserDetailsService(clienteDetailsService);

        return daoAuthenticationProvider;
    }
	
}
