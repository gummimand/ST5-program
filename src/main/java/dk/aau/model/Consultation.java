package dk.aau.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Consultation {
	private final StringProperty consultationTime;
	private final StringProperty consultationDate;
    
	
	//Reference to the ID's of the connected scheme and doctor
	private int doctorID;
	private int schemeID;
	
	//Reference to the contained scheme.
    private Scheme scheme;
    
    /**
     * Constructor for initialzing from database
     * @param time
     * @param date
     * @param doctorID
     * @param schemeID
     */
    public Consultation(String time, String date, int doctorID, int schemeID){
    	this.consultationTime = new SimpleStringProperty(time);
    	this.consultationDate = new SimpleStringProperty(date);
    	this.doctorID=doctorID;
    	this.schemeID=schemeID;     

    }
    
    
    public String getConsultationTime() {
        return consultationTime.get();
    }
   
    public StringProperty consultationTimeProperty() {
        return consultationTime;
    }
    public String getConsultationDate() {
        return consultationDate.get();
    }
    
    public StringProperty consultationDateProperty() {
        return consultationDate;
    }
    
    public Scheme getScheme() {
    	return scheme;
    }
    public void setScheme(Scheme scheme){
    	this.scheme = scheme;
    }
    
	public int getSchemeID() {
		return schemeID;
	}
	
	public int getDoctorID() {
		return doctorID;
	}    

}
