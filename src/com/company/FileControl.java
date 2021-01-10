package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileControl {
    private File file;

    public FileControl(String fileName) {
        this.file = new File(fileName);
    }

    //used with updating and deleting data, IOException caught
    //argument: an array of Data(Lead/Interaction)
    //return nothing
    public void fileUpdate(ArrayList<Object> listOfData) {
        try {
            //implements - Member: Trung
        } catch (IOException ex) {
            System.out.print("IO problem with up updating files, error: " + ex.getMessage());
        }
    }

    public void fileUpdateAppend(Object data){
        //implements - Member: Tae
    }
}
