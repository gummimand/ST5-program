package dk.aau;


import java.io.IOException;
import java.text.Format;
import java.util.List;
import java.util.stream.Collectors;

import Database.DatabaseController;
import dk.aau.model.*;
import dk.aau.model.handlers.ConsultationHandler;
import dk.aau.model.handlers.DoctorHandler;
import dk.aau.model.handlers.ExistingInfoHandler;
import dk.aau.model.handlers.PROHandler;
import dk.aau.model.handlers.PatientHandler;
import dk.aau.model.handlers.SchemeHandler;
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
    
    //Lists to store objects from database.
    private List<Patient> pList;
    private List<Consultation> cList;
    private List<Scheme> sList;
    private List<PRO> proList;
    private List<ExistingInfo> eList;
    
    

    /**
     * Constructor
     */
    public MainApp() {
    	
    	//Get data from database and instantiate model
    	readFromDatabase();
    }
  
    /***
     * Method to read data from database and instantiate model.
     * Fills list with patients.
     */
    private void readFromDatabase() {
    	//Lists to use as reference for databaseobjects
    	
    	
    	
    	//load from database
    	pList = loadPatients();
    	cList = loadConsultations();
    	sList = loadSchemes();
    	proList = loadPROs();
    	eList = loadExistingInformations();
    	this.doctor = loadDoctor();
    	
    	//Make correct references
    	addProToScheme(sList, proList);
    	addExistingToScheme(sList,eList);
    	addPatientToScheme(sList,pList);
    	addSchemeToConsultationAndConsultationToPatient(sList, cList,pList);
    	
    	
    	//Add patients to global list in main
    	pList.forEach(e -> patientData.add(e));
    	
    	
		
	}

    /**
     * Load patients from database
     * @return list of loaded patients
     */
    public List<Patient> loadPatients(){
    	PatientHandler ph = new PatientHandler();
    	DatabaseController.ExecuteQueryWithResultSet(ph);
    	
    	return ph.getPatientlist();
    }
    /**
     * Load consultations from database
     * @return list of loaded consultations
     */
    public List<Consultation> loadConsultations(){
    	ConsultationHandler ch = new ConsultationHandler();
    	DatabaseController.ExecuteQueryWithResultSet(ch);
    	
    	return ch.getConsultationlist();
    }
    
    /**
     * Load schemes from database
     * @return list of loaded schemes
     */
    public List<Scheme> loadSchemes(){
    	SchemeHandler sh = new SchemeHandler();
    	DatabaseController.ExecuteQueryWithResultSet(sh);
    	
    	return sh.getSchemelist();   	
    }
    /**
     * Load pros from database
     * @return list of loaded pros
     */
    public List<PRO> loadPROs(){
    	PROHandler proH = new PROHandler();
    	DatabaseController.ExecuteQueryWithResultSet(proH);
    	
    	return proH.getPROlist();
    }
    
    /**
     * Load existing infos from database
     * @return list of loaded existing infos
     */
    public List<ExistingInfo> loadExistingInformations(){
    	ExistingInfoHandler eh = new ExistingInfoHandler();
    	DatabaseController.ExecuteQueryWithResultSet(eh);
    	
    	return eh.getExistingInfolist();
    }
    
    /**
     * Load doctor from database
     * @return loaded Doctor
     */
    public Doctor loadDoctor(){
    	DoctorHandler dh = new DoctorHandler();
    	DatabaseController.ExecuteQueryWithResultSet(dh);
    	
    	return dh.getDoctorlist().get(0);    	
    }
	

	/**
     * Algorithm/method that finds schemeID of each element in sList and searches proList for matches, and then adds matches to scheme.
     * @param sList Schemelist to fill with PROs
     * @param proList Prolist to find elements in to add to slist.
     */
	private void addProToScheme(List<Scheme> sList, List<PRO> proList) {
		
		 
		sList.forEach(s -> {
			int sID = s.getSchemeID();
			List<PRO> matchingElements = proList.stream().filter(pro -> pro.getSchemeID() == sID).collect(Collectors.toList());
			s.setProList(matchingElements);
		});		
		
	}
	/**
	 * Algorithm/method that finds schemeID of each element in sList and searches eList for matches, and then adds matches to scheme.
	 * @param sList Schemelist to fill with ExistingInfo objects
	 * @param eList List of existingInfo objects
	 */
	private void addExistingToScheme(List<Scheme> sList, List<ExistingInfo> eList){
		sList.forEach(s -> {
			int sID = s.getSchemeID();
			List<ExistingInfo> matchingElements = eList.stream().filter(e -> e.getSchemeID() == sID).collect(Collectors.toList());
			s.setExistingInformationList(matchingElements);
		});
	}
	/**
	 * Algorithm/method that finds cpr of linked patient of each element in sList and searches pList for matches, and then adds matches to scheme.
	 * @param sList Schemelist to fill with reference
	 * @param pList List of objects to search
	 */
	private void addPatientToScheme(List<Scheme> sList, List<Patient> pList) {
		sList.forEach(s -> {
			String cprToFind = s.getPatientCPR();
			Patient matchingP = pList.stream().filter(p -> p.getCprNr().equals(cprToFind)).findFirst().get();
			s.setPatient(matchingP);
		});
		
	}
	
	/**
	 * Algorithm/method that finds schemeID from consultation and searches sList for matches, and then adds match to consultation.
	 * @param cList consultationList to fill with reference
	 * @param sList Schemelist to find schemes in and find patient to set reference to consultation.
	 * @param pList List of objects to search
	 */
	private void addSchemeToConsultationAndConsultationToPatient(List<Scheme> sList, List<Consultation> cList, List<Patient> pList) {
		cList.forEach(c -> {
			int schemeIDtoFind= c.getSchemeID();
			Scheme matchingS = sList.stream().filter(s -> s.getSchemeID() == schemeIDtoFind).findFirst().get();
			c.setScheme(matchingS);
			matchingS.getPatient().setConsultation(c); //For the matched scheme, set consultation for the schemes patient
		});
		
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
            controller.setMainApp(this);
            controller.setConsultation(consultation);
            controller.setDoctor(doctor);
			
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
        	
            
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int uploadToDatabase(){
    	ExistingInfoHandler eh = new ExistingInfoHandler();
    	PatientHandler ph = new PatientHandler();
    	SchemeHandler sh = new SchemeHandler();
    	
    	int result = 1;
    	
    	for (int i = 0; i < eList.size(); i++) {
    		ExistingInfo e = eList.get(i);
    		//Upload each element individually
    		int returnedResult = DatabaseController.ExecuteUploadStatement(eh, e);
    		if (returnedResult == 0)
    			result = 0;
		} 
    	
    	for (int i = 0; i < pList.size(); i++) {
			Patient p = pList.get(i);
			int returnedResult = DatabaseController.ExecuteUploadStatement(ph, p);
    		if (returnedResult == 0)
    			result = 0;
		}
    	
    	for (int i = 0; i < sList.size(); i++) {
			Scheme s = sList.get(i);
			int returnedResult = DatabaseController.ExecuteUploadStatement(sh, s);
    		if (returnedResult == 0)
    			result = 0;
		}
    	
    	return result;
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