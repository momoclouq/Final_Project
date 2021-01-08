package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    //testing area
    public static void main(String[] args){
        Controller program = new Controller();

        program.start();
    }

    private ArrayList<Lead> listOfLeads;
    private ArrayList<Interaction> listOfInteraction;
    private View view;
    private int index;
    private FileControl leadFile;
    private FileControl interactionFile;

    //constructor
    public Controller(){
        this.view = new View();
    }

    //setter and getter
    public ArrayList<Lead> getListOfLeads(){
        return this.listOfLeads;
    }

    //functions
    //starting the program
    public void start(){
        //initialization
        Scanner input = new Scanner(System.in);
        this.view.firstWords();

        while (true){
            //all layer is implemented within this method as there arent that many of them to actually
            //disrupt the visibility
            //main menu
            int firstLayer = this.view.mainMenu(input);
            if (firstLayer == 0) break;
            if (firstLayer == 1){
                //lead sub menu
                int secondLayer = this.view.subMenuLead(input);
                if (secondLayer == 0) break;
                if (secondLayer == 1) this.view.viewListLead(listOfLeads);
                //if (secondLayer == 2) this.view.updateLeadMenu();
            }
            System.out.println("Done operation...");
        }

        System.out.println("finished! I will rest now");
        System.exit(1);
    }
}
