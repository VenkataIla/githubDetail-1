/*
* Copyright (c).
*/
package de.tui.github.detail.business;

import java.util.List;

import de.tui.github.detail.domain.GithubDetail;

public interface IGithubDetailBusiness {
    
    List<GithubDetail> getGithubDetail(String username);
}
