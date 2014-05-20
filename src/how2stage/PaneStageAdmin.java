/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package how2stage;

import domein.Email;
import domein.PDF;
import domein.Stage;
import domein.StagesToevoegen;
import domein.Student;
import domein.WordDoc;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
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
        tblStages.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        TableColumn tbcStageId = new TableColumn();
        tbcStageId.setCellValueFactory(
                new PropertyValueFactory<Stage, String>("StageId"));
        tbcStageId.setVisible(false);
        TableColumn tbcTitel = new TableColumn("Titel");
        tbcTitel.setCellValueFactory(
                new PropertyValueFactory<Stage, String>("Titel"));
        TableColumn tbcStudenten = new TableColumn("studenten");
        tbcStudenten.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Stage, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Stage, String> s) {
                       
                        if (s.getValue().getEffectieveStudent().isEmpty()) {
                            
                            return new SimpleStringProperty("<Geen studenten>");
                        } else {
                            
                            String namen = new String();
                            for(Student student : s.getValue().getEffectieveStudent())
                            {
                                if(namen.isEmpty())
                                {
                                    namen = student.toString();
                                }
                                else
                                {
                                    namen = namen + ", " + student.toString();
                                }
                            }
                            
                            return new SimpleStringProperty(namen);
                        }
                    }
                });
        
        
        TableColumn tbcBegeleider = new TableColumn("Begeleider");
        tbcBegeleider.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Stage, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Stage, String> s) {
                       
                        if (s.getValue().getEffectieveBegeleider() == null) {
                            
                            return new SimpleStringProperty("<Geen begeleider>");
                        } else {
                            
                           
                            return new SimpleStringProperty(s.getValue().getEffectieveBegeleider().toString());
                        }
                    }
                });
        
        TableColumn tbcAantalStudenten = new TableColumn("Aantal Studenten");
        tbcAantalStudenten.setMinWidth(110);
        tbcAantalStudenten.setCellValueFactory(
                new PropertyValueFactory<Stage, Integer>("aantalStudenten"));
        
        TableColumn tbcStatus = new TableColumn("Status");
        tbcStatus.setMinWidth(110);
        tbcStatus.setCellValueFactory(
                new PropertyValueFactory<Stage, String>("stageStatus"));
        tblStages.getColumns().addAll(tbcStageId, tbcTitel, tbcAantalStudenten, tbcStudenten, tbcBegeleider, tbcStatus);
        
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
