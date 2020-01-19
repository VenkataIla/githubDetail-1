/*
* Copyright (c).
*/
package de.tui.github.detail.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GithubDetailTest {

     @DisplayName("Test the equals hashcode and tostring methods as they tend to greatly reduce our test coverage even though they are autogenerated")
    @Test
    void testEntity() {
        GithubDetail githubDetail = new GithubDetail();
        assertNotNull(githubDetail.hashCode());
        assertEquals(githubDetail.equals(githubDetail), true);
        assertNotNull(githubDetail.toString());
        GithubDetail githubDetail2 = new GithubDetail();
        githubDetail2.setBranch("abc");
        githubDetail2.setLastCommit("one");
        githubDetail2.setLogin("itsme");
        githubDetail2.setRepository("its Mine");
        assertEquals(githubDetail.equals(githubDetail2), false);

    }
}