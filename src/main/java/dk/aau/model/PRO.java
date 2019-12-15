package dk.aau.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Pair;


public class PRO extends Question{
		
    private StringProperty questionTextAnswer = new SimpleStringProperty("");
    private BooleanProperty questionBoolAnswer = new SimpleBooleanProperty(false);
    
    private int schemeID;
    private int proID;
	
    /**
     * Constructor for database init
     * @param id
     * @param question
     * @param textAnswer
     * @param schemeiD
     */
    public PRO(int id, String question, String textAnswer, String doctorNote, int schemeiD){
    	super(question);
    	this.proID = id;
    	this.questionTextAnswer = new SimpleStringProperty(textAnswer);
    	super.setDoctorNote(doctorNote);
    	this.schemeID = schemeiD;
    	
    }
    
    
    public String getquestionTextAnswer() {
        return questionTextAnswer.get();
    }

    public void setQuestionTextAnswer(String questionTextAnswer) {
        this.questionTextAnswer.set(questionTextAnswer);
    }
    
    public StringProperty questionTextAnswerProperty() {
        return questionTextAnswer;
    }
    
    public Boolean getquestionBoolAnswer() {
        return questionBoolAnswer.get();
    }

    public void setQuestionBoolAnswer(Boolean questionBoolAnswer) {
        this.questionBoolAnswer.set(questionBoolAnswer);
    }
    
    public BooleanProperty questionBoolAnswerProperty() {
        return questionBoolAnswer;
    }

    public int getSchemeID(){
    	return schemeID;
    }
    
    public int getProID(){
    	return proID;
    }
}
