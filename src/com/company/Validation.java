package com.company;

import java.util.Calendar;
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
            //implement - Member: Trung
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
            //implement - Member: Khang
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
        //implement with basic data input - Member: Dat
        return new Lead();
    }

    public Interaction getNewInteractionInput(){
        //implement with basic data input - Member: Tae
        return new Interaction();
    }

    //basic data input
    public static int getCurrentLeadIdInput(){
        //implement with listOfLeads - Member: Khang
        return 1;
    }

    public String getLeadNameInput(){
        //implement - Member: Trung
        return "name";
    }

    public Calendar getLeadDateOfBirthInput(){
        //implement - Member: Dat
        return Calendar.getInstance();
    }

    public boolean getLeadGenderInput(){
        //implement - Member: Tae
        return true;
    }

    public String getLeadPhoneInput(){
        //implement - Member: Khang
        return "phone";
    }

    public String getLeadEmailInput(){
        //implement - Member: Tae
        return "email";
    }

    public String getLeadAddressInput(){
        //implement - Member: Trung
        return "address";
    }

    public int getCurrentInteractionIdInput(){
        //implement with listOfInteractions - Member: Tae
        return 1;
    }

    public Calendar getInteractionDateInput(){
        //implement - Member: Trung
        return Calendar.getInstance();
    }

    public String getMeanOfInteractionInput(){
        //implement - Member: Dat
        return "mean";
    }

    public String getInteractionPotentialInput(){
        //implement - Member: Trung
        return "potential";
    }
}
