/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package how2stage;

import domein.StagesToevoegen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;


public class PaneStageAdmin extends BorderPane
{
    public Scene root;
    
    public PaneStageAdmin(Scene scene)
    {
        
        root = scene;
        //Aanmaken van TableView en toevoegen van kolommen aan deze 
        TableView tblStages = new TableView();
        tblStages.setEditable(false);
        TableColumn tbcTitel = new TableColumn("Titel");
        TableColumn tbcOmschrijving = new TableColumn("Omschrijving");
        TableColumn tbcSpecialisatie = new TableColumn("Specialisatie");
        TableColumn tbcAantalStudenten = new TableColumn("Aantal Studenten");
        TableColumn tbcMentorNaam = new TableColumn("Mentor Naam");
        tblStages.getColumns().addAll(tbcTitel, tbcOmschrijving, tbcSpecialisatie, tbcAantalStudenten, tbcMentorNaam);
        
        this.setCenter(tblStages);
        
        //het aanmaken van een MenuBar met menus
        MenuBar mubMenuBar = new MenuBar();
        Menu menAccount = new Menu("Account");
        MenuItem muiLogOff = new MenuItem("Log off");
        
        muiLogOff.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                root.setRoot(new Root(root));
            }
        });
        
        menAccount.getItems().add(muiLogOff);
        mubMenuBar.getMenus().add(menAccount);
        
        this.setTop(mubMenuBar);
        
        //aanmaak van Toolbar Met buttons
        ToolBar toolbar = new ToolBar();
        Button btnAccept = new Button("Accepteer");
        Button btnDecline = new Button("Afwijzen");
        btnDecline.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
        Button btnStage = new Button("Stage Toevoegen");
        btnStage.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) 
            {
                StagesToevoegen s = new StagesToevoegen();
                s.Toevoegen();
            }
        });
        toolbar.getItems().addAll(btnAccept, btnDecline, btnStage);
        
        this.setBottom(toolbar);
    }
}
