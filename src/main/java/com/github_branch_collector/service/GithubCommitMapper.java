package com.github_branch_collector.service;

import com.github_branch_collector.domain.GithubCommit;
import com.github_branch_collector.received.CommitReceivedDto;
import org.springframework.stereotype.Component;

@Component
class GithubCommitMapper {
    
    static GithubCommit mapCommitReceivedDtoToGithubCommit(CommitReceivedDto commit) {
        return new GithubCommit(commit.sha());
    }
    
    static String mapGithubCommitToSha(GithubCommit commit) {
        return commit.getSha();
    }
}
