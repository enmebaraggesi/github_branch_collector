package com.github_branch_collector.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class GithubCommit {
    
    private final String sha;
}
