package com.github_branch_collector.response;

import org.springframework.http.HttpStatus;

public record UserNotFoundExceptionResponseDto(HttpStatus status, String message) {

}
