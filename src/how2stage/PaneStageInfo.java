/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package how2stage;

import domein.WordDoc;
import domein.Email;
import domein.Stage;
import domein.StageBegeleider;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceBoxBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;
import jpa.Stages;

/**
 *
 * @author Shmoopsy
 */
public class PaneStageInfo extends BorderPane
{
    private Label titel = new Label();
    private Label omschrijving = new Label();
    private Label specialisatie = new Label();
    private Label aantalStudenten = new Label();
    private Label mentorNaam = new Label();
    private Label stageStatus = new Label();
    private Label bedrijfNaam = new Label();
    private Label begeleider = new Label();
    private ChoiceBox<StageBegeleider> begeleiders = new ChoiceBox<StageBegeleider>();
                    
    private TextField beginperiode = new TextField();
    private TextField eindperiode = new TextField();
    public String emailadress = new String("Stefdieu2@gmail.com");
    private Stage stage;
    private List<Stage> stagelijst = new ArrayList();
    private int index;
    
    
    public PaneStageInfo(Stage s)
    {
        stage = s;
        index = 0;
        
        
        getStages();
        getIndex();
        setUp();
        
        StageBegeleider sb;
        
        Label lbltitel = new Label("Titel");
        Label lblomschrijving = new Label("Omschrijving");
        Label lblspecialisatie = new Label("Specialisatie");
        Label lblaantalstudenten = new Label("Aantal Studenten");
        Label lblmentornaam = new Label("Mentor Naam");
        Label lblstagestatus = new Label("Stage Status");
        Label lblbedrijfnaam = new Label("Bedrijf Naam");
        Label lblbegeleider = new Label("Begeleider");
        Label lblbegeleiders = new Label("Mogelijke begeleiders");
        Label lblbeginperiode = new Label("Begin Periode");
        Label lbleindperiode = new Label("Eind Periode");
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.add(lbltitel, 0, 0);
        grid.add(titel, 1, 0);
        grid.add(lblomschrijving, 0, 1);
        grid.add(omschrijving, 1, 1);
        grid.add(lblspecialisatie, 0, 2);
        grid.add(specialisatie, 1, 2);
        grid.add(lblaantalstudenten, 0, 3);
        grid.add(aantalStudenten, 1, 3);
        grid.add(lblmentornaam, 0, 4);
        grid.add(mentorNaam, 1, 4);
        grid.add(lblstagestatus, 0, 5);
        grid.add(stageStatus, 1, 5);
        grid.add(lblbedrijfnaam, 0, 6);
        grid.add(bedrijfNaam, 1, 6);
        grid.add(lblbegeleider, 0, 7);
        grid.add(begeleider, 1, 7);
        grid.add(lblbegeleiders, 0, 8);
        grid.add(begeleiders, 1 , 8);
        grid.add(lblbeginperiode, 0, 9);
        grid.add(beginperiode, 1, 9);
        grid.add(lbleindperiode, 0, 10);
        grid.add(eindperiode, 1, 10);
        
        this.setCenter(grid);
        
        ToolBar toolbar = new ToolBar();
        
        Button btnVorige = new Button("Vorige");
        btnVorige.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                if(index >0){
                    index--;
                    stage = stagelijst.get(index);
                    setUp();
                }
            }
        });
        
        Button btnKeurGoed = new Button("Keur Goed");
        btnKeurGoed.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Email email = new Email();
                email.KeurGoed(emailadress);
                
                stage.setStageStatus("Goed gekeurd");
                Stages stages = new Stages();
                stages.changeStages(stage);
                getStages();
            }
        });
        
        Button btnDoc = new Button("WordDoc");
        btnDoc.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                WordDoc doc = new WordDoc();
                doc.Create(stage);
            }
        });
        
        Button btnSave = new Button("Save");
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Stages s = new Stages();
                stage.setEffectieveBegeleider(begeleiders.getSelectionModel().getSelectedItem());
                stage.setBeginPeriode(beginperiode.getText());
                stage.setEindPeriode(eindperiode.getText());
                s.changeStages(stage);
                setUp();
            }
        });
        
        Button btnWijsAf = new Button("Keur Af");
        btnWijsAf.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String rede = JOptionPane.showInputDialog("Zet Hier de rede voor het afkeuren" ); 
                Email email = new Email();
                email.KeurAf(emailadress, rede);
                
                stage.setStageStatus("Af gekeurd");
                Stages stages = new Stages();
                stages.changeStages(stage);
                getStages();
            }
        });
        Button btnVolgende = new Button("Volgende");
        btnVolgende.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                index++;
                if(stagelijst.size() > index){
                    
                    stage = stagelijst.get(index);
                    System.out.println(stage.getStagesId());
                    setUp();
                }
            }
        });
        Button btnTerug = new Button("Terug");
        btnTerug.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                PaneStageAdmin psa = new PaneStageAdmin();
                PaneStageInfo.this.getScene().setRoot(psa);
                psa.getScene().getWindow().sizeToScene();
                
                
            }
        });
        
        toolbar.getItems().addAll(btnVorige, btnKeurGoed, btnDoc, btnSave, btnWijsAf, btnVolgende, btnTerug);
        
        this.setBottom(toolbar);
    }
    public void getStages()
    {
       Stages stages = new Stages();
       stagelijst = stages.alleStages();
    }
    
    public void setUp()
    {
     
        System.out.println(stage.getStagesId());
        
        String b;
        
        titel.setText(stage.getTitel());
        omschrijving.setText(stage.getOmschrijving());
        specialisatie.setText(stage.getSpecialisatie());
        aantalStudenten.setText(Integer.toString(stage.getAantalStudenten()));
        mentorNaam.setText(stage.getMentorNaam());
        stageStatus.setText(stage.getStageStatus());
        bedrijfNaam.setText(stage.getB().getBedrijfNaam());
        beginperiode.setText(stage.getBeginPeriode());
        eindperiode.setText(stage.getEindPeriode());
       if(stage.getEffectieveBegeleider() == null)
        {
            begeleider.setText("");
        }
        else{
            
            begeleider.setText(stage.getEffectieveBegeleider().getNaam());
        }
        List<StageBegeleider> stageblijst = stage.getMogelijkeBegeleiderLijst();
        ObservableList os = FXCollections.observableList(stageblijst);
        begeleiders.setItems(os);
            
        
    }
    public void getIndex()
    {
        for(Stage s: stagelijst)
        {
            if(s == stage)
            {
                index = stagelijst.indexOf(s);
                System.out.println(index);
            }
        }
    }
}
