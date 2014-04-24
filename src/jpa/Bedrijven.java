/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;


import domein.Bedrijf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Shmoopsy
 */
public class Bedrijven 
{
    private EMer emer = new EMer();
    
    public List<Bedrijf> alleBedrijven(){
        
        emer.begin();
        EntityManager em = emer.getEm();
        TypedQuery<Bedrijf> queryFindAll = em.createNamedQuery("Bedrijf.findAll", Bedrijf.class);
        List<Bedrijf> results = queryFindAll.getResultList();
        
        emer.commit();
        emer.sluit();
        
        return results;
        
    }
    
    public Bedrijf getBedrijf(int BedrijfId)
    {
        emer.begin();
        EntityManager em = emer.getEm();
        Bedrijf bedrijf = em.find(Bedrijf.class, BedrijfId);
        
        emer.commit();
        emer.sluit();
        return bedrijf;
    }
    
    public void addBedrijf(Bedrijf bedrijf){
        emer.begin();
        EntityManager em = emer.getEm();
       
        
        em.persist(bedrijf);
        
        emer.commit();
        emer.sluit();
    }
}
