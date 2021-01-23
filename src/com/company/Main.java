package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try{
            Controller control = new Controller();
        } catch (FileNotFoundException ex){
            System.out.println("File not found");
        } catch (ParseException ex){
            System.out.println("file contain wrong input");
        } catch (IOException ex){
            System.out.println("io exception");
        }
    }
}
