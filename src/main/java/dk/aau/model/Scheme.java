package dk.aau.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;;


public class Scheme {
	private static int ID = 10;
	private final IntegerProperty schemeID;
	
	private final StringProperty journalNote;
	private final StringProperty schemeGuide;
	private final BooleanProperty dataVerified;
	private final StringProperty dataAdded;
	
	private Patient patient;
	private final ObservableList<PRO> proList = FXCollections.observableArrayList(); 
	private final ObservableList<ExistingInfo> existingInformationList = FXCollections.observableArrayList(); 
	
	private String patientCPR;
	
	/**
	 * Constructor for database intialize
	 * @param id
	 * @param jNote
	 * @param pCpr
	 */
	public Scheme(int id, String jNote, String pCpr){
		this.schemeID = new SimpleIntegerProperty(id);
		this.journalNote =  new SimpleStringProperty(jNote);
		this.patientCPR = pCpr;
		
		this.schemeGuide =  new SimpleStringProperty("Kig på spørgsmålene og besvar dem");
		this.dataVerified =  new SimpleBooleanProperty(false);
		this.dataAdded = new SimpleStringProperty("Ja");
		
		
		
	}
	
	public Scheme(Patient patient){
		this(patient, "Dummy fra model", "Dummy beskrivelse fra model", false, "Ja");

	}
	
	public Scheme(Patient patient, String journalNote, String schemeGuide, Boolean dataVerified, String dataAdded) {
		this.patient = patient;
		
		this.journalNote =  new SimpleStringProperty(journalNote);
		this.schemeGuide =  new SimpleStringProperty(schemeGuide);
		this.dataVerified =  new SimpleBooleanProperty(dataVerified);
		this.dataAdded = new SimpleStringProperty(dataAdded);
		
		this.schemeID = makeID();
		
		addPROdummies();
		addExistingInfoDummies();
		
		
	}
	
	private void addExistingInfoDummies() {
		ExistingInfo ex1 = new ExistingInfo("Dummy indhentet spørgsmål fra model", "dummy indhentet data fra model");
		ExistingInfo ex2 = new ExistingInfo("Dummy indhentet spørgsmål fra model 2", "dummy indhentet data fra model 2");
		addToExistingInfoList(ex1);
		addToExistingInfoList(ex2);
	}

	private void addPROdummies() {
		PRO pro1 = new PRO("Dummy PRO spørgsmål fra model", "dummy besvarelse fra model");
		PRO pro2 = new PRO("Dummy PRO spørgsmål fra model 2", "dummy besvarelse fra model 2");
		addToProList(pro1);
		addToProList(pro2);
		
	}

	public int getSchemeID() {
		return schemeID.get();
	}
	
	public IntegerProperty schemeIDProperty() {
		return schemeID;
	}
	
	public String getJournalNote() {
		return journalNote.get();
	}
	
	public void setJournalNote(String dischargeSummary) {
		this.journalNote.set(dischargeSummary);
	}

	public StringProperty journalNoteProperty() {
		return journalNote;
	}
	
	public String getschemeGuide() {
		return schemeGuide.get();
	}

	public StringProperty schemeGuideProperty() {
		return schemeGuide;
	}
	
	public Boolean getdataVerified() {
        return dataVerified.get();
    }

    public void setdataVerified(Boolean dataVerified) {
        this.dataVerified.set(dataVerified);
    }
    
    public BooleanProperty dataVerifiedProperty() {
        return dataVerified;
    }
	
	public String getDataAdded() {
        return dataAdded.get();
    }
	
	//TODO remove setter
    public void setDataAdded(String added) {
        this.dataAdded.set(added);
    }
    
    public StringProperty dataAddedProperty() {
        return dataAdded;
    }

	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient){
		this.patient = patient;
	}

	/**
	 * @return the proList
	 */
	public List<PRO> getProList() {
		return proList;
	}
	/** 
	 * Set an entire new list as the list of PRO's
	 * @param proList the proList to set
	 */
	public void setProList(List<PRO> proList) {
		this.proList.clear();
		proList.forEach(e -> this.proList.add(e));
		
	}
	/**
	 * Add PRO to pro list
	 * @param pro to add
	 */
	
	private void addToProList(PRO pro) {
		proList.add(pro);
	}

	/**
	 * @return the existingInformationList
	 */
	public List<ExistingInfo> getExistingInformationList() {
		return existingInformationList;
	}
	/**
	 * @param existingInformationList the existingInformationList to set
	 */
	public void setExistingInformationList(List<ExistingInfo> existingInformationList) {
		this.existingInformationList.clear();
		existingInformationList.forEach(e -> this.existingInformationList.add(e));
	}
	
	private void addToExistingInfoList(ExistingInfo ex) {
		existingInformationList.add(ex);
		
	}
	private SimpleIntegerProperty makeID(){
    	return new SimpleIntegerProperty(ID++);
    }
	
	public String getPatientCPR(){
		return patientCPR;
	}


}
