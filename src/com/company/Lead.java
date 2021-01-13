package com.company;

import java.util.Calendar;
import java.util.Date;

public class Lead implements Data{
    //testing area
    public static void main(String[] args){
        //write your test here
    }

    private String id;
    private String name;
    private Calendar dateOfBirth;
    private boolean gender; //true is male, false is female
    private String phone;
    private String email;
    private String address;

    //constructors
    //Only create a lead when we have all the requirements
    public Lead(int id, String name, Calendar dateOfBirth, boolean gender, String phone, String email, String address){
        this.id = processId(id);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Lead(String id, String name, Calendar dateOfBirth, boolean gender, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Lead(){
        //this is just temporary, after implementation of the methods in class View and Validation, this constructor will be deleted
    }
    //Turn an int id to the correct format of lead_xxx
    //validation will be handled in the controller class
    private String processId(int id){
        return "lead_" + String.valueOf(1000 + id).substring(1);
    }

    //setter and getter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //write this data to a file with this method
    @Override
    public String toFileFormat(){
        //implement - Member: Dat
        return "";
    }
}
