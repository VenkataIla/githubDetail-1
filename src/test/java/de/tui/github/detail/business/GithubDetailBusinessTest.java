/*
* Copyright (c).
*/
package de.tui.github.detail.business;

import de.tui.github.detail.business.impl.GithubDetailBusiness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class GithubDetailBusinessTest {


    @InjectMocks
    private IGithubDetailBusiness githubDetailBusiness = new GithubDetailBusiness();

    @BeforeEach
    void setMockOutput() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Test the streamer is connected method for IGithubDetailBusiness")
    @Test
    void testGithubDetailBusiness() {
        this.githubDetailBusiness.getGithubDetail("abc");
    }
}