package com.myprojects.kursspring.repositories;

import com.myprojects.kursspring.domain.Quest;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
@Scope("singleton")
public class QuestRepository {
    Random rand = new Random();

    List<Quest> questList = new ArrayList<>();

    public void createQuest(String description) {
        questList.add(new Quest(description));
    }

    public List<Quest> getAll() {
        return questList;
    }

    @PostConstruct
    public void init() {
        createQuest("Save the princess");
        createQuest("Take part in the tournament");
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + questList +
                '}';
    }

    public void removeQuest(Quest quest) {
        questList.remove(quest);
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Save the princess");
        descriptions.add("Take part in the tournament");
        descriptions.add("Kill the dragon");
        descriptions.add("Find Holy Grail");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        createQuest(description);
    }
}
