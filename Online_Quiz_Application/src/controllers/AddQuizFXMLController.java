package controllers;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

public class AddQuizFXMLController implements Initializable {

    @FXML
    private TextField quizTitle;
    @FXML
    private Button setQuizTitleButton;
    @FXML
    private TextField questions;
    @FXML
    private TextField option1;
    @FXML
    private TextField option2;
    @FXML
    private TextField option3;
    @FXML
    private TextField option4;
    @FXML
    private RadioButton radioOption1;
    @FXML
    private RadioButton radioOption2;
    @FXML
    private RadioButton radioOption3;
    @FXML
    private RadioButton radioOption4;
    @FXML
    private Button addNextQuestion;
    @FXML
    private Button submitQuiz;

    private ToggleGroup radioGroup;

    // Variables
    private String title = null;
    private HashMap<String, String[]> questionsMap = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupRadioButtons();
    }

    private void setupRadioButtons() {
        radioGroup = new ToggleGroup();
        radioOption1.setToggleGroup(radioGroup);
        radioOption2.setToggleGroup(radioGroup);
        radioOption3.setToggleGroup(radioGroup);
        radioOption4.setToggleGroup(radioGroup);
    }

    @FXML
    private void setQuizTitle(ActionEvent event) {
        String inputTitle = quizTitle.getText().trim();

        if (inputTitle.isEmpty()) {
            Notifications.create()
                .title("Quiz Title")
                .position(Pos.TOP_RIGHT)
                .darkStyle()
                .hideAfter(Duration.seconds(2))
                .text("Please enter a valid quiz title.")
                .showError();
        } else {
            this.title = inputTitle;
            quizTitle.setEditable(false);
            System.out.println("Quiz Title Saved: " + title);
        }
    }

    private boolean validateFields() {
        if (questions.getText().trim().isEmpty() ||
            option1.getText().trim().isEmpty() ||
            option2.getText().trim().isEmpty() ||
            option3.getText().trim().isEmpty() ||
            option4.getText().trim().isEmpty()) {

            Notifications.create()
                .title("Validation Error")
                .position(Pos.CENTER)
                .darkStyle()
                .text("All fields are required!\n[Question, Option1, Option2, Option3, Option4]")
                .showError();
            return false;
        }

        if (radioGroup.getSelectedToggle() == null) {
            Notifications.create()
                .title("Validation Error")
                .position(Pos.CENTER)
                .darkStyle()
                .text("Please select the correct answer.")
                .showError();
            return false;
        }

        return true;
    }

    @FXML
    private void addNextQuestion(ActionEvent event) {
        if (validateFields()) {
            String[] data = new String[5];
            data[0] = option1.getText().trim();
            data[1] = option2.getText().trim();
            data[2] = option3.getText().trim();
            data[3] = option4.getText().trim();

            Toggle selected = radioGroup.getSelectedToggle();

            if (selected == radioOption1) {
                data[4] = option1.getText().trim();
            } else if (selected == radioOption2) {
                data[4] = option2.getText().trim();
            } else if (selected == radioOption3) {
                data[4] = option3.getText().trim();
            } else if (selected == radioOption4) {
                data[4] = option4.getText().trim();
            }

            String questionText = questions.getText().trim();
            questionsMap.put(questionText, data);

            System.out.println("Question Added:");
            System.out.println("Q: " + questionText);
            for (int i = 0; i < 4; i++) {
                System.out.println("Option " + (i + 1) + ": " + data[i]);
            }
            System.out.println("Correct Answer: " + data[4]);
            System.out.println("-----------------------------------");

            clearFields();
        }
    }

    private void clearFields() {
        questions.clear();
        option1.clear();
        option2.clear();
        option3.clear();
        option4.clear();
        radioGroup.selectToggle(null);
    }

    @FXML
    private void submitQuiz(ActionEvent event) {
        if (title == null || title.isEmpty()) {
            Notifications.create()
                .title("Quiz Title")
                .position(Pos.CENTER)
                .darkStyle()
                .text("Please set the Quiz Title before submitting.")
                .showError();
            return;
        }

        if (questionsMap.isEmpty()) {
            Notifications.create()
                .title("Quiz")
                .position(Pos.CENTER)
                .darkStyle()
                .text("No questions added! Please add at least one question.")
                .showError();
            return;
        }

        System.out.println("------ Submitting Quiz ------");
        System.out.println("Quiz Title: " + title);
        System.out.println("Total Questions: " + questionsMap.size());
        System.out.println("-----------------------------------");

        for (String q : questionsMap.keySet()) {
            String[] options = questionsMap.get(q);
            System.out.println("Q: " + q);
            for (int i = 0; i < 4; i++) {
                System.out.println("Option " + (i + 1) + ": " + options[i]);
            }
            System.out.println("Correct Answer: " + options[4]);
            System.out.println("-----------------------------------");
        }

        Notifications.create()
            .title("Quiz Submitted")
            .position(Pos.TOP_CENTER)
            .darkStyle()
            .hideAfter(Duration.seconds(3))
            .text("Quiz submitted successfully!\nQuestions saved: " + questionsMap.size())
            .showInformation();

        resetForm();
    }

    private void resetForm() {
        title = null;
        quizTitle.setEditable(true);
        quizTitle.clear();

        questionsMap.clear();
        clearFields();

        System.out.println("Quiz form reset completed.");
    }
}
