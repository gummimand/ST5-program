package dk.aau.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Question {

	protected final StringProperty question;
    protected StringProperty doctorNote = new SimpleStringProperty("");
    
    public Question(String question) {
    	this.question = new SimpleStringProperty(question);
    	
	}

    
    
    
    public String getQuestion() {
        return question.get();
    }
    
    public StringProperty questionProperty() {
        return question;
    }
    
    public String getdoctorNote() {
        return doctorNote.get();
    }

    public void setDoctorNote(String doctorNote) {
        this.doctorNote.set(doctorNote);
    }
    
    public StringProperty doctorNoteProperty() {
        return doctorNote;
    }
}
