/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import java.util.List;
import jpa.Bedrijven;
import jpa.StageAdministrators;
import jpa.StageBegeleiders;
import jpa.Stages;
import jpa.Studenten;

/**
 *
 * @author Stef
 */
public class StagesToevoegen {
    
    public void Toevoegen()
    {
        
        int e = 2;
        
        Bedrijf bedrijf1 = new Bedrijf("Google","Jens Stoltenberg","Etterbeeksesteenweg 176-180 1040 Brussel", "JensStoltenberg@Gmail.com", "auto, bus, trein" );
       
        
        Bedrijven bedrijven = new Bedrijven();
        bedrijven.addBedrijf(bedrijf1);
        
        StageBegeleider stagebegeleider1 = new StageBegeleider("Steven Van Impe", "S.VanImpe", "3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4");
        StageBegeleider stagebegeleider2 = new StageBegeleider("Martine Van Audenrode", "M.VanAudenrode", "3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4");
        StageBegeleider stagebegeleider3 = new StageBegeleider("Stefaan De Cock", "S.DeCock", "3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4");
        
        StageBegeleiders sb = new StageBegeleiders();
        sb.addStageBegeleider(stagebegeleider1);
        sb.addStageBegeleider(stagebegeleider2);
        sb.addStageBegeleider(stagebegeleider3);
        
        
        
        
        
        
        Stage s = new Stage("programmeur","Het maken en beheren van android applicaties voor het Bedrijf","android developing", e,"Jens Stoltenberg", "pending");
        Stage a = new Stage("programmeur","Het maken en beheren van ios applicaties voor het Bedrijf","ios developing", e,"Jens Stoltenberg", "pending");
        s.setB(bedrijf1);
        a.setB(bedrijf1);
        //s.setEffectieveStageBegeleider(stagebegeleider);
        
        Stages stages = new Stages();
        stages.addStages(s);
        stages.addStages(a);
        
        StageAdministrator sa = new StageAdministrator("stef dieu", "dieuken", "3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4");
        StageAdministrators sas = new StageAdministrators();
        sas.addStageAdministrator(sa);
        
        
        Student student = new Student("s.VanImpe", "Steven Van Impe", "1234");
        
        Studenten bs = new Studenten();
        bs.addStudent(student);
    }
    
}
