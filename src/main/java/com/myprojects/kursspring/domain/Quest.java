package com.myprojects.kursspring.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Quest {

    private int id;

    private String description;

    private int reward = 100;

    private int questLength = 10;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private boolean started = false;

    private boolean isCompleted = false;

    public Quest(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public void setStarted(boolean started) {
        if (started) {
            this.startDate = LocalDateTime.now();
        }
        this.started = started;
    }

    public boolean isCompleted() {
        if (this.isCompleted) {
            return true;
        } else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime endQuestTime = this.startDate.plusSeconds(this.questLength);
            boolean isAfter = now.isAfter(endQuestTime);
            if (isAfter) {
                this.isCompleted = true;
            }
            return isAfter;
        }
    }
}
