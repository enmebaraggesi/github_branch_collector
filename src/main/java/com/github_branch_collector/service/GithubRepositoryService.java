package com.github_branch_collector.service;

import com.github_branch_collector.domain.GithubBranch;
import com.github_branch_collector.domain.GithubRepository;
import com.github_branch_collector.error.*;
import com.github_branch_collector.received.BranchReceivedDto;
import com.github_branch_collector.received.RepositoryReceivedDto;
import com.github_branch_collector.response.RepositoryResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Log4j2
@Service
public class GithubRepositoryService {
    
    private final WebClient webClient;
    
    public GithubRepositoryService(WebClient webClient) {
        this.webClient = webClient;
    }
    
    public List<RepositoryResponseDto> getAllNotForkedReposForUser(String username, String accept) {
        log.info("Fetching not forked repositories for user {}", username);
        try {
            if (accept.equalsIgnoreCase("application/json")) {
                List<GithubRepository> repos = GithubRepositoryMapper.filterNotForkedRepositoriesOnly(fetchReposForUser(username));
                return GithubRepositoryMapper.mapGithubRepositoryListToRepositoryResponseDtoList(fitFetchedBranchesIntoRepositories(repos));
            } else if (accept.equalsIgnoreCase("application/xml")) {
                throw new XmlFormatException(accept);
            } else throw new NotAcceptableFormatException(accept);
        } catch (WebClientResponseException e) {
            throw new UserNotFoundException();
        }
    }
    
    private List<GithubRepository> fetchReposForUser(String username) {
        RepositoryReceivedDto[] receivedArray = webClient.get()
                                                         .uri("users/{username}/repos", username)
                                                         .accept(MediaType.APPLICATION_JSON)
                                                         .retrieve()
                                                         .bodyToMono(RepositoryReceivedDto[].class)
                                                         .block();
        return GithubRepositoryMapper.mapRepositoryReceivedDtoArrayToGithubRepositoryList(receivedArray);
    }
    
    private List<GithubBranch> fetchBranchesForRepository(GithubRepository repository) {
        String repo = repository.getName();
        String owner = repository.getOwner().getLogin();
        BranchReceivedDto[] receivedArray = webClient.get()
                                                     .uri("repos/{owner}/{repo}/branches", owner, repo)
                                                     .accept(MediaType.APPLICATION_JSON)
                                                     .retrieve()
                                                     .bodyToMono(BranchReceivedDto[].class)
                                                     .block();
        return GithubBranchMapper.mapBranchReceivedDtoArrayToGithubBranchList(receivedArray);
    }
    
    private List<GithubRepository> fitFetchedBranchesIntoRepositories(List<GithubRepository> repositories) {
        repositories.forEach(repository -> {
            List<GithubBranch> branches = fetchBranchesForRepository(repository);
            repository.setBranches(branches);
        });
        return repositories;
    }
}
