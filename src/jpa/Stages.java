/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import domein.Stage;
import domein.StageBegeleider;
import java.util.List;
import javafx.collections.ObservableList;
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
    
    public Stage getStage(int StageId)
    {
        emer.begin();
        EntityManager em = emer.getEm();
        Stage stage = em.find(Stage.class, StageId);
        
        emer.commit();
        emer.sluit();
        return stage;
    }
    
    public void addStages(Stage stage){
        emer.begin();
        EntityManager em = emer.getEm();
       
        
        em.persist(stage);
        
        emer.commit();
        emer.sluit();
    }
    
    public void changeStages(Stage stage)
    {
        emer.begin();
        EntityManager em = emer.getEm();
        Stage s = em.find(Stage.class, stage.getStagesId());
        s.setTitel(stage.getTitel());
        s.setOmschrijving(stage.getOmschrijving());
        s.setSpecialisatie(stage.getSpecialisatie());
        s.setAantalStudenten(stage.getAantalStudenten());
        s.setMentorNaam(stage.getMentorNaam());
        s.setStageStatus(stage.getStageStatus());
        s.setBeginPeriode(stage.getBeginPeriode());
        s.setEindPeriode(stage.getEindPeriode());
        s.setEffectieveBegeleider(stage.getEffectieveBegeleider());
        s.setEffectieveStudent(stage.getEffectieveStudent());
        emer.commit();
        emer.sluit();
    }
    
    
}
