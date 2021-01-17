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
        System.out.println("\t Enter \"1\" or \"view list\" to view the list of all leads.");
        System.out.println("\t Enter \"2\" or \"add\"/\"enter detail\" to add a new lead.");
        System.out.println("\t Enter \"3\" or \"delete\" to delete a lead.");
        System.out.println("\t Enter \"4\" or \"update\" to update a lead");

        System.out.print("choice: ");
        return Validation.getInteractionMenuInput();
    }

    public String subMenuReport(){
        //implement - Member: Khang
        return "output";
    }

    public void viewLeadList(Lead[] listOfLeads){
        //implement - Member: Trung
    }

    public Lead addLeadMenu(){
        //implement - Member: Dat
        return new Lead();
    }

    public int deleteLeadMenu(){
        //implement - Member: Khang
        return 1;
    }

    public int updateLeadMenu(){
        //implement - Member: Khang
        System.out.println("enter lead id: ");

        return 1;
    }

    public Lead getNewLead(int id){
        //implement - Member: Minh
        System.out.println("\tEnter data for the new lead. " + id);
        Lead newLead = Validation.getNewLeadInput(id);

        return newLead;
    }
    //Interaction viewing section////////////////////////////////////////////
    public void viewInteractionList(){
        //implement - Member: Dat
    }

    public Interaction getNewInteraction(int id){
        //implements - Member: minh
        System.out.println("\tEnter data for the new Interaction. " + id);
        Interaction newInteraction = Validation.getNewInteractionInput(id);

        return newInteraction;
    }

    public Interaction addInteractionMenu(){
        //implement - Member: Tae
        return new Interaction();
    }

    public int deleteInteractionMenu(){
        //implement - Member: Trung
        return 1;
    }

    public int updateInteractionMenu(){
        //implement - Member: Dat
        return 1;
    }

    //report viewing section////////////////////////////////////////////
    public void viewReportLeadByAge(ArrayList<ReportData> output){
        //implement - Member: Tae
    }

    public void viewReportInteractionByPotential(ArrayList<ReportData> output){
        //implement - Member: Khang
    }

    public void viewReportInteractionByMonth(ArrayList<ReportData> output){
        //implement - Member: Dat
    }
}
