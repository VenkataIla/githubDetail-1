/*
* Copyright (c).
*/
package de.tui.github.detail.controller;

import de.tui.github.detail.business.IGithubDetailBusiness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class GithubDetailControllerTest {

    @Mock 
    private IGithubDetailBusiness githubDetailBusiness;

    @InjectMocks 
    private GithubDetailController githubDetailController = new GithubDetailController();

    @BeforeEach
    void setMockOutput() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Tests the getGitHub method for the GithubDetailController")
    @Test
    void testSave() {
        this.githubDetailController.getGithubDetail("abc");
    }
}
