package com.github_branch_collector.response;

import java.util.List;

public record RepositoryResponseDto(String repoName,
                                    String ownerName,
                                    List<BranchResponseDto> branches
) {

}
