/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import hibernate.Dao;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import objetos.Admin;
import objetos.Funcionario;

/**
 *
 * @author andre
 */
public class FXMLDocumentController implements Initializable {
      
    @FXML
    private Label labelstatus;
    
    @FXML
    private JFXTextField user;
    
    @FXML
    private JFXPasswordField pass;

    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        String usuario = user.getText().trim();
        String Senha = pass.getText().trim();
        Dao d = new Dao();
        List<Funcionario> func = d.consultar(Funcionario.class, "username", usuario);
        List<Admin> admin = d.consultar(Admin.class, "username", usuario);
        if (func.isEmpty() && admin.isEmpty()){
            labelstatus.setText("Usuário Incorreto!");
        }else if(func.size()==1 && admin.isEmpty()){
            if (func.get(0).getSenha().trim().equals(Senha.trim())) {
                labelstatus.setText("func");
                Parent parent = FXMLLoader.load(getClass().getResource("tela_principal.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }else{
                labelstatus.setText("Senha Incorreta!");
            }
        }else if (func.isEmpty() && admin.size()==1) {
            if (admin.get(0).getSenha().trim().equals(Senha.trim())) {
                labelstatus.setText("admin");
            }else{
                labelstatus.setText("Senha Incorreta!");
            }   
        }else{
            labelstatus.setText("Redundancia no Banco de Dados!");
        }
         
    }
    @FXML    private void exitbuttonclick(MouseEvent event) {

        System.exit(0);
        
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Dao d = new Dao();
    }    
    
}
