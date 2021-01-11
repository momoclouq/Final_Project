package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public abstract class Report {
    //implements - Minh
    protected Calendar startDate;
    protected Calendar endDate;
    protected ArrayList<ReportData> output;

    //constructor
    public Report(Calendar startDate, Calendar endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Report(Calendar startDate){
        this.startDate = startDate;
        this.endDate = Calendar.getInstance();
        endDate.set(3000, Calendar.DECEMBER, 31);
    }

    public Report(){
        this.startDate = Calendar.getInstance();
        this.endDate = Calendar.getInstance();
        startDate.set(0,Calendar.JANUARY, 1);
        endDate.set(3000, Calendar.DECEMBER, 31);
    }

    protected boolean inReport(Calendar date){
        return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }

    public ArrayList<ReportData> getOutput(){
        return this.output;
    }

    protected abstract void formReport(String type);
}

class ReportData{
    private String header;
    private int count;

    //should count be automatically 0?
    //constructor
    public ReportData(String header, int count){
        this.header = header;
        this.count = count;
    }

    //setter and getter
    public void setHeader(String header){
        this.header = header;
    }

    public void setCount(int count){
        if (count > 0) this.count = count;
    }

    public int getCount(){
        return this.count;
    }

    public String getHeader(){
        return this.header;
    }

    //usable functions
    public void increase(){
        this.count++;
    }
}

class ReportLead extends Report{
    private Lead[] listOfLeads;
    private String type;

    //constructor
    public ReportLead(Calendar startDate, Calendar endDate, Lead[] listOfLeads, String type){
        super(startDate, endDate);
        this.listOfLeads = listOfLeads;
        this.output = new ArrayList<ReportData>();
        formReport(type);
    }

    public ReportLead(Calendar startDate, Lead[] listOfLeads, String type){
        super(startDate);
        this.listOfLeads = listOfLeads;
        this.output = new ArrayList<ReportData>();
        formReport(type);
    }

    public ReportLead(Lead[] listOfLeads, String type){
        super();
        this.listOfLeads = listOfLeads;
        this.output = new ArrayList<ReportData>();
        formReport(type);
    }

    //basic data processing
    private int getAge(Lead lead){
        return lead.getDateOfBirth().get(Calendar.YEAR);
    }

    @Override
    protected void formReport(String type){
        if (type.equals("age")) formAgeReport();
        else System.out.println("That form of report is not yet supported");
        //other types of report are not implemented yet
    }

    //process database for report data
    private void formAgeReport(){
        //add the header
        output.add(new ReportData("0-10 (years old)", 0));
        output.add(new ReportData("10-20 (years old)", 0));
        output.add(new ReportData("20-60 (years old)", 0));
        output.add(new ReportData(">60 (years old)", 0));

        //data
        for (Lead lead: listOfLeads){
            int age = getAge(lead);
            if (age >= 0 && age <= 10) output.get(0).increase();
            else if (age >= 11 && age <= 20) output.get(1).increase();
            else if (age >= 21 && age <= 60) output.get(2).increase();
            else if (age >= 61) output.get(3).increase();
        }
    }
}

//class ReportInteraction - implement
//by potential - Member: Tae, by month - Member: Dat