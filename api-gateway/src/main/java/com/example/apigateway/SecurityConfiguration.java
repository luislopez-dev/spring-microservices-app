/*
 * Author: Luis López
 * Website: https://github.com/luislopez-dev
 * Description: Training Project
 */
package com.example.apigateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain SecurityWebFilterChain (ServerHttpSecurity httpSecurity) {
        httpSecurity.authorizeExchange(authorizeExchangeSpec -> authorizeExchangeSpec.anyExchange().authenticated())
        .oauth2Login(Customizer.withDefaults());

        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
