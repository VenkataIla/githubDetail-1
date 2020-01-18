package de.tui.github.detail.exception;

import de.tui.github.detail.business.impl.GithubDetailBusiness;
import de.tui.github.detail.controller.GithubDetailController;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomExceptionHandlerTest {

    private String baseUrl = "http://localhost:8080";
    private String endpointToThrowException = "/v1/gitHubByLoginId";

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Mock
    RestTemplate restTemplate;
    @Mock
    Exception exception;
    @Mock
    WebRequest webRequest;
    @InjectMocks
    GithubDetailController detailController;

    @Test(expected = GithubDetailException.class)
    public void testNotFoundException() throws GithubDetailException{
        CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
        assertNotNull(customExceptionHandler.handleAll(exception, webRequest));
        assertNotNull(customExceptionHandler.handlingJson(exception, webRequest));
        assertNotNull(customExceptionHandler.handlingXml(exception, webRequest));

        assertFalse(githubException());

    }
    private boolean githubException()
    {
        throw new GithubDetailException();
    }
    @Test(expected = GitHubDetailNotAcceptExcetion.class)
    public void testNotAcceptException() {
       when(detailController.getGithubDetail("abcd;;","application/xml")).thenThrow(new GitHubDetailNotAcceptExcetion());
        when(detailController.getGithubDetail("","")).thenThrow(new Throwable());
    }
}


