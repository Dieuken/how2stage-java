/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package how2stage;

import domein.Hash;
import domein.StageAdminCheck;
import domein.StageAdministrator;
import domein.StagesToevoegen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import jpa.StageAdministrators;

/**
 *
 * @author Stef
 */
public class Root extends BorderPane 
{
    public TextField logon;
    public PasswordField pass;
    public Label lbluit;
    
    
    
    public Root(){
        
        /*StagesToevoegen stagetoevoegen = new StagesToevoegen();
        stagetoevoegen.Toevoegen();*/
        Label lbllogon = new Label("Logon");
        Label lblpass = new Label("Passwoord");
        lbluit = new Label();
        
        logon = new TextField();
        pass = new PasswordField();
       
        
        Button btn = new Button();
        btn.setText("Log In");
        btn.setDefaultButton(true);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                StageAdministrator stageadmin = new StageAdministrator();
                StageAdminCheck stageAdminCheck = new StageAdminCheck();
                
                Hash hash = new Hash();
               
                stageadmin.setLognaam(logon.getText().toLowerCase().trim());
                stageadmin.setPasswoord(hash.encrypt(pass.getText()));
                System.out.println(stageadmin.getPasswoord());
                
                if(stageAdminCheck.Check(stageadmin) == true)
                {
                   // Root.this.getScene().getWindow().setHeight(800);
                    //Root.this.getScene().getWindow().setWidth(800);
                    
                    PaneStageAdmin pane = new PaneStageAdmin();
                    Root.this.getScene().setRoot(pane);
                    pane.getScene().getWindow().sizeToScene();
                    pane.getScene().getWindow().centerOnScreen();
                    
                    
                    
                }
                else{
                    lbluit.setText("Gebruikersnaam of Paswoord onjuist");
                    
                }
                
                
                
            }
        });
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.add(lbllogon, 0, 0);
        grid.add(logon, 1, 0);
        grid.add(lblpass, 0, 1);
        grid.add(pass, 1, 1);
        grid.add(lbluit, 0, 2, 2, 1);
        grid.add(btn, 1, 3);
       
        
       
        this.setCenter(grid);
    }
    
}
