package dk.aau.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Doctor {
	 private final StringProperty doctorName;
	 
	 public Doctor() {
		this("Teest Læge");
	}
	 
	 public Doctor(String name) {
		doctorName = new SimpleStringProperty(name);
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

}
