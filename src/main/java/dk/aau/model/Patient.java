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
    private final StringProperty adress;
    private final StringProperty phoneNumber;
    private final StringProperty emergencyContactName;
    private final StringProperty emergencyContactPhoneNumber;
    
    
    private final ObjectProperty<LocalDate> consultationDate;//TODO remove.
    
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
    	this(firstName,lastName,"testAdresse","12312322","Tryg forsikring","33311133");
        
    }
    public Patient(String firstName, String lastName, String adress, String phoneNumber, String emergencyContactName, String emergencyContactPhoneNumber) {
    	this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.adress = new SimpleStringProperty(adress);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.emergencyContactName = new SimpleStringProperty(emergencyContactName);
        this.emergencyContactPhoneNumber = new SimpleStringProperty(emergencyContactPhoneNumber);
                
        // Some initial dummy data, just for convenient testing.
        this.patientID = makeID();
        this.consultationDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(2019, 1, 1));//TODO remove
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
    
    public String getAdress() {
        return adress.get();
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }
    
    public StringProperty adressProperty() {
        return adress;
    }
    
    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }
    
    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }
    
    public String getEmergencyContactName() {
        return emergencyContactName.get();
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName.set(emergencyContactName);
    }
    
    public StringProperty emergencyContactNameProperty() {
        return emergencyContactName;
    }
    
    public String getEmergencyContactPhoneNumber() {
        return emergencyContactPhoneNumber.get();
    }

    public void setEmergencyContactPhoneNumbere(String emergencyContactPhoneNumber) {
        this.emergencyContactPhoneNumber.set(emergencyContactPhoneNumber);
    }
    
    public StringProperty emergencyContactPhoneNumberProperty() {
        return emergencyContactPhoneNumber;
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
