/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import domein.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Shmoopsy
 */
public class StageAdministrators 
{
    @PersistenceContext
    private EntityManager em;
    
    public List<StageAdministrator> alleStageAdmins()
    {
        TypedQuery<StageAdministrator> queryFindAll = em.createNamedQuery("StageAdministrator.findAll", StageAdministrator.class);
        return queryFindAll.getResultList();
    }
    
    public void addStageAdministrator(StageAdministrator stageadmin)
    {
        if(stageadmin.getLognaam() == null || stageadmin.getLognaam().trim().length() < 8)
        {
            
        }
    }
}
