package com.github_branch_collector.service;

import com.github_branch_collector.domain.GithubRepository;
import com.github_branch_collector.received.RepositoryReceivedDto;
import com.github_branch_collector.response.RepositoryResponseDto;
import org.springframework.stereotype.Component;

@Component
class GithubRepositoryMapper {
    
    GithubRepository mapRepositoryReceivedDtoToGithubRepository(RepositoryReceivedDto receivedDto) {
        return null;
    }
    
    RepositoryResponseDto mapGithubRepositoryToRepositoryResponseDto(GithubRepository githubRepository) {
        return null;
    }
}
