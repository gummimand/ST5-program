package dk.aau.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Optional;

import javax.xml.stream.events.Comment;

import dk.aau.MainApp;
import dk.aau.model.Consultation;
import dk.aau.model.Doctor;
import dk.aau.model.ExistingInfo;
import dk.aau.model.PRO;
import dk.aau.model.Patient;
import dk.aau.model.Scheme;
import dk.aau.util.DateUtil;


/**
 * Dialog to edit details of a patient.
 * 
 * @author st5-19gr5403
 */

public class DoctorSchemeController {
		
		//Attributes to show in rootpane
		@FXML
	    private Label patientNameLabel;
	    @FXML
	    private Label cprNumberLabel;
	    @FXML
	    private Label consultationTimeLabel;
	    @FXML
	    private Label doctorIDLabel;
	    
	    //Below is master data
		@FXML
		private Label patientAdressLabel;
	    @FXML
	    private Label patientPhoneLabel;
	    @FXML
	    private TextField emergencyContactNameTextField;
	    @FXML
	    private TextField emergencyContactPhoneTextField;
	    
	    //Below is questions
	    @FXML
	    private Label existingInfoQuestion1Label;
	    @FXML
	    private TextArea existingInfoText1;
	    @FXML
	    private TextArea existingInfoPatientCommentText1;
	    @FXML
	    private TextArea existingInfoDoctorCommentText1;
	    @FXML
	    private Label existingInfoQuestion2Label;
	    @FXML
	    private TextArea existingInfoText2;
	    @FXML
	    private TextArea existingInfoPatientCommentText2;
	    @FXML
	    private TextArea existingInfoDoctorCommentText2;
	    @FXML
	    private Label PROQuestion1Label;
	    @FXML
	    private TextArea proAnswerText1;
	    @FXML
	    private TextArea proAnswerDoctorCommentText1;
	    @FXML
	    private Label PROQuestion2Label;
	    @FXML
	    private TextArea proAnswerText2;
	    @FXML
	    private TextArea proAnswerDoctorCommentText2;
	    @FXML
	    private TextArea journalNote;
		
	    
	    private Consultation consultation;
	
	    
	    private Stage dialogStage;
	    private Patient patient;
	    private Doctor doctor;
	    private ExistingInfo ex1;
	    private ExistingInfo ex2;
	    private PRO pro1;
	    private PRO pro2;
	    private MainApp mainApp;
	   
	    private boolean dataSaved = false;
	    
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
	    public void setMainApp(MainApp mainApp){
	    	this.mainApp = mainApp;
	    }

	    
	    /**
	     * Sets the consultation to be edited in the dialog.
	     * 
	     * @param patient
	     */
	    public void setConsultation(Consultation consultation) {
	        this.consultation = consultation;
	        patient = consultation.getScheme().getPatient();
	        
	        showPatientDetails();
        	
        	//TODO hardcoded existings infos = remove and make generic.
        	ex1 = consultation.getScheme().getExistingInformationList().get(0);
        	existingInfoQuestion1Label.setText(ex1.getQuestion());
        	existingInfoText1.setText(ex1.getobtainedInfoText());
    	    existingInfoPatientCommentText1.setText(ex1.getpatientCommentText());
    	    existingInfoDoctorCommentText1.setText(ex1.getdoctorNote());
    	    
    	    ex2 = consultation.getScheme().getExistingInformationList().get(1);
        	existingInfoQuestion2Label.setText(ex2.getQuestion());
    	    existingInfoText2.setText(ex2.getobtainedInfoText());
    	    existingInfoPatientCommentText2.setText(ex2.getpatientCommentText());
    	    existingInfoDoctorCommentText2.setText(ex2.getdoctorNote());
    	    
    	    pro1 = consultation.getScheme().getProList().get(0);
    	    PROQuestion1Label.setText(pro1.getQuestion());
    	    proAnswerText1.setText(pro1.getquestionTextAnswer());
    	    proAnswerDoctorCommentText1.setText(pro1.getdoctorNote());
    	    
    	    pro2 = consultation.getScheme().getProList().get(1);
    	    PROQuestion2Label.setText(pro2.getQuestion());
    	    proAnswerText2.setText(pro2.getquestionTextAnswer());
    	    proAnswerDoctorCommentText2.setText(pro2.getdoctorNote());
    	    journalNote.setText(consultation.getScheme().getJournalNote());
        	
	    }
	    private void showPatientDetails(){
	    	patientNameLabel.setText(patient.getFirstName());
	        cprNumberLabel.setText(patient.getCprNr());
	        consultationTimeLabel.setText(consultation.getConsultationTime());
	        patientAdressLabel.setText(patient.getAdress());
        	patientPhoneLabel.setText(patient.getPhoneNumber());
        	emergencyContactNameTextField.setText(patient.getEmergencyContactName());
        	emergencyContactPhoneTextField.setText(patient.getEmergencyContactPhoneNumber());
	    	
	    }
	    
	    /**
	     * Sets the doctor to be shown in the dialog.
	     * 
	     * @param patient
	     */
	    public void setDoctor(Doctor doctor) {
	        this.doctor = doctor;
	        doctorIDLabel.setText(doctor.getDoctorName());
	        
	    }
	    
	    /**
	     * Returns true if the user clicked OK, false otherwise.
	     * 
	     * @return
	     */
	    public boolean isOkClicked() {
	        return dataSaved;
	    }

	    /**
	     * Called when the user clicks ok.
	     */
	    
	    @FXML
	    private void handleSaveButtonClicked() {
	        if (isInputValid()) {
	            //patient.setFirstName(firstNameField.getText());
	        	ex1.setobtainedInfoText(existingInfoText1.getText());
	        	ex1.setPatientCommentText(existingInfoPatientCommentText1.getText());
	        	ex1.setDoctorNote(existingInfoDoctorCommentText1.getText());
	        	patient.setEmergencyContactName(emergencyContactNameTextField.getText());
	        	patient.setEmergencyContactPhoneNumbere(emergencyContactPhoneTextField.getText());
	        	
	        	pro1.setDoctorNote(proAnswerDoctorCommentText1.getText());
	        	pro2.setDoctorNote(proAnswerDoctorCommentText2.getText());
	        	consultation.getScheme().setJournalNote(journalNote.getText());
	        	
	        	//Uploading 
	    	    int success = mainApp.uploadToDatabase();
	        	
	    	    if (success == 1){ 
		        	// Show success message.
		        	Alert alert = new Alert(AlertType.INFORMATION);
		            alert.initOwner(dialogStage);
		            alert.setTitle("Gem");
		            alert.setHeaderText("");
		            alert.setContentText("Data gemt!");
		            
		            alert.showAndWait();
		            
		            dataSaved = true;
	    	    }
	            
	            //dialogStage.close();
	        }
	    }

	    /**
	     * Called when the user clicks cancel.
	     */
	    @FXML
	    private void handleBackButtonClicked() {
	    	//If user has saved (works only once)
	    	if(!isOkClicked()){
		    	// Show the error message.
	        	Alert alert = new Alert(AlertType.CONFIRMATION);
	            alert.initOwner(dialogStage);
	            alert.setTitle("Tilbage");
	            alert.setHeaderText("");
	            alert.setContentText("Vil du lukke uden at gemme?");
	            
	            Optional<ButtonType> result = alert.showAndWait();
	            if (result.get() == ButtonType.OK)
	            	dialogStage.close();
	    	}
	    	else
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
