package pe.edu.upn.embarcadero41.config.security;

import java.util.ArrayList;
import java.util.List;

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
	private UsuarioDetailsService usuarioDetailsService;
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
				
				
				
				.antMatchers("/usuario/pedido/**").hasRole("IDENTIFICADO")
				.antMatchers("/usuario/**/nuevopedido").hasRole("IDENTIFICADO")
				.antMatchers("/pedido/del/**").hasRole("IDENTIFICADO")
				.antMatchers("/pedido/edit/**").hasRole("IDENTIFICADO")
				
				.antMatchers("/usuario/informacion/**").hasRole("CAMARERO")
				
				
				.antMatchers("/usuario/del").hasRole("GERENTE")
				.antMatchers("/plato/nuevo").hasRole("GERENTE")
				.antMatchers("/plato/del/**").hasRole("GERENTE")
				.antMatchers("/plato/edit/**").hasRole("GERENTE")
				
				.antMatchers("/usuario/del/**").hasRole("GERENTE")
				
				
				
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
            	.userDetailsService(usuarioDetailsService)
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
        daoAuthenticationProvider.setUserDetailsService(this.usuarioDetailsService);
        
       
        return daoAuthenticationProvider;
    }
	
}
