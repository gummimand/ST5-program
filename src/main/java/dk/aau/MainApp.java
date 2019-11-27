package dk.aau;


import java.io.IOException;

import dk.aau.model.Consultation;
import dk.aau.model.Doctor;
import dk.aau.model.ExistingInfo;
import dk.aau.model.PRO;
import dk.aau.model.Patient;
import dk.aau.view.DoctorSchemeController;
import dk.aau.view.PatientInfoController;
import dk.aau.view.ConsultationListController;
import dk.aau.view.DoctorOverviewRootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * The data as an observable list of Patients.
     */
    private ObservableList<Patient> patientData = FXCollections.observableArrayList();
    private ConsultationListController consultationListcontroller;
    private Doctor doctor;

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        patientData.add(new Patient("Hans", "Muster"));
        patientData.add(new Patient("Ruth", "Mueller"));
        patientData.add(new Patient("Heinz", "Kurz"));
        patientData.add(new Patient("Cornelia", "Meier"));
        patientData.add(new Patient("Werner", "Meyer"));
        patientData.add(new Patient("Lydia", "Kunz"));
        patientData.add(new Patient("Anna", "Best"));
        patientData.add(new Patient("Stefan", "Meier"));
        patientData.add(new Patient("Martin", "Mueller"));
        
        doctor = new Doctor();
        
        // Test for patient specific questions
        patientData.get(0).getConsultation().getScheme().getProList().get(0).setQuestionTextAnswer(("Min farmor havde det også"));
        patientData.get(0).setAdress("Hans' Adresse");
        
        
        
        
        /*
        //Test for updating patient with existing info
        ExistingInfo exInfo = new ExistingInfo("Peter", "Petersen");
        
        patientData.filtered(p -> p.getFirstName().equals("Martin")).get(0).setFirstName(exInfo.getFirstName());
		patientData.filtered(p -> p.getFirstName().equals("Peter") && p.getLastName().equals("Mueller")).get(0)
				.setLastName(exInfo.getLastName());
        */
    }
  
    /**
     * Returns the data as an observable list of Patients. 
     * @return
     */
    public ObservableList<Patient> getPatientData() {
        return patientData;
    }
    

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("DoctorOverview");

        initRootLayout();
        showConsultationListView();
        showPatientInfoListView();
        showPendingListView();
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/DoctorOverviewRootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            // Give the controller access to the main app.
            DoctorOverviewRootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            controller.setDoctor(doctor);
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showConsultationListView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ConsultationListView.fxml"));
            AnchorPane ConsultationListView = (AnchorPane) loader.load();
            
            // Set person overview into the center of root layout.
            rootLayout.setLeft(ConsultationListView);
            
            // Give the controller access to the main app.
            ConsultationListController controller = loader.getController();
            controller.setMainApp(this);
            consultationListcontroller = controller;
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showPatientInfoListView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PatientInfoListView.fxml"));
            AnchorPane PatientInfoListView = (AnchorPane) loader.load();
            
            rootLayout.setCenter(PatientInfoListView);
            // Give the controller access to the main app.
            PatientInfoController controller = loader.getController();
            controller.setMainApp(this);
            controller.setConsultationListController(consultationListcontroller);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPendingListView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PendingListView.fxml"));
            AnchorPane PendingListView = (AnchorPane) loader.load();
            
            rootLayout.setBottom(PendingListView);
            
	         // Give the controller access to the main app.
            //DoctorOverviewController controller = loader.getController();
            //controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean showPatientOpenDialog(Consultation consultation) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/doctorSchemeScrollPane.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Open Patient");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the patient into the controller.
            
            DoctorSchemeController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setConsultation(consultation);
            controller.setDoctor(doctor);
			
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
        	
            //TODO change when ok is implemented
            return false;
            //return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}