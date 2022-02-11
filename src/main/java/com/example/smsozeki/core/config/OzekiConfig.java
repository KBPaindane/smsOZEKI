package com.example.smsozeki.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kelvin Paindane
 */
@Configuration
public class OzekiConfig {
    @Value("${ozeki.port}")
    public int port;
    @Value("${ozeki.host}")
    public String host;
    @Value("${ozeki.username}")
    public String username;
    @Value("${ozeki.password}")
    public String password;
}
