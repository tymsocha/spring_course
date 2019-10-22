package com.myprojects.kursspring.singleton;

//Example of class without state
//Example of Singleton class
public class PersonUtils {

    private static PersonUtils instance = null;

    private PersonUtils() {

    }

    public PersonUtils getInstance() {
        if (instance == null) {
            instance = new PersonUtils();
        }
        return instance;
    }

    public final String operation(Person person) {
        return person.name.toLowerCase();
    }
}
