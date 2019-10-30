package com.myprojects.kursspring.repositories;

import com.myprojects.kursspring.domain.Knight;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.Optional;

public class DBKnightRepository implements KnightRepository {

    @Override
    @PostConstruct
    public void build() {

    }

    @Override
    @PreDestroy
    public void tearDown() {

    }

    @Override
    public void createKnight(Knight knight) {
        System.out.println("Using Database");
        throw new NotImplementedException();
    }

    @Override
    public void createKnight(String name, int age) {
        System.out.println("Using Database");
        throw new NotImplementedException();
    }

    @Override
    public Collection<Knight> getAllKnights() {
        System.out.println("Using Database");
        throw new NotImplementedException();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        System.out.println("Using Database");
        throw new NotImplementedException();
    }

    @Override
    public void removeKnight(Integer integer) {
        System.out.println("Using Database");
        throw new NotImplementedException();
    }

    @Override
    public Knight getKnightById(Integer id) {
        System.out.println("Using Database");
        throw new NotImplementedException();
    }
}
