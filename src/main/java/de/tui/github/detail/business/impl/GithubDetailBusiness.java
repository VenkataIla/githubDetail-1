/*
 * Copyright (c)
 */
package de.tui.github.detail.business.impl;

import de.tui.github.detail.business.IGithubDetailBusiness;
import de.tui.github.detail.domain.GithubDetail;
import de.tui.github.detail.exception.GithubDetailException;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GithubDetailBusiness implements IGithubDetailBusiness {
    private static final Logger LOGGER = LoggerFactory.getLogger(GithubDetailBusiness.class);

    @Autowired
    RestTemplate restTemplate;

    public static final String GITREPOS = "https://api.github.com/users/";
    public static final String GITREPOBRANCH = "https://api.github.com/repos/";

    @Override
    public List<GithubDetail> getGithubDetail(final String username) {
        List<GithubDetail> details = new ArrayList<>();
        try {
            List<LinkedHashMap<String, String>> repos = restTemplate
                    .getForObject(GITREPOS + username + "/repos", List.class);
            repos.forEach(repo -> {
                if (StringUtils.equalsIgnoreCase(String.valueOf(repo.get("forks")),"0")) {
                    LOGGER.info("Login by {}, repository is {} ", username, repo.get("name"));
                    List<LinkedHashMap<String, String>> branchs = restTemplate
                            .getForObject(GITREPOBRANCH + username + "/" + repo.get("name") + "/branches", List.class);
                    LOGGER.info("Login by {}, repository is {} and count of the branches is {}",
                            username, repo.get("name"), branchs.size());
                    if (CollectionUtils.isNotEmpty(branchs)) {
                        branchs.forEach(branch -> {
                            final GithubDetail user = new GithubDetail();
                            user.setLogin(username);
                            user.setRepository(repo.get("name"));
                            user.setBranch(branch.get("name"));
                            try {
                                final JSONObject iibJson = JSONObject.fromObject(branch.get("commit"));
                                final JsonNode jsonNode = new ObjectMapper().readTree(iibJson.toString());
                                user.setLastCommit(jsonNode.get("sha").textValue());
                            } catch (final IOException io) {
                                throw new GithubDetailException(io.getLocalizedMessage());
                            }
                            LOGGER.info("Login by {}, repository is {} and count of the branches are {}", username,
                                    user.getBranch(), branchs.size());
                            details.add(user);
                        });
                    } else {
                        final GithubDetail user = new GithubDetail();
                        user.setLogin(username);
                        user.setRepository(repo.get("name"));
                        details.add(user);
                    }
                }
            });

        } catch (final Exception e) {
            throw new GithubDetailException(e.getLocalizedMessage());
        }
        return details;
    }
}
