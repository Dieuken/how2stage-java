/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Stef
 */
public class EMer 
{
    public EntityManagerFactory emf;
    public EntityManager em;
    
    public void begin(){
       emf = Persistence.createEntityManagerFactory("How2StagePU");
       em = emf.createEntityManager();
       em.getTransaction().begin();
    }
    
    public void sluit(){
        em.close();
        emf.close();
    }
    
    public void commit(){
        em.getTransaction().commit();
    }

    public EntityManager getEm() {
        return em;
    }
    
    
}
