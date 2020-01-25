/*
* Copyright (c) 
*/
package de.tui.github.detail.controller;

import de.tui.github.detail.business.IGithubDetailBusiness;
import de.tui.github.detail.domain.GithubDetail;

import java.util.List;

import de.tui.github.detail.exception.GitHubDetailNotAcceptExcetion;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="GithubDetail Domain Object Controller")
@RestController
@RequestMapping(value = "/v1")
public class GithubDetailController {

    @Autowired
    private IGithubDetailBusiness githubDetailBusiness;     

    @GetMapping(value = "/gitHubDetails/{username}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Add a GithubDetail object to the database", response = ResponseEntity.class)
    @ApiResponses({
        @ApiResponse(code = 201, message = "Successfully created GithubDetail"),
        @ApiResponse(code = 400, message = "ERROR_CODE_MESSAGE_BAD_REQUEST"),
        @ApiResponse(code = 500, message = "ERROR_CODE_MESSAGE_INTERNAL_ERROR")
    })
    public ResponseEntity<List<GithubDetail>> getGithubDetail(
        @ApiParam(value = "GithubDetail object store in database table", required = true)
        @PathVariable final String username, @RequestHeader("Accept") String contentType) {
        if(StringUtils.equalsIgnoreCase(contentType,"application/xml"))
        {
            throw new GitHubDetailNotAcceptExcetion("406 Could not find acceptable representation");
        }
        final List<GithubDetail> githubDetails = this.githubDetailBusiness.getGithubDetail(username);
        return new ResponseEntity<>(githubDetails, new HttpHeaders(), HttpStatus.OK);
    }



}
