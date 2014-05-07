/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;


public class WordDoc 
{
    public void Create(Stage stage)
    {
        
       
        
        
        try {
              FileChooser fc = new FileChooser();
              
              File dir = new File("C:\\Users\\Stef\\Documents\\StageContracten");
              dir.mkdir();
              String naam = JOptionPane.showInputDialog("Geef de naam voor het document" ); ;
              naam = naam + ".txt";
              //File file = fc.showOpenDialog(stage);
	      File file = new File(dir, naam);
              
	      if (file.createNewFile()){
	        System.out.println("File is created!");
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                out.printf("Titel: " + stage.getTitel() + "%n" + "Omschrijving: " + stage.getOmschrijving() +"%n"+"Specialisatie: " + stage.getSpecialisatie());
                out.close();
	      }else{
	        System.out.println("File already exists.");
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true))); 
                out.printf("Titel: " + stage.getTitel() + "%n" + "Omschrijving: " + stage.getOmschrijving() +"%n"+"Specialisatie: " + stage.getSpecialisatie());
                out.close();
	      };
 
    	} catch (IOException e) {
	      e.printStackTrace();
	}
    }
}
