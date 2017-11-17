/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.telas.recibo;

import com.jfoenix.controls.JFXButton;
import hibernate.Dao;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import objetos.Funcionario;

/**
 *
 * @author Lurguers
 */
public class controllerRecibo implements Initializable{
    @FXML
    private JFXButton manutencaoButon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    @FXML    
    private void exitbuttonclick(MouseEvent event) {
        Stage stage = (Stage) ((Node)(event.getSource())).getScene().getWindow();
        stage.close();
    }
}
