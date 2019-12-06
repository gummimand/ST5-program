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
	private static int ID = 40;
	public final IntegerProperty proID;
	
    //private final ObjectProperty<Pair<String,String>> question1;
    private StringProperty questionTextAnswer = new SimpleStringProperty("");
    private BooleanProperty questionBoolAnswer = new SimpleBooleanProperty(false);
    
    private int schemeID;

	
    /**
     * Constructor for database init
     * @param id
     * @param question
     * @param textAnswer
     * @param schemeiD
     */
    public PRO(int id, String question, String textAnswer, int schemeiD){
    	super(question);
    	this.proID = new SimpleIntegerProperty(id);
    	this.questionTextAnswer = new SimpleStringProperty(textAnswer);
    	this.schemeID = schemeiD;
    }
    
    
    /**
     * Constructor with inistialisations
     * @param question question for superclass
     */
    public PRO(String question) {
    	super(question);
    	this.proID = makeID();
    			
	}
    
    
    /**
     * 
     * @param question question for superclass
     * @param answer answer for question
     */
    public PRO(String question, String answer) {
    	super(question);
    	questionTextAnswer= new SimpleStringProperty(answer);
    	this.proID = makeID();
    	
		
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

    private SimpleIntegerProperty makeID(){
    	return new SimpleIntegerProperty(ID++);
    }
    public int getSchemeID(){
    	return schemeID;
    }
}
