package com.github_branch_collector.domain;

public record GithubRepository(String name,
                               Owner owner,
                               Boolean fork) {
    
}
