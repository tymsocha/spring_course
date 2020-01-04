package com.myprojects.kursspring.repositories;

import com.myprojects.kursspring.domain.Quest;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Scope("singleton")
public class QuestRepository {
    Random rand = new Random();

    @PersistenceContext
    private EntityManager em;

    @Transactional // It has to be done whole or not at all
    public void createQuest(String description) {
        Quest newQuest = new Quest(description);
        em.persist(newQuest);

        System.out.println(newQuest);
    }

    public List<Quest> getAll() {
        return em.createQuery("from Quest", Quest.class).getResultList();}

    @Transactional
    public void removeQuest(Quest quest) {
        em.remove(quest);
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    @Transactional
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Save the princess");
        descriptions.add("Take part in the tournament");
        descriptions.add("Kill the dragon");
        descriptions.add("Find Holy Grail");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        createQuest(description);
    }

    @Transactional
    public void update(Quest quest) {
        em.merge(quest);
    }

    public Quest getQuest(Integer id) {
        return em.find(Quest.class, id);
    }
}
