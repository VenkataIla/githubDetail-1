/*
* Copyright (c) .
*/
package de.tui.github.detail.domain;
import io.swagger.annotations.ApiModel;

import lombok.Data;

import java.util.Objects;

@ApiModel(description = "GithubDetails model class. ")
@Data
public class GithubDetail {

  public String repository;  
  public String login;
  public String branch;
  public String lastCommit;

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
        return "GithubDetail [branch=" + getBranch() + ", lastCommit=" + getLastCommit() + ", login=" + getLogin() + ", repository="
                + getRepository() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubDetail that = (GithubDetail) o;
        return Objects.equals(repository, that.repository) &&
                Objects.equals(login, that.login) &&
                Objects.equals(branch, that.branch) &&
                Objects.equals(lastCommit, that.lastCommit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository, login, branch, lastCommit);
    }
}
