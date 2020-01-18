/*
* Copyright (c).
*/
package de.tui.github.detail.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GithubDetailExceptionTest {
    

    @DisplayName("Tests constructor for the exception")
    @Test
    void testException() {
        final GithubDetailException ex = new GithubDetailException("Test Exception Message");
        assertEquals(ex.getMessage(), "Test Exception Message");
    }
}
