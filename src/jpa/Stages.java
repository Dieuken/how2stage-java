/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import domein.Stage;
import domein.StageAdministrator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Stages 
{
    private EMer emer = new EMer();
    
    public List<Stage> alleStages(){
        
        emer.begin();
        EntityManager em = emer.getEm();
        TypedQuery<Stage> queryFindAll = em.createNamedQuery("Stage.findAll", Stage.class);
        List<Stage> results = queryFindAll.getResultList();
        
        emer.commit();
        emer.sluit();
        
        return results;
        
    }
    
    public void addStages(Stage stage){
        emer.begin();
        EntityManager em = emer.getEm();
       
        
        em.persist(stage);
        
        emer.commit();
        emer.sluit();
    }
}
