package rs.spai.demogQL2;
import static org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
    //Définition des utilisateurs stockés en mémoire (In-memory)
	 @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        @SuppressWarnings("deprecation")
			UserDetails admin = withDefaultPasswordEncoder().username("admin")     //nom utilisateur  
	            .password("admin")  //mot de passe
	            .roles("ADMIN")          //le role
	            .build();
	        return new InMemoryUserDetailsManager(admin);         // Retourne un gestionnaire d'utilisateurs en mémoire avec l'utilisateur admin
	    }
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable()) 
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/graphql").authenticated()  // Nécessite l'authentification pour /graphql
	                .anyRequest().permitAll()
	            )
	            // Active l'authentification HTTP Basic
	            .httpBasic(httpBasic -> {}); 
	        return http.build();
	    }
}