package com.company;

import java.util.Date;
import java.util.Scanner;

public class Validation {
    //testing area
    public static void main(String[] args){

    }
    //This class will deal with input validation.
    // All the methods usable in this class will return the input "choice" if it is valid
    // force the user to re-enter the input "choice" if not
    // user choose not to continue (1. return to the "main" menu or exit the program) with the return "@END@" option

    private Lead[] listOfLeads;
    private Interaction[] listOfInteractions;

    //constructor
    public Validation(Lead[] listOfLeads, Interaction[] listOfInteractions){
        this.listOfLeads = listOfLeads;
        this.listOfInteractions = listOfInteractions;
    }

    public static String trimInput(String input){
        return input.trim().toLowerCase();
    }

    public static boolean isInteger(String input){
        try{
            int number = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    public static String getMainMenuInput(){
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine().trim().toLowerCase();
        boolean cont = true; //quit the program if the user wants
        do{
            if (choice.equals("1") || choice.equals("lead"))return "lead";
            if (choice.equals("2") || choice.equals("interaction")) return "interaction";
            if (choice.equals("3") || choice.equals("report") || choice.equals("stats")) return "report";
            if (choice.equals("end")) return "end";

            //wrong input
            System.out.print("Wrong menu option. Enter choice again: ");
            choice = input.nextLine().trim().toLowerCase();
        } while (true);
    }

    public static String getLeadMenuInput(){
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine().trim().toLowerCase();
        boolean cont = true; //quit the program if the user wants
        do{
            if (choice.equals("1") || choice.equals("view lead list"))return "viewLeadList";
            if (choice.equals("2") || choice.equals("add lead") || choice.equals("add")) return "addLead";
            if (choice.equals("3") || choice.equals("delete lead") || choice.equals("delete")) return "deleteLead";
            if (choice.equals("4") || choice.equals("update lead") || choice.equals("update")) return "update";
            if (choice.equals("end")) return "end";

            //wrong input
            System.out.print("Wrong menu option. Enter choice again: ");
            choice = input.nextLine().trim().toLowerCase();
        } while (true);
    }

    public static String getInteractionMenuInput(){
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine().trim().toLowerCase();
        boolean cont = true; //quit the program if the user wants
        do{
            //implement
            //similar to lead, replace with interaction, check return value in the controller
            if (choice.equals("end")) return "end";

            //wrong input
            System.out.print("Wrong menu option. Enter choice again: ");
            choice = input.nextLine().trim().toLowerCase();
            break;
        } while (true);
        //delete this line when implemented
        return "end";
    }

    public static String getReportMenuInput(){
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine().trim().toLowerCase();
        boolean cont = true; //quit the program if the user wants
        do{
            //implement
            //similar to lead, replace with report, check return value in the controller
            if (choice.equals("end")) return "end";

            //wrong input
            System.out.print("Wrong menu option. Enter choice again: ");
            choice = input.nextLine().trim().toLowerCase();
            break;
        } while (true);
        //delete this line when implemented
        return "end";
    }

    public Lead getNewLeadInput(){
        //implement with basic data input
        return new Lead();
    }

    public Interaction getNewInteractionInput(){
        //implement with basic data input
        return new Interaction();
    }

    //basic data input
    public int getCurrentLeadIdInput(){
        //implement with listOfLeads
        return 1;
    }

    public String getLeadNameInput(){
        //implement
        return "name";
    }

    public Date getLeadDateOfBirthInput(){
        //implement
        return new Date();
    }

    public boolean getLeadGenderInput(){
        //implement
        return true;
    }

    public String getLeadPhoneInput(){
        //implement
        return "phone";
    }

    public String getLeadEmailInput(){
        //implement
        return "email";
    }

    public String getLeadAddressInput(){
        //implement
        return "address";
    }

    public int getCurrentInteractionIdInput(){
        //implement with listOfInteractions
        return 1;
    }

    public Date getInteractionDateInput(){
        //implement
        return new Date();
    }

    public String getMeanOfInteractionInput(){
        //implement
        return "mean";
    }

    public String getInteractionPotentialInput(){
        //implement
        return "potential";
    }
}
