/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Sowrav Dey
 */
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setQuizTitle(ActionEvent event) {
    }

    @FXML
    private void addNextQuestion(ActionEvent event) {
    }

    @FXML
    private void submitQuiz(ActionEvent event) {
    }
    
}
