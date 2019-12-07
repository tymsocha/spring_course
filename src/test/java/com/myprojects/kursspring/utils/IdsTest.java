package com.myprojects.kursspring.utils;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IdsTest {

    @Test
    public void testEmptySet() {
        int result = Ids.getNewId(Collections.emptySet());
        assertEquals(0, result);
    }

    @Test
    public void createNewId() {
        Set<Integer> sample = new HashSet<>();
        sample.add(4);
        int result = Ids.getNewId(sample);
        assertEquals(5, result);
    }
}
