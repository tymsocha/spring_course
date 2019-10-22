package com.myprojects.kursspring.singleton;

public enum PersonUtils2 {

    INSTANCE;

    public final String operation(Person person) {
        return person.name.toLowerCase();
    }
}
