package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class FileControl {
    public static void main(String[] args){
        FileControl open = new FileControl("interactions.csv");
    }
    private final File file;

    public FileControl(String fileName) {
        this.file = new File(fileName);
    }

    //used with updating and deleting data, IOException caught
    //argument: an array of Data(Lead/Interaction)
    //return nothing
    public void fileUpdateAll(Data[] listOfData) {
        try {
            PrintWriter output = new PrintWriter(this.file);
            for (Data data: listOfData){
                output.println(data.toFileFormat());
            }
            output.close();
        } catch (IOException ex) {
            System.out.print("IO problem with up updating files, error: " + ex.getMessage());
        }
    }

    public int transferData(Lead[] listOfLeads) throws FileNotFoundException, ParseException {
        int index = 0;
        Scanner input = new Scanner(file);
        while (input.hasNext()){
            String[] allInput = input.nextLine().split(",");
            String id = allInput[0];
            String name = allInput[1];
            //get date
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = sdf.parse(allInput[2]);
            Calendar dateOfBirth = Calendar.getInstance();
            dateOfBirth.setTime(date);
            boolean gender = Boolean.parseBoolean(allInput[3]);
            String phone = allInput[4];
            String email = allInput[5];
            String address = allInput[6];
            listOfLeads[index] = new Lead(id, name, dateOfBirth, gender, phone, email, address);
            index++;
        }
        return index;
    }

    public int transferData(Interaction[] listOfInteractions, Lead[] listOfLeads) throws FileNotFoundException, ParseException {
        int index = 0;
        Scanner input = new Scanner(file);
        while (input.hasNext()){
            String[] allInput = input.nextLine().split(",");
            String id = allInput[0];
            //get date
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = sdf.parse(allInput[1]);
            Calendar dateOfInteraction = Calendar.getInstance();
            dateOfInteraction.setTime(date);
            //get id from string
            String last3Num = allInput[2].substring(5,7);
            int idLead = Integer.valueOf(last3Num);
            Lead lead = listOfLeads[idLead];
            String meanOfInteraction = allInput[3];
            String potential = allInput[4];
            listOfInteractions[index] = new Interaction(id, dateOfInteraction, lead, meanOfInteraction, potential);
            index++;
        }
        return index;
    }
}
