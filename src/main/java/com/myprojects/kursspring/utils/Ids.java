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
            Integer integer = keysSoFar.stream().max((Integer::compareTo)).get();
            return integer + 1;
        }
    }
}
