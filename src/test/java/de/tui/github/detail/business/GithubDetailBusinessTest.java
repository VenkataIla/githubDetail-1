/*
* Copyright (c).
*/
package de.tui.github.detail.business;

import de.tui.github.detail.business.impl.GithubDetailBusiness;

import de.tui.github.detail.exception.GithubDetailException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
@RunWith(SpringRunner.class)
public class GithubDetailBusinessTest {
   @Autowired
    private MockRestServiceServer mockServer;
    @Mock
    RestTemplate restTemplate;
    @Mock
    RestTemplate restTemplate1;
    @InjectMocks
    private IGithubDetailBusiness githubDetailBusiness = new GithubDetailBusiness();
    @Value("${api.git.users}")
    public String gitRepos;

    @Value("${api.git.repos}")
    public String gitRepoBranch;
    @Before
    public void setup() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
        mockServer.expect(requestTo("/gitHubDetails")).andExpect(method( HttpMethod.POST))
                .andRespond(withSuccess("{json list response}", MediaType.APPLICATION_JSON));
        ReflectionTestUtils.setField ( githubDetailBusiness,
                "GITREPOS", "GITREPOS");
        ReflectionTestUtils.setField ( githubDetailBusiness,
                "GITREPOBRANCH", "GITREPOBRANCH");
    }

    @BeforeEach
    void setMockOutput() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Test the streamer is connected method for IGithubDetailBusiness")
    @Test
    public void testGithubDetailBusinessThrows() {

        try {
            Mockito.when(this.githubDetailBusiness.getGithubDetail("vesdfasdfasfasnkat")).thenThrow(new GithubDetailException());
        }catch (Exception e){}
    }
    @Test
    public void testGetBranch()
    {
        try {
            MockitoAnnotations.initMocks(this);
            // mock the student repository to provide a list of 3 students.
            List<LinkedHashMap<String, String>> repos = new ArrayList<LinkedHashMap<String, String>>();
            List<LinkedHashMap<String, String>> branches = new ArrayList<LinkedHashMap<String, String>>();
            LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<>();
            stringStringLinkedHashMap.put("name","adf");
            stringStringLinkedHashMap.put("forks","0");
            repos.add(stringStringLinkedHashMap);
            branches.add(stringStringLinkedHashMap);
            Mockito.when(
                    restTemplate.getForObject(
                            gitRepos + "venkat" + "/repos",
                            List.class
                    )
            ).thenReturn(repos);

            Assert.assertNotNull(this.githubDetailBusiness.getGithubDetail("venkat"));
            Mockito.when(
                    restTemplate1.getForObject(gitRepoBranch  + "venkat" + "/"
                            + repos.get(0).get("name") + "/branches", List.class
                    )
            ).thenReturn(branches);
        }catch (Exception e){}
    }
}