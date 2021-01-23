package com.company;

import java.net.InterfaceAddress;
import java.util.*;

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

    public String getPeriod(){
        Calendar start = Calendar.getInstance();
        start.set(0,Calendar.JANUARY, 1);
        Calendar end = Calendar.getInstance();
        end.set(3000, Calendar.DECEMBER, 31);


        if(startDate.compareTo(start) == 0 && endDate.compareTo(end) == 0) return "All time";
        if(startDate.compareTo(start) != 0) return "starting from " + startDate.toString();
        return "ending at " + endDate.toString();
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
    //both starting date and end date
    public ReportLead(Calendar startDate, Calendar endDate, Lead[] listOfLeads, String type){
        super(startDate, endDate);
        this.listOfLeads = listOfLeads;
        this.output = new ArrayList<ReportData>();
        formReport(type);
    }

    //only starting date
    public ReportLead(Calendar startDate, Lead[] listOfLeads, String type){
        super(startDate);
        this.listOfLeads = listOfLeads;
        this.output = new ArrayList<ReportData>();
        formReport(type);
    }

    //only end date
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

class CalendarSortingComparator implements Comparator<Calendar> {

    public int compareYear(Calendar y1, Calendar y2) {
        if (y1.get(Calendar.YEAR) > y2.get(Calendar.YEAR)) return 1;
        else if (y1.get(Calendar.YEAR) == y2.get(Calendar.YEAR)) return 0;
        else if (y1.get(Calendar.YEAR) < y2.get(Calendar.YEAR)) return -1;
        else return -10000000;
    }

    public int compareMonth(Calendar m1, Calendar m2) {
        if (m1.get(Calendar.MONTH) + 1 > m1.get(Calendar.MONTH) + 1) return 1;
        else if (m1.get(Calendar.MONTH) + 1 == m2.get(Calendar.MONTH)) return 0;
        else if (m1.get(Calendar.MONTH) < m2.get(Calendar.MONTH)) return -1;
        else return -10000000;
    }

    @Override
    public int compare(Calendar o1, Calendar o2) {
        int yearCompare = compareYear(o1, o2);
        int monthCompare = compareMonth(o1, o2);

        if (yearCompare == 0) {
            return ((monthCompare == 0) ? yearCompare : monthCompare);
        } else {
            return yearCompare;
        }
    }
}


//class ReportInteraction - implement
//by potential - Member: Tae, by month - Member: Dat
class ReportInteraction extends Report{
    private Interaction[] listOfInteractions;
    private String type;

    //constructor
    public ReportInteraction(Calendar startDate, Calendar endDate, Interaction[] listOfInteractions, String type){
        super(startDate, endDate);
        this.listOfInteractions = listOfInteractions;
        this.output = new ArrayList<ReportData>();
        formReport(type);
    }

    //only starting date
    public ReportInteraction(Calendar startDate, Interaction[] listOfInteractions, String type){
        super(startDate);
        this.listOfInteractions = listOfInteractions;
        this.output = new ArrayList<ReportData>();
        formReport(type);
    }

    //only end date
    public ReportInteraction(Interaction[] listOfInteractions, String type){
        super();
        this.listOfInteractions = listOfInteractions;
        this.output = new ArrayList<ReportData>();
        formReport(type);
    }


    //basic data processing
    private String getPotential(Interaction interaction) {
        return interaction.getPotential();
    }

    private Calendar getInteractionDate(Interaction interaction) {
        return interaction.getDateOfInteraction();
    }

    private String monthTransfer(Calendar cal) {
        int month = cal.get(Calendar.MONTH);
        switch (month) {
            case 0:
                return "Jan";
            case 1:
                return "Feb";
            case 2:
                return "Mar";
            case 3:
                return "Apr";
            case 4:
                return "May";
            case 5:
                return "Jun";
            case 6:
                return "July";
            case 7:
                return "Aug";
            case 8:
                return "Sep";
            case 9:
                return "Oct";
            case 10:
                return "Nov";
            case 11:
                return "Dec";
            default:
                throw new IllegalStateException("Unexpected value: " + month);
        }
    }


    @Override
    protected void formReport(String type) {
        if (type.equals("potential")) formPotentialReport();
        else if (type.equals("monthly")) formMonthReport();
        else System.out.println("That form of report is not yet supported");
    }


    private void formPotentialReport() {
        //add the header
        output.add(new ReportData("Positive", 0));
        output.add(new ReportData("Negative", 0));
        output.add(new ReportData("Neutral", 0));


        //data
        for (Interaction inter : listOfInteractions) {
            String potential = getPotential(inter);
            if (potential.equalsIgnoreCase("Positive")) output.get(0).increase();
            else if (potential.equalsIgnoreCase("Negative")) output.get(1).increase();
            else if (potential.equalsIgnoreCase("Neutral")) output.get(2).increase();

        }
    }

    private void formMonthReport() {
        //add the header
        List<Calendar> calList = new ArrayList<>();
        CalendarSortingComparator compareOb = new CalendarSortingComparator();


        //data
        for (Interaction inter : listOfInteractions) {
            Calendar calendarDate = getInteractionDate(inter);
            for (int i = 0; i < listOfInteractions.length; i++) {
                if (calendarDate.compareTo(startDate) >= 0 && calendarDate.compareTo(endDate) == -1) calList.add(calendarDate);
            }

        }

        Collections.sort(calList, new CalendarSortingComparator());

        int currentIndex = 0;
        output.add(new ReportData( monthTransfer(calList.get(currentIndex)) + " "  + calList.get(currentIndex).get(Calendar.YEAR), 1));
        while (currentIndex < output.size()) {
            if (compareOb.compare(calList.get(currentIndex), calList.get(currentIndex+1)) == 0) {
                output.add(new ReportData( (calList.get(currentIndex+1).get(Calendar.MONTH) + 1) + " "  + calList.get(currentIndex+1).get(Calendar.YEAR), 1+output.get(currentIndex).getCount()));
                output.remove(currentIndex);
            } else currentIndex++;
        }
    }
}
