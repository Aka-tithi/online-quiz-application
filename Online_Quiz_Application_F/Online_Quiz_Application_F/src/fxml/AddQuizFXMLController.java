package fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import javafx.geometry.Pos;
import static javafx.geometry.Pos.CENTER;
import javafx.scene.control.Toggle;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioButtonSetup();  // Ensure the ToggleGroup is initialized
    }

    private void radioButtonSetup() {
        radioGroup = new ToggleGroup();
        radioOption1.setToggleGroup(radioGroup);
        radioOption2.setToggleGroup(radioGroup);
        radioOption3.setToggleGroup(radioGroup);
        radioOption4.setToggleGroup(radioGroup);
    }

    @FXML
    private void setQuizTitle(ActionEvent event) {
        System.out.println("controllers.AddQuizFXMLController.setQuizTitle()");
        String title = quizTitle.getText();
        if (title.trim().isEmpty()) {
            Notifications.create()
                .darkStyle()
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.millis(2000))
                .text("Enter valid Quiz Title")
                .title("Quiz Title").showError();
        } else {
            quizTitle.setEditable(false);
            System.err.println("Save Title.....");
        }
    }
    
    private boolean validateFields(){
        
        String ques = this.questions.getText();
        String op1 = this.option1.getText();
        String op2 = this.option2.getText();
        String op3 = this.option3.getText();
        String op4 = this.option4.getText();
        
        Toggle selectedRadio =  radioGroup.getSelectedToggle();
        System.out.println(selectedRadio);
                
                
        if(ques.trim().isEmpty()||
                op1.trim().isEmpty()||
                op2.trim().isEmpty()||
                op3.trim().isEmpty()||
                op4.trim().isEmpty()) {
            
            Notifications.create()
                .title("Questions").position(CENTER)
                .darkStyle().text("All Fields Are Required.....\n [Questions, Option1, Option2, Option3, Option4]")
                .showError();
            return false;
            
        }else{
            if(selectedRadio == null){
                
                Notifications.create()
                .title("Questions").position(CENTER)
                .darkStyle().text("Please Select A Answer.....")
                .showError();
                
               return false;
               
            }else{
                return true;
                //save Question and next
            }
    } 
}

    @FXML
    private void addNextQuestion(ActionEvent event) {
        boolean valid = validateFields();
            if(valid){
                //save
                System.out.println("Save Questions.....");
            }
        }

    @FXML
    private void submitQuiz(ActionEvent event) {
    }

}