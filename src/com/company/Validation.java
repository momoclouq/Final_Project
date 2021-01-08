package com.company;

import java.util.Scanner;

public class Validation {
    //Deals with input validation

    //menu: {"main" = mainmenu, "lead" = menulead, "interaction" = menyinteraction, "report" = menureport}
    //
    public static int getMenuInputRepeat(Scanner input, String menu){
        String choice = input.nextLine().trim().toLowerCase();
        boolean cont = true; //quit the program if the user wants
        do{
            int status = checkMenuInput(choice, menu);
            if (status != 0) return status;
            System.out.print("Continue (y/n)? ");
            if (Character.toLowerCase(input.nextLine().trim().charAt(0)) == 'n') cont = false;
            else {
                System.out.print("choice again: ");
                choice = input.nextLine().trim().toLowerCase();
            }
        } while (cont);
        return 0;
    }

    public static int checkMenuInput(String choice, String menu){
        if (menu.equals("main")){
            //main menu
            if (choice.equals("1") || choice.equals("lead")) return 1;
            if (choice.equals("2") || choice.equals("interaction")) return 2;
            if (choice.equals("3") || choice.equals("report") || choice.equals("stats")) return 3;
        } else if (menu.equals("lead")){
            //lead menu
            if (choice.equals("1") || choice.equals("view list")) return 4;
            if (choice.equals("2") || choice.equals("add") || choice.equals("enter details")) return 5;
            if (choice.equals("3") || choice.equals("delete")) return 6;
            if (choice.equals("4") || choice.equals("update")) return 7;
        } else if (menu.equals("interaction")){
            //continue
        }

        return 0;
    }
}
