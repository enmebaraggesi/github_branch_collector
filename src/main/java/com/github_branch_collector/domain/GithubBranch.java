package com.github_branch_collector.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class GithubBranch {
    
    private final String name;
    private final GithubCommit commit;
}
