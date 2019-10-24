package com.myprojects.kursspring.repositories;

import com.myprojects.kursspring.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class KnightRepository {

    Map<String, Knight> knights = new HashMap<>();

    public KnightRepository() {

    }

    @PostConstruct
    public void build() {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @PreDestroy
    public void tearDown() {

    }

    public void createKnight(String name, int age) {
        knights.put(name, new Knight(name, age));
    }

    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    public Knight getKnight(String name) {
        return knights.get(name);
    }

    public void removeKnight(String name) {
        knights.remove(name);
    }

    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knights +
                '}';
    }
}
