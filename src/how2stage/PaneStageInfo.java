/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package how2stage;


import com.itextpdf.text.DocumentException;
import domein.WordDoc;
import domein.Email;
import domein.PDF;
import domein.Stage;
import domein.StageBegeleider;
import domein.Student;
import java.io.IOException;
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
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
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
    private Label academiejaar = new Label();
    private Label semester = new Label();
    private ListView<Student> student = new ListView<Student>();
    private ChoiceBox<StageBegeleider> begeleiders = new ChoiceBox<StageBegeleider>();
    private ChoiceBox<Student> studenten = new ChoiceBox<Student>();
                    
    private TextField beginperiode = new TextField();
    private TextField eindperiode = new TextField();
    public String emailadress = new String("Stefdieu2@gmail.com");
    private Stage stage;
    private List<Stage> stagelijst = new ArrayList();
    private int index;
    private ObservableList<Student> stud = FXCollections.observableArrayList();
    
    
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
        Label lblstudent = new Label("Student");
        Label lblstudenten = new Label("Mogelijke Studenten");
        Label lblbeginperiode = new Label("Begin Periode");
        Label lbleindperiode = new Label("Eind Periode");
        Label lblacademiejaar = new Label("AcademieJaar");
        Label lblsemester = new Label("Semester");
        
        
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
        grid.add(lblstudent, 0, 9);
        grid.add(student, 1, 9);
        grid.add(lblstudenten, 0, 10);
        grid.add(studenten, 1, 10);
        grid.add(lblbeginperiode, 0, 11);
        grid.add(beginperiode, 1, 11);
        grid.add(lbleindperiode, 0, 12);
        grid.add(eindperiode, 1, 12);
        grid.add(lblacademiejaar, 0, 13);
        grid.add(academiejaar, 1, 13);
        grid.add(lblsemester, 0, 14);
        grid.add(semester, 1 , 14);
        
        this.setCenter(grid);
        
        MenuBar mubMenuBar = new MenuBar();
        Menu menuNav = new Menu("Navigatie");
        MenuItem miVorige = new MenuItem("Vorige");
        miVorige.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Vorige();
            }
        });
        MenuItem miVolgende = new MenuItem("Volgende");
        miVolgende.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Volgende();
            }
        });
        menuNav.getItems().addAll(miVorige, miVolgende);
        
        
        Menu menuStage = new Menu("Stage");
        MenuItem miKeurGoed = new MenuItem("Keur Goed");
        miKeurGoed.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                KeurGoed();
            }
        });
        MenuItem miKeurAf = new MenuItem("Keur Af");
        miKeurAf.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                KeurAf();
            }
        });
        menuStage.getItems().addAll(miKeurGoed, miKeurAf);
        
        
        Menu menuStudent = new Menu("Student");
        MenuItem miToevoegen = new MenuItem("Toevoegen");
        miToevoegen.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                 StudentToevoegen();
            }
        });
        MenuItem miVerwijder = new MenuItem("Verwijderen");
        miVerwijder.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                StudentVerwijder();
            }
        });
        menuStudent.getItems().addAll(miToevoegen, miVerwijder);
        
         Menu menuBestand = new Menu("Bestand");
         MenuItem miSave = new MenuItem("Save");
         miSave.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Save();
            }
        });
        MenuItem miDocument = new MenuItem("StageContract");
        miDocument.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                  MaakDocument();
            }
        });
        MenuItem miTerug = new MenuItem("Terug");
        miTerug.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Terug();
            }
        });
        menuBestand.getItems().addAll(miSave, miDocument, miTerug);
        mubMenuBar.getMenus().addAll(menuBestand, menuNav, menuStage, menuStudent);
        
        this.setTop(mubMenuBar);
        
        ToolBar toolbar = new ToolBar();
        
        
        Button btnVorige = new Button("Vorige");
        btnVorige.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Vorige();
               
            }
        });
        
        Button btnKeurGoed = new Button("Keur Goed");
        btnKeurGoed.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                KeurGoed();
            }
        });
        
        Button btnStudentverwijder = new Button("Student Verwijder");
        btnStudentverwijder.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               StudentVerwijder();
            }
        });
        
        Button btnDoc = new Button("WordDoc");
        btnDoc.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                MaakDocument();
            }
        });
        
        Button btnSave = new Button("Save");
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Save();
            }
        });
        
        Button btnStudentToevoegen = new Button("Student Toevoegen");
        btnStudentToevoegen.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                StudentToevoegen();
            }
        });
        
        Button btnWijsAf = new Button("Keur Af");
        btnWijsAf.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                KeurAf();
            }
        });
        
        Button btnVolgende = new Button("Volgende");
        btnVolgende.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Volgende();
            }
        });
        
        Button btnTerug = new Button("Terug");
        btnTerug.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                Terug();
                
            }
        });
        
        toolbar.getItems().addAll(btnVorige, btnKeurGoed, btnStudentverwijder, btnDoc, btnSave, btnStudentToevoegen, btnWijsAf, btnVolgende, btnTerug);
        
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
        
     
        
        titel.setText(stage.getTitel());
        omschrijving.setText(stage.getOmschrijving());
        specialisatie.setText(stage.getSpecialisatie());
        aantalStudenten.setText(Integer.toString(stage.getAantalStudenten()));
        mentorNaam.setText(stage.getMentorNaam());
        stageStatus.setText(stage.getStageStatus());
        bedrijfNaam.setText(stage.getB().getBedrijfNaam());
        beginperiode.setText(stage.getBeginPeriode());
        eindperiode.setText(stage.getEindPeriode());
        semester.setText(stage.getSemester());
        academiejaar.setText(stage.getAcademiejaar());
       if(stage.getEffectieveBegeleider() == null)
        {
            begeleider.setText("");
        }
        else{
            
            begeleider.setText(stage.getEffectieveBegeleider().getNaam());
        }
        List<StageBegeleider> stageblijst = stage.getMogelijkeBegeleiderLijst();
        ObservableList bos = FXCollections.observableList(stageblijst);
        begeleiders.setItems(bos);
        
        if(stage.getEffectieveStudent() == null || stage.getEffectieveStudent().size() > stage.getAantalStudenten())
        {
            
        }
        else{
            ObservableList esos = FXCollections.observableList(stage.getEffectieveStudent());
            student.setItems(esos);
        }
        List<Student> stagestudlijst = stage.getMogelijkeStudenten();
        ObservableList sos = FXCollections.observableList(stagestudlijst);
        studenten.setItems(sos);
        
        
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
    
    public void Vorige()
    {
         if(index >0){
            index--;
            stage = stagelijst.get(index);
            setUp();
        }
    }
    
    public void Volgende()
    {
        index++;
        if(stagelijst.size() > index){

            stage = stagelijst.get(index);
            System.out.println(stage.getStagesId());
            setUp();
        }
    }
    
    public void KeurGoed()
    {
        Email email = new Email();
        email.KeurGoed(emailadress, stage.getB().getBedrijfContact(), stage.getTitel(), stage.getAcademiejaar());

        stage.setStageStatus("Goed gekeurd");
        Stages stages = new Stages();
        stages.changeStages(stage);
        getStages();
    }
    
    public void KeurAf()
    {
        String rede = JOptionPane.showInputDialog("Zet Hier de rede voor het afkeuren" ); 
                Email email = new Email();
                email.KeurAf(emailadress, rede,  stage.getB().getBedrijfContact(), stage.getTitel(), stage.getAcademiejaar());
                
                stage.setStageStatus("Af gekeurd");
                Stages stages = new Stages();
                stages.changeStages(stage);
                getStages();
    }
    
    public void StudentToevoegen()
    {
        
        if(stud.size() == 0 || stud.size() < stage.getAantalStudenten()){

            stud.add(studenten.getSelectionModel().getSelectedItem());
            student.setItems(stud);
        }
                
    }
    
    public void StudentVerwijder()
    {
       int i = student.getSelectionModel().getSelectedIndex();
       stud.remove(i);
       student.setItems(stud);  
    }
    public void MaakDocument()
    {
        PDF pdf = new PDF();
        try{
        pdf.createPdf(stage);
        }catch (IOException e) {
	      e.printStackTrace();
	}catch (DocumentException d){
            d.printStackTrace();
        }
    }
    public void Save()
    {
        Stages s = new Stages();
                if(begeleiders.getSelectionModel().getSelectedItem() !=null)
                {
                    stage.setEffectieveBegeleider(begeleiders.getSelectionModel().getSelectedItem());
                }
                
                stage.setBeginPeriode(beginperiode.getText());
                stage.setEindPeriode(eindperiode.getText());
                List<Student> studentlijst = stage.getEffectieveStudent();
                
                for(Student student : stud)
                {
                   
                    studentlijst.add(student);
                    stage.setEffectieveStudent(studentlijst);
                }
                s.changeStages(stage);
                getStages();
                setUp();
    }
    public void Terug()
    {
        PaneStageAdmin psa = new PaneStageAdmin();
        PaneStageInfo.this.getScene().setRoot(psa);
        psa.getScene().getWindow().sizeToScene();
    }
}
