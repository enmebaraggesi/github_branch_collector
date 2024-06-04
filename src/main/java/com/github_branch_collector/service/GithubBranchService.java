package com.github_branch_collector.service;

import com.github_branch_collector.response.RepositoryResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubBranchService {
    
    @Value("${github.api.url}")
    String githubApiUrl;
    
    private final GithubBranchMapper branchMapper;
    private final GithubRepositoryMapper repositoryMapper;
    
    GithubBranchService(GithubBranchMapper branchMapper, GithubRepositoryMapper repositoryMapper) {
        this.branchMapper = branchMapper;
        this.repositoryMapper = repositoryMapper;
    }
    
    //"/users/{username}/repos"
    public List<RepositoryResponseDto> getAllNotForkedReposForUser(String username, String accept) {
        return null;
    }
}
