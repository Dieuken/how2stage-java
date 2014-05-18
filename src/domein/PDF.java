/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import java.io.FileOutputStream;
import java.io.IOException;
 
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import javafx.stage.FileChooser;


public class PDF 
{
    /** Path to the resulting PDF file. */
    public String result = new String();
       
 
   
    public void createPdf()
	throws DocumentException, IOException {
        // step 1
        FileChooser fileChooser = new FileChooser();
        result = fileChooser.showSaveDialog(null).toString();
        
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(result));
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph("Hello World!"));
        // step 5
        document.close();
    }
}
