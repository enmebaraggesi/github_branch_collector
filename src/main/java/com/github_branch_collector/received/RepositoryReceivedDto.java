package com.github_branch_collector.received;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RepositoryReceivedDto(String name,
                                    OwnerReceivedDto owner,
                                    Boolean fork,
                                    String branches_url) {
    
}
