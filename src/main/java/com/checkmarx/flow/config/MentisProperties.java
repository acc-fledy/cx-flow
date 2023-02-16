package com.checkmarx.flow.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties(prefix = "mentis")

public class MentisProperties extends RepoProperties {

    private String apiToken;
    private String apiUrl;


    /* getters & setters */

    public String getApiToken() {
        return apiToken;
    }

    @Override
    public String getApiUrl() {
        return apiUrl;
    }
}
