package com.github_branch_collector.config;

import com.github_branch_collector.domain.GithubOwner;
import com.github_branch_collector.domain.GithubRepository;
import com.github_branch_collector.response.BranchResponseDto;
import com.github_branch_collector.service.GithubRepositoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Log4j2
@Configuration
public class RunnerConfig {
    
    @Autowired
    GithubRepositoryService service;
    
    @Bean
    CommandLineRunner run() {
        return args -> {
            GithubRepository repository = new GithubRepository("remigiusz-slabczynski-tic-tac-toe",
                                                               new GithubOwner("enmebaraggesi"),
                                                               false);
            List<BranchResponseDto> branches = service.getAllBranchesForRepository(repository);
            log.info(branches.toString());
        };
    }
}
