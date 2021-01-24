package com.company;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Controller {
    private Lead[] listOfLeads = new Lead[100000];
    private Interaction[] listOfInteraction = new Interaction[100000];
    private View view;
    private int indexLead;
    private int indexInteraction;
    private FileControl leadFile;
    private FileControl interactionFile;

    //constructor
    public Controller() throws IOException, ParseException {
        this.leadFile = new FileControl("leads.csv");
        this.interactionFile = new FileControl("interactions.csv");
        //implements - Member: Khang
        //update listOfLeads and listOfInteractions from fileControl
        indexLead = leadFile.transferData(listOfLeads);
        indexInteraction = interactionFile.transferData(listOfInteraction, listOfLeads);
    }

    //functions
    //starting the program
    public void start(){
        //initialization
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
            leadFile.fileUpdateAll(listOfLeads);
            System.out.println("lead with id: " + (idLeadDelete+1) + " deleted.");

            return "lead";
        }

        if (currentLocation.equals("addLead")) {
            listOfLeads[indexLead] = View.addLeadMenu(indexLead);
            System.out.println("lead with id: " + (indexLead+1) + " added.");
            indexLead++;
            leadFile.fileUpdateAll(listOfLeads);
            return "lead";
        }

        if (currentLocation.equals("updateLead")){
            int idLeadUpdate = View.updateLeadMenu(listOfLeads);
            listOfLeads[idLeadUpdate] = View.getNewLead(idLeadUpdate);
            leadFile.fileUpdateAll(listOfLeads);
            System.out.println("lead with id: " + (idLeadUpdate+1) + " updated.");
            return "lead";
        }

        if (currentLocation.equals("addInteraction")){
            listOfInteraction[indexInteraction] = View.addInteractionMenu(indexInteraction, listOfLeads);
            System.out.println("interaction with id: " + (indexInteraction+1) + " added.");
            indexInteraction++;
            interactionFile.fileUpdateAll(listOfInteraction);

            return "interaction";
        }

        if (currentLocation.equals("deleteInteraction")){
            int correctId = View.deleteInteractionMenu(listOfInteraction);
            listOfInteraction[correctId] = null;
            interactionFile.fileUpdateAll(listOfInteraction);
            System.out.println("interaction with id: " + (correctId+1) + " deleted.");
            return "interaction";
        }

        if (currentLocation.equals("updateInteraction")){
            int idInteractionUpdate = View.updateInteractionMenu(listOfInteraction);
            listOfInteraction[idInteractionUpdate] = View.getNewInteraction(idInteractionUpdate, listOfLeads);
            interactionFile.fileUpdateAll(listOfInteraction);
            System.out.println("interaction with id: " + (idInteractionUpdate+1) + " updated");
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
            View.viewReportInteractionByMonth(report);

            return "report";
        }
        return "end";
    }
}
