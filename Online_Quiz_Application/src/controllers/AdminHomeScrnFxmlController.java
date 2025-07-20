/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AdminHomeScrnFxmlController implements Initializable {

    @FXML
    private TabPane AdminTabPane;
    @FXML
    private Tab AddQuizTAb;
    @FXML
    private Tab AddStudentTab;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
            Parent node = FXMLLoader.load(getClass().getResource("/fxml/AddQuizFXML.fxml"));
        AddQuizTAb.setContent(node);
        
        Parent studentTabNode = FXMLLoader.load(getClass().getResource("/fxml/AdminStudentTabFXML.fxml"));
        AddStudentTab.setContent(studentTabNode);
        }
        catch(Exception e){
            e.printStackTrace();   
        }
        
    }    
    
}
