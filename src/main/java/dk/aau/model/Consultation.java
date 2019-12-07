package dk.aau.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Consultation {
	private static int ID = 20;
	public final IntegerProperty consultationID;
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
    	
    	
    	
    	//UNused
    	this.consultationID = makeID();
    }
    
    
    public Consultation(Patient patient) {
    	this(patient,"00:00");
    	
    }
    public Consultation(Patient patient, String consultationTime) {
    	//Some initial dummy data, just for convenient testing.
        this.consultationTime = new SimpleStringProperty(consultationTime);
        this.consultationDate = new SimpleStringProperty("00/00/00");
        this.consultationID = makeID();
        
        scheme = new Scheme(patient);
    	
    }
    
    
    public String getConsultationTime() {
        return consultationTime.get();
    }

    public void setConsultationTime(String consultationTime) {
        this.consultationTime.set(consultationTime);
    }
    
    public StringProperty consultationTimeProperty() {
        return consultationTime;
    }
    public String getConsultationDate() {
        return consultationDate.get();
    }

    public void setConsultationDate(String consultationDate) {
        this.consultationDate.set(consultationDate);
    }
    
    public StringProperty consultationDateeProperty() {
        return consultationDate;
    }
    
    
    
    public Scheme getScheme() {
    	return scheme;
    }
    public void setScheme(Scheme scheme){
    	this.scheme = scheme;
    }
    
    private SimpleIntegerProperty makeID(){
    	return new SimpleIntegerProperty(ID++);
    }


	public int getSchemeID() {
		return schemeID;
	}


	public int getDoctorID() {
		return doctorID;
	}    

}
