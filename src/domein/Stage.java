/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Shmoopsy
 */

@Entity
@Table(name = "TBL_STAGE")
@NamedQueries({
    @NamedQuery(name = "Stage.findAll", query = "SELECT s FROM Stage s")
})

public class Stage {
    
    @Id
    @GeneratedValue
    private int stagesId;
    private String titel;
    private String omschrijving;
    private String specialisatie;
    private String aantalStudenten;
    private String mentorNaam;
    private String stageStatus;

    public Stage() {
    }

    public Stage(int stagesId, String titel, String omschrijving, String specialisatie, String aantalStudenten, String mentorNaam, String stageStatus) {
        this.stagesId = stagesId;
        this.titel = titel;
        this.omschrijving = omschrijving;
        this.specialisatie = specialisatie;
        this.aantalStudenten = aantalStudenten;
        this.mentorNaam = mentorNaam;
        this.stageStatus = stageStatus;
    }

    public int getStagesId() {
        return stagesId;
    }

    public String getTitel() {
        return titel;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getSpecialisatie() {
        return specialisatie;
    }

    public String getAantalStudenten() {
        return aantalStudenten;
    }

    public String getMentorNaam() {
        return mentorNaam;
    }

    public String getStageStatus() {
        return stageStatus;
    }

    public void setStagesId(int stagesId) {
        this.stagesId = stagesId;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public void setSpecialisatie(String specialisatie) {
        this.specialisatie = specialisatie;
    }

    public void setAantalStudenten(String aantalStudenten) {
        this.aantalStudenten = aantalStudenten;
    }

    public void setMentorNaam(String mentorNaam) {
        this.mentorNaam = mentorNaam;
    }

    public void setStageStatus(String stageStatus) {
        this.stageStatus = stageStatus;
    }

    
    
    
    
}
