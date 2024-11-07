package com.esprit.spring;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bloc-route", r -> r.path("/bloc/**")
                        .uri("http://localhost:8081"))
                .route("foyer-route", r -> r.path("/foyer/**")
                        .uri("http://localhost:8090"))
                .route("universite-route", r -> r.path("/universite/**")
                        .uri("http://localhost:8910"))
                .route("chambre-route", r -> r.path("/chambre/**")
                        .uri("http://localhost:8082"))
                .route("reservation-route", r -> r.path("/reservation/**")
                        .uri("http://localhost:8091"))
                .route("etudiant-route", r -> r.path("/etudiant/**")
                        .uri("http://localhost:8087"))
                .route("enseignant-route", r -> r.path("/enseignant/**")
                        .uri("http://localhost:3000"))
                .build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());

        // Cors configuration for all routes
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:4200");  // Allow only your frontend (Angular app)
        config.addAllowedHeader("*");  // Allow all headers
        config.addAllowedMethod("*");  // Allow all methods (GET, POST, etc.)
        config.setAllowCredentials(true);  // Allow credentials (cookies, authorization headers, etc.)

        // Apply CORS configuration to both "/bloc/**" and "/foyer/**"
        source.registerCorsConfiguration("/**", config);  // This applies to all routes, including "foyer" and "bloc"

        return source;
    }
}
