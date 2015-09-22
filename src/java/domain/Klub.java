package domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "klub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klub.findAll", query = "SELECT k FROM Klub k"),
    @NamedQuery(name = "Klub.findByKlubID", query = "SELECT k FROM Klub k WHERE k.klubID = :klubID"),
    @NamedQuery(name = "Klub.findByNazivKluba", query = "SELECT k FROM Klub k WHERE k.nazivKluba = :nazivKluba")})
public class Klub implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "klubID")
    private Integer klubID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazivKluba")
    private String nazivKluba;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klubDomacin")
    private Collection<Utakmica> utakmicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klubGost")
    private Collection<Utakmica> utakmicaCollection1;
    @JoinColumn(name = "drzavaID", referencedColumnName = "drzavaID")
    @ManyToOne(optional = false)
    private Drzava drzavaID;

    public Klub() {
    }

    public Klub(Integer klubID) {
        this.klubID = klubID;
    }

    public Klub(Integer klubID, String nazivKluba) {
        this.klubID = klubID;
        this.nazivKluba = nazivKluba;
    }

    public Integer getKlubID() {
        return klubID;
    }

    public void setKlubID(Integer klubID) {
        this.klubID = klubID;
    }

    public String getNazivKluba() {
        return nazivKluba;
    }

    public void setNazivKluba(String nazivKluba) {
        this.nazivKluba = nazivKluba;
    }

    @XmlTransient
    public Collection<Utakmica> getUtakmicaCollection() {
        return utakmicaCollection;
    }

    public void setUtakmicaCollection(Collection<Utakmica> utakmicaCollection) {
        this.utakmicaCollection = utakmicaCollection;
    }

    @XmlTransient
    public Collection<Utakmica> getUtakmicaCollection1() {
        return utakmicaCollection1;
    }

    public void setUtakmicaCollection1(Collection<Utakmica> utakmicaCollection1) {
        this.utakmicaCollection1 = utakmicaCollection1;
    }

    public Drzava getDrzavaID() {
        return drzavaID;
    }

    public void setDrzavaID(Drzava drzavaID) {
        this.drzavaID = drzavaID;
    }

    @Override
    public String toString() {
        return nazivKluba + " [" + drzavaID.getNaziv() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Klub) {
            Klub k = (Klub) obj;
            return Objects.equals(k.getKlubID(), klubID);
        } else {
            return false;
        }
    }

}
