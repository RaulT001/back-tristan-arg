package com.argmoviles.backend.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		/*.antMatchers(HttpMethod.GET, "/api/productos/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/productos").hasRole("ADMIN")
		.antMatchers("/api/productos/**").hasRole("ADMIN")*/
		
		
		/* activaciones */
		.antMatchers(HttpMethod.GET, "/api/activaciones").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.GET, "/api/activaciones/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/activaciones").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/activaciones/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/activaciones/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/api/activaciones/activacionesExcel").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/activaciones/filterByMonth").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/activaciones/filterByDay").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/activaciones/ventaDiaNeto/{year}/{month}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/activaciones/ventaPromotorNeto").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api//activaciones/puntoPromotorNeto").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.GET, "/api/activaciones/**").hasAnyRole("USER", "ADMIN")
		
		/* clientes */
		.antMatchers(HttpMethod.GET, "/api/clientes").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/clientes").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/clientes/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/clientes/{id}").hasRole("ADMIN")
		
		/* ingresos */
		.antMatchers(HttpMethod.GET, "/api/ingresos").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.GET, "/api/ingresos/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/ingresos").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/ingresos/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/ingresos/{id}").hasRole("ADMIN")
		
		/* llamadas */
		.antMatchers(HttpMethod.GET, "/api/llamadas").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.GET, "/api/llamadas/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/llamadas").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/llamadas/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/llamadas/{id}").hasRole("ADMIN")
		
		/* netos */
		.antMatchers(HttpMethod.GET, "/api/netos").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.GET, "/api/netos/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/netos").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/netos/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/netos/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/api/netos/netosFilter").hasAnyRole("USER", "ADMIN")
		
		/* productos */
		.antMatchers(HttpMethod.GET, "/api/productos").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.GET, "/api/productos/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/productos").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/productos/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/productos/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/api/productos/productosFilter").hasAnyRole("USER", "ADMIN")
		
		/* vendedores */
		.antMatchers(HttpMethod.GET, "/api/vendedores").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.GET, "/api/vendedores/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/vendedores").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/vendedores/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/vendedores/{id}").hasRole("ADMIN")
		
		
		
		
		/*.antMatchers("/api/activaciones/**").hasRole("ADMIN")
		.antMatchers("/api/clientes/**").hasRole("ADMIN")
		.antMatchers("/api/ingresos/**").hasRole("ADMIN")
		.antMatchers("/api/llamadas/**").hasRole("ADMIN")
		.antMatchers("/api/netos/**").hasRole("ADMIN")
		.antMatchers("/api/vendedores/**").hasRole("ADMIN")*/
		
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
	}
	
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		//config.setAllowedOrigins(Arrays.asList("http://80.240.126.60"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	
}
