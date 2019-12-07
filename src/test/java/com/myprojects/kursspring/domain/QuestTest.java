package com.myprojects.kursspring.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestTest {

    @Test
    public void setHasStartedWithDate() {
        Quest quest = new Quest(1, "Test");

        quest.setStarted(true);

        assertNotNull(quest.getStartDate());
    }

    @Test
    public void questShouldBeCompleted() {
        Quest quest = new Quest(1, "Test");

        quest.setStarted(true);
        quest.setQuestLength(-60);

        assertTrue(quest.isCompleted());
        assertTrue(quest.isCompleted());
    }

    @Test
    public void questShouldBeNotCompleted() {
        Quest quest = new Quest(1, "Test");

        quest.setStarted(true);
        quest.setQuestLength(30000);

        assertFalse(quest.isCompleted());
        assertFalse(quest.isCompleted());
    }
}