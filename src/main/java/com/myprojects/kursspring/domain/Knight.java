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
        this.name = "Lancelot";
        this.age = 29;
    }

    @Override
    public String toString() {
        return "Knight named " + name + " ( " + age + " ). Quest: " + quest;
    }

    public void setQuest(Quest quest) {
        System.out.println("Assigning quest to Knight");
        this.quest = quest;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
