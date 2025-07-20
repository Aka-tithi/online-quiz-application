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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Sowrav Dey
 */
public class AdminStudentTabFXMLController implements Initializable {

    @FXML
    private AnchorPane fullAnchorPane;
    @FXML
    private SplitPane splitpan;
    @FXML
    private AnchorPane studentAnchorPane;
    @FXML
    private VBox fromContainer;
    @FXML
    private Label enterStudentDetails;
    @FXML
    private TextField fristName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField mobileNumber;
    @FXML
    private Label genderGroup;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private Button saveButton;
    @FXML
    private AnchorPane tableAnchorPane;
    @FXML
    private TableView<?> studentTable;
    @FXML
    private TableColumn<?, ?> studentIdColumn;
    @FXML
    private TableColumn<?, ?> fristNameColumn;
    @FXML
    private TableColumn<?, ?> lastNameColumn;
    @FXML
    private TableColumn<?, ?> emailColumn;
    @FXML
    private TableColumn<?, ?> passwordColumn;
    @FXML
    private TableColumn<?, ?> PhoneNumberColumn;
    @FXML
    private TableColumn<?, ?> genderColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveStudent(ActionEvent event) {
    }
    
}
