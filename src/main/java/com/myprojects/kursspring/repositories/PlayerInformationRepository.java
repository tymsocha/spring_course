package com.myprojects.kursspring.repositories;

import com.myprojects.kursspring.domain.PlayerInformation;
import com.myprojects.kursspring.domain.Quest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class PlayerInformationRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createPlayerInformation(PlayerInformation playerInformation) {
        em.persist(playerInformation);
    }

    public PlayerInformation getFirst() {
        return em.createQuery("from PlayerInformation", PlayerInformation.class).getResultList().get(0);
    }
}
