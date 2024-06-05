package com.github_branch_collector.service;

import com.github_branch_collector.domain.GithubBranch;
import com.github_branch_collector.received.BranchReceivedDto;
import com.github_branch_collector.response.BranchResponseDto;
import org.springframework.stereotype.Component;

@Component
class GithubBranchMapper {
    
    static GithubBranch mapBranchReceivedDtoToGithubBranch(BranchReceivedDto receivedDto) {
        return null;
    }
    
    static BranchResponseDto mapGithubBranchToBranchResponseDto(GithubBranch githubBranch) {
        return null;
    }
}
