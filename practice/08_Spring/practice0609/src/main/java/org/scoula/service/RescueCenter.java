package org.scoula.service;

import org.scoula.domain.Dog2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RescueCenter {
    private final Dog2 dog;

    @Autowired
    public RescueCenter(@Qualifier("밤비") Dog2 dog) {
        this.dog = dog;
    }

    @PostConstruct
    public void rescue() {
        System.out.println("🎉 [자동 출력] 구조 완료: " + dog);
    }
}
