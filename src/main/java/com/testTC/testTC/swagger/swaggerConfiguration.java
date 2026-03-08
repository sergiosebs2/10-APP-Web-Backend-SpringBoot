package com.testTC.testTC.swagger;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "API BAZAR S.A.",
                version = "1.0.0",
                description = "API creada para gestión backend de comercio, con fines formativos.",
                contact = @Contact(
                        name = "Sergio Sanchez",
                        url = "https://github.com/sergiosebs2"
                )
        )
)
@Configuration
public class swaggerConfiguration {
}
