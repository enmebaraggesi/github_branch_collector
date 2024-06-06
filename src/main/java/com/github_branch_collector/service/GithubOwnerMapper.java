package com.github_branch_collector.service;

import com.github_branch_collector.domain.GithubOwner;
import com.github_branch_collector.received.OwnerReceivedDto;
import org.springframework.stereotype.Component;

@Component
class GithubOwnerMapper {
    
    static GithubOwner mapOwnerReceivedDtoToOwner(OwnerReceivedDto dto) {
        return new GithubOwner(dto.login());
    }
    
    static String mapOwnerToOwnerName(GithubOwner owner) {
        return owner.getLogin();
    }
}
