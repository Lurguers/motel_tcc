/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.telas.telaHospedeSaida;

import hibernate.Dao;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javaFx.telas.principal.principalController;
import javaFx.telas.recibo.controllerRecibo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import objetos.Produto;
import objetos.Recibo;

/**
 *
 * @author Lurguers
 */
public class TelaHospedeSaidaController implements Initializable{
    @FXML
    private Pane pnlInfo;
    @FXML
    private Label lblvalorquarto;

    @FXML
    private Label lblvalortotal;

    @FXML
    private Label lblvalorprodutos;
    
    @FXML
    private TableView<Produto> tabelaProdutos;
    
    @FXML
    private TableColumn<Produto, String> colnomeprod;
    
    @FXML
    private TableColumn<Produto, Float> colvalprod;
    
    @FXML
    public Pane pnlDados;
    
    @FXML
    public Label lblnotificacao;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pnlDados.setVisible(false);
        pnlInfo.setVisible(true);
        
        
        colvalprod.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getValorVenda()).asObject());
        colnomeprod.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
        Timeline oneMinuteTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dao d = new Dao();
                List<Recibo> recibo  = d.consultar(Recibo.class, "emAndamento", true);
                if (recibo.isEmpty()) {
                    pnlDados.setVisible(false);
                    pnlInfo.setVisible(true);
                    lblvalorquarto.setText("");
                    lblvalorprodutos.setText("");
                    lblvalortotal.setText("");
                }else{
                    pnlDados.setVisible(true);
                    pnlInfo.setVisible(false);
                    tabelaProdutos.setItems(FXCollections.observableList(controllerRecibo.dataProdutos));
                    float valorTotal = controllerRecibo.valorHora;
                    lblvalorquarto.setText(String.format("R$%.2f", valorTotal));
                    lblvalorprodutos.setText(String.format("R$%.2f", controllerRecibo.valorprodutos));
                    float valortotalmesmo = valorTotal + controllerRecibo.valorprodutos;
                    lblvalortotal.setText(String.format("R$%.2f",valortotalmesmo));
                }
                        
            }
        }));    
        oneMinuteTimeline.setCycleCount(Timeline.INDEFINITE); // Executar indefinidamente.
        oneMinuteTimeline.play();
    }  
    @FXML
    private void confirmaCliente(ActionEvent event) throws InterruptedException{
        Dao d = new Dao();
        List<Recibo> recibo = d.consultar(Recibo.class, "emAndamento", true);
        recibo.get(0).setEmAndamento(false);
        recibo.get(0).setConfirmado(true);
        d.inserir(recibo.get(0));
        pnlDados.setVisible(false);
        pnlInfo.setVisible(true);
        lblnotificacao.setText("Aguarde o encerramento da Conta!");
    }
    
}
