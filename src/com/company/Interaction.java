package com.company;

import java.util.Calendar;

public class Interaction implements Data{
    private String id;
    private Calendar dateOfInteraction;
    private Lead lead;
    private String meanOfInteraction; //this can be implemented with an array of means?
    private String potential; //Array of potential?

    //constructor - all detail has to be initialized
    public Interaction(int id, Calendar dateOfInteraction, Lead lead, String meanOfInteraction, String potential){
        this.id = processId(id);
        this.dateOfInteraction = dateOfInteraction;
        this.lead = lead;
        this.meanOfInteraction = meanOfInteraction;
        this.potential = potential;
    }

    public Interaction(String id, Calendar dateOfInteraction, Lead lead, String meanOfInteraction, String potential){
        this.id = id;
        this.dateOfInteraction = dateOfInteraction;
        this.lead = lead;
        this.meanOfInteraction = meanOfInteraction;
        this.potential = potential;
    }

    //process the int id to the string id
    private String processId(int id){
        return "inter_" + String.valueOf(1000+id).substring(1);
    }

    //setter and getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calendar getDateOfInteraction() {
        return dateOfInteraction;
    }

    public void setDateOfInteraction(Calendar dateOfInteraction) {
        this.dateOfInteraction = dateOfInteraction;
    }

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }

    public String getMeanOfInteraction() {
        return meanOfInteraction;
    }

    public void setMeanOfInteraction(String meanOfInteraction) {
        this.meanOfInteraction = meanOfInteraction;
    }

    public String getPotential() {
        return potential;
    }

    public void setPotential(String potential) {
        this.potential = potential;
    }

    //write this data to a file with this method
    @Override
    public String toFileFormat(){
        //implement - Member: Dat
        return id + "," + dateOfInteraction.get(dateOfInteraction.YEAR) + "-" + (dateOfInteraction.get(dateOfInteraction.MONTH) +1) + "-" +dateOfInteraction.get(dateOfInteraction.DATE) + "," + lead.getId() + "," + meanOfInteraction + "," + potential;
    }
}
