/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import domein.Stage;

/**
 *
 * @author Shmoopsy
 */
@Entity
@Table(name = "TBL_BEDRIJF")
@NamedQueries({
    @NamedQuery(name = "Bedrijf.findAll", query = "SELECT b FROM Bedrijf b")
})

public class Bedrijf 
{
    @Id
    @GeneratedValue
    private int bedrijfId;
    private String bedrijfNaam;
    private String bedrijfContact;
    private String bedrijfAdress;
    private String bedrijfEmail;
    private String bedrijfbereikbaarheid;
    

    public Bedrijf() {
    }

    public Bedrijf(String bedrijfNaam, String bedrijfContact, String bedrijfAdress, String bedrijfEmail, String bedrijfbereikbaarheid) {
        
        this.bedrijfNaam = bedrijfNaam;
        this.bedrijfContact = bedrijfContact;
        this.bedrijfAdress = bedrijfAdress;
        this.bedrijfEmail = bedrijfEmail;
        this.bedrijfbereikbaarheid = bedrijfbereikbaarheid;
        
    }

    public int getBedrijfId() {
        return bedrijfId;
    }

    public String getBedrijfNaam() {
        return bedrijfNaam;
    }

    public String getBedrijfContact() {
        return bedrijfContact;
    }

    public String getBedrijfAdress() {
        return bedrijfAdress;
    }

    public String getBedrijfEmail() {
        return bedrijfEmail;
    }

    public String getBedrijfbereikbaarheid() {
        return bedrijfbereikbaarheid;
    }

    

    public void setBedrijfId(int bedrijfId) {
        this.bedrijfId = bedrijfId;
    }

    public void setBedrijfNaam(String bedrijfNaam) {
        this.bedrijfNaam = bedrijfNaam;
    }

    public void setBedrijfContact(String bedrijfContact) {
        this.bedrijfContact = bedrijfContact;
    }

    public void setBedrijfAdress(String bedrijfAdress) {
        this.bedrijfAdress = bedrijfAdress;
    }

    public void setBedrijfEmail(String bedrijfEmail) {
        this.bedrijfEmail = bedrijfEmail;
    }

    public void setBedrijfbereikbaarheid(String bedrijfbereikbaarheid) {
        this.bedrijfbereikbaarheid = bedrijfbereikbaarheid;
    }

    

    
    
    
    
    
    
}
