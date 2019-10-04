package ca.lclbootcamp.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class WebConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .httpBasic().disable()
                .formLogin().disable()
                .csrf().disable()
                .logout().disable();

        http.authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .oauth2Login();
        return http.build();
    }
}
