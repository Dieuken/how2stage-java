/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import java.util.ArrayList;
import java.util.List;
import jpa.StageAdministrators;

/**
 *
 * @author Stef
 */
public class StageAdminCheck 
{
    public boolean Check(StageAdministrator stageadmin)
    {
        StageAdministrators db = new StageAdministrators();
        List<StageAdministrator> dbList = new ArrayList();
        dbList = db.alleStageAdmins();
        
        for(StageAdministrator s : dbList)
        {
            
            
            
            if(s.getLognaam().equals(stageadmin.getLognaam()) == true && s.getPasswoord().equals(stageadmin.getPasswoord()) == true)
            {
                System.out.println("log in juist");
                return true;
            }
            else
            {
                System.out.println("log in fout");
                return false;
            }
        }
        return false;
    }
}
