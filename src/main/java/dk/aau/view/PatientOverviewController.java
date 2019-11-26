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

public class PatientOverviewController {
    @FXML
    private TableView<Patient> patientTable;
    @FXML
    private TableColumn<Patient, String> firstNameColumn;
    @FXML
    private TableColumn<Patient, String> lastNameColumn;
    
    @FXML
    private TableColumn<Patient, LocalDate> timeColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label patientIDLabel;
    @FXML
    private Label consultationDateLabel;
    
    @FXML
    private Label question1Label;
    @FXML
    private Label question2Label;
    @FXML
    private Label question3Label;
    
    @FXML
    private Label answer1Label;
    @FXML
    private Label answer2Label;
    @FXML
    private Label answer3Label;
    
    
    @FXML
    private TextField comment1Label;
    @FXML
    private TextField comment2Label;
    @FXML
    private TextField comment3Label;
    
    

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PatientOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the patient table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        //timeColumn.setCellValueFactory(cellData -> (cellData.getValue().consultationDateProperty()));
        
        showPatientDetails(null);
        
        patientTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPatientDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        patientTable.setItems(mainApp.getPatientData());
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
            firstNameLabel.setText(patient.getFirstName());
            lastNameLabel.setText(patient.getLastName());
            patientIDLabel.setText(Integer.toString(patient.getPatientID()));
            consultationDateLabel.setText(DateUtil.format(patient.getConsultationDate()));
            
            
            question1Label.setText(patient.getPROSchedule().getQuestion1().getKey());
            question2Label.setText(patient.getPROSchedule().getQuestion2());
            question3Label.setText(patient.getPROSchedule().getQuestion3());
            
            answer1Label.setText(patient.getPROSchedule().getQuestion1().getValue());
            
            

        } else {
            // Patient is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            patientIDLabel.setText("");
            consultationDateLabel.setText("");
            
            question1Label.setText("");
            question2Label.setText("");
            question3Label.setText("");
            
            answer1Label.setText("");
            answer2Label.setText("");
            answer3Label.setText("");
            
            
            comment1Label.setText("");
            comment2Label.setText("");
            comment3Label.setText("");
        }
    }
    
    
    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected patient.
     */
    @FXML
    private void handleEditPatient() {
        Patient selectedPatient = patientTable.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            boolean okClicked = mainApp.showPatientEditDialog(selectedPatient);
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