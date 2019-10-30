package com.myprojects.kursspring.repositories;

import com.myprojects.kursspring.domain.Knight;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;


public interface KnightRepository {
    void build();

    void tearDown();

    void createKnight(Knight knight);

    Collection<Knight> getAllKnights();

    Knight getKnight(String name);

    void removeKnight(String name);
}
