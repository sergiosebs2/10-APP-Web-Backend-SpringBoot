package com.testTC.testTC.swagger;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "API Grosery Store",
                version = "1.0.0",
                description = "API creada para gestión backend de comercio."
        )
)
@Configuration
public class swaggerConfiguration {
}
