package com.company;

import com.company.displayelements.Login;
import com.company.displayelements.Orderframe;


import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        final Orderframe frame = new Orderframe();
        frame.setSize (1000, 500);//размер окна
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Login login = new Login(frame);
        login.setVisible(true);
        frame.exit.addActionListener(l->{
            frame.dispose();
            login.setVisible(true);
        });


    }

}
