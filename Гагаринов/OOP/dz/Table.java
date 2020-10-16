package com.company;

public class Table extends Game {
    public String janre;

    public Table(String name, Integer duration, Integer quantity, String janre) {
        super(name, duration, quantity);
        this.janre = janre;
    }

    public String getJanre() {
        return janre;
    }

    public void setJanre(String janre) {
        this.janre = janre;
    }
}
