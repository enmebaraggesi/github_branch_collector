package com.github_branch_collector.service;

import com.github_branch_collector.domain.GithubRepository;
import com.github_branch_collector.received.BranchReceivedDto;
import com.github_branch_collector.received.RepositoryReceivedDto;
import com.github_branch_collector.response.BranchResponseDto;
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
    
    public List<RepositoryResponseDto> getAllNotForkedReposForUser(String username) {
        RepositoryReceivedDto[] receivedArray = webClient.get()
                                                         .uri("users/{username}/repos", username)
                                                         .accept(MediaType.APPLICATION_JSON)
                                                         .retrieve()
                                                         .bodyToMono(RepositoryReceivedDto[].class)
                                                         .block();
        List<GithubRepository> repositories = GithubRepositoryMapper.mapRepositoryReceivedDtoArrayToNotForkedGithubRepositoryList(receivedArray);
        return GithubRepositoryMapper.mapGithubRepositoryListToRepositoryResponseDtoList(repositories);
    }
    
    public List<BranchResponseDto> getAllBranchesForRepository(GithubRepository repository) {
        String repo = repository.getName();
        String owner = repository.getOwner().getLogin();
        BranchReceivedDto[] receivedArray = webClient.get()
                                                     .uri("repos/{owner}/{repo}/branches", owner, repo)
                                                     .accept(MediaType.APPLICATION_JSON)
                                                     .retrieve()
                                                     .bodyToMono(BranchReceivedDto[].class)
                                                     .block();
        return GithubBranchMapper.mapBranchReceivedDtoArrayToBranchResponseDtoList(receivedArray);
    }
}
