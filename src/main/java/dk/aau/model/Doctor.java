package dk.aau.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Doctor {
	 public final IntegerProperty doctorID;
	 private final StringProperty doctorName;
	 
	 private Consultation consultation;
	 
	 /**
	  * Constructor to initialize from database.
	  * @param id
	  * @param fName
	  * @param lName
	  */
	 public Doctor(int id, String fName, String lName){
		 this.doctorID = new SimpleIntegerProperty(id);
		 this.doctorName = new SimpleStringProperty(fName + " " + lName);
	 }
	 
	 
	 public String getDoctorName() {
	        return doctorName.get();
    }
    
    public StringProperty doctorNameProperty() {
        return doctorName;
    }
    
	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
}
