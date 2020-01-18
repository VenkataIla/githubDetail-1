/*
* Copyright (c).
*/
package de.tui.github.detail.controller;


import de.tui.github.detail.business.impl.GithubDetailBusiness;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


public class GithubDetailControllerTest {

    private MockRestServiceServer mockServer;
    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    private GithubDetailBusiness githubDetailBusiness ;

    @Before
    public void setup() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
        mockServer.expect(requestTo("/gitHubByLoginId")).andExpect(method( HttpMethod.POST))
                .andRespond(withSuccess("{json list response}", MediaType.APPLICATION_JSON));
        ReflectionTestUtils.setField ( githubDetailBusiness,
                "GITREPOS", "https://api.github.com/users/");
        ReflectionTestUtils.setField ( githubDetailBusiness,
                "GITREPOBRANCH", "https://api.github.com/repos/");
    }

    @BeforeEach
    void setMockOutput() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks 
    private GithubDetailController githubDetailController ;



    @DisplayName("Tests the getGitHub method for the GithubDetailController")
    @Test
    void testSave() {
        try {
            Assert.assertNotNull(this.githubDetailController.getGithubDetail("abc", "application/xml"));
            Assert.assertNotNull(this.githubDetailController.getGithubDetail("abc", "application/json"));
        }catch (Exception e){}

    }
}
