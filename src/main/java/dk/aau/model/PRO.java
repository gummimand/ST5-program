package dk.aau.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Pair;


public class PRO {
	
    private final ObjectProperty<Pair<String,String>> question1;
    private final StringProperty question2;
    private final StringProperty question3;

	
    /**
     * Constructor with inistialisations
     */
    public PRO() {
		question1 = new SimpleObjectProperty<Pair<String,String>>(new Pair<String,String>("Hvornår havde du sidst smerter?","I går"));
		question2 = new SimpleStringProperty("Hvor mange smerter havde du fra 1-10?");
		question3 = new SimpleStringProperty("Hvor mange cigaretter ryger du dagligt?");
		
	}
    
    
    /**
     * 
     * @param q1 first question
     * @param q2 second question
     * @param q3 third question
     */
    public PRO(String q1, String a1, String q2, String q3) {
    	question1 = new SimpleObjectProperty<Pair<String,String>>(new Pair<String,String>(q1,a1));
		question2 = new SimpleStringProperty(q2);
		question3 = new SimpleStringProperty(q3);
		
	}
	
	
	public Pair<String,String> getQuestion1() {
        return question1.get();
    }

    public void setQuestion1(String question) {
        this.question1.set(new Pair<String,String>(question,""));
    }
    
    public ObjectProperty<Pair<String,String>> question1Property() {
        return question1;
    }
    
    public String getQuestion2() {
        return question2.get();
    }

    public void setQuestion22(String question) {
        this.question2.set(question);
    }
    
    public StringProperty question2Property() {
        return question2;
    }
    
    public String getQuestion3() {
        return question3.get();
    }

    public void setQuestion3(String question) {
        this.question3.set(question);
    }
    
    public StringProperty question3Property() {
        return question3;
    }
    
    /**
     * Function updates answer to question 1
     * @param answer new answer to input
     */
    public void setAnswer1(String answer) {
        this.question1.set(new Pair<String,String>(question1.get().getKey(),answer));
    }

}
