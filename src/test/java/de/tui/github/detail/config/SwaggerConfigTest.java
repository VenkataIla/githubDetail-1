package de.tui.github.detail.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SwaggerConfigTest {

    @DisplayName("Test for Swagger Config")
    @Test
    void testSwagger() {
        assertNotNull(new SwaggerConfig().api());
    }
}
