package com.eco.challengeservice.domain.sub;

public class Stage {

    private int number;

    private int value;
    // exemple : km en velo -> number 1 : value 20km, number 2 : value 50km, ect
    private int description;

    public Stage(int number, int value, int description) {
        this.number = number;
        this.value = value;
        this.description = description;
    }
}
