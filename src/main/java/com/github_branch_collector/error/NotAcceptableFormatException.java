package com.github_branch_collector.error;

public class NotAcceptableFormatException extends RuntimeException {
    
    public NotAcceptableFormatException(String accept) {
        super("Accept header was: " + accept);
    }
}
