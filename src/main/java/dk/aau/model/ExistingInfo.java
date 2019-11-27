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
	public final IntegerProperty existingInfoID;
	
	private StringProperty patientCommentText = new SimpleStringProperty("");
    private StringProperty obtainedInfoText = new SimpleStringProperty("");
    
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
    	obtainedInfoText= new SimpleStringProperty(obtainedInfo);
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

    private SimpleIntegerProperty makeID(){
    	return new SimpleIntegerProperty(ID++);
    }
}
