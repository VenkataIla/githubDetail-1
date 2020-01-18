package de.tui.github.detail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class GitHubDetailNotAcceptExcetion extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public GitHubDetailNotAcceptExcetion() {
    }

    public GitHubDetailNotAcceptExcetion(final String message) {
        super(message);
    }
}
