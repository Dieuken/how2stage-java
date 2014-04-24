/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;


import domein.StageBegeleider;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Shmoopsy
 */
public class StageBegeleiders {
    private EMer emer = new EMer();
    
    public List<StageBegeleider> alleBedrijven(){
        
        emer.begin();
        EntityManager em = emer.getEm();
        TypedQuery<StageBegeleider> queryFindAll = em.createNamedQuery("StageBegeleider.findAll", StageBegeleider.class);
        List<StageBegeleider> results = queryFindAll.getResultList();
        
        emer.commit();
        emer.sluit();
        
        return results;
        
    }
    
    public StageBegeleider getStageBegeleider(int StageBegeleiderId)
    {
        emer.begin();
        EntityManager em = emer.getEm();
        StageBegeleider stageBegeleider = em.find(StageBegeleider.class, StageBegeleiderId);
        
        emer.commit();
        emer.sluit();
        return stageBegeleider;
    }
    
    public void addStageBegeleider(StageBegeleider stageBegeleider){
        emer.begin();
        EntityManager em = emer.getEm();
       
        
        em.persist(stageBegeleider);
        
        emer.commit();
        emer.sluit();
    }
}
