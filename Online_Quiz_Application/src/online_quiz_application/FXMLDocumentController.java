/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package online_quiz_application;

import java.net.URL;
import static java.time.Clock.system;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author LENOVO
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label adid;
    @FXML
    private Label ademail;
    @FXML
    private TextField adminemail;
    @FXML
    private PasswordField adminpass;
    @FXML
    private Button adminlogin;
    @FXML
    private TextField studentemail;
    @FXML
    private PasswordField studentpass;
    @FXML
    private Button studentlogin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginadmin(ActionEvent event) {
        String email=adminemail.getText();
        String password = adminpass.getText();
        System.out.println(email+"----->" + password);
        
        System.out.println("AdminLoginController.loginAdmin()");
    }

    @FXML
    private void loginstudent(ActionEvent event) {
        System.out.println("AdminLoginController.loginstudent()");
    }
    
}
