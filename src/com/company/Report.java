package com.company;

import java.net.InterfaceAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public Report() {
        this.startDate = Calendar.getInstance();
        this.endDate = Calendar.getInstance();
        startDate.set(0, Calendar.JANUARY, 1);
        endDate.set(3000, Calendar.DECEMBER, 31);
    }

    public String getPeriod(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Calendar start = Calendar.getInstance();
        start.set(0,Calendar.JANUARY, 1);
        Calendar end = Calendar.getInstance();
        end.set(3000, Calendar.DECEMBER, 31);


        if(startDate.compareTo(start) == 0 && endDate.compareTo(end) == 0) return "All time";
        if(startDate.compareTo(start) != 0) return "starting from " + sdf.format(startDate.getTime());
        return "ending at " + sdf.format(endDate.getTime());
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
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);

        //data
        for (Lead lead: listOfLeads){
            if (lead != null && inReport(lead.getDateOfBirth())){
                int age = currentYear - getAge(lead);
                if (age >= 0 && age <= 10) output.get(0).increase();
                else if (age >= 11 && age <= 20) output.get(1).increase();
                else if (age >= 21 && age <= 60) output.get(2).increase();
                else if (age >= 61) output.get(3).increase();
            }
        }
    }
}


class CalendarSortingComparator implements Comparator<Calendar> {
    public int compareYear(Calendar y1, Calendar y2) {
        if (y1.get(Calendar.YEAR) > y2.get(Calendar.YEAR)) return 1;
        if (y1.get(Calendar.YEAR) == y2.get(Calendar.YEAR)) return 0;
        return -1;
    }

    public int compareMonth(Calendar m1, Calendar m2) {
        if (m1.get(Calendar.MONTH) > m1.get(Calendar.MONTH)) return 1;
        if (m1.get(Calendar.MONTH) == m2.get(Calendar.MONTH)) return 0;
        return -1;
    }

    @Override
    public int compare(Calendar item1, Calendar item2) {
        if (item1.get(Calendar.YEAR) == item2.get(Calendar.YEAR) && item1.get(Calendar.MONTH) == item2.get(Calendar.MONTH)) return 0;
        if (item1.get(Calendar.YEAR) < item2.get(Calendar.YEAR)) {
            return -1;
        }
        if (item1.get(Calendar.YEAR) > item2.get(Calendar.YEAR)){
            return 1;
        }
        if (item1.get(Calendar.MONTH) < item2.get(Calendar.MONTH)){
            return -1;
        }
        if (item1.get(Calendar.MONTH) > item2.get(Calendar.MONTH)){
            return 1;
        }
        return 0;
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
        else if (type.equals("month")) formMonthReport();
        else System.out.println("That form of report is not yet supported");
    }


    private void formPotentialReport() {
        //add the header
        output.add(new ReportData("Positive", 0));
        output.add(new ReportData("Negative", 0));
        output.add(new ReportData("Neutral", 0));

        for (Interaction inter : listOfInteractions) {
            if (inter != null && inReport(inter.getDateOfInteraction())) {
                String potential = getPotential(inter);
                if (potential.equalsIgnoreCase("Positive")) output.get(0).increase();
                else if (potential.equalsIgnoreCase("Negative")) output.get(1).increase();
                else if (potential.equalsIgnoreCase("Neutral")) output.get(2).increase();
            }
        }
    }

    public int compareX(Calendar item1, Calendar item2) {
        if (item1.get(Calendar.YEAR) == item2.get(Calendar.YEAR) && item1.get(Calendar.MONTH) == item2.get(Calendar.MONTH)) return 0;
        if (item1.get(Calendar.YEAR) < item2.get(Calendar.YEAR)) {
            return -1;
        }
        if (item1.get(Calendar.YEAR) > item2.get(Calendar.YEAR)){
            return 1;
        }
        if (item1.get(Calendar.MONTH) < item2.get(Calendar.MONTH)){
            return -1;
        }
        if (item1.get(Calendar.MONTH) > item2.get(Calendar.MONTH)){
            return 1;
        }
        return 0;
    }

    private void formMonthReport() {
        List<Calendar> calList = new ArrayList<>();
        //CalendarSortingComparator compareOb = new CalendarSortingComparator();

        //data
        for (Interaction inter : listOfInteractions) {
            if (inter != null){
                Calendar calendarDate = getInteractionDate(inter);
                if (inReport(calendarDate)) {
                    calList.add(calendarDate);
                    //int index = calList.size() - 1;
                    //output.add(new ReportData( monthTransfer(calList.get(index)) + " "  + calList.get(index).get(Calendar.YEAR), 1));
                }
            }
        }

        //sort the list of Calendars
        Collections.sort(calList, new Comparator<Calendar>() {
            @Override
            public int compare(Calendar item1, Calendar item2) {
                if (item1.get(Calendar.YEAR) == item2.get(Calendar.YEAR) && item1.get(Calendar.MONTH) == item2.get(Calendar.MONTH)) return 0;
                if (item1.get(Calendar.YEAR) < item2.get(Calendar.YEAR)) {
                    return -1;
                }
                if (item1.get(Calendar.YEAR) > item2.get(Calendar.YEAR)){
                    return 1;
                }
                if (item1.get(Calendar.MONTH) < item2.get(Calendar.MONTH)){
                    return -1;
                }
                if (item1.get(Calendar.MONTH) > item2.get(Calendar.MONTH)){
                    return 1;
                }
                return 0;
            }
        });

        //sort the list of all dates
        //Collections.sort(calList, new CalendarSortingComparator());

        int currentIndexCalList = 1;
        int currentIndexOutput = 0;
        Calendar currentDate = calList.get(0);

        //loop through the list of all dates, count the occurences of each individual date to form the report
        if (calList.size() > 0){
            output.add(new ReportData( (monthTransfer(calList.get(0))) + " "  + calList.get(0).get(Calendar.YEAR), 1));

            while (currentIndexCalList < calList.size()) {
                if (compareX(calList.get(currentIndexCalList), currentDate) == 0) {
                    output.get(currentIndexOutput).increase();
                } else {
                    currentIndexOutput++;
                    currentDate = calList.get(currentIndexCalList);
                    output.add(new ReportData( (monthTransfer(calList.get(currentIndexCalList))) + " "  + calList.get(currentIndexCalList).get(Calendar.YEAR), 1));
                }

                currentIndexCalList++;
            }
        } else output.add(new ReportData("empty", 0));
    }
}
