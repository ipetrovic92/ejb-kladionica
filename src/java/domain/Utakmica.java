package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ivan Petrovic
 */
@Entity
@Table(name = "utakmica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utakmica.findAll", query = "SELECT u FROM Utakmica u"),
    @NamedQuery(name = "Utakmica.findBySifraUtakmice", query = "SELECT u FROM Utakmica u WHERE u.sifraUtakmice = :sifraUtakmice"),
    @NamedQuery(name = "Utakmica.findByVremeUtakmice", query = "SELECT u FROM Utakmica u WHERE u.vremeUtakmice = :vremeUtakmice"),
    @NamedQuery(name = "Utakmica.findByKvotaDomacin", query = "SELECT u FROM Utakmica u WHERE u.kvotaDomacin = :kvotaDomacin"),
    @NamedQuery(name = "Utakmica.findByKvotaNereseno", query = "SELECT u FROM Utakmica u WHERE u.kvotaNereseno = :kvotaNereseno"),
    @NamedQuery(name = "Utakmica.findByKvotaGost", query = "SELECT u FROM Utakmica u WHERE u.kvotaGost = :kvotaGost"),
    @NamedQuery(name = "Utakmica.findByRezultat", query = "SELECT u FROM Utakmica u WHERE u.rezultat = :rezultat")})
public class Utakmica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sifraUtakmice")
    private String sifraUtakmice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vremeUtakmice")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vremeUtakmice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kvotaDomacin")
    private double kvotaDomacin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kvotaNereseno")
    private double kvotaNereseno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kvotaGost")
    private double kvotaGost;
    @Basic(optional = false)
    @Size(min = 1, max = 5)
    @Column(name = "rezultat")
    private String rezultat;
    @JoinColumn(name = "emailAdministrator", referencedColumnName = "emailAdministrator")
    @ManyToOne(optional = false)
    private Administrator emailAdministrator;
    @JoinColumn(name = "klubDomacin", referencedColumnName = "klubID")
    @ManyToOne(optional = false)
    private Klub klubDomacin;
    @JoinColumn(name = "klubGost", referencedColumnName = "klubID")
    @ManyToOne(optional = false)
    private Klub klubGost;
    @JoinColumn(name = "obradaID", referencedColumnName = "obradaID")
    @ManyToOne(optional = false)
    private Obrada obradaID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utakmica")
    private Collection<Tiketutakmica> tiketutakmicaCollection;

    public Utakmica() {
        klubDomacin = new Klub();
        klubGost = new Klub();
    }

    public Utakmica(String sifraUtakmice) {
        this.sifraUtakmice = sifraUtakmice;
        klubDomacin = new Klub();
        klubGost = new Klub();
    }

    public Utakmica(String sifraUtakmice, Date vremeUtakmice, double kvotaDomacin, double kvotaNereseno, double kvotaGost, String rezultat) {
        this.sifraUtakmice = sifraUtakmice;
        this.vremeUtakmice = vremeUtakmice;
        this.kvotaDomacin = kvotaDomacin;
        this.kvotaNereseno = kvotaNereseno;
        this.kvotaGost = kvotaGost;
        this.rezultat = rezultat;
        klubDomacin = new Klub();
        klubGost = new Klub();
    }

    public String getSifraUtakmice() {
        return sifraUtakmice;
    }

    public void setSifraUtakmice(String sifraUtakmice) {
        this.sifraUtakmice = sifraUtakmice;
    }

    public Date getVremeUtakmice() {
        return vremeUtakmice;
    }

    public void setVremeUtakmice(Date vremeUtakmice) {
        this.vremeUtakmice = vremeUtakmice;
    }

    public double getKvotaDomacin() {
        return kvotaDomacin;
    }

    public void setKvotaDomacin(double kvotaDomacin) {
        this.kvotaDomacin = kvotaDomacin;
    }

    public double getKvotaNereseno() {
        return kvotaNereseno;
    }

    public void setKvotaNereseno(double kvotaNereseno) {
        this.kvotaNereseno = kvotaNereseno;
    }

    public double getKvotaGost() {
        return kvotaGost;
    }

    public void setKvotaGost(double kvotaGost) {
        this.kvotaGost = kvotaGost;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public Administrator getEmailAdministrator() {
        return emailAdministrator;
    }

    public void setEmailAdministrator(Administrator emailAdministrator) {
        this.emailAdministrator = emailAdministrator;
    }

    public Klub getKlubDomacin() {
        return klubDomacin;
    }

    public void setKlubDomacin(Klub klubDomacin) {
        this.klubDomacin = klubDomacin;
    }

    public Klub getKlubGost() {
        return klubGost;
    }

    public void setKlubGost(Klub klubGost) {
        this.klubGost = klubGost;
    }

    public Obrada getObradaID() {
        return obradaID;
    }

    public void setObradaID(Obrada obradaID) {
        this.obradaID = obradaID;
    }

    @XmlTransient
    public Collection<Tiketutakmica> getTiketutakmicaCollection() {
        return tiketutakmicaCollection;
    }

    public void setTiketutakmicaCollection(Collection<Tiketutakmica> tiketutakmicaCollection) {
        this.tiketutakmicaCollection = tiketutakmicaCollection;
    }

    @Override
    public String toString() {
        return "Domacin: " + klubDomacin + ", Gost: " + klubGost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Utakmica) {
            Utakmica u = (Utakmica) obj;
            if (u == null) {
                return false;
            }
            return u.getSifraUtakmice().equals(this.sifraUtakmice);
        } else {
            return false;
        }
    }

}
