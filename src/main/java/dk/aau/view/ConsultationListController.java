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

public class ConsultationListController {
    @FXML
    protected TableView<Patient> patientTable;
    @FXML
    private TableColumn<Patient, String> firstNameColumn;
    @FXML
    private TableColumn<Patient, Integer> cprNumberColumn;
    @FXML
    private TableColumn<Patient, String> consultationTimeColumn;
    @FXML
    private TableColumn<Patient, String> SchemeAvailableColumn;



    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ConsultationListController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the patient table with the two columns.
    	//From Patient model
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        //lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        cprNumberColumn.setCellValueFactory(cellData -> cellData.getValue().patientIDProperty().asObject());
        //timeColumn.setCellValueFactory(cellData -> (cellData.getValue().consultationDateProperty()));
        
        //From Consultation Model
        consultationTimeColumn.setCellValueFactory(cellData -> cellData.getValue().consultation.consultationTimeProperty());
        SchemeAvailableColumn.setCellValueFactory(cellData -> cellData.getValue().consultation.schemeAvailableProperty());
        
        //TODO set to other controller
        //showPatientDetails(null);
        
       //patientTable.getSelectionModel().selectedItemProperty().addListener(
               // (observable, oldValue, newValue) -> showPatientDetails(newValue));
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
    
}