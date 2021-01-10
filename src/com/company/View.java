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

    public String mainMenu(){
        System.out.println("\t Enter \"1\" or \"lead\" to manage leads.");
        System.out.println("\t Enter \"2\" or \"interaction\" to manage interactions.");
        System.out.println("\t Enter \"3\" or \"report\"/\"stats\" to manage reporting and statistic.");

        System.out.print("choice: ");
        return Validation.getMainMenuInput();
    }

    public String subMenuLead(){
        System.out.println("\t Enter \"1\" or \"view list\" to view the list of all leads.");
        System.out.println("\t Enter \"2\" or \"add\"/\"enter detail\" to add a new lead.");
        System.out.println("\t Enter \"3\" or \"delete\" to delete a lead.");
        System.out.println("\t Enter \"4\" or \"update\" to update a lead");

        System.out.print("choice: ");
        return Validation.getLeadMenuInput();
    }

    public String subMenuInteraction(){
        //implement here
        return "output";
    }

    public String subMenuReport(){
        //implement here
        return "output";
    }

    public void viewLeadList(Lead[] listOfLeads){
        //implement
    }

    public Lead addLeadMenu(){
        //implement
    }

    public int deleteLeadMenu(){
        //implement
    }

    public int updateLeadMenu(){
        //implement
    }

    //Interaction viewing section////////////////////////////////////////////
    public void viewInteractionList(){
        //implement
    }

    public Interaction addInteractionMenu(){
        //implement
    }

    public int deleteInteractionMenu(){
        //implement
        return 1;
    }

    public int updateInteractionMenu(){
        //implement
        return 1;
    }

    //report viewing section////////////////////////////////////////////
    public void viewReportLeadByAge(Report report){
        //implement
    }

    public void viewReportInteractionByPotential(Report report){
        //implement
    }

    public void viewReportInteractionByMonth(Report report){
        //implement
    }
}
