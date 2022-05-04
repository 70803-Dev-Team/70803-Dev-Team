package CalculationsTests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataBaseTester {

    public static void main(String args[]) throws FileNotFoundException {
            File credentialsFile = new File("/LoginCredentials.txt");
            Scanner sc = new Scanner(credentialsFile);
            String userName = sc.next();
            String password = sc.next();
            String url = sc.next();
            String driver = sc.next();
            System.out.printf("User Name: %s\n", userName);
    }
}
