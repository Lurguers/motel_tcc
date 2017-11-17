/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.telas.recibo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import hibernate.Dao;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javaFx.telas.principal.principalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import objetos.Quarto;

/**
 *
 * @author Lurguers
 */
public class controllerRecibo implements Initializable{
    @FXML
    private Label numeroQuarto;
    @FXML
    private TableView<?> tableProdutos;
    @FXML
    private Label tempoNoQuarto;
    @FXML
    private JFXTextField codigoPesquisaProduto;
    @FXML
    private JFXButton buttonMudarSatatusQuarto;
    @FXML
    private JFXButton buttonConfirmar;
    @FXML
    private Label porHora;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (principalController.quartoClicadoRecibo.equals("um")) {
            //o quarto clicado foi o um
            numeroQuarto.setText("QUARTO 01");
            Dao d = new Dao();
            List<Quarto> quarto = d.consultar(Quarto.class, "id", 1);
            switch (quarto.get(0).getStatusQuarto()) {
                case 1: 
                    //quarto estava livre
                    codigoPesquisaProduto.setDisable(true);
                    buttonConfirmar.setDisable(true);
                    buttonMudarSatatusQuarto.setText("Manutenção");
                    break;
                case 2:
                    //quarto estava ocupado
                    buttonMudarSatatusQuarto.setDisable(true);
                    break;
                case 3:
                    //quarto estava em limpeza
                    codigoPesquisaProduto.setDisable(true);
                    buttonConfirmar.setDisable(true);
                    buttonMudarSatatusQuarto.setText("Livre");
                    break;
                case 4:
                    //quarto estava em manutenção
                    codigoPesquisaProduto.setDisable(true);
                    buttonConfirmar.setDisable(true);
                    buttonMudarSatatusQuarto.setText("Em Limpeza");
                    break;
            }
        }else if(principalController.quartoClicadoRecibo.equals("dois")){
            //o quarto clicado foi o dois
            numeroQuarto.setText("QUARTO 02");
            Dao d = new Dao();
            List<Quarto> quarto = d.consultar(Quarto.class, "id", 2);
            switch (quarto.get(0).getStatusQuarto()) {
                case 1: 
                    //quarto estava livre
                    codigoPesquisaProduto.setDisable(true);
                    buttonConfirmar.setDisable(true);
                    buttonMudarSatatusQuarto.setText("Manutenção");
                    break;
                case 2:
                    //quarto estava ocupado
                    buttonMudarSatatusQuarto.setDisable(true);
                    break;
                case 3:
                    //quarto estava em limpeza
                    codigoPesquisaProduto.setDisable(true);
                    buttonConfirmar.setDisable(true);
                    buttonMudarSatatusQuarto.setText("Livre");
                    break;
                case 4:
                    //quarto estava em manutenção
                    codigoPesquisaProduto.setDisable(true);
                    buttonConfirmar.setDisable(true);
                    buttonMudarSatatusQuarto.setText("Em Limpeza");
                    break;
            }
        }
    }
    @FXML
    private void alterarStatusQuarto(ActionEvent event){
        Dao d = new Dao();
        if (principalController.quartoClicadoRecibo.equals("um")) {
            List<Quarto> quarto = d.consultar(Quarto.class, "id", 1);
            switch (quarto.get(0).getStatusQuarto()) {
                case 1: 
                        //quarto estava livre
                        quarto.get(0).setStatusQuarto(4);
                        d.inserir(quarto.get(0));
                        break;
                case 3:
                        //quarto estava em limpeza
                        quarto.get(0).setStatusQuarto(1);
                        d.inserir(quarto.get(0));
                        break;
                case 4:
                        //quarto estava em manutenção
                        quarto.get(0).setStatusQuarto(3);
                        d.inserir(quarto.get(0));
                        break;
            } 
        }else if (principalController.quartoClicadoRecibo.equals("dois")) {
            List<Quarto> quarto = d.consultar(Quarto.class, "id", 2);
            switch (quarto.get(0).getStatusQuarto()) {
                case 1: 
                    //quarto estava livre
                    quarto.get(0).setStatusQuarto(4);
                    d.inserir(quarto.get(0));
                    break;
                case 3:
                    //quarto estava em limpeza
                    quarto.get(0).setStatusQuarto(1);
                    d.inserir(quarto.get(0));
                    break;
                case 4:
                    //quarto estava em manutenção
                    quarto.get(0).setStatusQuarto(3);
                    d.inserir(quarto.get(0));
                    break;
            } 
        }
    }
    @FXML    
    private void exitbuttonclick(MouseEvent event) {
        Stage stage = (Stage) ((Node)(event.getSource())).getScene().getWindow();
        stage.close();
    }
}
