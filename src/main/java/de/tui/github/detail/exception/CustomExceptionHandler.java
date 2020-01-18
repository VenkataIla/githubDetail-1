package de.tui.github.detail.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        ErrorResponse apiError = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage() );
        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({ GithubDetailException.class })
    public ResponseEntity<Object> handlingJson(Exception ex, WebRequest request) {
        ErrorResponse apiError = new ErrorResponse(
                HttpStatus.NOT_FOUND, ex.getLocalizedMessage() );
        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({ GitHubDetailNotAcceptExcetion.class })
    public ResponseEntity<Object> handlingXml(Exception ex, WebRequest request) {
        ErrorResponse apiError = new ErrorResponse(
                HttpStatus.NOT_ACCEPTABLE, ex.getLocalizedMessage() );
        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}