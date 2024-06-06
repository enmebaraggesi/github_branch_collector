package com.github_branch_collector.received;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BranchReceivedDto(String name,
                                CommitReceivedDto commit) {
    
}
