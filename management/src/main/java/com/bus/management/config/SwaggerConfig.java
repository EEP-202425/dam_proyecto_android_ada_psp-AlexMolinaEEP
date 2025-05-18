package com.bus.management.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Reserva de Autobuses")
                        .description("API REST para la gestión de reservas de autobuses")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Soporte Técnico")
                                .email("soporte@autobuses.com")
                        )
                );
    }
}
