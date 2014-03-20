/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_STAGEADMINISTRATOR")
@NamedQueries({
    @NamedQuery(name = "StageAdministrator.findAll", query = "SELECT a FROM StageAdministrator a")
})
public class StageAdministrator
{
    @Id
    private String lognaam;
    private String naam;
    private String passwoord;

    public StageAdministrator() {
    }

    public StageAdministrator(String naam, String lognaam, String passwoord) {
        this.naam = naam;
        this.lognaam = lognaam;
        this.passwoord = passwoord;
    }
    
    public String getNaam() {
        return naam;
    }

    public String getLognaam() {
        return lognaam;
    }

    public String getPasswoord() {
        return passwoord;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setLognaam(String lognaam) {
        this.lognaam = lognaam;
    }

    public void setPasswoord(String passwoord) {
        this.passwoord = passwoord;
    }
}
