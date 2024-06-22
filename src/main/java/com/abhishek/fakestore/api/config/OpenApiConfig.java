package com.abhishek.fakestore.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPISpecifications(@Value("${application-description}") String appDescription,
                                         @Value("${application-version}") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("FakeStore API")
                        .description(appDescription)
                        .version(appVersion)
                        .termsOfService("https://fakestoreapi.com/docs")
                        .contact(new Contact()
                                .name("Abhishek Kumar")
                                .email("your-email@gmail.com")
                                .url("https://example.com"))
                        .license(new License()
                                .name("springdoc-openapi")
                                .url("https://springdoc.org/#Introduction")))
                .externalDocs(new ExternalDocumentation()
                        .description("FakeStoreApi Documentation")
                        .url("https://fakestoreapi.com/docs"))
        .components(new Components()
                .addSecuritySchemes("bearer-key", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList("bearer-key"));
    }

}
