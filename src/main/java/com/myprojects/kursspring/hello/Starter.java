package com.myprojects.kursspring.hello;

import com.myprojects.kursspring.domain.Castle;
import com.myprojects.kursspring.domain.Knight;
import com.myprojects.kursspring.domain.Quest;
import com.myprojects.kursspring.domain.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    Castle castle;

    @Autowired
    Tournament tournament;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(castle);
        tournament.duel();
        System.out.println(tournament);

        System.out.println(castle);

//        Quest saveThePrincess = new Quest("Uratuj księżniczkę");
//        Knight lancelot = new Knight("Lancelot", 29, saveThePrincess);
//        System.out.println(lancelot);
//
//        Quest slayingDragon = new Quest("Zabij smoka");
//        Knight percival = new Knight("Percival", 31);
//        System.out.println(percival);
//        percival.setQuest(slayingDragon);
//        System.out.println(percival);
    }
}
