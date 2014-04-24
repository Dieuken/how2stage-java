/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package how2stage;

import domein.Email;
import domein.Stage;
import domein.StagesToevoegen;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import jpa.Stages;


public class PaneStageAdmin extends BorderPane
{
    
    public TableView<Stage> tblStages = new TableView<Stage>();
    public String emailadress = new String("Stefdieu2@gmail.com");
    public PaneStageAdmin()
    {
        
        
        //Aanmaken van TableView en toevoegen van kolommen aan deze 
        
        tblStages.setEditable(false);
        
        
        
        TableColumn tbcStageId = new TableColumn();
        tbcStageId.setCellValueFactory(
                new PropertyValueFactory<Stage, String>("StageId"));
        tbcStageId.setVisible(false);
        TableColumn tbcTitel = new TableColumn("Titel");
        tbcTitel.setCellValueFactory(
                new PropertyValueFactory<Stage, String>("Titel"));
        TableColumn tbcOmschrijving = new TableColumn("Omschrijving");
        tbcOmschrijving.setMinWidth(110);
        tbcOmschrijving.setCellValueFactory(
                new PropertyValueFactory<Stage, String>("Omschrijving"));
        tbcOmschrijving.setMinWidth(200);
        TableColumn tbcSpecialisatie = new TableColumn("Specialisatie");
        tbcSpecialisatie.setMinWidth(110);
        tbcSpecialisatie.setCellValueFactory(
                new PropertyValueFactory<Stage, String>("Specialisatie"));
        TableColumn tbcAantalStudenten = new TableColumn("Aantal Studenten");
        tbcAantalStudenten.setMinWidth(110);
        tbcAantalStudenten.setCellValueFactory(
                new PropertyValueFactory<Stage, Integer>("aantalStudenten"));
        TableColumn tbcMentorNaam = new TableColumn("Mentor Naam");
        tbcMentorNaam.setMinWidth(110);
        tbcMentorNaam.setCellValueFactory(
                new PropertyValueFactory<Stage, String>("mentorNaam"));
        TableColumn tbcStatus = new TableColumn("Status");
        tbcStatus.setMinWidth(110);
        tbcStatus.setCellValueFactory(
                new PropertyValueFactory<Stage, String>("stageStatus"));
        tblStages.getColumns().addAll(tbcStageId, tbcTitel, tbcOmschrijving, tbcSpecialisatie, tbcAantalStudenten, tbcMentorNaam, tbcStatus);
        
        this.setCenter(tblStages);
        getStages();
        
        tblStages.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount()>1) {
                    Stage s = new Stage();
                    s = tblStages.getSelectionModel().getSelectedItem();
                    PaneStageInfo psi = new PaneStageInfo(s);
                    PaneStageAdmin.this.getScene().setRoot(psi);
                }
            }
            });
        
        
        
        //het aanmaken van een MenuBar met menus
        MenuBar mubMenuBar = new MenuBar();
        Menu menAccount = new Menu("Account");
        MenuItem muiLogOff = new MenuItem("Log off");
        
        muiLogOff.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Root root = new Root();
                PaneStageAdmin.this.getScene().setRoot(root);
                root.getScene().getWindow().sizeToScene();
                root.getScene().getWindow().centerOnScreen();
            }
        });
        
        menAccount.getItems().add(muiLogOff);
        mubMenuBar.getMenus().add(menAccount);
        
        this.setTop(mubMenuBar);
        
        //aanmaak van Toolbar Met buttons
        ToolBar toolbar = new ToolBar();
        Button btnKeurGoed = new Button("Keur Goed");
        btnKeurGoed.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Email email = new Email();
                email.KeurGoed(emailadress);
                Stage stage = (Stage)tblStages.getSelectionModel().getSelectedItem();
                stage.setStageStatus("Goed gekeurd");
                Stages stages = new Stages();
                stages.changeStages(stage);
                getStages();
            }
        });
        Button btnWijsAf = new Button("Keur Af");
        btnWijsAf.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String rede = JOptionPane.showInputDialog("Zet Hier de rede voor het afkeuren" ); 
                Email email = new Email();
                email.KeurAf(emailadress, rede);
                Stage stage = (Stage)tblStages.getSelectionModel().getSelectedItem();
                stage.setStageStatus("Af gekeurd");
                Stages stages = new Stages();
                stages.changeStages(stage);
                getStages();
            }
        });
        
        toolbar.getItems().addAll(btnKeurGoed, btnWijsAf);
        
        this.setBottom(toolbar);
    }
    public void getStages()
    {
        Stages stages = new Stages();
        List<Stage> s = new ArrayList();
        s = stages.alleStages();
        ObservableList os = FXCollections.observableList(s);
        tblStages.setItems(os);
    }
    
}
