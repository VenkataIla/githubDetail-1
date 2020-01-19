
package de.tui.github.detail.exception;

import de.tui.github.detail.business.IGithubDetailBusiness;
import de.tui.github.detail.business.impl.GithubDetailBusiness;
import de.tui.github.detail.controller.GithubDetailController;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


public class CustomExceptionHandlerTest {

    @Autowired
    private MockRestServiceServer mockServer;
    @Autowired
    private MockMvc mvc;
    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    Exception exception;
    @InjectMocks
    WebRequest webRequest;
    @Mock
    HttpStatus httpStatus;
    @InjectMocks
    ErrorResponse errorResponse;

    @InjectMocks
    GithubDetailController githubDetailController = new GithubDetailController();
    @InjectMocks
    private IGithubDetailBusiness githubDetailBusiness = new GithubDetailBusiness();
    @InjectMocks
    public CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();


    private ExceptionHandlerExceptionResolver createExceptionResolver() {
        ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
            @Override
            protected ServletInvocableHandlerMethod getExceptionHandlerMethod(
                    HandlerMethod handlerMethod, Exception exception) {
                Method method = new ExceptionHandlerMethodResolver(
                        CustomExceptionHandler.class).resolveMethod(exception);
                return new ServletInvocableHandlerMethod(
                       new CustomExceptionHandler(), method);
            }
        };
        exceptionResolver.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        exceptionResolver.afterPropertiesSet();
        return exceptionResolver;
    }

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(new GithubDetailController())
                .setControllerAdvice(new CustomExceptionHandler())
                .setHandlerExceptionResolvers(createExceptionResolver())
                .build();
    }
    @BeforeEach
    void setMockOutput() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testNotFoundException() {
        assertNotNull(customExceptionHandler.handleAll(new Exception(), webRequest));
        assertNotNull(customExceptionHandler.handlingJson(new Exception(), webRequest));
        assertNotNull(customExceptionHandler.handlingXml(new Exception() , webRequest));
    }

    @Test
   public void testXml1() throws GitHubDetailNotAcceptExcetion {
        try {
            when(githubDetailController.getGithubDetail("abc", "application/xml")).thenThrow(new GitHubDetailNotAcceptExcetion());
        }catch (Exception e){}
    }
    @Test
    public void testJson1() throws GithubDetailException {
        try {
            when(this.githubDetailBusiness.getGithubDetail("vesdfasdfasfasnkat")).thenThrow(new GithubDetailException());
        }catch (Exception e){}
    }
    @Test
    public void testException() throws  Exception {
        try {
            when(this.githubDetailController.getGithubDetail("", "")).thenThrow(new Exception());
        }catch (Exception e){}

    }

}



