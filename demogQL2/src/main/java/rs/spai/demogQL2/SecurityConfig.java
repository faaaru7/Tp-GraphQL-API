package rs.spai.demogQL2;
import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



//définit un seul utilisateur admin avec rôle ADMIN. En prod, tu utiliserais une base de données.

@Configuration
public class SecurityConfig {
	
	 @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        UserDetails admin = User.withDefaultPasswordEncoder()
	            .username("admin")       // ton username
	            .password("admin123")    // ton password
	            .roles("ADMIN")          // rôle admin
	            .build();
	        return new InMemoryUserDetailsManager(admin);
	    }

	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable())  // désactiver CSRF
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/graphql").authenticated() // protéger GraphQL
	                .anyRequest().permitAll()
	            )
	            .httpBasic(httpBasic -> {}); // httpBasic avec configuration par défaut

	        return http.build();
	    }
}