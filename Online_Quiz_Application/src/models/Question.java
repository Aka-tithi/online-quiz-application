package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.beans.property.*;

public class Question {

    private ObjectProperty<Quiz> quiz = new SimpleObjectProperty<>();
    private IntegerProperty questionId = new SimpleIntegerProperty();
    private StringProperty question = new SimpleStringProperty();
    private StringProperty option1 = new SimpleStringProperty();
    private StringProperty option2 = new SimpleStringProperty();
    private StringProperty option3 = new SimpleStringProperty();
    private StringProperty option4 = new SimpleStringProperty();
    private StringProperty answer = new SimpleStringProperty();
    
    public static class MetaData{
        public static final String Table_Name = "questions"; 
        public static final String Option1 = "option1"; 
        public static final String Option2 = "option2"; 
        public static final String Option3 = "option3"; 
        public static final String Option4 = "option4"; 
        public static final String Answer = "answer"; 
        public static final String Quiz_Id = "quiz_id"; 
    }


    public Question(Quiz quiz, int questionId, String question, String option1, String option2, String option3, String option4, String answer) {
        this.quiz.set(quiz);
        this.questionId.set(questionId);
        this.question.set(question);
        this.option1.set(option1);
        this.option2.set(option2);
        this.option3.set(option3);
        this.option4.set(option4);
        this.answer.set(answer);
    }

    public ObjectProperty<Quiz> quizProperty() {
        return quiz;
    }

    public Quiz getQuiz() {
        return quiz.get();
    }

    public void setQuiz(Quiz quiz) {
        this.quiz.set(quiz);
    }

    public IntegerProperty questionIdProperty() {
        return questionId;
    }

    public int getQuestionId() {
        return questionId.get();
    }

    public void setQuestionId(int questionId) {
        this.questionId.set(questionId);
    }

    public StringProperty questionProperty() {
        return question;
    }

    public String getQuestion() {
        return question.get();
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }

    public StringProperty option1Property() {
        return option1;
    }

    public String getOption1() {
        return option1.get();
    }

    public void setOption1(String option1) {
        this.option1.set(option1);
    }

    public StringProperty option2Property() {
        return option2;
    }

    public String getOption2() {
        return option2.get();
    }

    public void setOption2(String option2) {
        this.option2.set(option2);
    }

    public StringProperty option3Property() {
        return option3;
    }

    public String getOption3() {
        return option3.get();
    }

    public void setOption3(String option3) {
        this.option3.set(option3);
    }

    public StringProperty option4Property() {
        return option4;
    }

    public String getOption4() {
        return option4.get();
    }

    public void setOption4(String option4) {
        this.option4.set(option4);
    }

    public StringProperty answerProperty() {
        return answer;
    }

    public String getAnswer() {
        return answer.get();
    }

    public void setAnswer(String answer) {
        this.answer.set(answer);
    }

    // ✅ Create 'question' table
    public static void createTable() {
        
            String raw = "CREATE TABLE %s (" +
                           "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                           "%s VARCHAR(1000), " +
                           "%s VARCHAR(500), " +
                           "%s VARCHAR(500), " +
                           "%s VARCHAR(500), " +
                           "%s VARCHAR(500), " +
                           "%s VARCHAR(500), " +
                           "%s INTEGER, " +
                           "FOREIGN KEY (%s) REFERENCES %s (%s))";
            
            String query = String.format(raw, MetaData.Table_Name ,
                                                   MetaData.Option1 ,
                                                   MetaData.Option2 ,
                                                   MetaData.Option3 ,
                                                   MetaData.Option4 ,
                                                   MetaData.Answer ,
                                                   MetaData.Quiz_Id ,
                                                   MetaData.Quiz_Id ,
                                                   Quiz.MetaData.Table_Name ,
                                                   Quiz.MetaData.Quiz_Id);
            
            System.out.println(query);
            
            try {
            String connectionUrl = "jdbc:sqlite:quiz_app";

            Class.forName("org.sqlite.JDBC");

            Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.execute();

            System.out.println("Table 'question' created successfully.");

            ps.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}