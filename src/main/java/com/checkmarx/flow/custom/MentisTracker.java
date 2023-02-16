package com.checkmarx.flow.custom;

import com.checkmarx.flow.dto.Issue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.checkmarx.flow.config.FlowProperties;
import com.checkmarx.flow.config.MentisProperties;
import com.checkmarx.flow.utils.ScanUtils;
import com.checkmarx.flow.exception.MachinaException;
import com.checkmarx.flow.exception.MachinaRuntimeException;
import com.checkmarx.flow.dto.ScanRequest;
import com.checkmarx.sdk.dto.ScanResults;
import org.springframework.web.client.RestOperations;
import org.springframework.boot.web.client.RestTemplateBuilder;


@Service("Mentis")
public class MentisTracker implements IssueTracker {
    private static final Logger log = LoggerFactory.getLogger(MentisTracker.class);
    private final MentisProperties properties;
    private RestOperations restOperations;

    @Autowired
    public MentisTracker(MentisProperties properties) {
        this.properties = properties;
    }

    @Override
    public void init(ScanRequest request, ScanResults results) throws MachinaException {
        log.info("Initializing MentisTracker...");
        // verifications
        if(ScanUtils.empty(properties.getApiUrl())) {
            throw new MachinaException("Service Now API Url must be provided in property config");
        }

        if(ScanUtils.empty(properties.getApiToken())){
            throw new MachinaException("Service Now API Rest Call requires api token");
        }

        restOperations = new RestTemplateBuilder()
                .defaultHeader("Authorization", properties.getApiToken())
                .build();

    }

    @Override
    public Issue createIssue(Issue issue) {
        log.info("Creating issue in MentisTracker...");
        // logic to create issue in Mentis bug tracker
        return issue;
    }

    @Override
    public Issue getIssue(String id) {
        log.info("Getting issue from MentisTracker...");
        // logic to retrieve issue from Mentis bug tracker
        return null;
    }
}
