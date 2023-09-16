package ru.sber.textcheckup.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "openapi")
public class OpenAPIProperties {
    private String title;
    private String description;
    private String version;
    private String serverUrl;
    private String serverDescription;
    private String contactName;
    private String contactEmail;
    private String contactUrl;
}
