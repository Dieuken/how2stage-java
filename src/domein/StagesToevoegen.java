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
        
        StageBegeleider stagebegeleider = new StageBegeleider("s.VanImpe", "Steven Van Impe", "1234");
        
        StageBegeleiders sb = new StageBegeleiders();
        sb.addStageBegeleider(stagebegeleider);
        
        
        List<Bedrijf> bedrijvenlist = bedrijven.alleBedrijven();
        bedrijf1 = bedrijvenlist.get(0);
        
        
        Stage s = new Stage("programmeur","Het maken en beheren van android applicaties voor het Bedrijf","android developing", e,"Jens Stoltenberg", "pending");
        Stage a = new Stage("programmeur","Het maken en beheren van ios applicaties voor het Bedrijf","ios developing", e,"Jens Stoltenberg", "pending");
        s.setB(bedrijf1);
        a.setB(bedrijf1);
        //s.setEffectieveStageBegeleider(stagebegeleider);
        
        Stages stages = new Stages();
        stages.addStages(s);
        stages.addStages(a);
        
        StageAdministrator sa = new StageAdministrator("stef dieu", "dieuken", "1234");
        StageAdministrators sas = new StageAdministrators();
        sas.addStageAdministrator(sa);
        
        
        
    }
    
}
