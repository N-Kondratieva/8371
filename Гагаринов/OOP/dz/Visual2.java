package com.company;



import info.clearthought.layout.TableLayout;



import javax.swing.*;


import static info.clearthought.layout.TableLayoutConstants.*;

public class Visual2 {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Окно");
        frame.setSize(600,600);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new TableLayout(
                new double[][]{
                        {FILL, PREFERRED,PREFERRED,FILL},
                        {FILL, PREFERRED,PREFERRED,FILL}
                }
        ));

        frame.add(new JButton("1"), "0,0");
        frame.add(new JButton("1"), "1,0");
        frame.add(new JButton("1"), "2,0");
        frame.add(new JButton("1"), "3,0");
        frame.add(new JButton("1"), "0,1");
        frame.add(new JButton("1"), "1,1");
        frame.add(new JButton("1"), "2,1");
        frame.add(new JButton("1"), "3,1");
        frame.add(new JButton("1"), "0,2");
        frame.add(new JButton("1"), "1,2");
        frame.add(new JButton("1"), "2,2");
        frame.add(new JButton("1"), "3,2");

        frame.setVisible(true);
    }

}
