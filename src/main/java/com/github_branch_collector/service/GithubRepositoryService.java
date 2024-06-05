package com.github_branch_collector.service;

import com.github_branch_collector.domain.GithubRepository;
import com.github_branch_collector.received.RepositoryReceivedDto;
import com.github_branch_collector.response.RepositoryResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Log4j2
@Service
public class GithubRepositoryService {
    
    private final WebClient webClient;
    
    public GithubRepositoryService(WebClient webClient) {
        this.webClient = webClient;
    }
    
    //"/users/{username}/repos"
    public List<RepositoryResponseDto> getAllNotForkedReposForUser(String username) {
        RepositoryReceivedDto[] receivedArray = webClient.get()
                                                         .uri("/users/{username}/repos", username)
                                                         .accept(MediaType.APPLICATION_JSON)
                                                         .retrieve()
                                                         .bodyToMono(RepositoryReceivedDto[].class)
                                                         .block();
        List<GithubRepository> repositories = GithubRepositoryMapper.mapRepositoryReceivedDtoArrayToGithubRepositoryList(receivedArray);
        List<GithubRepository> filteredRepositories = returnNotForkedReposList(repositories);
        return GithubRepositoryMapper.mapGithubRepositoryListToRepositoryResponseDtoList(filteredRepositories);
    }
    
    private List<GithubRepository> returnNotForkedReposList(List<GithubRepository> list) {
        return list.stream()
                   .filter(repo -> !repo.fork())
                   .toList();
    }
}
