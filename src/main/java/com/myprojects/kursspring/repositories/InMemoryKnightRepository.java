package com.myprojects.kursspring.repositories;

import com.myprojects.kursspring.domain.Knight;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryKnightRepository implements KnightRepository {

    Map<String, Knight> knights = new HashMap<>();

    public InMemoryKnightRepository() {

    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    @PreDestroy
    public void tearDown() {

    }

    @Override
    public void createKnight(Knight knight) {
        knights.put(knight.getName(), knight);
    }

    public void createKnight(String name, int age) {
        knights.put(name, new Knight(name, age));
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Knight getKnight(String name) {
        return knights.get(name);
    }

    @Override
    public void removeKnight(String name) {
        knights.remove(name);
    }

    @Override
    public String toString() {
        return "InMemoryKnightRepository{" +
                "knights=" + knights +
                '}';
    }
}
