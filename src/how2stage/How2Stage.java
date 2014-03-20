/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package how2stage;

import domein.Hash;
import domein.StageAdministrator;
import java.awt.TextArea;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jpa.StageAdministrators;

/**
 *
 * @author Shmoopsy
 */
public class How2Stage extends Application {
    
    public TextField logon;
    public TextField pass;
    public TextField naam;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        Label lbllogon = new Label("logon");
        Label lblpass = new Label("passwoord");
        Label lblnaam = new Label("naam");
        
        
        logon = new TextField();
        pass = new TextField();
        naam = new TextField();
        
        Button btn = new Button();
        btn.setText("post");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                StageAdministrator stageadmin = new StageAdministrator();
                StageAdministrators stage = new StageAdministrators();
                
                stageadmin.setLognaam(logon.getText());
                stageadmin.setPasswoord(pass.getText());
                stageadmin.setNaam(naam.getText());
                
                
                
            }
        });
        
        GridPane grid = new GridPane();
        grid.setHgap(50);
        grid.setVgap(50);
        grid.add(lbllogon, 0, 0);
        grid.add(logon, 1, 0);
        grid.add(lblpass, 0, 1);
        grid.add(pass, 1, 1);
        grid.add(lblnaam, 0, 2);
        grid.add(naam, 1, 2);
        grid.add(btn, 0, 3);
        
        BorderPane root = new BorderPane();
        root.setCenter(grid);
       
        
        Scene scene = new Scene(root, 800, 800);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
