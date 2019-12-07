package com.myprojects.kursspring.repositories;

import com.myprojects.kursspring.domain.Knight;
import com.myprojects.kursspring.utils.Ids;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryKnightRepository implements KnightRepository {

    Map<Integer, Knight> knights = new HashMap<>();

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
        knights.put(knight.getId(), knight);
    }

    @Override
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name, age);
        knight.setId(Ids.getNewId(knights.keySet()));
        knights.put(knight.getId(), knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Optional<Knight> optionalKnight = knights.values().stream()
                .filter(knight -> knight.getName().equals(name)).findAny();
        return optionalKnight;
    }

    @Override
    public void removeKnight(Integer id) {
        knights.remove(id);
    }

    @Override
    public String toString() {
        return "InMemoryKnightRepository{" +
                "knights=" + knights +
                '}';
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }
}
