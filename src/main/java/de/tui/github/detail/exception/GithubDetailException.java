/*
 * Copyright (c)
 * @author Venkata Ila
 */
package de.tui.github.detail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GithubDetailException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public GithubDetailException() {
    }

    public GithubDetailException(final String message) {
        super(message);
    }
}