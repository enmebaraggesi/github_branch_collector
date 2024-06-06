package com.github_branch_collector.error;

import com.github_branch_collector.controller.GithubRepositoryController;
import com.github_branch_collector.response.AcceptFormatExceptionResponseDto;
import com.github_branch_collector.response.UserNotFoundExceptionResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestControllerAdvice(assignableTypes = GithubRepositoryController.class)
public class ClientErrorHandler {
    
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public UserNotFoundExceptionResponseDto handleUserNotFoundExceptionException(UserNotFoundException e) {
        log.error(e);
        return new UserNotFoundExceptionResponseDto(HttpStatus.valueOf(404),
                                                    e.getMessage());
    }
    
    @ExceptionHandler(XmlFormatException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public AcceptFormatExceptionResponseDto handleXmlFormatException(XmlFormatException e) {
        log.error(e);
        return new AcceptFormatExceptionResponseDto(HttpStatus.NOT_ACCEPTABLE,
                                                    "Your Accept header is invalid. Our client accepts only application/json");
    }
    
    @ExceptionHandler(NotAcceptableFormatException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public AcceptFormatExceptionResponseDto handleNotAcceptableFormatException(NotAcceptableFormatException e) {
        log.error(e);
        return new AcceptFormatExceptionResponseDto(HttpStatus.NOT_ACCEPTABLE,
                                                    "Your Accept header is invalid. Our client accepts only application/json");
    }
}
