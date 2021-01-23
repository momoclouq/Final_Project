package com.company;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Controller {
    //testing area
    public static void main(String[] args){
        try{
            Controller program = new Controller();
            program.start();
        } catch (Exception ex){
            System.out.println("error");
        }
    }

    private Lead[] listOfLeads = new Lead[100000];
    private Interaction[] listOfInteraction = new Interaction[100000];
    private View view;
    private int indexLead;
    private int indexInteraction;
    private FileControl leadFile;
    private FileControl interactionFile;
    private Validation validate;

    //constructor
    public Controller() throws IOException, ParseException {
        this.leadFile = new FileControl("leads.csv");
        this.interactionFile = new FileControl("interactions.csv");
        System.out.println("hehe");
        //implements - Member: Khang
        //update listOfLeads and listOfInteractions from fileControl
        indexLead = leadFile.transferData(listOfLeads);
        indexInteraction = interactionFile.transferData(listOfInteraction, listOfLeads);
    }

    //functions
    //starting the program
    public void start(){
        //initialization
        try {
            String location = "main";
            this.view.firstWords();

            while (!location.equals("end")) {
                location = changeLocation(location);
                //separation line for each location
                System.out.println("----------------------------");
                if (location.equals("main")) {
                    System.out.println("Operation done...");
                    System.out.print("");
                }
            }

            System.out.println("finished! I will rest now");
            System.exit(1);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    private String changeLocation(String currentLocation){
        if (currentLocation.equals("main")){
            String newLocation = this.view.mainMenu();
            if (newLocation.equals("end")) return "end";

            //change the location
            return newLocation;
        }

        if (currentLocation.equals("lead")){
            String newLocation = this.view.subMenuLead();
            if (newLocation.equals("end")) return "main";

            //change the location
            return newLocation;
        }

        if (currentLocation.equals("interaction")){
            String newLocation = this.view.subMenuInteraction();
            if (newLocation.equals("end")) return "main";

            //change the location
            return newLocation;
        }

        if (currentLocation.equals("report")){
            String newLocation = this.view.subMenuReport();
            if (newLocation.equals("end")) return "main";

            //change the location
            return newLocation;
        }

        if (currentLocation.equals("viewLeadList")){
            this.view.viewLeadList(listOfLeads);
            return "lead";
        }

        if (currentLocation.equals("viewInteractionList")){
            //implement - Member: Trung
            this.view.viewInteractionList(listOfInteraction);
            return "interaction";
        }

        if (currentLocation.equals("deleteLead")){
            //implement - Member: Tae
            int idLeadDelete = View.deleteLeadMenu(listOfLeads);
            listOfLeads[idLeadDelete] = null;

            return "lead";
        }

        if (currentLocation.equals("addLead")) {
            listOfLeads[indexLead] = View.addLeadMenu(indexLead);
            indexLead++;
            return "lead";
        }

        if (currentLocation.equals("updateLead")){
            int idLeadUpdate = View.updateLeadMenu(listOfLeads);
            listOfLeads[idLeadUpdate] = View.getNewLead(idLeadUpdate);

            return "lead";
        }

        if (currentLocation.equals("addInteraction")){
            listOfInteraction[indexInteraction] = View.getNewInteraction(indexInteraction, listOfLeads);
            indexInteraction++;
            return "interaction";
        }

        if (currentLocation.equals("deleteInteraction")){
            int correctId = View.deleteInteractionMenu(listOfInteraction);
            listOfInteraction[correctId] = null;

            System.out.println("End interaction--------------------------");
            return "interaction";
        }

        if (currentLocation.equals("updateInteraction")){
            int idInteractionUpdate = View.updateInteractionMenu(listOfInteraction);
            listOfInteraction[idInteractionUpdate] = View.getNewInteraction(idInteractionUpdate, listOfLeads);

            return "interaction";
        }

        if (currentLocation.equals("report1")){
            ReportLead report = Validation.getReportLead(listOfLeads, "age");
            View.viewReportLeadByAge(report);

            return "report";
        }

        if (currentLocation.equals("report2")){
            ReportInteraction report = Validation.getReportInteraction(listOfInteraction, "potential");
            View.viewReportInteractionByPotential(report);

            return "report";
        }

        if (currentLocation.equals("report3")){
            ReportInteraction report = Validation.getReportInteraction(listOfInteraction, "month");
            View.viewReportInteractionByPotential(report);

            return "report";
        }
        return "end";
    }
}
