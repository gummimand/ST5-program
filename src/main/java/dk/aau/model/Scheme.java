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
	public final IntegerProperty schemeID;
	
	private final StringProperty journalNote;
	private final StringProperty schemeGuide;
	private final BooleanProperty dataVerified;
	private final StringProperty dataAdded;
	
	private final Patient patient;
	private final ObservableList<PRO> proList = FXCollections.observableArrayList(); 
	private final ObservableList<ExistingInfo> existingInformationList = FXCollections.observableArrayList(); 
	
	
	

	
	public Scheme(Patient patient){
		this(patient, "Ikke udfyldt endnu", "Kig på spørgsmålene og besvar dem", false, "Ja");

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
		ExistingInfo ex1 = new ExistingInfo("Årsag for henvisning til Reumatologisk Afdeling, og hvornår symptomerne startede", "Patient havde smerter i tibialis under gang");
		ExistingInfo ex2 = new ExistingInfo("Medicin patienten tager i øjeblikket", "Panodil, ipren, morfin");
		addToExistingInfoList(ex1);
		addToExistingInfoList(ex2);
	}

	private void addPROdummies() {
		PRO pro1 = new PRO("Er der rygsygdom, gigtsygdom, tarmsygdom eller psoreasis i din nærmeste familie?", "Ja min mor har det");
		PRO pro2 = new PRO("Gener i øjne (synsforstyrrelse, smerte, betændelse, røde øjne, tørhed)", "Nej ingen");
		addToProList(pro1);
		addToProList(pro2);
		
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
	public void setProList(ObservableList<PRO> proList) {
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
	public void setExistingInformationList(ObservableList<ExistingInfo> existingInformationList) {
		this.existingInformationList.clear();
		existingInformationList.forEach(e -> this.existingInformationList.add(e));
	}
	
	private void addToExistingInfoList(ExistingInfo ex) {
		existingInformationList.add(ex);
		
	}
	private SimpleIntegerProperty makeID(){
    	return new SimpleIntegerProperty(ID++);
    }


}
