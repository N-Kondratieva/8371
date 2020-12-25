package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class UserLogs {

    public static String role;
    public static String id;

    public static boolean UserReader(String[] arg) throws Exception {

        boolean succes = false;
        FileReader fileReader = new FileReader("UserLogs.txt");
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (GUI.userName.equals(str)) {
                succes = true;
                str = scanner.nextLine();
                if (GUI.userPassword.equals(str)) {
                    succes = true;
                    id = scanner.nextLine();
                    role = scanner.nextLine();
                    break;
                } else {
                    succes = false;
                }
            } else {
                succes = false;
            }
            fileReader.close();
        }
        return succes;
    }
}