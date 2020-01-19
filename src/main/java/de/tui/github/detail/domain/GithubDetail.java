/*
* Copyright (c) .
*/
package de.tui.github.detail.domain;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel(description = "GithubDetails model class. ")
@Data
public class GithubDetail implements Serializable {

    private String repository;
    private String login;
    private String branch;
    private String lastCommit;

}
