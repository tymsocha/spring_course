package com.myprojects.kursspring.repositories;

import com.myprojects.kursspring.domain.Quest;
import com.myprojects.kursspring.utils.Ids;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
@Scope("singleton")
public class QuestRepository {
    Random rand = new Random();

    Map<Integer, Quest> questMap = new HashMap<>();

    public void createQuest(String description) {
        int newId = Ids.getNewId(questMap.keySet());
        Quest newQuest = new Quest(newId, description);
        questMap.put(newId, newQuest);
    }

    public List<Quest> getAll() {
        return new ArrayList<>(questMap.values());
    }

    @PostConstruct
    public void init() {
//        createQuest("Save the princess");
//        createQuest("Take part in the tournament");
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questMap=" + questMap +
                '}';
    }

    public void removeQuest(Quest quest) {
        questMap.remove(quest.getId());
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

    public void update(Quest quest) {
        questMap.put(quest.getId(), quest);
    }

    public Quest getQuest(Integer id) {
        return questMap.get(id);
    }
}
