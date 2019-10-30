package com.myprojects.kursspring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Knight {
    private int id;
    private String name /*= "Lancelot"*/;
    private int age /*= 29*/;
    private Quest quest;
    private int level;

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 1;
    }

    public Knight() {

    }

    @Override
    public String toString() {
        return "Knight named " + name + " ( " + age + " ). Quest: " + quest;
    }
}
