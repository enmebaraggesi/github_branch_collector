package com.github_branch_collector.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class GithubBranch {
    
    private String name;
    private GithubCommit commit;
}
