package com.example.name;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * @author paavan.shah */
@ConfigurationProperties
public class NameProperties {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
