package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Question;
import models.Quiz;
import models.Student;

public class StartApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        createTable();  // Create quiz and question tables

        Parent root = FXMLLoader.load(getClass().getResource("/AdminLogin.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin Login");
        primaryStage.show();
    }

    private void createTable() {
        Quiz.createTable();
        Question.createTable();
        Student.createTable();
    }
}
