package com.company;

import java.util.ArrayList;
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
    //argument: a Scanner
    //return an int value: {1,2,3}
    public int mainMenu(Scanner input){
        System.out.println("\t Enter \"1\" or \"lead\" to manage leads.");
        System.out.println("\t Enter \"2\" or \"interaction\" to manage interactions.");
        System.out.println("\t Enter \"3\" or \"report\"/\"stats\" to manage reporting and statistic.");

        //input validation: should it be a class?
        System.out.print("choice: ");
        return Validation.getMenuInputRepeat(input, "main");
    }

    //show the sub menu for lead management: managing leads and ask the user for String input
    //argument: a Scanner
    //return an int value: {4,5,6,7}
    public int subMenuLead(Scanner input){
        System.out.println("\t Enter \"1\" or \"view list\" to view the list of all leads.");
        System.out.println("\t Enter \"2\" or \"add\"/\"enter detail\" to add a new lead.");
        System.out.println("\t Enter \"3\" or \"delete\" to delete a lead.");
        System.out.println("\t Enter \"4\" or \"update\" to update a lead");

        //input validation: should it be a class? yes
        System.out.print("choice: ");
        return Validation.getMenuInputRepeat(input, "lead");
    }

    //show the sub menu for interaction management: managing interactions and ask the user for String input
    //argument: a Scanner
    //return an int value: {8,9,10,11}
    public int subMenuInteraction(Scanner input){
        //implement here
        return 0;
    }

    //show the sub menu for report management: showing reports and ask for String input
    //argument: a Scanner
    //return an int value: {12,13,14}
    public int subMenuReport(Scanner input){
        //implement here
        return 0;
    }

    //Lead viewing section////////////////////////////////////////////
    //view all leads in the system
    //argument: none
    //return void
    public void viewListLead(ArrayList<Lead> listOfLeads){
        //implement
    }

    //public Lead updateLeadMenu(){}
}
