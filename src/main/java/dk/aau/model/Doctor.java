package dk.aau.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Doctor {
	private static int ID = 30;
	public final IntegerProperty doctorID;
	 private final StringProperty doctorName;
	 
	 private Consultation consultation;
	 
	 public Doctor(int id, String fName, String lName){
		 this.doctorID = new SimpleIntegerProperty(id);
		 this.doctorName = new SimpleStringProperty(fName + " " + lName);
	 }
	 
	 public Doctor() {
		this("Teest Læge");
	}
	 
	 public Doctor(String name) {
		this.doctorName = new SimpleStringProperty(name);
		this.doctorID = makeID();
	}
	 
	 
	 
	 public String getDoctorName() {
	        return doctorName.get();
    }

    public void setDoctorName(String doctorName) {
        this.doctorName.set(doctorName);
    }
    
    public StringProperty doctorNameProperty() {
        return doctorName;
    }
    
    private SimpleIntegerProperty makeID(){
    	return new SimpleIntegerProperty(ID++);
    }

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
}
