package com.myprojects.kursspring.repositories;

import com.myprojects.kursspring.domain.Knight;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;

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
    public Collection<Knight> getAllKnights() {
        System.out.println("Using Database");
        throw new NotImplementedException();
    }

    @Override
    public Knight getKnight(String name) {
        System.out.println("Using Database");
        throw new NotImplementedException();
    }

    @Override
    public void removeKnight(String name) {
        System.out.println("Using Database");
        throw new NotImplementedException();
    }
}
