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
 * @author St5-gr19-5403
 */
public class Patient {
	private static int ID = 0;

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty cprNr;
    public final IntegerProperty patientID;
    private final StringProperty adress;
    private final StringProperty phoneNumber;
    private final StringProperty emergencyContactName;
    private final StringProperty emergencyContactPhoneNumber;
    
    
    
    
    
    private Consultation consultation;

    /**
     * 
     */
    public Patient() {
        this(null, null);
    }
    
    /**
     * Constructor to initialize patient from database
     * @param cpr
     * @param fName
     * @param lName
     * @param phone
     * @param eContactName
     * @param eContactPhone
     * @param streetName
     */
    public Patient(String cpr, String fName, String lName, String phone, String eContactName, String eContactPhone, String streetName){
    	this.cprNr = new SimpleStringProperty(cpr);
    	this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.phoneNumber = new SimpleStringProperty(phone);
        this.emergencyContactName = new SimpleStringProperty(eContactName);
        this.emergencyContactPhoneNumber = new SimpleStringProperty(eContactPhone);
        this.adress = new SimpleStringProperty(streetName);
        
        consultation = new Consultation(this);
        
        //Unused attribute.
        this.patientID = makeID();
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
        
        consultation = new Consultation(this);
                
        // Some initial dummy data, just for convenient testing.
        this.patientID = makeID();
        this.cprNr = new SimpleStringProperty(makeCPR());

    	
    }
    
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
    
    public StringProperty firstNameProperty() {
        return firstName;
        
    	//To return full name.
    	//return new SimpleStringProperty(firstName.get() + " " + lastName.get());
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
    
    public String getCprNr() {
        return cprNr.get();
    }

    public void setCprNr(String cprNr) {
        this.cprNr.set(cprNr);
    }
    
    public StringProperty cprNrProperty() {
        return cprNr;
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
    
    public Consultation getConsultation() {
    	return consultation;
    }
    public void setConsultation(Consultation consultation){
    	this.consultation = consultation;
    }
    
    
    private SimpleIntegerProperty makeID(){
    	return new SimpleIntegerProperty(ID++);
    }
    private String makeCPR() {
    	return "010101-111" + Integer.toString(patientID.get());
    }
}
