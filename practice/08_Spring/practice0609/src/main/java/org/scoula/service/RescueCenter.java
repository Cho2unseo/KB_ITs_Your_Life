package org.scoula.service;

import org.scoula.domain.Dog3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Component
public class RescueCenter {
    private final List<Dog3> dogs;

    /*
    @Autowired
    public RescueCenter(@Qualifier("밤비") Dog2 dog) {
        this.dog = dog;
    }

    @PostConstruct
    public void rescue() {
        System.out.println("🎉 [자동 출력] 구조 완료: " + dog);
    }

     */
    @Autowired
    public RescueCenter(List<Dog3> dogs) {
        this.dogs = dogs;
    }

    private final Map<String, Integer> priorityMap = Map.of(
            "진돗개", 1,
            "시바견", 2,
            "푸들", 3
    );

    @PostConstruct
    public void rescue() {
        dogs.sort(Comparator.comparingInt(dog -> priorityMap.getOrDefault(dog.getBreed(), 100)));
        System.out.println("📋 구조 우선순위에 따라 구조를 시작합니다!");
        for (Dog3 dog: dogs) {
            System.out.println("🫂 안아줌 완료: " + dog);
        }
    }
}
