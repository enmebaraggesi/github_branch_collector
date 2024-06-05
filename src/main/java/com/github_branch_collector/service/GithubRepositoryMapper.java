package com.github_branch_collector.service;

import com.github_branch_collector.domain.GithubRepository;
import com.github_branch_collector.received.RepositoryReceivedDto;
import com.github_branch_collector.response.RepositoryResponseDto;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
class GithubRepositoryMapper {
    
    static List<GithubRepository> mapRepositoryReceivedDtoArrayToGithubRepositoryList(RepositoryReceivedDto[] array) {
        return Arrays.stream(array)
                     .map(GithubRepositoryMapper::mapRepositoryReceivedDtoToGithubRepository)
                     .toList();
    }
    
    static List<RepositoryResponseDto> mapGithubRepositoryListToRepositoryResponseDtoList(List<GithubRepository> list) {
        return list.stream()
                   .map(GithubRepositoryMapper::mapGithubRepositoryToRepositoryResponseDto)
                   .toList();
    }
    
    private static RepositoryResponseDto mapGithubRepositoryToRepositoryResponseDto(GithubRepository repository) {
        return new RepositoryResponseDto(repository.name(),
                                         OwnerMapper.mapOwnerToOwnerName(repository.owner()),
                                         Collections.emptyList());
    }
    
    private static GithubRepository mapRepositoryReceivedDtoToGithubRepository(RepositoryReceivedDto dto) {
        return new GithubRepository(dto.name(),
                                    OwnerMapper.mapOwnerReceivedDtoToOwner(dto.owner()),
                                    dto.fork());
    }
}
