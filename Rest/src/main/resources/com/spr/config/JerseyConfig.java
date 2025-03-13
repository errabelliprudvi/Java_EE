package com.spr.config;

import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api") // Base URL for all REST endpoints
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.spr.rest"); // Scans this package for REST endpoints
    }
}

