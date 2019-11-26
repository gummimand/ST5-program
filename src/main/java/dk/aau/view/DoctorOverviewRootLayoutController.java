package dk.aau.view;

import dk.aau.MainApp;
import dk.aau.model.Doctor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DoctorOverviewRootLayoutController {
	@FXML
    private Label doctorNameLabel;
	private Doctor doctor;
	
    // Reference to the main application.
    private MainApp mainApp;
	
	
	public DoctorOverviewRootLayoutController() {
	}
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
	@FXML
    private void initialize() {
		
		//Initialize doctor
		showDoctorDetails(null);
    }
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
		showDoctorDetails(doctor);
	}
	
	private void showDoctorDetails(Doctor doctor) {
		if(doctor != null)
			doctorNameLabel.setText(doctor.getDoctorName());
		else
			doctorNameLabel.setText("");
	}
	
	
	
	
	

}
