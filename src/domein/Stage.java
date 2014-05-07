/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    private int aantalStudenten;
    private String mentorNaam;
    private String stageStatus;
    private String beginPeriode;

   
    private String eindPeriode;
    @ManyToOne
    private Bedrijf b;
    
    @ManyToOne
    private StageBegeleider effectieveBegeleider;
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<StageBegeleider> mogelijkeBegeleiderLijst;

    

    public Bedrijf getB() {
        return b;
    }

    public Stage() {
    }

    public Stage(String titel, String omschrijving, String specialisatie, int aantalStudenten, String mentorNaam, String stageStatus) 
    {
        this.titel = titel;
        this.omschrijving = omschrijving;
        this.specialisatie = specialisatie;
        this.aantalStudenten = aantalStudenten;
        this.mentorNaam = mentorNaam;
        this.stageStatus = stageStatus;
        
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

    public int getAantalStudenten() {
        return aantalStudenten;
    }

    public String getMentorNaam() {
        return mentorNaam;
    }

    public String getStageStatus() {
        return stageStatus;
    }

    public int getStagesId() {
        return stagesId;
    }

    public StageBegeleider getEffectieveBegeleider() {
        return effectieveBegeleider;
    }

    public List<StageBegeleider> getMogelijkeBegeleiderLijst() {
        return mogelijkeBegeleiderLijst;
    }
    
    public String getBeginPeriode() {
        return beginPeriode;
    }

    public String getEindPeriode() {
        return eindPeriode;
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

    public void setAantalStudenten(int aantalStudenten) {
        this.aantalStudenten = aantalStudenten;
    }

    public void setMentorNaam(String mentorNaam) {
        this.mentorNaam = mentorNaam;
    }

    public void setStageStatus(String stageStatus) {
        this.stageStatus = stageStatus;
    }

    public void setB(Bedrijf b) {
        this.b = b;
    }

    public void setEffectieveStageBegeleider(StageBegeleider effectieveBegeleider) {
        this.effectieveBegeleider = effectieveBegeleider;
    }

    public void setMogelijkeBegeleiderLijst(List<StageBegeleider> mogelijkeBegeleiderLijst) {
        this.mogelijkeBegeleiderLijst = mogelijkeBegeleiderLijst;
    }
    
    public void setBeginPeriode(String beginPeriode) {
        this.beginPeriode = beginPeriode;
    }

    public void setEindPeriode(String eindPeriode) {
        this.eindPeriode = eindPeriode;
    }

    public void setEffectieveBegeleider(StageBegeleider effectieveBegeleider) {
        this.effectieveBegeleider = effectieveBegeleider;
    }
    
    
    
}
