package dk.aau.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.xml.stream.events.Comment;

import dk.aau.model.Consultation;
import dk.aau.model.Patient;
import dk.aau.util.DateUtil;


/**
 * Dialog to edit details of a patient.
 * 
 * @author Nicolaj
 */

public class DoctorSchemeController {
		@FXML
		private Label patientAdressLabel;
	    @FXML
	    private Label patientPhoneLabel;
	    @FXML
	    private Label emergencyContactNameLabel;
	    @FXML
	    private Label emergencyContactPhoneLabel;
	    
	    private Consultation consultation;
	
	    
	    private Stage dialogStage;
	    private Patient patient;
	   
	    private boolean okClicked = false;
	    
	    /**
	     * Initializes the controller class. This method is automatically called
	     * after the fxml file has been loaded.
	     */
	    @FXML
	    private void initialize() {
	    }	

	    /**
	     * Sets the stage of this dialog.
	     * 
	     * @param dialogStage
	     */
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }

	    
	    /**
	     * Sets the consultation to be edited in the dialog.
	     * 
	     * @param patient
	     */
	    public void setConsultation(Consultation consultation) {
	        this.consultation = consultation;
	        this.patient = consultation.getScheme().getPatient();

	        patientAdressLabel.setText(patient.getAdress());
        	patientPhoneLabel.setText(patient.getPhoneNumber());
        	emergencyContactNameLabel.setText(patient.getEmergencyContactName());
        	emergencyContactPhoneLabel.setText(patient.getEmergencyContactPhoneNumber());
	    }
	    
	    /**
	     * Returns true if the user clicked OK, false otherwise.
	     * 
	     * @return
	     */
	    public boolean isOkClicked() {
	        return okClicked;
	    }

	    /**
	     * Called when the user clicks ok.
	     */
	    
	    @FXML
	    private void handleOk() {
	        if (isInputValid()) {
	            //patient.setFirstName(firstNameField.getText());
	            
	            okClicked = true;
	            dialogStage.close();
	        }
	    }

	    /**
	     * Called when the user clicks cancel.
	     */
	    @FXML
	    private void handleCancel() {
	        dialogStage.close();
	    }
	    
	    /**
	     * Validates the user input in the text fields.
	     * 
	     * @return true if the input is valid
	     */
	    private boolean isInputValid() {
	        String errorMessage = "";

	        //if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
	        //    errorMessage += "No valid first name!\n"; 


	        if (errorMessage.length() == 0) {
	            return true;
	        } else {
	            // Show the error message.
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.initOwner(dialogStage);
	            alert.setTitle("Invalid Fields");
	            alert.setHeaderText("Please correct invalid fields");
	            alert.setContentText(errorMessage);
	            
	            alert.showAndWait();
	            
	            return false;
	        }
	    }
	    

}
