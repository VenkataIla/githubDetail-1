/*
* Copyright (c).
*/
package de.tui.github.detail.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GithubDetailExceptionTest {
    

    @DisplayName("Tests constructor for the exception")
    @Test
    void testException() {
        final GithubDetailException ex = new GithubDetailException("Test Exception Message");
        assertEquals("Test Exception Message",ex.getMessage());
    }

    @Test
    void testNotAcceptException() {
        final GitHubDetailNotAcceptExcetion ex = new GitHubDetailNotAcceptExcetion("Test Exception Message");
        assertEquals("Test Exception Message",ex.getMessage());
    }

    @Test
    void testErrorRespose() {
        ErrorResponse errorResponse = new ErrorResponse();
        assertNotNull(errorResponse.hashCode());
        errorResponse.setMessage("");
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        assertEquals(true, errorResponse.equals(errorResponse));
        assertNotNull(errorResponse.toString());
        ErrorResponse errorResponse2 = new ErrorResponse(HttpStatus.NOT_ACCEPTABLE,"error");
        assertEquals(false, errorResponse.equals(errorResponse2));

    }
}
