package com.botscrew.task.view;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainView {

    private Scanner scanner = new Scanner(System.in);

    public int executeChoice() {
        System.out.println("Choose one of the offered number: ");
        System.out.println("1. Who is head of department?");
        System.out.println("2. Show department statistics.");
        System.out.println("3. Show the average salary for the department.");
        System.out.println("4. Show count of employee for department.");
        System.out.println("5. Global search by template.");

        return scanner.nextInt();
    }

}
