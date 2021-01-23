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
    }

    public static Lead getNewLeadInput(int id){
        String name = getLeadNameInput();
        Calendar dateOfBirth = getLeadDateOfBirthInput();
        boolean gender = getLeadGenderInput();
        String phone = getLeadPhoneInput();
        String address = getLeadAddressInput();
        String email = getLeadEmailInput();

        return new Lead(id, name, dateOfBirth, gender, phone, email, address);
    }

    public static Interaction getNewInteractionInput(int id, Lead[] listOfLeads){
        //implement with basic data input - Member: Tae
        Calendar dateOfInteraction = getInteractionDateInput();
        String potential = getInteractionPotentialInput();
        Lead lead = listOfLeads[getCurrentLeadIdInput(listOfLeads)];
        String meanOfInteraction = getMeanOfInteractionInput();
        return new Interaction(id, dateOfInteraction, lead, meanOfInteraction, potential);
    }

    //basic data input
    public static int getCurrentLeadIdInput(Lead[] listOfLeads){
        //implement with listOfLeads - Member: Khang
        //note: this is to check if the lead with id entered by the user is in the listOfLeads or not
        Scanner input = new Scanner(System.in);
        System.out.print("Enter lead id for processing: ");
        int correctId;

        while (true){
            try{
                correctId = input.nextInt();
                if(listOfLeads[correctId-1] != null) return correctId-1;
            } catch (InputMismatchException ex){
                input.nextLine();
                System.out.print("Wrong lead id, please enter id again: ");
            }
        }
    }

    public static String getLeadNameInput(){
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

    public static Calendar getLeadDateOfBirthInput(){
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

    public static boolean getLeadGenderInput(){
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

    public static String getLeadPhoneInput(){
        //implement - Member: Khang
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your phone number (start with 0, length equals 10, only numbers): ");
        String phone_no=scanner.nextLine();
        do {
            if (phone_no.length() == 10 && phone_no.charAt(0) == '0' && phone_no.matches("^[0-9]*$")) return phone_no;

            //wrong input
            System.out.println("Invalid number, try again: ");
            phone_no=scanner.nextLine().trim().toLowerCase();
        }while (true);
    }

    public static String getLeadEmailInput(){
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

    public static String getLeadAddressInput(){
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

    public static int getCurrentInteractionIdInput(Interaction[] listOfInteractions){
        //implement with listOfInteractions - Member: Tae
        Scanner input = new Scanner(System.in);
        System.out.print("Enter interaction id for processing: ");
        int correctId;

        while (true){
            try{
                correctId = input.nextInt();
                if(listOfInteractions[correctId-1] != null) return correctId-1;
            } catch (InputMismatchException ex){
                input.nextLine();
                System.out.print("Wrong interaction id, please enter id again: ");
            }
        }
    }

    public static Calendar getInteractionDateInput(){
        //implement - Member: Trung
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter the interaction date (DD/MM/YYYY): ");
        String interactionDate = scanner.nextLine();
        sdf.setLenient(false);
        Calendar calendar = Calendar.getInstance();

        while (true) {
            try {
                Date date = sdf.parse(interactionDate);
                calendar.setTime(date);
                return calendar;
            } catch (ParseException e) {
                System.out.print("Invalid. Please re-enter the date of birth (DD/MM/YYYY): ");
                interactionDate = scanner.nextLine();
            }
        }
    }

    public static ReportLead getReportLead(Lead[] listOfLeads, String type){
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter the date for report (DD/MM/YYYY - DD/MM/YYYY): ");
        String date = scanner.nextLine();
        String[] dateList = date.split("-");
        sdf.setLenient(false);
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        while (true) {
            try {
                Date startDateFormat = sdf.parse(dateList[0].trim());
                startDate.setTime(startDateFormat);
                Date endDateFormat = sdf.parse(dateList[1].trim());
                endDate.setTime(endDateFormat);
                break;
            } catch (ParseException e) {
                System.out.print("Invalid date. Please re-enter the date for report (DD/MM/YYYY - DD/MM/YYYY): ");
                date = scanner.nextLine();
                dateList = date.split("-");
            } catch (ArrayIndexOutOfBoundsException ex){
                if (dateList.length == 0) return new ReportLead(listOfLeads, type);
                if (dateList.length == 1) return new ReportLead(startDate, listOfLeads, type);
            }
        }

        return new ReportLead(startDate, endDate, listOfLeads, type);
    }

    public static ReportInteraction getReportInteraction(Interaction[] listOfInteractions, String type){
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter the date for report (DD/MM/YYYY - DD/MM/YYYY): ");
        String date = scanner.nextLine();
        String[] dateList = date.split("-");
        sdf.setLenient(false);
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        while (true) {
            try {
                Date startDateFormat = sdf.parse(dateList[0].trim());
                startDate.setTime(startDateFormat);
                Date endDateFormat = sdf.parse(dateList[1].trim());
                endDate.setTime(endDateFormat);
                break;
            } catch (ParseException e) {
                System.out.print("Invalid date. Please re-enter the date for report (DD/MM/YYYY - DD/MM/YYYY): ");
                date = scanner.nextLine();
                dateList = date.split("-");
            } catch (ArrayIndexOutOfBoundsException ex){
                if (dateList.length == 0) return new ReportInteraction(listOfInteractions, type);
                if (dateList.length == 1) return new ReportInteraction(startDate, listOfInteractions, type);
            }
        }

        return new ReportInteraction(startDate, endDate, listOfInteractions, type);
    }

    public static String getMeanOfInteractionInput(){
        //implement - Member: Dat
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the means of the interaction \n1. Email \n2. Telephone \n3. Face to Face \n4. Social Media ");
        System.out.print("Enter the choice: ");
        String choice = in.nextLine().trim();
        do{
            if (choice.equals("1") || choice.equalsIgnoreCase("email"))return "email";
            if (choice.equals("2") || choice.equalsIgnoreCase("telephone")) return "telephone";
            if (choice.equals("3") || choice.equalsIgnoreCase("face to face")) return "face to face";
            if (choice.equals("4") || choice.equalsIgnoreCase("social Media")) return "social media";

            //wrong input
            System.out.print("Invalid option. Enter mean of interaction again: ");
            choice = in.nextLine().toLowerCase();
        } while (true);
    }

    public static String getInteractionPotentialInput(){
        //implement - Member: Trung
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter interaction's potential (1. positive/2. neutral/3. negative): ");
        String potential = scanner.nextLine().trim().toLowerCase();
        do{
            if (potential.equals("positive") || potential.equals("neutral") || potential.equals("negative")) return potential;
            if (potential.equals("1")) return "positive";
            if (potential.equals("2")) return "neutral";
            if (potential.equals("3")) return "negative";
            //wrong input
            System.out.print("Invalid format. Enter potential again: ");
            potential = scanner.nextLine().trim().toLowerCase();
        } while (true);
    }
}
