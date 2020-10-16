package com.company;

public class Game {
    public String name;
    public int duration;
    public int quantity;

    public Game(String name, Integer duration, Integer quantity) {
        this.name = name;
        this.duration = duration;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}


