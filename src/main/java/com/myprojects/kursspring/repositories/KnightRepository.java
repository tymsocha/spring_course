package com.myprojects.kursspring.repositories;

import com.myprojects.kursspring.domain.Knight;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {
    void build();

    void tearDown();

    void createKnight(Knight knight);

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void removeKnight(Integer id);

    Knight getKnightById(Integer id);

    default void updateKnight(int id, Knight knight) {
         throw new NotImplementedException();
    }
}
