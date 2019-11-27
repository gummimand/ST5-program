package dk.aau.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Doctor {
	private static int ID = 30;
	public final IntegerProperty doctorID;
	 private final StringProperty doctorName;
	 
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
}
