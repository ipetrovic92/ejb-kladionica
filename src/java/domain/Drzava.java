package domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ivan Petrovic
 */
@Entity
@Table(name = "drzava")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drzava.findAll", query = "SELECT d FROM Drzava d"),
    @NamedQuery(name = "Drzava.findByDrzavaID", query = "SELECT d FROM Drzava d WHERE d.drzavaID = :drzavaID"),
    @NamedQuery(name = "Drzava.findByNaziv", query = "SELECT d FROM Drzava d WHERE d.naziv = :naziv")})
public class Drzava implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "drzavaID")
    private Integer drzavaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drzavaID")
    private Collection<Klub> klubCollection;

    public Drzava() {
    }

    public Drzava(Integer drzavaID) {
        this.drzavaID = drzavaID;
    }

    public Drzava(Integer drzavaID, String naziv) {
        this.drzavaID = drzavaID;
        this.naziv = naziv;
    }

    public Integer getDrzavaID() {
        return drzavaID;
    }

    public void setDrzavaID(Integer drzavaID) {
        this.drzavaID = drzavaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public Collection<Klub> getKlubCollection() {
        return klubCollection;
    }

    public void setKlubCollection(Collection<Klub> klubCollection) {
        this.klubCollection = klubCollection;
    }

    @Override
    public String toString() {
        return "Drzava[ drzavaID=" + drzavaID + " ] " + naziv;
    }

}
