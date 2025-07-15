/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package online_quiz_application;

import constant.AdminEmailPassword;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        // Initialization logic if needed
    }

    @FXML
    private void loginadmin(ActionEvent event) {
        String email = adminemail.getText();
        String password = adminpass.getText();

        if (email.trim().equalsIgnoreCase(AdminEmailPassword.email)
                && password.trim().equalsIgnoreCase(AdminEmailPassword.password)) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/AdminHomeScrnFxml.fxml"));
                Stage stage = (Stage) adminemail.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                System.out.println("Admin Login Success.");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        } else {
            System.out.println("Admin Login Failed.");
        }

        System.out.println(email + " -----> " + password);
        System.out.println("AdminLoginController.loginAdmin()");
    }

    @FXML
    private void loginstudent(ActionEvent event) {
        // Implement student login logic here or redirect
        System.out.println("AdminLoginController.loginstudent()");
    }
}
