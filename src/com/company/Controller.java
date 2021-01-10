package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    //testing area
    public static void main(String[] args){
        Controller program = new Controller();
        program.start();
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
    public Controller(){
        this.leadFile = new FileControl("leads.csv");
        this.interactionFile = new FileControl("interactions.csv");

        //implements - Member: Khang
        //update listOfLeads and listOfInteractions from fileControl

        this.view = new View();
        this.validate = new Validation(listOfLeads, listOfInteraction);
    }

    //setter and getter

    //functions
    //starting the program
    public void start(){
        //initialization
        try {
            String location = "main";
            this.view.firstWords();

            while (!location.equals("end")) {
                location = changeLocation(location);
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

        //implements
        //currentLocation = "addLead" -> "lead"
        //currentLocation = "deleteLead" -> "lead"
        //currentLocation = "updateLead" -> "lead"
        //currentLocation = "viewInteractionList" -> "lead"
        //currentLocation = "addInteraction" -> "lead"
        //currentLocation = "deleteInteraction" -> "lead"
        //currentLocation = "updateInteraction" -> "lead"
        //currentLocation = "report1" -> "lead"
        //currentLocation = "report2" -> "lead"
        //currentLocation = "report3" -> "lead"
        return "end";
    }
}
