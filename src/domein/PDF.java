/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import javafx.stage.DirectoryChooser;

import javafx.stage.FileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class PDF 
{
    /** Path to the resulting PDF file. */
    public String result = new String();
       
    

   
    public void createPdf(Stage stage)
	throws DocumentException, IOException {
        // step 1
        /*FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PDF FILES", "pdf", "pdf");
        fileChooser.getExtensionFilters().add(filter);
        result = fileChooser.showSaveDialog(null).toString();*/
        
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(null);
        String path = file.getPath();
        
        
        // step 2
        for(Student student : stage.getEffectieveStudent())
        {
        Document document = new Document(PageSize.A4, 36, 36, 54, 54);
        result = new String(path.toString() + "\\" + student.toString() + ".pdf");
        PdfWriter.getInstance(document, new FileOutputStream(result));
        
        
        // step 3
        document.open();
        // step 4

        document.add(new Paragraph("STAGEOVEREENKOMST",new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD)));
        document.add(new Paragraph("Tussen:",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(new Paragraph("1. " + stage.getB().getBedrijfNaam() + "gevestigd te " + stage.getB().getBedrijfAdress() + "\n" +
                                   "vertegenwoordigd door "+ stage.getB().getBedrijfContact()+" \n" +
                                   "\n" +
                                   "hierna genoemd de “stage-instelling”; \n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(new Paragraph("2.	De Hogeschool Gent, faculteit Bedrijf en Organisatie gevestigd in Valentin Vaerwyckweg 1 – 9000 Gent vertegenwoordigd door Anita Bernard, decaan\n" +
                                   "\n" +
                                   "hierna genoemd de “onderwijsinstelling”;",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(new Paragraph("3. " + student.toString() +" wonende te " + student.getAdress() + ",\n" +
                                   "ingeschreven in het derde modeltraject van de professionele bachelor toegepaste informatica\n" +
                                   "Geboortedatum: " + student.getGeboortedatum() + "\n" +
                                   "\n" +
                                   "hierna genoemd de “student”; \n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(new Paragraph("wordt overeengekomen wat volgt:\n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        Paragraph paragraph = new Paragraph("Artikel 1 Stageopdracht \n",new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD));
        paragraph.add(new Paragraph("De stage-instelling aanvaardt de student voor de uitvoering van de hierna bepaalde stage- opdracht in het kader van de opleiding aan de onderwijsinstelling tijdens het academiejaar 2014 -2015.\n" +
                                   "De stage-opdracht houdt in: zie taakomschrijving zoals vermeld in bijlage 1.\n" +
                                   "De stage-opdracht, de duur en de omvang van de stage dienen te worden gerespecteerd.  \n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));

        document.add(paragraph);
        paragraph = new Paragraph("Artikel 2 Stageplaats \n",new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD));
        paragraph.add(new Paragraph("De stage zal uitgevoerd worden op volgende plaats(en):\n" +
                                   stage.getB().getBedrijfAdress() + "\n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(paragraph);
        paragraph = new Paragraph("Artikel 3 Stageverantwoordelijken \n",new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD));
        paragraph.add(new Paragraph("Mevrouw Anneleen Bekkens werd door de onderwijsinstelling aangeduid als stagecoördinator. De stagecoördinator is belast met het organiseren van de stages. \n" +
"Daarnaast duidt de onderwijsinstelling mevrouw/de heer " + stage.getEffectieveBegeleider().getNaam() +  " (e- mailadres: " + stage.getEffectieveBegeleider().getEmail() + ") aan als stagebegeleider. De stagebegeleider is belast met de voorbereiding van de stage en het toezicht op, de pedagogische begeleiding van en de evaluatie van de student. Hij/Zij onderhoudt de contacten met de stagementor.\n" +
" \n" +
"\n" +
"De stage-instelling duidt de heer/mevrouw " + stage.getMentorNaam() + "\n" +
"aan als stagementor. De stagementor ondersteunt de student bij de uitvoering van de stage door middel van aanwijzingen, richtlijnen en feedback. Hij/zij houdt toezicht op het functioneren van de student en rapporteert hieromtrent aan de stagebegeleider. \n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(paragraph);
        paragraph = new Paragraph("Artikel 4 Stageperiode \n",new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD));
        paragraph.add(new Paragraph("De stageperiode loopt van " + stage.getBeginPeriode() + " tot " + stage.getEindPeriode() + ". Het uurrooster en de vrijgestelde dagen zijn bepaald in bijlage 3 van de overeenkomst. \n" +
"De student zal zich stipt aan de overeengekomen regeling houden. De regeling kan in onderling overleg gewijzigd worden, op voorwaarde dat de wijzigingen schriftelijk worden vastgelegd en door de partijen ondertekend. \n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(paragraph);
        paragraph = new Paragraph("Artikel 5 Afwezigheid \n",new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD));
        paragraph.add(new Paragraph("De student stelt de stage- en onderwijsinstelling onmiddellijk in kennis in geval van afwezigheid tijdens de stage. Elke afwezigheid waarvan geen kennis wordt gegeven, wordt door de stage-instelling aan de onderwijsinstelling gemeld. \n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(paragraph);
        paragraph = new Paragraph("Artikel 6 Juridisch statuut van de student \n",new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD));
        paragraph.add(new Paragraph("Juridisch blijft de student onderworpen aan het statuut van de onderwijsinstelling. Tussen de student en de stage-instelling bestaat er geen arbeidsovereenkomst.\n" +
"Dit heeft tot gevolg dat:\n" +
"\n" +
"-	De student geen aanspraak kan maken op enige bezoldiging of vergoeding door de stage-instelling omdat de stageovereenkomst niet valt onder de beroepsinlevingsovereenkomsten: dit is de stageovereenkomst waarbij de totale duur van de arbeidsprestaties bij eenzelfde stage-instelling de 60 dagen overschrijdt.\n" +
"-	De student niet onderworpen is aan de wetgeving op de sociale zekerheid, zodat de stage-instelling geen RSZ- bijdragen dient te betalen. De wetgeving op de beroepsziekten is wel van toepassing.\n" +
"-	De arbeidsongevallen (ongevallen tijdens de uitvoering van de stage- opdracht) ten laste zijn van de onderwijsinstelling en gedekt worden door de verzekeringspolis arbeidsongevallen stagiairs nr. 6.569.723, afgesloten bij Ethias Verzekering. De ongevallen op weg van en naar het werk (de stage-instelling) zijn gedekt door de hogeschoolpolis nr. 45.217.081, afgesloten bij Ethias Verzekering. \n" +
"De onderwijsinstelling en de student gaan de verbintenis aan af te zien van iedere eis tot schadevergoeding tegenover de stage-instelling, hetzij persoonlijk, hetzij door toedoen van hun verzekeraar, voor ongevallen waarvan de student in de stage-instelling of op de weg naar of van de stageplaats het slachtoffer zou worden.\n" +
"De burgerlijke aansprakelijkheid van de student is gedekt door de hogeschoolpolis nr. 45.217.081, afgesloten bij Ethias Verzekering, waarvan de onderwijsinstelling de kosten draagt.\n" +
" \n" +
"Deze verzekeringspolis voorziet volgende waarborgen:\n" +
"* lichamelijke schade: tot 12.500.000,00 EUR per schadegeval; \n" +
"* materiële schade: tot 2.500.000,00. EUR per schadegeval;\n" +
"* schade veroorzaakt aan ter gelegenheid van de stage door de stage-instelling toevertrouwde voorwerpen: dekking tot 75.000,00 EUR per schadegeval.\n" +
"In tegenstelling tot de andere studenten, heeft de student die valt onder de bepalingen betreffende de beroepsinlevingsovereenkomsten dezelfde aansprakelijkheid als de werknemer. Dit houdt in dat hij zelf verantwoordelijk is voor zijn zware fout, bedrog en zijn herhaaldelijk voorkomende lichte fout. \n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(paragraph);
        paragraph = new Paragraph("Artikel 7 Plichten van de stage-instelling \n",new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD));
        paragraph.add(new Paragraph("De stage-instelling geeft in bijlage een exemplaar van het arbeidsreglement alsook de nodige inlichtingen en voorlichting over de aard van de stage-opdracht, de eraan verbonden risico’s en de te nemen preventiemaatregelen.\n" +
"Tevens zal de stage-instelling verantwoordelijk zijn voor de uitvoering van de wetgeving op het vlak van de veiligheid, gezondheid en welzijn ten aanzien van de student en de nodige beschermingsmiddelen verschaffen, bepaald in titel VII, hoofdstuk II van de codex over het Welzijn op het Werk. \n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(paragraph);
        paragraph = new Paragraph("Artikel 8 Plichten van de student \n",new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD));
        paragraph.add(new Paragraph("De student aanvaardt zich te gedragen naar de bepalingen van het arbeidsreglement en naar de bepalingen op het gebied van veiligheid, hygiëne en inwendige orde van de stage-instelling.\n" +
"Bovendien verbindt de student er zich toe geen persoonlijke, vertrouwelijke noch geheime informatie waarvan hij in de uitoefening van zijn stage kennis heeft genomen, bekend te maken, en dit zowel gedurende de uitvoering van de stage als na het beëindigen ervan. Indien de student een eindwerk opmaakt waarbij gegevens worden gebruikt die door de stage- instelling worden verstrekt of tijdens de stage in of over de stage- instelling worden vergaard, zal de student het eindwerk voorafgaand aan de indiening voorleggen aan de stagementor zodat deze laatste als vertegenwoordiger van de stage-instelling zijn akkoord kan geven tot indiening van het eindwerk, dan wel een voorbehoud maken tot de openbaarmaking (indiening en openbare verdediging eindwerk, plaatsing kopij in de bibliotheek, verkorte inhoud op een bepaalde webstek) van bepaalde in het eindwerk opgenomen gegevens. In geval er een betwisting ontstaat tussen student en stagementor over het openbaar maken van bepaalde gegevens zal de stagebegeleider of stagecoördinator tussenkomen om tot een overeenkomst te komen tussen de drie partijen. \n" +
"Het auteursrecht en/of andere intellectuele eigendomsrechten worden zo nodig geregeld in een afzonderlijke en schriftelijke stageovereenkomst tussen de student en de stage-instelling.\n" +
"Indien de stage in het buitenland gerealiseerd wordt, verbindt de student zich ertoe dit onder een geldig (stage)visum te doen, conform de consulaire vereisten van het betreffende land. \n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(paragraph);
        paragraph = new Paragraph("Artikel 9 Opschorting of verbreking van de stageovereenkomst \n",new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD));
        paragraph.add(new Paragraph("De onderwijsinstelling kan op initiatief van de stagebegeleider of op vraag van de student de stageovereenkomst opschorten en desgevallend verbreken in volgende gevallen:\n" +
" \n" +
"	bij zware inbreuken van de stage-instelling tegen de stageovereenkomst;\n" +
"	in geval van deontologische fout, manifeste onbekwaamheid, wangedrag, slechte wil, opzettelijke overtreding van deze overeenkomst, alsook in geval van ongewettigde afwezigheid van de student; \n" +
"	wanneer de fysische of psychologische gezondheid van de student gevaar loopt.\n" +
"\n" +
"De stage-instelling beschikt – in bovenvermelde gevallen – over dezelfde verbrekingsmogelijkheden. Er zal steeds gestreefd worden naar een voorafgaande bespreking van de situatie met alle partijen. De verbreking van de overeenkomst door de stage-instelling of de onderwijsinstelling dient steeds te geschieden bij een gemotiveerd aangetekend schrijven aan de andere betrokken partijen. \n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(paragraph);
        paragraph = new Paragraph("Artikel 10 Gezondheidsbeoordeling en -toezicht \n",new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD));
        paragraph.add(new Paragraph("Wat betreft de gezondheidsbeoordeling en het gezondheidstoezicht op de student zijn het koninklijk besluit van 3 mei 1999 betreffende de bescherming van de jongeren op het werk en de koninklijk besluiten van 21 september 2004 en van 30 september 2005 betreffende de bescherming van de stagiairs van toepassing.\n" +
"\n" +
"Voorafgaand aan de stage zal de stage-instelling een risicoanalyse (bijlage 2) uitvoeren voor de activiteiten die de student zal uitoefenen. Deze risicoanalyse laat toe om alle mogelijke risico’s voor de veiligheid en voor de fysische en psychische gezondheid van de student in kaart te brengen. Uit de ingevulde risicoanalyse blijkt of er wel of geen gezondheidstoezicht nodig is en dat wordt opgenomen in bijlage 3 van de stageovereenkomst. Indien er gezondheidstoezicht nodig is, \n" +
"vertrouwt de stage-instelling de uitvoering van het gezondheidstoezicht toe aan de preventiedienst van de onderwijsinstelling, tenzij de stage-instelling ervoor kiest om het gezondheidstoezicht zelf te doen en dan ook de kosten zelf te betalen.\n" +
"Artikel 11 Stagereglement\n" +
"De decaan van de onderwijsinstelling, de vertegenwoordiger van de stage-instelling en de student verklaren het stagereglement (zie bijlage 4) te kennen en het te zullen naleven.\n" +
"\n" +
"Aldus opgemaakt in drievoud te …………op ……………………………. \n",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(new Paragraph("Voor de stage-instelling 		De student		           	Voor de onderwijsinstelling",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(new Paragraph("…………………………..	     …………………………	Anita Bernard, Decaan",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.newPage();
        document.add(new Paragraph("Bijlage 1: Taakomschrijving \n",new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD)));
        document.add(new Paragraph("Door de stagementor of de contactpersoon in de onderneming/instelling in te vullen. \n" +
"\n" +
"Globale opsomming van de taken die de stagiair zal moeten uitvoeren:",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(new Paragraph("……………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………"));
        document.add(new Paragraph("Onderneming/instelling:	\n" +
"Naam:	\n" +
"Functie:	\n" +
"Datum: 	",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(new Paragraph("Student:",new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.newPage();
        document.add(new Paragraph("Bijlage 2: Risicoanalyse", new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD)));
        document.add(new Paragraph("Deze checklist voor de risicoanalyse is een niet limitatieve lijst en kan verder aangevuld worden, afhankelijk van het risico en de aard van stage-instelling. Het staat de stage-instelling vrij om een andere checklist of methode te gebruiken voor het uitvoeren van de risicoanalyse, op voorwaarde dat de uitgevoerde risicoanalyse volledig is."
                + "\n"
                + "\n"
                + "\n"));
        PdfPTable pdfTable = new PdfPTable(1);
        pdfTable.addCell("STUDENT: IDENTIFICATIEGEGEVENS");
        pdfTable.addCell("Naam:                     Voornaam:	\n" +
"Korte omschrijving van de soort activiteit van de student \n");
        pdfTable.addCell("STAGE-INSTELLING: IDENTIFICATIEGEGEVENS");
        pdfTable.addCell("Benaming:	\n" +
"Adres:	\n");
        pdfTable.addCell("STAGE-INSTELLING:  WERKPOSTEN – WERKPLAATSEN");
        pdfTable.addCell("Korte omschrijving:\n" +
" \n" +
" \n" +
" \n" +
" \n" +
" ");
        pdfTable.addCell("STAGE-INSTELLING:	RISICO’S OP DE WERKPOST\n" +
"	GEVAARLIJKE STOFFEN / BIOLOGISCHE AGENTIA / RADIOACTIVITEIT");
        pdfTable.addCell("Komt de student in aanraking met gevaarlijke stoffen?	 JA	 NEE\n" +
"Komt de student in aanraking met biologische agentia?	 JA	 NEE\n" +
"Komt de student in aanraking met radioactieve stoffen?	 JA	 NEE");
        pdfTable.addCell("STAGE-INSTELLING:     RISICO’S OP DE WERKPOST\n" +
"	BEELDSCHERMWERK");
        pdfTable.addCell("Voert de student specifiek beeldschermwerk uit?	 JA	 NEE\n" +
"                   Zo ja, wat is de gemiddelde tijdsduur per dag in uren:	  uren	\n" +
"Is het werk voldoende (ergonomisch) aangepast voor de student?	 JA	 NEE");
        pdfTable.addCell("STAGE-INSTELLING:	RISICO’S OP DE WERKPOST\n" +
"	ANDERE SPECIFIEKE RISICO’S NIET OPGENOMEN IN DEZE CHECKLIST");
        pdfTable.addCell("Omschrijving risico"
                + "\n"
                + "\n"
                + "\n");
        pdfTable.addCell("Getroffen maatregel(en)"
                + "\n"
                + "\n"
                + "\n");
        pdfTable.addCell("OPGEMAAKT DOOR");
        pdfTable.addCell("Naam:	\n" +
"Datum:	\n" +
"Handtekening		\n" +
" \n" +
" \n" +
" \n" +
" \n"
        );
        document.add(pdfTable);
        document.newPage();
        document.add(new Paragraph("Bijlage 3: Analyse van de risico’s verbonden aan de stage", new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD)));
        document.add(new Paragraph("Uit de ingevulde risicoanalyse resulteert dat:\n" +
"\n" +
"een gezondheidstoezicht vereist is\n" +
"\n" +
"geen gezondheidstoezicht vereist is\n" +
"omdat er geen risico’s zijn of omdat het enige risico dat van beeldschermen is", new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(new Paragraph("Verplichte aanwezigheid van de student in de onderwijsinstelling:", new Font(Font.FontFamily.TIMES_ROMAN, 11,Font.BOLD)));
        document.add(new Paragraph("dd/mm/2015: stageterugkomdag en jobevent op campus Schoonmeersen in Gent.\n", new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(new Paragraph("Werkuren \n", new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD)));
        PdfPTable pdfweekTable = new PdfPTable(2);
        pdfweekTable.addCell("Dag");
        pdfweekTable.addCell("Uren");
        pdfweekTable.addCell("Maandag");
        pdfweekTable.addCell("");
        pdfweekTable.addCell("Dinsdag");
        pdfweekTable.addCell("");
        pdfweekTable.addCell("Woensdag");
        pdfweekTable.addCell("");
        pdfweekTable.addCell("Donderdag");
        pdfweekTable.addCell("");
        pdfweekTable.addCell("Vrijdag");
        pdfweekTable.addCell("");
        pdfweekTable.addCell("Zaterdag");
        pdfweekTable.addCell("");
        document.add(pdfweekTable);
        document.add(new Paragraph("Vrije dagen", new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD)));
        document.add(new Paragraph("	dinsdag 11 november 2014 (Wapenstilstand)\n" +
"	maandag 6 april 2015 (paasmaandag)\n" +
"	vrijdag 1 mei 2015 (Dag van de Arbeid)\n" +
"	donderdag 14 mei 2015 (Hemelvaart) \n" +
"	maandag 25 mei 2015 (Pinkstermaandag)\n" +
"\n" +
"Hogeschool Gent organiseert voor haar studenten de volgende activiteit waarvoor de student vrijgesteld wordt van stage-activiteiten indien hij deelneemt aan deze activiteit:\n" +
"dd/mm/2015 van xx u tot xx u - afstudeerbeurs in ICC Gent: vrijstelling van stage-activiteit vanaf 12u.\n" +
"\n" +
"\n" +
"Student: ……………………………………….", new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.newPage();
        document.add(new Paragraph("Bijlage 4: Stagereglement", new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD)));
        document.add(new Paragraph("Artikel 1", new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD)));
        document.add(new Paragraph("De student voert stipt de hem/haar opgedragen opdrachten uit onder leiding en toezicht van de stagementor. Bij betwistingen terzake is het oordeel van de stagebegeleider doorslaggevend. ", new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(new Paragraph("Artikel 2", new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD)));
        document.add(new Paragraph("1* De stage-instelling zal de student het nodige materiaal en materieel ter beschikking stellen en laten gebruiken in overeenstemming met de modaliteiten in onderhavig reglement.\n" +
"2* 	Indien het gebruik van bepaald materieel niet kan toegelaten worden, wordt dit vermeld in de stageovereenkomst.\n" +
"3*	De student is verplicht het hem in overeenstemming met dit artikel toevertrouwde materieel en ongebruikte materiaal in goede staat terug te geven. Hij is niet verantwoordelijk voor de beschadigingen of de slijtage toe te schrijven aan het regelmatig gebruik van het materieel.  Hij is evenmin verantwoordelijk voor het gebrekkig werk te wijten aan zijn onhandigheid of onervarenheid.  \n" +
"4*	De student zelf is persoonlijk verantwoordelijk voor de schade ontstaan uit zijn opzettelijk gestelde daad.  \n" +
"\n" +
"5*	De student is verplicht de stagementor en stagebegeleider onverwijld op de hoogte te brengen in geval van schade aan het materieel. De stagementor en stagebegeleider ondernemen de gepaste stappen in het kader van de verzekering. ", new Font(Font.FontFamily.TIMES_ROMAN, 11)));
        document.add(new Paragraph("Artikel 3"));
        document.add(new Paragraph("De student houdt een stagedagboek bij dat hij wekelijks laat nakijken door de stagementor en bij elk bezoek van de stagebegeleider."));
        document.add(new Paragraph("Artikel 4"));
        document.add(new Paragraph("De stage-instelling dient het algemeen toezicht van de stagebegeleider op het stageverloop toe te laten en hem op de overeengekomen wijze de voor de evaluatie van de student noodzakelijke informatie te verstrekken."));
        document.add(new Paragraph("Artikel 5"));
        document.add(new Paragraph("De decaan van de onderwijsinstelling dient onmiddellijk in kennis te worden gesteld van ongevallen overkomen aan of veroorzaakt door de student."));
        document.add(new Paragraph("Artikel 6"));
        document.add(new Paragraph("De decaan van de onderwijsinstelling kan, op eigen initiatief of op vraag van de stagebegeleider, de stageovereenkomst opschorten:\n" +
"1* bij zware inbreuken van de stage-instelling tegen het stagereglement;\n" +
"2* wanneer de fysieke of geestelijke gezondheid van de student gevaar loopt;\n" +
"3* wanneer de stage inefficiënt of onnuttig is.\n" +
"\n" +
"De decaan van de onderwijsinstelling beslist na de opschorting over het al dan niet verbreken van de stageovereenkomst."));
        document.add(new Paragraph("Artikel 7"));
        document.add(new Paragraph("Bij verbreking van de stageovereenkomst beslist de examencommissie op voorstel van de titularis stage van de onderwijsinstelling of men de al gelopen stage al dan niet geheel of gedeeltelijk in aanmerking zal nemen bij de beoordeling van de onderwijsactiviteiten en beraadslaging."));
        document.add(new Paragraph("Artikel 8"));
        document.add(new Paragraph("In geval van staking, overmacht en technische of economische werkloosheid dient de stage-instelling de student terug te sturen naar de hogeschool. Dit wordt onverwijld gemeld aan de decaan van de onderwijsinstelling."));
        document.add(new Paragraph("Artikel 9"));
        document.add(new Paragraph("De stage-instelling informeert de student, voor de ondertekening van de stageovereenkomst, over de eventuele kosten verbonden aan de stage."));
        
        // step 5
        document.close();
        
        }
    }
}
