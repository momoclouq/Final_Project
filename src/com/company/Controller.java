package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private ArrayList<Lead> listOfLeads;
    private ArrayList<Interaction> listOfInteraction;
    private View view;
    private int index;
    private FileControl leadFile;
    private FileControl interactionFile;

    //setter and getter
    public ArrayList<Lead> getListOfLeads(){
        return this.listOfLeads;
    }

    //functions
    //starting the program
    public void start(){

    }
}
