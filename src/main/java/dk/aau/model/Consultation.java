package dk.aau.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Consultation {
	private static int ID = 20;
	public final IntegerProperty consultationID;
	private final StringProperty consultationTime;
    
    private Scheme scheme;
    
    
       
    public Consultation(Patient patient) {
    	this(patient,"11:00");
    	
    }
    public Consultation(Patient patient, String consultationTime) {
    	//Some initial dummy data, just for convenient testing.
        this.consultationTime = new SimpleStringProperty(consultationTime);
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
    
    
    
    public Scheme getScheme() {
    	return scheme;
    }
    
    private SimpleIntegerProperty makeID(){
    	return new SimpleIntegerProperty(ID++);
    }    

}
