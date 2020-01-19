/*
 * Copyright (c)
 */
package de.tui.github.detail.business.impl;

import de.tui.github.detail.business.IGithubDetailBusiness;
import de.tui.github.detail.domain.GithubDetail;
import de.tui.github.detail.exception.GithubDetailException;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GithubDetailBusiness implements IGithubDetailBusiness {
    private static final Logger LOGGER = LoggerFactory.getLogger(GithubDetailBusiness.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.git.users}")
    public String gitRepos;

    @Value("${api.git.repos}")
    public String gitRepoBranch;

    /**
     * @param username
     * @return
     */
    @Override
    public List<GithubDetail> getGithubDetail(final String username) {
        try {
            //Finding the repositories by sending username in github api "https://api.github.com/users/{username}/repos"
            List<LinkedHashMap<String, String>> repos = restTemplate
                    .getForObject(gitRepos + username + "/repos", List.class);
            // if username matches to any git repositories then verify is that repo forks?
            if (CollectionUtils.isNotEmpty(repos)) {
                return gitBranches(username, repos);
            }else{
                throw new GithubDetailException("username is not found");
            }
        } catch (Exception e) {
            throw new GithubDetailException(e.getLocalizedMessage());
        }
    }

    /**
     * @param username
     * @param repos
     */
    private List<GithubDetail> gitBranches(String username, List<LinkedHashMap<String, String>> repos) {
        List<GithubDetail> details = new ArrayList<GithubDetail>();
        repos.forEach(repo -> {
            //validating against repository which is not forks, here forks count comes 0 then can can step forward
            if (StringUtils.equalsIgnoreCase(String.valueOf(repo.get("forks")), "0")) {
                LOGGER.info("Login by {}, repository is {} ", username, repo.get("name"));
                //finding the branches belongs to repository
                List<LinkedHashMap<String, String>> branches = restTemplate
                        .getForObject(gitRepoBranch + username + "/" + repo.get("name") + "/branches", List.class);
                 //if repository having branches then finding the branch name and last commit of branch
                 //else we just binding model with repository name and login value.
                if (CollectionUtils.isNotEmpty(branches)) {
                    LOGGER.info("Login by {}, repository is {} and count of the branches is {}",
                            username, repo.get("name"), branches.size());
                    branches.forEach(branch -> {
                        GithubDetail user = new GithubDetail();
                        user.setLogin(username);
                        user.setRepository(repo.get("name"));
                        user.setBranch(branch.get("name"));
                        try {
                            //sha is child of commit in branches object and query always gives latest commit values.
                            final JSONObject iibJson = JSONObject.fromObject(branch.get("commit"));
                            final JsonNode jsonNode = new ObjectMapper().readTree(iibJson.toString());
                            user.setLastCommit(jsonNode.get("sha").textValue());
                        } catch (Exception e) {throw new GithubDetailException();}
                        details.add(user);
                    });
                } else {
                    LOGGER.info("Login by {}, repository is {} does not have branches", username,repo.get("name"));
                    final GithubDetail user = new GithubDetail();
                    user.setLogin(username);
                    user.setRepository(repo.get("name"));
                    details.add(user);
                }
            }
        });
        return details;
    }
}
