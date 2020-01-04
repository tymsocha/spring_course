package com.myprojects.kursspring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "QUESTS")
@NoArgsConstructor
@AllArgsConstructor
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "DESC")
    private String description;

    private int reward = 100;

   // @Transient // annotation that informs hibernate that field will not be saved to database
    private int questLength = 10;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private boolean started = false;

    private boolean isCompleted = false;

    public Quest(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Quest(String description) {
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
