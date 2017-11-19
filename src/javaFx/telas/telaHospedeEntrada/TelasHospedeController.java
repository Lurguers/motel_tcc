/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.telas.telaHospedeEntrada;

import hibernate.Dao;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javax.lang.model.SourceVersion;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import objetos.Quarto;

/**
 *
 * @author Lurguers
 */
public class TelasHospedeController implements Initializable{
    @FXML
    private Button buttonQuarto01;
    @FXML
    private Label labelQuarto01;
    @FXML
    private Button buttonQuarto02;
    @FXML
    private Label labelQuarto02;
    @FXML
    private Label label;
    @FXML
    private Button buttonRecepcao;
    @FXML
    private Label labelQuartoMostrado;
    @FXML
    private ImageView quartoMostrado;
    @FXML
    private Label labelQuartoOcupado;
    
    public void StatusQuarto(int idQuarto, Button button, Label labeldoquarto){
        Dao d = new Dao();
        List<Quarto> quarto = d.consultar(Quarto.class, "id", idQuarto);
        switch (quarto.get(0).getStatusQuarto()) {
            case 1:
                //quarto livre
                button.setStyle("-fx-background-color: linear-gradient(#3bed3b, #11bb11, #3bed3b);");
                labeldoquarto.setText("0"+idQuarto);
                labeldoquarto.setFont( new Font("Verdana", 72) );
                break;
            case 2:
            case 3:
            case 4:
                //quarto ocupado
                button.setStyle("-fx-background-color: linear-gradient(#ed3b3b, #bb1111, #ed3b3b);");
                labeldoquarto.setText("Ocupado");
                labeldoquarto.setFont( new Font("Verdana", 24) );
                break;
        }
    }
    int i = 0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Timeline oneMinuteTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            StatusQuarto(1, buttonQuarto01, labelQuarto01);
            StatusQuarto(2, buttonQuarto02, labelQuarto02);
            i ++;
            if (i==5) {
                labelQuartoOcupado.setText("");
                if(labelQuartoMostrado.getText().equals("Quarto 01")){
                    labelQuartoMostrado.setText("Quarto 02");
                    Image img = new Image("/javaFx/telas/imagens/quarto02.jpg");
                    quartoMostrado.setImage(img);
                    i = 0;
                }else if(labelQuartoMostrado.getText().equals("Quarto 02")){
                    labelQuartoMostrado.setText("Quarto 01");
                    Image img = new Image("/javaFx/telas/imagens/quarto01.jpg");
                    quartoMostrado.setImage(img);
                    i = 0;
                }
            }
        }
    }));       
        oneMinuteTimeline.setCycleCount(Timeline.INDEFINITE); // Executar indefinidamente.
        oneMinuteTimeline.play();
    }
    @FXML
    public void buttonRecepcaoClick(ActionEvent event) throws MalformedURLException, LineUnavailableException, UnsupportedAudioFileException, IOException{
        URL oUrl = new URL("file:C:\\Users\\Lurguers\\Documents\\NetBeansProjects\\motel_tcc\\src\\javaFx\\telas\\imagens\\Sino.wav");
        Clip oClip = AudioSystem.getClip();
        AudioInputStream oStream = AudioSystem.getAudioInputStream(oUrl);
        oClip.open(oStream);
        oClip.loop(0);
    }
    @FXML
    public void buttonQuartoClicado01(ActionEvent event){
        ClicarQuarto(1, labelQuartoOcupado);
    }
    @FXML
    public void buttonQuartoClicado02(ActionEvent event){
        ClicarQuarto(2, labelQuartoOcupado);
    }
    public void ClicarQuarto(int idQuarto, Label labelQuartoOcupado){
        Dao d = new Dao();
        List<Quarto> quarto = d.consultar(Quarto.class, "id", idQuarto);
        switch(quarto.get(0).getStatusQuarto()){
            case 1:
                //abrir portao da frente
                //abrir portao da garagem do quarto
                //piscar luz da garagem
                //seta tempo de comeco do quarto
                labelQuartoOcupado.setText("");
                quarto.get(0).setStatusQuarto(2);
                quarto.get(0).setHoraHoraComeco(new Date());
                d.inserir(quarto.get(0));
                break;
            case 2:
            case 3:
            case 4:
                labelQuartoOcupado.setText("Quarto ocupado!");
                break;
        }
    }
    
}
