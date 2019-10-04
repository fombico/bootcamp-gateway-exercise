package ca.lclbootcamp.gateway;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

@Configuration
public class FilterConfig {

    @Bean
    public GlobalFilter addUsernameHeader() {
        return (exchange, chain) -> exchange.getPrincipal()
                .filter(principal -> principal instanceof OAuth2AuthenticationToken)
                .cast(OAuth2AuthenticationToken.class)
                .map(token -> {
                    String name = (String) token.getPrincipal().getAttributes().get("user_name");
                    exchange.getRequest().mutate().header("Username", name).build();
                    return exchange;
                })
                .flatMap(chain::filter);
    }
}
