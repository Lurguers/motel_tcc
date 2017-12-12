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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javaFx.telas.principal.principalController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import objetos.Arduino;
import objetos.Funcionario;
import objetos.MaskFieldUtil;
import objetos.Produto;
import objetos.Quarto;
import objetos.Recibo;

/**
 *
 * @author Lurguers
 */
public class controllerRecibo implements Initializable{
    
    Dao d;
     @FXML
    private Label numeroQuarto;

    @FXML
    private TableView<Produto> tableProduto;

    @FXML
    private TableColumn<Produto, String> colnomeprod;

    @FXML
    private TableColumn<Produto, Float> colvalprod;
    
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
    
    @FXML
    private JFXButton btnbuscar;
    
    @FXML
    private Label lblTotal;
    
    @FXML
    private JFXButton btnConfirmar;
    @FXML
    private JFXButton buttonPago;
    
    public static float valorHora;
    
    private Arduino arduino = new Arduino();
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonConfirmar.setVisible(true);
        buttonPago.setVisible(false);
        MaskFieldUtil.onlyDigitsValue(codigoPesquisaProduto);
        float valorTotal = principalController.tempoFinalSec * 0.018f;
        valorHora = valorTotal;
        valorprodutos = 0;
        valortotal = valorTotal;
        if (principalController.quartoClicadoRecibo.equals("um")) {
            //o quarto clicado foi o um
            numeroQuarto.setText("QUARTO 01");
            d = new Dao();
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
                    arduino.mandarDados(30);
                    arduino.mandarDados(301);
                    buttonMudarSatatusQuarto.setDisable(true);
                    tempoNoQuarto.setText(principalController.tempoFinal);
                    porHora.setText(String.format("R$%.2f", valorTotal));
                    lblTotal.setText(String.format("R$%.2f", valorTotal));
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
            d = new Dao();
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
                    arduino.mandarDados(40);
                    arduino.mandarDados(301);
                    buttonMudarSatatusQuarto.setDisable(true);
                    tempoNoQuarto.setText(principalController.tempoFinal);
                    porHora.setText(String.format("R$%.2f", valorTotal));
                    lblTotal.setText(String.format("R$%.2f", valorTotal));
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
        
        
        
        colvalprod.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getValorVenda()).asObject());
        colnomeprod.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
        produtos.clear();
        
        
    }
    
    public List<Produto> produtos = new ArrayList<Produto>();
    public static List<Produto> dataProdutos = new ArrayList<Produto>();
    private float valortotal;
    public static float valorprodutos;
    
    @FXML
    private void btnConfirmarClick(ActionEvent event) {
        List<Funcionario> funcionarioLogado = d.consultar(Funcionario.class, "logado", true);
        Date date = new Date();
        if (principalController.quartoClicadoRecibo.equals("um")) {
            List<Quarto> quarto = d.consultar(Quarto.class, "id", 1);
            Recibo r = new Recibo(funcionarioLogado.get(0).getNome(), quarto.get(0).getHoraHoraComeco(), date, 1, valortotal, produtosstr);
            r.setEmAndamento(true);
            d.inserir(r);
        }else if (principalController.quartoClicadoRecibo.equals("dois")) {
            List<Quarto> quarto = d.consultar(Quarto.class, "id", 2);
            Recibo r = new Recibo(funcionarioLogado.get(0).getNome(), quarto.get(0).getHoraHoraComeco(), date, 2, valortotal, produtosstr);
            r.setEmAndamento(true);
            d.inserir(r);
        }
        
        dataProdutos = produtos;
        codigoPesquisaProduto.setEditable(false);
        buttonConfirmar.setDisable(true);
        Timeline oneMinuteTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dao d = new Dao();
                List<Recibo> recibo  = d.consultar(Recibo.class, "confirmado", true);
                if (recibo.isEmpty()) {
                    buttonConfirmar.setVisible(true);
                    buttonPago.setVisible(false);
                }else{
                    buttonConfirmar.setVisible(false);
                    buttonPago.setVisible(true);
                }
                    
                        
            }
        }));    
        oneMinuteTimeline.setCycleCount(Timeline.INDEFINITE); // Executar indefinidamente.
        oneMinuteTimeline.play();
        
    }
    
    private String produtosstr = "";
    
    @FXML
    private void btnbuscarclick(ActionEvent event){
        List<Produto> result = d.consultar(Produto.class, "codigo", codigoPesquisaProduto.getText());
        
        if (result.isEmpty()){
            System.out.println("Busca Vazia");
        }else{            
            valortotal += result.get(0).getValorVenda();
            valorprodutos += result.get(0).getValorVenda();
            
            lblTotal.setText(String.format("R$%.2f", valortotal));
            produtos.add(result.get(0));
            produtosstr += result.get(0).getNome() + "; ";
            tableProduto.setItems(FXCollections.observableList(produtos));
            codigoPesquisaProduto.setText("");
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
    private void btnPagoClick(ActionEvent event){
        List<Recibo> recibo = d.consultar(Recibo.class, "confirmado", true);
        recibo.get(0).setConfirmado(false);
        d.inserir(recibo.get(0));
        int idquarto = recibo.get(0).getQuarto();
        if (idquarto == 1){
            arduino.mandarDados(70);
        }else{
            arduino.mandarDados(80);
        }
        arduino.mandarDados(401);
        List<Quarto> quarto = d.consultar(Quarto.class, "id", idquarto);
        quarto.get(0).setStatusQuarto(3);
        d.inserir(quarto.get(0));
        Stage stage = (Stage) ((Node)(event.getSource())).getScene().getWindow();
        stage.close();
    }
    @FXML    
    private void exitbuttonclick(MouseEvent event) {
        Stage stage = (Stage) ((Node)(event.getSource())).getScene().getWindow();
        stage.close();
    }
}
