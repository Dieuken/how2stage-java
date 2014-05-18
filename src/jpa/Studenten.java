/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import domein.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Stef
 */
public class Studenten {
    private EMer emer = new EMer();
    
    public List<Student> alleStudenten(){
        
        emer.begin();
        EntityManager em = emer.getEm();
        TypedQuery<Student> queryFindAll = em.createNamedQuery("Student.findAll", Student.class);
        List<Student> results = queryFindAll.getResultList();
        
        emer.commit();
        emer.sluit();
        
        return results;
        
    }
    
    public Student getStudent(int StudentId)
    {
        emer.begin();
        EntityManager em = emer.getEm();
        Student stageBegeleider = em.find(Student.class, StudentId);
        
        emer.commit();
        emer.sluit();
        return stageBegeleider;
    }
    
    public void addStudent(Student student){
        emer.begin();
        EntityManager em = emer.getEm();
       
        
        em.persist(student);
        
        emer.commit();
        emer.sluit();
    }
}
