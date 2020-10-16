package com.company;

import javax.swing.*;
import java.awt.*;

public class Visual {
    static int a = 0;
    static int b = 0;
    static String str = "";
    public static  void  main(String[] args){
        final JFrame frame = new JFrame("Новое окно");
        frame.setSize (500, 400);//размер окна
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //Растановка: Приоритет: Север Юг -> Запад Восток -> Центер
        frame.setLayout(new GridLayout(5,3));
        JButton comp_1 = new JButton("1");
        comp_1.addActionListener(l->{
            if (str.isEmpty()) a = a*10 + 1;
            else b = b*10 +1;
        });
        JButton comp_2 = new JButton("2");
        comp_2.addActionListener(l->{
            if (str.isEmpty()) a = a*10 + 2;
            else b = b*10 +2;
        });
        JButton comp_3 = new JButton("3");
        comp_3.addActionListener(l->{
            if (str.isEmpty()) a = a*10 + 3;
            else b = b*10 +3;
        });
        JButton comp_4 = new JButton("4");
        comp_4.addActionListener(l->{
            if (str.isEmpty()) a = a*10 + 4;
            else b = b*10 +4;
        });
        JButton comp_5 = new JButton("5");
        comp_5.addActionListener(l->{
            if (str.isEmpty()) a = a*10 + 5;
            else b = b*10 +5;
        });
        JButton comp_6 = new JButton("6");
        comp_6.addActionListener(l->{
            if (str.isEmpty()) a = a*10 + 6;
            else b = b*10 +6;
        });
        JButton comp_7 = new JButton("7");
        comp_7.addActionListener(l->{
            if (str.isEmpty()) a = a*10 + 7;
            else b = b*10 +7;
        });
        JButton comp_8 = new JButton("8");
        comp_8.addActionListener(l->{
            if (str.isEmpty()) a = a*10 + 8;
            else b = b*10 +8;
        });
        JButton comp_9 = new JButton("9");
        comp_9.addActionListener(l->{
            if (str.isEmpty()) a = a*10 + 9;
            else b = b*10 +9;
        });
        JLabel result = new JLabel();
        JButton sum = new JButton("+");
        sum.addActionListener(l->{
            str = "+";


        });
        JButton minus = new JButton("-");
        minus.addActionListener(l->{

            str = "-";

        });
        JButton umnozh = new JButton("*");
        umnozh.addActionListener(l->{

            str = "*";

        });
        JButton divide = new JButton("/");
        divide.addActionListener(l->{

            str = "/";

        });
        JButton res = new JButton("=");
        res.addActionListener(l->{
            int resultat =0;
            switch (str) {
                case "+":
                    resultat = a + b;
                    break;
                case "-":
                    resultat = a - b;
                    break;
                case "*":
                    resultat = a * b;
                    break;
                case "/":
                    resultat = a / b;
                    break;
            }

            result.setText(" " + resultat);
            str = "";
        });
        JButton clear = new JButton("C");
        clear.addActionListener(l->{
            a = 0;
            b = 0;
            result.setText(" ");
        });


        frame.add(clear);
        frame.add(comp_1);
        frame.add(comp_2);
        frame.add(comp_3);
        frame.add(comp_4);
        frame.add(comp_5);
        frame.add(comp_6);
        frame.add(comp_7);
        frame.add(comp_8);
        frame.add(comp_9);
        frame.add(minus);
        frame.add(sum);
        frame.add(umnozh);
        frame.add(divide);
        frame.add(res);
        frame.add(result);
        frame.setVisible(true);//показать окно

    }

}
