package com.myprojects.kursspring.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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
