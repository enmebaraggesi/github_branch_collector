package com.github_branch_collector.service;

import com.github_branch_collector.domain.GithubRepository;
import com.github_branch_collector.received.RepositoryReceivedDto;
import com.github_branch_collector.response.RepositoryResponseDto;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
class GithubRepositoryMapper {
    
    static List<GithubRepository> mapRepositoryReceivedDtoArrayToNotForkedGithubRepositoryList(RepositoryReceivedDto[] array) {
        List<GithubRepository> repositories = mapRepositoryReceivedDtoArrayToGithubRepositoryList(array);
        return repositories.stream()
                           .filter(repo -> !repo.getFork())
                           .toList();
    }
    
    static List<RepositoryResponseDto> mapGithubRepositoryListToRepositoryResponseDtoList(List<GithubRepository> repositories) {
        return repositories.stream()
                           .map(GithubRepositoryMapper::mapGithubRepositoryToRepositoryResponseDto)
                           .toList();
    }
    
    private static List<GithubRepository> mapRepositoryReceivedDtoArrayToGithubRepositoryList(RepositoryReceivedDto[] array) {
        return Arrays.stream(array)
                     .map(GithubRepositoryMapper::mapRepositoryReceivedDtoToGithubRepository)
                     .toList();
    }
    
    private static RepositoryResponseDto mapGithubRepositoryToRepositoryResponseDto(GithubRepository repository) {
        return new RepositoryResponseDto(repository.getName(),
                                         GithubOwnerMapper.mapOwnerToOwnerName(repository.getOwner()),
                                         Collections.emptyList());
    }
    
    private static GithubRepository mapRepositoryReceivedDtoToGithubRepository(RepositoryReceivedDto dto) {
        return new GithubRepository(dto.name(),
                                    GithubOwnerMapper.mapOwnerReceivedDtoToOwner(dto.owner()),
                                    dto.fork());
    }
}
