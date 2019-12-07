package com.myprojects.kursspring.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Ids {
    static public int getNewId(Set<Integer> keysSoFar) {
        if (keysSoFar.isEmpty()) {
            return 0;
        } else {
            return keysSoFar.stream().max(Integer::max).get() + 1;
        }
    }
}
