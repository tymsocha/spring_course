package com.myprojects.kursspring.services;

import com.myprojects.kursspring.domain.Knight;
import com.myprojects.kursspring.domain.Quest;
import com.myprojects.kursspring.repositories.KnightRepository;
import com.myprojects.kursspring.repositories.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    final static Random rand = new Random();

    public void assignRandomQuest(String knightName) {
        List<Quest> allQuests = questRepository.getAll();
        Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).ifPresent(knight1 -> knight1.setQuest(randomQuest));
        questRepository.removeQuest(randomQuest);
    }
}
