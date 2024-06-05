package com.github_branch_collector.config;

import com.github_branch_collector.controller.GithubRepositoryController;
import com.github_branch_collector.response.RepositoryResponseDto;
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
    GithubRepositoryController controller;
    
    @Bean
    CommandLineRunner run() {
        return args -> {
            List<RepositoryResponseDto> repos = controller.getAllNotForkedReposForUser("kalqa");
            log.info(repos.toString());
        };
    }
}
