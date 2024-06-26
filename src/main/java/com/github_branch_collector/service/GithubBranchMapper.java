package com.github_branch_collector.service;

import com.github_branch_collector.domain.GithubBranch;
import com.github_branch_collector.received.BranchReceivedDto;
import com.github_branch_collector.response.BranchResponseDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
class GithubBranchMapper {
    
    static List<BranchResponseDto> mapGithubBranchListToBranchResponseDtoList(List<GithubBranch> list) {
        return list.stream()
                   .map(GithubBranchMapper::mapGithubBranchToBranchResponseDto)
                   .toList();
    }
    
    static List<GithubBranch> mapBranchReceivedDtoArrayToGithubBranchList(BranchReceivedDto[] array) {
        return Arrays.stream(array)
                     .map(GithubBranchMapper::mapBranchReceivedDtoToGithubBranch)
                     .toList();
    }
    
    private static GithubBranch mapBranchReceivedDtoToGithubBranch(BranchReceivedDto dto) {
        return new GithubBranch(dto.name(),
                                GithubCommitMapper.mapCommitReceivedDtoToGithubCommit(dto.commit()));
    }
    
    private static BranchResponseDto mapGithubBranchToBranchResponseDto(GithubBranch branch) {
        return new BranchResponseDto(branch.getName(),
                                     GithubCommitMapper.mapGithubCommitToSha(branch.getCommit()));
    }
}
