package dk.aau.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * Model class for a Person.
 *
 * @author Nicolaj T
 */
public class Patient {
	private static int ID = 0;

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty patientID;
    private final ObjectProperty<LocalDate> consultationDate;
    
    private final ObjectProperty<PRO> PRO_schedule;
    
    
    public final Consultation consultation = new Consultation();

    /**
     * Default constructor.
     */
    public Patient() {
        this(null, null);
    }
    
    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public Patient(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
                
        // Some initial dummy data, just for convenient testing.
        this.patientID = makeID();
        this.consultationDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(2019, 1, 1));
        this.PRO_schedule = new SimpleObjectProperty<PRO>(new PRO());
    }
    
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
    
    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
    
    public StringProperty lastNameProperty() {
        return lastName;
    }

    public int getPatientID() {
        return patientID.get();
    }

    public void setPatientID(int patientID) {
        this.patientID.set(patientID);
    }
    
    public IntegerProperty patientIDProperty() {
        return patientID;
    }
    

    public LocalDate getConsultationDate() {
        return consultationDate.get();
    }

    public void setConsultationDate(LocalDate consultationDate) {
        this.consultationDate.set(consultationDate);
    }
    
    public ObjectProperty<LocalDate> consultationDateProperty() {
        return consultationDate;
    }
    
    public PRO getPROSchedule() {
        return PRO_schedule.get();
    }

    public void setPROSchedule(PRO proSchedule) {
        this.PRO_schedule.set(proSchedule);
    }
    
    public ObjectProperty<PRO> PROScheduleProperty() {
        return PRO_schedule;
    }
    
    
    private SimpleIntegerProperty makeID(){
    	return new SimpleIntegerProperty(ID++);
    }
}
