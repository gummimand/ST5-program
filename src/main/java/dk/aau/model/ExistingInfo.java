package dk.aau.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class ExistingInfo extends Question{
	private static int ID = 50;
	
	
	private final StringProperty patientCommentText = new SimpleStringProperty("");
    private final StringProperty obtainedInfoText = new SimpleStringProperty("");
   
    private int schemeID;
    private int existingInfoID;
    
    
    public ExistingInfo(int id, String question, String patientComment, String obtainedInfo, int schemeID){
    	super(question);
    	this.existingInfoID = id;
    	this.patientCommentText.set(patientComment);
    	this.obtainedInfoText.set(obtainedInfo);
    	this.schemeID = schemeID;
    }
    
    
    /**
     * Constructor with inistialisations
     * @param question question for superclass
     */
    public ExistingInfo(String question) {
    	super(question);
    	this.existingInfoID = makeID();
    			
	}
    
    
    /**
     *  Constructor with inistialisations
     * @param question question for superclass
     * @param answer obtained for question
     */
    public ExistingInfo(String question, String obtainedInfo) {
    	super(question);
    	obtainedInfoText.set(obtainedInfo);
    	this.existingInfoID = makeID();
    	
		
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

    private int makeID(){
    	return (ID++);
    }
    public int getSchemeID(){
    	return schemeID;
    }
    
    public int getExistingInfoID(){
    	return existingInfoID;
    }
}
