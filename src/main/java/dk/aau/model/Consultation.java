package dk.aau.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Consultation {
	private final StringProperty consultationTime;
    private final StringProperty schemeAvailable;
    
    
    public Consultation() {
        
    	
    	//Some initial dummy data, just for convenient testing.
        this.consultationTime = new SimpleStringProperty("11:00");
        this.schemeAvailable = new SimpleStringProperty("Ja");
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
    
    public String getSchemeAvailable() {
        return schemeAvailable.get();
    }

    public void setSchemeAvailable(String available) {
        this.schemeAvailable.set(available);
    }
    
    public StringProperty schemeAvailableProperty() {
        return schemeAvailable;
    }

}
