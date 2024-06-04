package com.github_branch_collector.controller;

import com.github_branch_collector.response.RepositoryResponseDto;
import com.github_branch_collector.service.GithubBranchService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class GithubBranchController {
    
    private final GithubBranchService githubBranchService;
    
    public GithubBranchController(GithubBranchService githubBranchService) {
        this.githubBranchService = githubBranchService;
    }
    
    @GetMapping("/repos/{username}")
    public List<RepositoryResponseDto> getAllNotForkedReposForUser(@PathVariable String username,
                                                                   @RequestHeader String accept) {
        List<RepositoryResponseDto> responseDtos = githubBranchService.getAllNotForkedReposForUser(username, accept);
        return Collections.emptyList();
    }
    
}
