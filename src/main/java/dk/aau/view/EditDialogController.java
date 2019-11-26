package dk.aau.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import dk.aau.model.Patient;
import dk.aau.util.DateUtil;


/**
 * Dialog to edit details of a patient.
 * 
 * @author Nicolaj
 */

public class EditDialogController {
	
	 	@FXML	
	    private TextField firstNameField;
	    @FXML
	    private TextField lastNameField;
	    @FXML
	    private TextField consultationTimeField;
	    
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
	     * Sets the patient to be edited in the dialog.
	     * 
	     * @param patient
	     */
	    public void setPatient(Patient patient) {
	        this.patient = patient;

	        firstNameField.setText(patient.getFirstName());
	        lastNameField.setText(patient.getLastName());
	        consultationTimeField.setText(DateUtil.format(patient.getConsultationDate()));
	        consultationTimeField.setPromptText("dd.mm.yyyy");
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
	            patient.setFirstName(firstNameField.getText());
	            patient.setLastName(lastNameField.getText());
	            patient.setConsultationDate((DateUtil.parse(consultationTimeField.getText())));

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

	        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
	            errorMessage += "No valid first name!\n"; 
	        }
	        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
	            errorMessage += "No valid last name!\n"; 
	        }
	        if (consultationTimeField.getText() == null || consultationTimeField.getText().length() == 0) {
	            errorMessage += "No valid birthday!\n";
	        } else {
	            if (!DateUtil.validDate(consultationTimeField.getText())) {
	                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
	            }
	        }

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
