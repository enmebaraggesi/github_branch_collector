package com.github_branch_collector.response;

import org.springframework.http.HttpStatus;

public record AcceptFormatExceptionResponseDto(HttpStatus status, String message) {

}
