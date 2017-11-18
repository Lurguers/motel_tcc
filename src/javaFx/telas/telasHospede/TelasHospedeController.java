/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.telas.telasHospede;

import hibernate.Dao;
import java.net.URL;
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
import net.sf.ehcache.constructs.blocking.SelfPopulatingCache;
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
    
    public void StatusQuarto(int idQuarto, Button button, Label labeldoquarto){
        Dao d = new Dao();
        List<Quarto> quarto = d.consultar(Quarto.class, "id", idQuarto);
        switch (quarto.get(0).getStatusQuarto()) {
            case 1:
                //quarto livre
                button.setStyle("-fx-background-color: linear-gradient(#3bed3b, #11bb11, #3bed3b);");
                //button.setOnAction(@345c03cc);
                labeldoquarto.setText("0"+idQuarto);
                labeldoquarto.setFont( new Font("Verdana", 72) );
                break;
            case 2:
            case 3:
            case 4:
                //quarto ocupado
                button.setStyle("-fx-background-color: linear-gradient(#ed3b3b, #bb1111, #ed3b3b);");
                button.setOnAction(null);
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
                if(labelQuartoMostrado.getText().equals("Quarto 01")){
                    labelQuartoMostrado.setText("Quarto 02");
                    Image img = new Image("file:C:\\Users\\Lurguers\\Documents\\NetBeansProjects\\motel_tcc\\src\\javaFx\\telas\\imagens\\quarto02.jpg");
                    quartoMostrado.setImage(img);
                    i = 0;
                }else if(labelQuartoMostrado.getText().equals("Quarto 02")){
                    labelQuartoMostrado.setText("Quarto 01");
                    Image img = new Image("file:C:\\Users\\Lurguers\\Documents\\NetBeansProjects\\motel_tcc\\src\\javaFx\\telas\\imagens\\quarto01.jpg");
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
    public void buttonQuartoLivreClicado(ActionEvent event){
        //abrir portao da frente
        
        //abrir portao da garagem do quarto
        
        //piscar luz da garagem
        
        //seta tempo de comeco do quarto
        System.out.println("dae");
    }
    
}
