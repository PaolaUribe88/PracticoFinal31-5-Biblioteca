package cl.aiep.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ConfigSeguridadWeb extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//VAMOS A CONFIGURAR LAS RUTAS A NECESITAR
				http
					.authorizeRequests(authorize -> authorize
							.mvcMatchers("/inicio", "/listadoInicio", "/libro/buscar").permitAll()
							.mvcMatchers("/index", "/libro/**", "/autor/**").hasRole("ADMIN")
							.anyRequest().authenticated())
					.formLogin(form -> form 
							
							.defaultSuccessUrl("/libro/index", true)
							.permitAll()
						)
					
					.logout(logout -> logout
							.logoutRequestMatcher(new AntPathRequestMatcher("/salir", "GET"))
							);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web 
			.ignoring() 
			.mvcMatchers("/imagenes/**", "/css/**", "/js/**") 
		;
	}
}
