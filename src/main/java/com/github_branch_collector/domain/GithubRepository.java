package com.github_branch_collector.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class GithubRepository {
    
    private final String name;
    private final GithubOwner owner;
    private final Boolean fork;
}
