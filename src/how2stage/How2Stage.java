/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package how2stage;

import domein.Hash;
import domein.StageAdminCheck;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jpa.StageAdministrators;

/**
 *
 * @author Shmoopsy
 */
public class How2Stage extends Application {
    
    public TextField logon;
    public PasswordField pass;
    public Label lbluit;
    public Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        //BorderPane root = new BorderPane();
        Pane pane = new Pane();
        scene = new Scene(pane,800, 800);
        scene.setRoot(new Root(scene));
        /*Label lbllogon = new Label("logon");
        Label lblpass = new Label("passwoord");
        lbluit = new Label();
        
        
        logon = new TextField();
        pass = new PasswordField();
       
        
        Button btn = new Button();
        btn.setText("post");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                StageAdministrator stageadmin = new StageAdministrator();
                StageAdminCheck stageAdminCheck = new StageAdminCheck();
                Hash hash = new Hash();
                
                stageadmin.setLognaam(logon.getText());
                stageadmin.setPasswoord(hash.encrypt(pass.getText()));
                System.out.println(hash.encrypt(pass.getText()));
                if(stageAdminCheck.Check(stageadmin) == true)
                {
                    System.out.println("log in geslaagd");
                }
                else{
                    lbluit.setText("Gebruikersnaam of Paswoord onjuist");
                    
                }
                
                
                
            }
        });
        
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.add(lbllogon, 0, 0);
        grid.add(logon, 1, 0);
        grid.add(lblpass, 0, 1);
        grid.add(pass, 1, 1);
        grid.add(lbluit, 1, 2);
        grid.add(btn, 1, 3);
       
        
       
        root.setCenter(grid);
       */
        
        
        
        primaryStage.setTitle("How2Stage");
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
