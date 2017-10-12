/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.login;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author andre
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Você clicou entrar");      
        
    }
    @FXML    private void exitbuttonclick(MouseEvent event) {

        System.exit(0);
        
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
