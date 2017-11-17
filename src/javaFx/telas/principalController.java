/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.telas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import hibernate.Dao;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import objetos.Funcionario;
import objetos.MaskFieldUtil;
import objetos.Produto;
import objetos.Quarto;

/**
 *
 * @author Lurguers
 */
public class principalController implements Initializable {
    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnCadProd;
    @FXML
    private JFXButton btnConsProd;
    @FXML
    private JFXButton btnCadFunc;
    @FXML
    private Pane consulProd;
    @FXML
    private Pane cadprodu;
    @FXML
    private JFXButton btnCad;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private Label notCod;
    @FXML
    private Label notNome;
    @FXML
    private Label notQtdEstoq;
    @FXML
    private Label notPrecoCompra;
    @FXML
    private Label notPrecoVenda;
    @FXML
    private Label notDesc;
    @FXML
    private Label notUni;
    @FXML
    private Label Notificacao;
    @FXML
    private JFXTextField cod;
    @FXML
    private JFXTextField nome;
    @FXML
    private JFXTextField qtdEstoq;
    @FXML
    private JFXTextField precoCompra;
    @FXML
    private JFXTextField precoVenda;
    @FXML
    private JFXTextField desc;
    @FXML
    private JFXTextField unid;
    @FXML
    private Pane quartos;
    @FXML
    private Label nomeLogado;
    @FXML
    private Pane cadFuncionario;
    @FXML
    private JFXTextField nomeFunc;
    @FXML
    private JFXTextField cpfFunc;
    @FXML
    private JFXTextField telFunc;
    @FXML
    private JFXTextField salarioFunc;
    @FXML
    private JFXTextField emailFunc;
    @FXML
    private JFXComboBox<Label> boxCargos;
    @FXML
    private JFXTextField userFunc;
    @FXML
    private JFXPasswordField senhaFunc;
    @FXML
    private JFXPasswordField confirmSenhaFunc;
    @FXML
    private JFXTextField cepFunc;
    @FXML
    private JFXTextField enderecoFunc;
    @FXML
    private JFXTextField cidFunc;
    @FXML
    private JFXTextField bairroFunc;
    @FXML
    private JFXTextField ufFunc;
    @FXML
    private JFXTextField descFunc;
    @FXML
    private JFXTextField numFunc;
    @FXML
    private JFXButton btnCadFuncionario;
    @FXML
    private JFXButton btnLimparFunc;
    @FXML
    private Label notnomeFunc;
    @FXML
    private Label notcpfFunc;
    @FXML
    private Label notTelFunc;
    @FXML
    private Label notSalFunc;
    @FXML
    private Label notUserFunc;
    @FXML
    private Label notSenhaFunc;
    @FXML
    private Label notSenhaFuncConfirmada;
    @FXML
    private Label notcepFunc;
    @FXML
    private Label notnumerocasaFunc;
    @FXML
    private Label Notificacao1;
    @FXML
    private Label NotificacaoSenhas;
    @FXML
    private ImageView statusPortaQuarto01;
    @FXML
    private ImageView statusPortaQuarto02;
    @FXML
    private Label horaAtual;
    @FXML
    private JFXButton um;
    @FXML
    private JFXButton dois;
    @FXML
    private ImageView statusLuz01;
    @FXML
    private ImageView statusPortaServico01;
    @FXML
    private ImageView statusPortao01;
    @FXML
    private ImageView statusLuz02;
    @FXML
    private ImageView statusPortaServico02;
    @FXML
    private ImageView statusPortao02;
    @FXML
    private Label tempoQuarto01;
    @FXML
    private Label tempoQuarto02;
    
    
    public void funcaoCorQuarto(int idQuarto, JFXButton button, Label tempoQuarto){
        Dao d = new Dao();
        List<Quarto> quarto = d.consultar(Quarto.class, "id", idQuarto);
        switch (quarto.get(0).getStatusQuarto()) {
            case 1:
                //quarto livre
                button.setStyle("-fx-background-color: green;");
                tempoQuarto.setText("");
                break;
            case 2:
                //quarto ocupado
                button.setStyle("-fx-background-color: #e52424;");
                tempoQuarto.setText("tempo quarto");
                break;
            case 3:
                //quarto em limpeza
                button.setStyle("-fx-background-color: yellow;");
                tempoQuarto.setText("");
                break;
            case 4:
                //quarto em manutemção
                button.setStyle("-fx-background-color: blue;");
                tempoQuarto.setText("");
                break;
        }
        
    }
    public void funcaoPortaQuarto(int idQuarto, ImageView imagem){
        Dao d = new Dao();
        List<Quarto> quarto = d.consultar(Quarto.class, "id", idQuarto);
        if (quarto.get(0).isStatusPortaQuarto() == true) {
            //porta quarto aberta
            Image img = new Image("file:C:\\Users\\Lurguers\\Documents\\NetBeansProjects\\motel_tcc\\src\\javaFx\\telas\\imagens\\icons8-door-opened-40.png");
            imagem.setImage(img);
        }else{
            //porta quarto fechada
            Image img = new Image("file:C:\\Users\\Lurguers\\Documents\\NetBeansProjects\\motel_tcc\\src\\javaFx\\telas\\imagens\\icons8-door-closed-40.png");
            imagem.setImage(img);
        }
    }
    public void funcaoPortaServiço(int idQuarto, ImageView imagem){
        Dao d = new Dao();
        List<Quarto> quarto = d.consultar(Quarto.class, "id", idQuarto);
        if (quarto.get(0).isStatusPortaServico()== true) {
            //porta serviço aberta
            Image img = new Image("file:C:\\Users\\Lurguers\\Documents\\NetBeansProjects\\motel_tcc\\src\\javaFx\\telas\\imagens\\icons8-door-opened-40.png");
            imagem.setImage(img);
        }else{
            //porta serviço fechada
            Image img = new Image("file:C:\\Users\\Lurguers\\Documents\\NetBeansProjects\\motel_tcc\\src\\javaFx\\telas\\imagens\\icons8-door-closed-40.png");
            imagem.setImage(img);
        }
    }
    public void funcaoPortao(int idQuarto, ImageView imagem){
        Dao d = new Dao();
        List<Quarto> quarto = d.consultar(Quarto.class, "id", idQuarto);
        if (quarto.get(0).isStatusGaragem()== true) {
            //portão aberta
            Image img = new Image("file:C:\\Users\\Lurguers\\Documents\\NetBeansProjects\\motel_tcc\\src\\javaFx\\telas\\imagens\\icons8-depot-40.png");
            imagem.setImage(img);
        }else{
            //portão fechada
            Image img = new Image("file:C:\\Users\\Lurguers\\Documents\\NetBeansProjects\\motel_tcc\\src\\javaFx\\telas\\imagens\\icons8-warehouse-40.png");
            imagem.setImage(img);
        }
    }
    public void funcaoLux(int idQuarto, ImageView imagem){
        Dao d = new Dao();
        List<Quarto> quarto = d.consultar(Quarto.class, "id", idQuarto);
        if (quarto.get(0).isStatusLuz()== true) {
            //luz acessa
            Image img = new Image("file:C:\\Users\\Lurguers\\Documents\\NetBeansProjects\\motel_tcc\\src\\javaFx\\telas\\imagens\\icons8-idea-40.png");
            imagem.setImage(img);
        }else{
            //luz apagada
            Image img = new Image("file:C:\\Users\\Lurguers\\Documents\\NetBeansProjects\\motel_tcc\\src\\javaFx\\telas\\imagens\\icons8-light-off-40.png");
            imagem.setImage(img);
        }
    }
    @FXML
    public void reciboQuarto01(ActionEvent event) throws IOException{
                Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("javaFx/telas/recibo/TelaRecibo.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
    }
    @FXML
    public void reciboQuarto02(ActionEvent event) throws IOException{
                Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("javaFx/telas/recibo/TelaRecibo.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    Timeline oneMinuteTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Calendar data = Calendar.getInstance();
            horaAtual.setText(data.getTime().toString());
            funcaoPortaQuarto(1, statusPortaQuarto01);
            funcaoPortaQuarto(2, statusPortaQuarto02);
            funcaoPortaServiço(1, statusPortaServico01);
            funcaoPortaServiço(2, statusPortaServico02);
            funcaoPortao(1, statusPortao01);
            funcaoPortao(2, statusPortao02);
            funcaoLux(1, statusLuz01);
            funcaoLux(2, statusLuz02);
            funcaoCorQuarto(1, um, tempoQuarto01);
            funcaoCorQuarto(2, dois, tempoQuarto02);
        }
    }));    
        oneMinuteTimeline.setCycleCount(Timeline.INDEFINITE); // Executar indefinidamente.
        oneMinuteTimeline.play();
        //seta o combobox de cargos do cadastro de funcionario
        boxCargos.getItems().add(new Label("Limpeza"));
        boxCargos.getItems().add(new Label("Controle"));
        boxCargos.getItems().add(new Label("Adiministrador"));
        boxCargos.getSelectionModel().select(1);
        //seta para home aparecer quando iniciar
        quartos.setVisible(true);
        cadprodu.setVisible(false);
        consulProd.setVisible(false);
        cadFuncionario.setVisible(false);
        //seta o nome do usuario logado na label
        Dao d = new Dao();
        List<Funcionario> funcionarioLogado = d.consultar(Funcionario.class, "logado", true);
        nomeLogado.setText("Bem vindo, "+funcionarioLogado.get(0).getNome()+".");
        //valida os campos do cadastro de produtos
        MaskFieldUtil.monetaryField(precoCompra);
        MaskFieldUtil.monetaryField(precoVenda);
        MaskFieldUtil.numericField(qtdEstoq);
        MaskFieldUtil.numericField(cod);
        //valida os campos do cadastro de funionarios
        MaskFieldUtil.cepField(cepFunc);
        MaskFieldUtil.cpfField(cpfFunc);
        MaskFieldUtil.foneField(telFunc);
        MaskFieldUtil.monetaryField(salarioFunc);
        MaskFieldUtil.onlyAlfaNumericValue(numFunc);
    }
    @FXML
    private void homeClick(ActionEvent event){
        quartos.setVisible(true);
        cadprodu.setVisible(false);
        consulProd.setVisible(false);
        cadFuncionario.setVisible(false);
    }
    @FXML
    private void cadProdClick(ActionEvent event){
        cadprodu.setVisible(true);
        quartos.setVisible(false);
        consulProd.setVisible(false);
        cadFuncionario.setVisible(false);
    }
    @FXML
    private void consultPrdoClick(ActionEvent event){
        consulProd.setVisible(true);
        quartos.setVisible(false);
        cadprodu.setVisible(false);
        cadFuncionario.setVisible(false);
    }
    @FXML
    public void cadFunciClick(ActionEvent event){
        consulProd.setVisible(false);
        quartos.setVisible(false);
        cadprodu.setVisible(false);
        cadFuncionario.setVisible(true);
    }
    @FXML    
    private void exitbuttonclick(MouseEvent event) {
        Dao d = new Dao();
        List<Funcionario> funcionarioLogado = d.consultar(Funcionario.class, "logado", true);
        funcionarioLogado.get(0).setLogado(false);
        d.inserir(funcionarioLogado.get(0));
        System.exit(0);//
        
    }
    @FXML
    private void cadButtonClick(ActionEvent event){
        if (cod.getText().isEmpty()) {
            notCod.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notCod.setText("");
        }
        
        if (nome.getText().isEmpty()){
            notNome.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notNome.setText("");
        }
        
        if (qtdEstoq.getText().isEmpty()){
            notQtdEstoq.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notQtdEstoq.setText("");
        }
        
        if (precoCompra.getText().isEmpty()){
            notPrecoCompra.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notPrecoCompra.setText("");
        }
        
        if (precoVenda.getText().isEmpty()){
            notPrecoVenda.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notPrecoVenda.setText("");
        }
        
        if (desc.getText().isEmpty()){
            notDesc.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notDesc.setText("");
        }
        
        if (unid.getText().isEmpty()){
            notUni.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notUni.setText("");
        }
        
        if (!(cod.getText().isEmpty() || nome.getText().isEmpty() ||qtdEstoq.getText().isEmpty() || precoCompra.getText().isEmpty() ||precoVenda.getText().isEmpty() || desc.getText().isEmpty()||unid.getText().isEmpty())) {
            try{
            String precocompra = precoCompra.getText();
            precocompra = precocompra.replace(".","");
            precocompra = precocompra.replace(",00","");
            precocompra = precocompra.replace(",",".");
            String precovenda = precoVenda.getText();
            precovenda = precovenda.replace(".","");
            precovenda = precovenda.replace(",00","");
            precovenda = precovenda.replace(",",".");
            Produto prod = new Produto(cod.getText(), nome.getText(), Integer.parseInt(qtdEstoq.getText()), Float.parseFloat(precocompra), Float.parseFloat(precovenda), desc.getText(), unid.getText());
            Dao dao = new Dao();
            dao.inserir(prod);
            JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!","Sucesso!",1);
            limpar(event);
            cod.focusedProperty();
            
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro! "+e, "Erro", 0);
            }
        }       
    }
    @FXML
    public void limpar(ActionEvent event){
        cod.setText("");
        nome.setText("");
        qtdEstoq.setText("");
        precoCompra.setText("");
        precoVenda.setText("");
        desc.setText("");
        unid.setText("");
        notCod.setText("");
        notNome.setText("");
        notQtdEstoq.setText("");
        notPrecoCompra.setText("");
        notPrecoVenda.setText("");
        notDesc.setText("");
        notUni.setText("");
        Notificacao.setText("");        
    }
    @FXML
    public void cadFuncClick(ActionEvent event){
        if (nomeFunc.getText().isEmpty()){
            notnomeFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notnomeFunc.setText("");
        }
        if (cpfFunc.getText().isEmpty()){
            notcpfFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notcpfFunc.setText("");
        }
        if (telFunc.getText().isEmpty()){
            notTelFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notTelFunc.setText("");
        }
        if (salarioFunc.getText().isEmpty()){
            notSalFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notSalFunc.setText("");
        }
        if (userFunc.getText().isEmpty()){
            notUserFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notUserFunc.setText("");
        }
        if (senhaFunc.getText().isEmpty()){
            notSenhaFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notSenhaFunc.setText("");
        }
        if (confirmSenhaFunc.getText().isEmpty()){
            notSenhaFuncConfirmada.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notSenhaFuncConfirmada.setText("");
        }
        if (cepFunc.getText().isEmpty()){
            notcepFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notcepFunc.setText("");
        }
        if (numFunc.getText().isEmpty()){
            notnumerocasaFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notnumerocasaFunc.setText("");
        }      
        if (!(nomeFunc.getText().isEmpty() || cpfFunc.getText().isEmpty() ||telFunc.getText().isEmpty() || salarioFunc.getText().isEmpty() ||userFunc.getText().isEmpty() || senhaFunc.getText().isEmpty()||confirmSenhaFunc.getText().isEmpty()||cepFunc.getText().isEmpty()|| numFunc.getText().isEmpty())){
            if (senhaFunc.getText().trim().equals(confirmSenhaFunc.getText().trim())) {
                try{
                String salariofuncionario = salarioFunc.getText();
                salariofuncionario = salariofuncionario.replace(".","");
                salariofuncionario = salariofuncionario.replace(",00","");
                salariofuncionario = salariofuncionario.replace(",",".");
                JOptionPane.showMessageDialog(null, salariofuncionario);
                Funcionario func = new Funcionario(nomeFunc.getText(),Float.parseFloat(salariofuncionario), emailFunc.getText(), telFunc.getText(), cpfFunc.getText(), userFunc.getText(), senhaFunc.getText(), cepFunc.getText(), enderecoFunc.getText(), bairroFunc.getText(), cidFunc.getText(), ufFunc.getText(), boxCargos.getSelectionModel().getSelectedIndex(), Integer.parseInt(numFunc.getText()), descFunc.getText());
                Dao dao = new Dao();
                dao.inserir(func);
                JOptionPane.showMessageDialog(null,"Funcionário cadastrado com sucesso!","Sucesso!",1);
                limparFunc(event);
                nomeFunc.focusedProperty();

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erro! "+e, "Erro", 0);
                }
            }else{
                NotificacaoSenhas.setText("Senhas não coincidem!");
            }
        }       
    }
    @FXML
    public void limparFunc(ActionEvent event){
        nomeFunc.setText("");
        cpfFunc.setText("");
        telFunc.setText("");        
        salarioFunc.setText("");
        emailFunc.setText("");
        boxCargos.getSelectionModel().select(1);
        userFunc.setText("");
        senhaFunc.setText("");
        confirmSenhaFunc.setText("");
        cepFunc.setText("");
        enderecoFunc.setText("");
        cidFunc.setText("");
        bairroFunc.setText("");
        ufFunc.setText("");
        descFunc.setText("");
        numFunc.setText("");
        notnomeFunc.setText("");
        notcpfFunc.setText("");
        notTelFunc.setText("");
        notSalFunc.setText("");
        notUserFunc.setText("");
        notSenhaFunc.setText("");
        notSenhaFuncConfirmada.setText("");
        notcepFunc.setText("");
        notnumerocasaFunc.setText("");
        Notificacao1.setText("");
        NotificacaoSenhas.setText("");              
    }
}