package dk.aau.view;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;

import dk.aau.util.DateUtil;
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
        
       consultationListcontroller.patientTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPatientDetails(newValue));
    }
    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    //Reference to ConsultationListController to get selected patient to open
    public void setConsultationListController(ConsultationListController ctrl) {
    	consultationListcontroller = ctrl;
    	
    }
    
    
    /**
     * Fills all text fields to show details about the patient.
     * If the specified patient is null, all text fields are cleared.
     * 
     * @param patient the patient or null
     */
    private void showPatientDetails(Patient patient) {
        if (patient != null) {
            // Fill the labels with info from the patient object.
        	

            
            

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
        Patient selectedPatient = consultationListcontroller.patientTable.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            boolean okClicked = mainApp.showPatientOpenDialog(selectedPatient);
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
