package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Quiz {
    private Integer quizId;
    private String title;

    public Quiz(String title) {
        this.title = title;
    }

    public Quiz() {}

    public Integer getQuizId() {
        return quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public static class MetaData{
        public static final String Table_Name = "quizs";  
        public static final String Quiz_Id = "quiz_id"; 
        public static final String Title = "title"; 
    }

    @Override
    public String toString() {
        return "Quiz{" + "quizId=" + quizId + ", title=" + title + '}';
    }

    // ✅ Create 'quiz' table
    public static void createTable() {
        try {
            String raw = "CREATE TABLE %s (" +
                           "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                           "%s VARCHAR(50))";
            String query = String.format(raw, MetaData.Table_Name ,
                    MetaData.Quiz_Id , MetaData.Title);
            
            System.out.println(query);

            String connectionUrl = "jdbc:sqlite:quiz_app";

            Class.forName("org.sqlite.JDBC");

            Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.execute();

            System.out.println("Table 'quiz' created successfully.");

            ps.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
