package com.myprojects.kursspring.domain;

import org.springframework.stereotype.Component;

@Component
public class Quest {
    private String description;

    public Quest() {
        this.description = "Save princess";
    }

    @Override
    public String toString() {
        return description;
    }
}
