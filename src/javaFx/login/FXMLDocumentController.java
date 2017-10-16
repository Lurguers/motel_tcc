/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.login;

import hibernate.Dao;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import objetos.Admin;
import objetos.Funcionario;

/**
 *
 * @author andre
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField user;

    @FXML
    private PasswordField pass;
    
    @FXML
    private Label labelstatus;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String usuario = user.getText().trim();
        String Senha = pass.getText().trim();
        Dao d = new Dao();
        List<Funcionario> func = d.consultar(Funcionario.class, "username", usuario);
        List<Admin> admin = d.consultar(Admin.class, "username", usuario);
        if (func.size()==0 && admin.size()==0){
            System.out.println("Usuário Incorreto!");
        }else if(func.size()==1 && admin.size()==0){
            if (func.get(0).getSenha().trim().equals(Senha.trim())) {
                System.out.println("func");
                JavaFXApplication1.launch();
            }else{
                System.out.println("Senha Incorreta!");
            }
        }else if (func.size()==0 && admin.size()==1) {
            if (admin.get(0).getSenha().trim().equals(Senha.trim())) {
                System.out.println("admin");
            }else{
                System.out.println("Senha Incorreta!");
            }   
        }else{
            System.out.println("Redundancia no Banco de Dados!");
        }
         
    }
    @FXML    private void exitbuttonclick(MouseEvent event) {

        System.exit(0);
        
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
