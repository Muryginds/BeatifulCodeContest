package ru.sber.textcheckup.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class OpenAPIConfig {
    private final OpenAPIProperties properties;

    @Bean
    public OpenAPI customOpenApi() {
        Contact contact = new Contact()
                .name(properties.getContactName())
                .email(properties.getContactEmail())
                .url(properties.getContactUrl());
        License license = new License()
                .name("Apache 2.0")
                .url("http://springdoc.org");
        Info info = new Info()
                .title(properties.getTitle())
                .version(properties.getVersion())
                .description(properties.getDescription())
                .license(license)
                .contact(contact);
        Server devServer = new Server()
                .url(properties.getServerUrl())
                .description(properties.getServerDescription());
        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer));
    }
}
