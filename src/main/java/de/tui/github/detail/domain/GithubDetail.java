/*
* Copyright (c) .
*/
package de.tui.github.detail.domain;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "GithubDetails model class. ")
@Data
public class GithubDetail  {
    private String repository;
    private String login;
    private String branch;
    private String lastCommit;

    public GithubDetail() {
    }

    public GithubDetail(String repository, String login, String branch, String lastCommit) {
        this.repository = repository;
        this.login = login;
        this.branch = branch;
        this.lastCommit = lastCommit;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getLastCommit() {
        return lastCommit;
    }

    public void setLastCommit(String lastCommit) {
        this.lastCommit = lastCommit;
    }

    @Override
    public String toString() {
        return "GithubDetail{" +
                "repository='" + repository + '\'' +
                ", login='" + login + '\'' +
                ", branch='" + branch + '\'' +
                ", lastCommit='" + lastCommit + '\'' +
                '}';
    }
}
