/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package how2stage;

import domein.Hash;
import domein.StageAdminCheck;
import domein.StageAdministrator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private Scene root;
    
    
    public Root(Scene scene){
        Label lbllogon = new Label("logon");
        Label lblpass = new Label("passwoord");
        lbluit = new Label();
        root = scene;
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
               
                stageadmin.setLognaam(logon.getText().toLowerCase().trim());
                stageadmin.setPasswoord(hash.encrypt(pass.getText()));
                
                
                if(stageAdminCheck.Check(stageadmin) == true)
                {
                    root.setRoot(new PaneStageAdmin(root));
                    
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
        grid.add(lbluit, 0, 2);
        grid.add(btn, 1, 3);
       
        
       
        this.setCenter(grid);
    }
    
}
