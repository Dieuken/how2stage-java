/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import jpa.Stages;

/**
 *
 * @author Stef
 */
public class StagesToevoegen {
    
    public void Toevoegen()
    {
        int e = 2;
        Stage s = new Stage("programmeur","l<jfkù<kjfl<jljlkjij","android developing", e,"Mr. mcgoo", "pending");
        Stage t = new Stage("netwerker","","servers",0,"Mr. mcgoo","pending");
        Stage a = new Stage("programmeur","sdfghjkiuqzdjqdj","os develpment",1,"Mr. mcgoo", "pending");
        
        Stages stages = new Stages();
        stages.addStages(s);
        stages.addStages(t);
        stages.addStages(a);
    }
    
}
