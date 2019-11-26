package dk.aau.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.BooleanProperty;;


public class Scheme {
	
	private final StringProperty dischargeSummary;
	private final StringProperty schemeGuide;
	private final BooleanProperty dataVerified;
	private final StringProperty dataAdded;
	
	private final Patient patient;
	private List<PRO> proList;
	private List<ExistingInfo> existingInformationList;
	
	
	

	
	public Scheme(Patient patient){
		this.dischargeSummary =  new SimpleStringProperty("Ikke udfyldt endnu");
		this.schemeGuide =  new SimpleStringProperty("Kig på spørgsmålene og besvar dem");
		this.dataVerified =  new SimpleBooleanProperty(false);
		this.dataAdded = new SimpleStringProperty("Ja");
		
		this.patient = patient;

	}
	
	public String getDischargeSummary() {
		return dischargeSummary.get();
	}
	
	public void setDischargeSummary(String dischargeSummary) {
		this.dischargeSummary.set(dischargeSummary);
	}

	public StringProperty DischargeSummaryProperty() {
		return dischargeSummary;
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
	 * @param proList the proList to set
	 */
	public void setProList(List<PRO> proList) {
		this.proList = proList;
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
		this.existingInformationList = existingInformationList;
	}


}
