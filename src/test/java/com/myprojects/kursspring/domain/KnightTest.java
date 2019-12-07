package com.myprojects.kursspring.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class KnightTest {

    @Test
    public void checkifQuestStarted() {
        Knight knight = new Knight("Percival", 28);
        Quest quest = new Quest(1, "Test");

        knight.setQuest(quest);

        assertTrue(knight.getQuest().isStarted());
    }
}
