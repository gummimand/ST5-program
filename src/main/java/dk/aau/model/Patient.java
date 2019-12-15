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
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty cprNr;
    private final StringProperty adress;
    private final StringProperty phoneNumber;
    private final StringProperty emergencyContactName;
    private final StringProperty emergencyContactPhoneNumber;
    
    
    
    
    
    private Consultation consultation;

      
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
    }
    
    
    public String getFirstName() {
        return firstName.get();
    }
    
    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }
    
    public StringProperty lastNameProperty() {
        return lastName;
    }
    
    public String getCprNr() {
        return cprNr.get();
    }
    
    public StringProperty cprNrProperty() {
        return cprNr;
    }
    
    public String getAdress() {
        return adress.get();
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
}
