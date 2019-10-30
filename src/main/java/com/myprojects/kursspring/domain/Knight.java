package com.myprojects.kursspring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Knight {
    private String name /*= "Lancelot"*/;

    private int age /*= 29*/;

    private Quest quest;

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Knight() {

    }

    @Override
    public String toString() {
        return "Knight named " + name + " ( " + age + " ). Quest: " + quest;
    }
}
