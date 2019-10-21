package com.myprojects.kursspring.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CastleTest {

    @Test
    public void castleToStringMessage() {
        Quest quest = new Quest();
        Knight knight = new Knight();
        knight.setQuest(quest);
        Castle castle = new Castle(knight, "King's Landing");
        String  except = "Znajduje się tu zamek King's Landing. Zamieszkały przez rycerza Rycerz o imieniu Lancelot ( 29 ). Zadanie: Save princess";
        assertEquals(except, castle.toString());
    }
}
