package com.company;

import java.util.Scanner;

public class View {
    //main menu and sub menu section////////////////////////////////////////////
    //Show a few words talking nonsense about the system
    public void firstWords(){
        System.out.println("CRM system initialized.");
        System.out.println("Data will be stored in leads.csv and interaction.csv");
        System.out.println("Enter 0 in the menu to quit the program");
        System.out.println("------------------------------------------");
    }

    //show the main menu and ask the user for String input and return a value back to the controller
    //argument:
    //return an int value: {1,2,3}
    public int mainMenu(Scanner input){
        System.out.println("\t Enter \"1\" or \"lead\" to manage leads.");
        System.out.println("\t Enter \"2\" or \"interaction\" to manage interactions.");
        System.out.println("\t Enter \"3\" or \"report\"/\"stats\" to manage reporting and statistic.");

        //input validation: should it be a class?
        System.out.print("choice: ");
        String choice = input.nextLine().trim().toLowerCase();
        boolean cont = true; //quit the program if the user wants
        do{
            if (choice.equals("1") || choice.equals("lead")) return 1;
            if (choice.equals("2") || choice.equals("interaction")) return 2;
            if (choice.equals("3") || choice.equals("report") || choice.equals("stats")) return 3;
            System.out.print("Continue (y/n)? ");
            if (Character.toLowerCase(input.nextLine().trim().charAt(0)) == 'n') cont = false;
            else System.out.print("choice again: ");
        } while (cont);
        return 0;
    }

    //show the sub menu for lead management: managing leads and ask the user for String input
    //return an int value: {4,5,6,7}
    public int subMenuLead(Scanner input){
        System.out.println("\t Enter \"1\" or \"view list\" to view the list of all leads.");
        System.out.println("\t Enter \"2\" or \"add\"/\"enter detail\" to add a new lead.");
        System.out.println("\t Enter \"3\" or \"delete\" to delete a lead.");
        System.out.println("\t Enter \"4\" or \"update\" to update a lead");

        //input validation: should it be a class? yes
        System.out.print("choice: ");
        String choice = input.nextLine().trim().toLowerCase();
        boolean cont = true; //quit the program if the user wants
        do{
            if (choice.equals("1") || choice.equals("view list")) return 4;
            if (choice.equals("2") || choice.equals("add") || choice.equals("enter details")) return 5;
            if (choice.equals("3") || choice.equals("delete")) return 6;
            if (choice.equals("4") || choice.equals("update")) return 7;
            System.out.print("Continue (y/n)? ");
            if (Character.toLowerCase(input.nextLine().trim().charAt(0)) == 'n') cont = false;
            else System.out.print("choice again: ");
        } while (cont);
        return 0;
    }




    //Lead viewing section////////////////////////////////////////////
    //public Lead updateLeadMenu(){}
}
