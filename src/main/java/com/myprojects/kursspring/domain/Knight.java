package com.myprojects.kursspring.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Knight {
    private int id;

    @NotNull
    @Size(min = 2, max = 40, message = "Name of the knight must be between 2 and 40 characters")
    private String name /*= "Lancelot"*/;

    @NotNull
    @Range(min = 18, max = 80, message = "Knight cannot be younger than 18YO, and older than 60YO")
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

    public void setQuest(Quest quest) {
        if (quest != null) {
            quest.setStarted(true);
        }
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "Knight named " + name + " ( " + age + " ). Quest: " + quest;
    }
}
