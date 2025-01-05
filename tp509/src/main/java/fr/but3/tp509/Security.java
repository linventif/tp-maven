package fr.but3.tp509;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class Security {
    @Bean
    public SecurityFilterChain mesautorisations(HttpSecurity http, HandlerMappingIntrospector introspector)
            throws Exception {
        MvcRequestMatcher.Builder mvc = new MvcRequestMatcher.Builder(introspector);
        return http.authorizeHttpRequests((authorize) -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers(mvc.pattern("/public")).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
//                after /logout, redirect to /public
                .logout(logout -> logout.logoutSuccessUrl("/public"))
                .rememberMe(rememberMe -> rememberMe
                        .key("uniqueAndSecret") // should be unique and secret and not hardcoded
                        .tokenValiditySeconds(60 * 60 * 24) // 24 hours
                )
                .build();
    }

    // EXO 2
    //    // to get the hash of the password use: spring help encodepassword : spring encodepassword -a bcrypt admin
    //    @Bean
    //    public UserDetailsService mesUtilisateurs() {
    //        UserDetails user1 = User.withUsername("admin")

    /// /                .password("$2a$10$oe4lY6mKDCx/.QJLl79kzefrRJY//N0yRuruwaTqkWzfCjn2cvBg6") // solution: admin
    //                .password(encoder().encode("admin"))
    //                .roles("ADMIN")
    //                .build();
    //        return new InMemoryUserDetailsManager(user1);
    //    }

    // EXO 3
    @Bean
    public UserDetailsService mesUtilisateurs(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}