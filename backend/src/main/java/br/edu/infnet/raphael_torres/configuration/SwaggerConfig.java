package br.edu.infnet.raphael_torres.configuration;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Microservice Auth API", version = "v1.0", description = "API de Midias", license = @License(name = "MIT", url = "http:localhost")))
public class SwaggerConfig {

}
