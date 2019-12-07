package com.myprojects.kursspring.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class PlayerInformation {
    private int goldAmount = 0;
}
