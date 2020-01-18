/*
* Copyright (c) 
*/
package de.tui.github.detail.controller;

import de.tui.github.detail.business.IGithubDetailBusiness;
import de.tui.github.detail.domain.GithubDetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="GithubDetail Domain Object Controller")
@RestController
@RequestMapping(value = "/v1/github")
public class GithubDetailController {

    @Autowired
    private IGithubDetailBusiness githubDetailBusiness;     

    @GetMapping(value = "/detail", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Add a GithubDetail object to the database", response = ResponseEntity.class)
    @ApiResponses({
        @ApiResponse(code = 201, message = "Successfully created GithubDetail"),
        @ApiResponse(code = 400, message = "ERROR_CODE_MESSAGE_BAD_REQUEST"),
        @ApiResponse(code = 404, message = "NON_AUTHORITATIVE_INFORMATION"),
        @ApiResponse(code = 406, message = "NON_AUTHORITATIVE_INFORMATION"),
        @ApiResponse(code = 500, message = "ERROR_CODE_MESSAGE_INTERNAL_ERROR")
    })
    public ResponseEntity<List<GithubDetail>> getGithubDetail(
        @ApiParam(value = "GithubDetail object store in database table", required = true)
        @RequestParam final String username) {
        final List<GithubDetail> githubDetails = this.githubDetailBusiness.getGithubDetail(username);
        return new ResponseEntity<>(githubDetails, new HttpHeaders(), HttpStatus.OK);
    }



}
