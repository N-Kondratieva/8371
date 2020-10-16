package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        Game xo = new Game("Крестики нолики", 5 ,2);
        Table civi = new Table("Цивилизация",180,4, "Стратегия");

        HashSet<Game> games = new HashSet<>();
        games.add(xo);
        games.add(civi);
//        System.out.println(games);


        for (Game g: games){
            System.out.println(g.getName());
            System.out.println(g.getDuration());
            System.out.println(g.getQuantity());
            if(g instanceof  Table){
                Table g1 = (Table) g;
                System.out.println(g1.getJanre());
            }
        }
    }
}
