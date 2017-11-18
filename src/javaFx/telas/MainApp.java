/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.telas;

import hibernate.Dao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author andre
 */
public class MainApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent parentHospede = FXMLLoader.load(getClass().getClassLoader().getResource("javaFx/telas/telasHospede/TelaHospedeEntrada.fxml"));
        Stage stageHospede = new Stage();
        Scene sceneHospede = new Scene(parentHospede);
        stageHospede.setScene(sceneHospede);
        stageHospede.initStyle(StageStyle.UNDECORATED);
        stageHospede.show();
        stageHospede.setFullScreen(true);
        
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("javaFx/telas/loading/TelaLoadingFXML.fxml"));
        Scene scene = new Scene(parent);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
}