package com.github_branch_collector.error;

public class XmlFormatException extends RuntimeException {
    
    public XmlFormatException(String accept) {
        super("Accept header was: " + accept);
    }
}
