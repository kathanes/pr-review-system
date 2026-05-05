package com.pr.review.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "azure.devops")
@Getter
@Setter
public class AzureDevOpsConfig {
    private String org;
    private String project;
    private String repoId;
    private String pat;
    private String baseUrl;
    private String collection;
}
