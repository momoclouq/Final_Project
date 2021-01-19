package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
            if (choice.equals("1") || choice.equals("view interaction list"))return "viewInteractionList";
            if (choice.equals("2") || choice.equals("add interaction") || choice.equals("add")) return "addInteraction";
            if (choice.equals("3") || choice.equals("delete interaction") || choice.equals("delete")) return "deleteInteraction";
            if (choice.equals("4") || choice.equals("update interaction") || choice.equals("update")) return "update";
            if (choice.equals("end")) return "end";

            //wrong input
            System.out.print("Wrong menu option. Enter choice again: ");
            choice = input.nextLine().trim().toLowerCase();
        } while (true);
        //delete this line when implemented

    }

    public static String getReportMenuInput(){
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine().trim().toLowerCase();
        boolean cont = true; //quit the program if the user wants
        do{
            //implement - Member: Khang
            //similar to lead, replace with report, check return value in the controller
            if (choice.equals("1") || choice.equals("display summary report by age"))return "report1";
            if (choice.equals("2") || choice.equals("display interactions by potential")) return "report2";
            if (choice.equals("3") || choice.equals("display interactions by month")) return "report3";
            if (choice.equals("end")) return "end";

            //wrong input
            System.out.print("Wrong menu option. Enter choice again: ");
            choice = input.nextLine().trim().toLowerCase();

        } while (true);
        //delete this line when implemented

    }

    public static Lead getNewLeadInput(int id){
        //implement with basic data input - Member: Dat
        return new Lead();
    }

    public static Interaction getNewInteractionInput(int id){
        //implement with basic data input - Member: Tae
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Enter the date of interaction(dd/mm/yyyy): ");
        String dateOfInteraction = scanner.nextLine();
        sdf.setLenient(false);
        Calendar calendar = Calendar.getInstance();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the lead: ");
//        Lead lead = scanner.next();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter the mean of interaction: ");
        String meanOfInteraction = scanner.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Enter the potential (Positive / Neutral / Negative): ");
        String potential = scanner.nextLine();

        return new Interaction();
    }

    //basic data input
    public static int getCurrentLeadIdInput(){
        //implement with listOfLeads - Member: Khang
        //note: this is to check if the lead with id entered by the user is in the listOfLeads or not
        return 1;
    }

    public String getLeadNameInput(){
        //implement - Member: Trung
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lead name");
        String name = scanner.nextLine();
        do{
            if (name.matches("^[\\p{L} .'-]+$")) return name;

            //wrong input
            System.out.println("Invalid format. Enter another one: ");
            name = scanner.nextLine().trim();
        } while (true);
    }

    public Calendar getLeadDateOfBirthInput(){
        //implement - Member: Dat
        Scanner in = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter the date of Birth of the Lead(DD/MM/YYYY): ");
        String dateOfBirth = in.nextLine();
        sdf.setLenient(false);
        Calendar cal = Calendar.getInstance();
        boolean valid = false;

        while (!valid) {

            try {
                Date date = sdf.parse(dateOfBirth);
                cal.setTime(date);
                valid = true;
            } catch (ParseException e) {
                System.out.print("Invalid. Please re-enter the date of birth (DD/MM/YYYY): ");
                dateOfBirth = in.nextLine();
                continue;
            }

        }

        return cal;
    }

    public boolean getLeadGenderInput(){
        //implement - Member: Tae
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your gender \n1. Male(m) \n2. Female(f) ");
        System.out.print("Enter the choice: ");
        String gender = input.nextLine().trim().toLowerCase();
        do{
            if (gender.equals("1") || gender.equalsIgnoreCase("male")) return true;
            if (gender.equals("2") || gender.equalsIgnoreCase("female")) return false;

            //wrong input
            System.out.print("Wrong menu option. Enter choice again: ");
            gender = input.nextLine().trim().toLowerCase();
        } while (true);
    }

    public String getLeadPhoneInput(){
        //implement - Member: Khang
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your phone number: ");
        String phone_no=scanner.nextLine();
        String[] phone = phone_no.split("");
        do {
            if (phone_no.length() == 10 && phone[0].equals("0")) return phone_no;

            //wrong input
            System.out.println("Invalid number, try again: ");
            phone_no=scanner.nextLine().trim().toLowerCase();

        }while (true);
    }

    public String getLeadEmailInput(){
        //implement - Member: Tae
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your email address: ");
        String email = input.nextLine().trim().toLowerCase();
        do {
            if (email.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$")) return email;

            //wrong input
            System.out.println("Invalid format. Enter another one: ");
            email = input.nextLine().trim().toLowerCase();

        }while (true);
    }

    public String getLeadAddressInput(){
        //implement - Member: Trung
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lead address");
        String address = scanner.nextLine();
        do{
            if (address.matches("[A-Za-z0-9'\\.\\-\\s\\,]")) return address;

            //wrong input
            System.out.println("Invalid format. Enter another one: ");
            address = scanner.nextLine().trim();
        } while (true);
    }

    public int getCurrentInteractionIdInput(int id){
        //implement with listOfInteractions - Member: Tae
        //this is to check if the interaction id input is in the interaction list or not
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the interaction id: ");
        int interId = scanner.nextInt();

        do{
            if (id==interId) return interId;

            //wrong input
            System.out.println("Invalid id. Enter another one: ");
            interId = scanner.nextInt();

        }while (true);
    }

    public Calendar getInteractionDateInput(){
        //implement - Member: Trung
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter the interaction date (DD/MM/YYYY): ");
        String interactionDate = scanner.nextLine();
        sdf.setLenient(false);
        Calendar calendar = Calendar.getInstance();
        boolean valid = false;

        while (!valid) {

            try {
                Date date = sdf.parse(interactionDate);
                calendar.setTime(date);
                valid = true;
            } catch (ParseException e) {
                System.out.print("Invalid. Please re-enter the date of birth (DD/MM/YYYY): ");
                interactionDate = scanner.nextLine();
                continue;
            }

        }

        return calendar;
    }

    public String getMeanOfInteractionInput(){
        //implement - Member: Dat
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the means of the interaction \n1. Email \n2. Telephone \n3. Face to Face \n4. Social Media ");
        System.out.print("Enter the choice: ");
        String choice = in.nextLine().toLowerCase();
        do{
            if (choice.equals("1") || choice.equalsIgnoreCase("email"))return "email";
            if (choice.equals("2") || choice.equalsIgnoreCase("telephone")) return "telephone";
            if (choice.equals("3") || choice.equalsIgnoreCase("face to face")) return "face to face";
            if (choice.equals("4") || choice.equalsIgnoreCase("social Media")) return "social media";


            //wrong input
            System.out.print("Invalid option. Enter choice again: ");
            choice = in.nextLine().toLowerCase();
        } while (true);

    }

    public String getInteractionPotentialInput(){
        //implement - Member: Trung
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter interaction potential positive/neutral/negative");
        String potential = scanner.nextLine().trim().toLowerCase();
        do{
            if (potential.equals("positive"))return potential;
            if (potential.equals("neutral"))return potential;
            if (potential.equals("negative"))return potential;

            //wrong input
            System.out.println("Invalid format. Enter another one: ");
            potential = scanner.nextLine().trim().toLowerCase();
        } while (true);
    }
}
