package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class View {
    //main menu and sub menu section////////////////////////////////////////////
    //Show a few words talking nonsense about the system
    public static void firstWords(){
        System.out.println("CRM system initialized.");
        System.out.println("Data will be stored in leads.csv and interaction.csv");
        System.out.println("If you change the data in the file and reset the program, the id of each lead and interaction may be wrong");
        System.out.println("To maintain optimal usability, keep the ids of the data sequential");
        System.out.println("Enter \"end\" in the menu to return to the previous menu");
        System.out.println("Enter \"end\" in the main menu to quit the program");
        System.out.println("------------------------------------------");
    }

    public static String mainMenu(){
        System.out.println("Main Menu");
        System.out.println("\t Enter \"1\" or \"lead\" to manage leads.");
        System.out.println("\t Enter \"2\" or \"interaction\" to manage interactions.");
        System.out.println("\t Enter \"3\" or \"report\" or \"stats\" to manage reporting and statistic.");

        System.out.print("choice: ");
        return Validation.getMainMenuInput();
    }

    public static String subMenuLead(){
        System.out.println("Lead Management");
        System.out.println("\t Enter \"1\" or \"view list\" to view the list of all leads.");
        System.out.println("\t Enter \"2\" or \"add\" or \"add lead\" to add a new lead.");
        System.out.println("\t Enter \"3\" or \"delete\" to delete a lead.");
        System.out.println("\t Enter \"4\" or \"update\" to update a lead");

        System.out.print("choice: ");
        return Validation.getLeadMenuInput();
    }

    public static String subMenuInteraction(){
        System.out.println("Interaction Management");
        System.out.println("\t Enter \"1\" or \"view list\" to view the list of all interactions.");
        System.out.println("\t Enter \"2\" or \"add\" or \"add interaction\" to add a new interaction.");
        System.out.println("\t Enter \"3\" or \"delete\" to delete a interaction.");
        System.out.println("\t Enter \"4\" or \"update\" to update a interaction.");

        System.out.print("choice: ");
        return Validation.getInteractionMenuInput();
    }

    public static String subMenuReport(){
        //implement - Member: Khang
        System.out.println("Report Management");
        System.out.println("\t Enter \"1\" or \"report lead age\" to view a lead report by age.");
        System.out.println("\t Enter \"2\" or \"report interaction potential\" to view a interaction report by potential.");
        System.out.println("\t Enter \"3\" or \"report interaction month\" to view a interaction report by month.");

        System.out.print("choice: ");
        return Validation.getReportMenuInput();
    }

    public static void viewLeadList(Lead[] listOfLeads){
        //implement - Member: Trung
        System.out.println("The list of all leads in the report: ");
        for (int i = 0; i < listOfLeads.length; i++) {
            if (listOfLeads[i] != null)
                System.out.println(listOfLeads[i].toFileFormat());
        }
    }

    public static Lead addLeadMenu(int idIndex){
        //implement - Member: Dat
        System.out.println("Add a new lead to the system");
        Lead newLead = getNewLead(idIndex);
        return newLead;
    }

    public static int deleteLeadMenu(Lead[] listOfLeads){
        //implement - Member: Khang
        System.out.println("Deleting an existing lead");
        System.out.println("Please enter a lead for deletion.");
        int correctId = Validation.getCurrentLeadIdInput(listOfLeads);
        return correctId;
    }

    public static int updateLeadMenu(Lead[] listOfLeads){
        //implement - Member: Khang
        System.out.println("Update an existing lead");
        System.out.println("Please enter a lead for updating");
        int correctId = Validation.getCurrentLeadIdInput(listOfLeads);
        return correctId;
    }

    public static Lead getNewLead(int id){
        //implement - Member: Minh
        System.out.println("Please enter data for the new lead.");
        Lead newLead = Validation.getNewLeadInput(id);

        return newLead;
    }
    //Interaction viewing section////////////////////////////////////////////
    public static void viewInteractionList(Interaction[] listOfInteractions){
        //implement - Member: Dat
        System.out.println("List of all Interaction: ");
        for (int i = 0; i < listOfInteractions.length; i++) {
            if (listOfInteractions[i] != null)
                System.out.println(listOfInteractions[i].toFileFormat());
        }
    }

    public static Interaction getNewInteraction(int id, Lead[] listOfLeads){
        //implements - Member: minh
        Interaction newInteraction = Validation.getNewInteractionInput(id, listOfLeads);
        return newInteraction;
    }

    public static Interaction addInteractionMenu(int id, Lead[] listOfLeads){
        //implement - Member: Tae
        System.out.println("Adding a new interaction");
        Interaction output = getNewInteraction(id, listOfLeads);
        System.out.println("Interaction " + (id+1) + " added to the system");
        return output;
    }

    public static int deleteInteractionMenu(Interaction[] listOfInteractions){
        //implement - Member: Trung
        System.out.println("Enter interaction id available in the list for deletion");
        int currentId = Validation.getCurrentInteractionIdInput(listOfInteractions);
        return currentId;
    }

    public static int updateInteractionMenu(Interaction[] listOfInteractions){
        //implement - Member: Dat
        System.out.println("Enter interaction id available in the list for updating");
        int currentId = Validation.getCurrentInteractionIdInput(listOfInteractions);
        return currentId;
    }

    //report viewing section///////////////////////////////////////////
    public static void viewReportLeadByAge(ReportLead report){
        //implement - Member: Tae
        System.out.println("Lead report by age. Period: " + report.getPeriod());
        printReport(report);
    }

    public static void viewReportInteractionByPotential(ReportInteraction report){
        //implement - Member: Khang
        System.out.println("Interaction report by potential. Period: " + report.getPeriod());
        printReport(report);
    }

    public static void viewReportInteractionByMonth(ReportInteraction report){
        //implement - Member: Dat
        System.out.println("Interaction report by month. Period: " + report.getPeriod());
        printReport(report);
    }

    private static void printReport(Report report){
        for (ReportData data: report.getOutput()){
            System.out.printf("%20s", data.getHeader());
        }

        System.out.println("");
        for (ReportData data: report.getOutput()){
            System.out.printf("%20d", data.getCount());
        }
        System.out.println("");
    }
}
