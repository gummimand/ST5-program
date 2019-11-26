package dk.aau.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;


import dk.aau.MainApp;
import dk.aau.model.Patient;

public class PatientInfoController {
	
	@FXML
    private Label patientNameLabel;
    @FXML
    private Label cprNumberLabel;
    @FXML
    private Label patientAdressLabel;
    @FXML
    private Label patientPhoneLabel;
    @FXML
    private Label emergencyContactNameLabel;
    @FXML
    private Label emergencyContactPhoneLabel;
    
    private ConsultationListController consultationListcontroller;
    private Patient currentPatient;
    
    
    
    
    // Reference to the main application.
    private MainApp mainApp;
    
    public PatientInfoController() {
	}
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
                
        //Initialize to no text
        showPatientDetails(null);
       
    }
    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    //Reference to ConsultationListController to get selected patient to open
    public void setConsultationListController(ConsultationListController ctrl) {
    	consultationListcontroller = ctrl;
    	consultationListcontroller.patientTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPatientDetails(newValue));
    	
    }
    
    
    /**
     * Fills all text fields to show details about the patient.
     * If the specified patient is null, all text fields are cleared.
     * 
     * @param patient the patient or null
     */
    private void showPatientDetails(Patient patient) {
        if (patient != null) {
        	currentPatient = patient;
            // Fill the labels with info from the patient object.
        	patientNameLabel.setText(patient.getFirstName() + " " + patient.getLastName());
        	cprNumberLabel.setText(Integer.toString(patient.getPatientID()));
        	patientAdressLabel.setText(patient.getAdress());
        	patientPhoneLabel.setText(patient.getPhoneNumber());
        	emergencyContactNameLabel.setText(patient.getEmergencyContactName());
        	emergencyContactPhoneLabel.setText(patient.getEmergencyContactPhoneNumber());
            
            

        } else {
            // Patient is null, remove all the text.
        	patientNameLabel.setText("");
        	cprNumberLabel.setText("");
        	patientAdressLabel.setText("");
        	patientPhoneLabel.setText("");
        	emergencyContactNameLabel.setText("");
        	emergencyContactPhoneLabel.setText("");

        }
    }
    
    
    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected patient.
     */
    @FXML
    private void handleOpenPatient() {
    	
        //Patient selectedPatient = consultationListcontroller.patientTable.getSelectionModel().getSelectedItem();
    	Patient selectedPatient = currentPatient;
        if (selectedPatient != null) {
            boolean okClicked = mainApp.showPatientOpenDialog(selectedPatient.getConsultation());
            if (okClicked) {
                showPatientDetails(selectedPatient);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Patient Selected");
            alert.setContentText("Please select a patient in the table.");

            alert.showAndWait();
        }
    }

}
