package dk.aau.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class ExistingInfo extends Question{	
	private final StringProperty patientCommentText = new SimpleStringProperty("");
    private final StringProperty obtainedInfoText = new SimpleStringProperty("");
   
    private int schemeID;
    private int existingInfoID;
    
    
    
    /**
     * Constructor to initalize from database
     * @param id
     * @param question
     * @param patientComment
     * @param obtainedInfo
     * @param doctorNote
     * @param schemeID
     */
    public ExistingInfo(int id, String question, String patientComment, String obtainedInfo, String doctorNote, int schemeID){
    	super(question);
    	this.existingInfoID = id;
    	this.patientCommentText.set(patientComment);
    	this.obtainedInfoText.set(obtainedInfo);
    	super.setDoctorNote(doctorNote);
    	this.schemeID = schemeID;
    }
    
    
    public String getpatientCommentText() {
        return patientCommentText.get();
    }

    public void setPatientCommentText(String patientCommentText) {
        this.patientCommentText.set(patientCommentText);
    }
    
    public StringProperty patientCommentTextProperty() {
        return patientCommentText;
    }
    
    public String getobtainedInfoText() {
        return obtainedInfoText.get();
    }

    public void setobtainedInfoText(String obtainedInfoText) {
        this.obtainedInfoText.set(obtainedInfoText);
    }
    
    public StringProperty obtainedInfoTextProperty() {
        return obtainedInfoText;
    }

    public int getSchemeID(){
    	return schemeID;
    }
    
    public int getExistingInfoID(){
    	return existingInfoID;
    }
}
