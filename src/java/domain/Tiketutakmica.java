package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Petrovic
 */
@Entity
@Table(name = "tiketutakmica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiketutakmica.findAll", query = "SELECT t FROM Tiketutakmica t"),
    @NamedQuery(name = "Tiketutakmica.findByEmailIgrac", query = "SELECT t FROM Tiketutakmica t WHERE t.tiketutakmicaPK.emailIgrac = :emailIgrac"),
    @NamedQuery(name = "Tiketutakmica.findBySifraTiketa", query = "SELECT t FROM Tiketutakmica t WHERE t.tiketutakmicaPK.sifraTiketa = :sifraTiketa"),
    @NamedQuery(name = "Tiketutakmica.findBySifraUtakmice", query = "SELECT t FROM Tiketutakmica t WHERE t.tiketutakmicaPK.sifraUtakmice = :sifraUtakmice"),
    @NamedQuery(name = "Tiketutakmica.findByTip", query = "SELECT t FROM Tiketutakmica t WHERE t.tip = :tip"),
    @NamedQuery(name = "Tiketutakmica.findByKvota", query = "SELECT t FROM Tiketutakmica t WHERE t.kvota = :kvota")})
public class Tiketutakmica implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TiketutakmicaPK tiketutakmicaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tip")
    private int tip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kvota")
    private double kvota;
    @JoinColumns({
        @JoinColumn(name = "emailIgrac", referencedColumnName = "emailIgrac", insertable = false, updatable = false),
        @JoinColumn(name = "sifraTiketa", referencedColumnName = "sifraTiketa", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Tiket tiket;
    @JoinColumn(name = "sifraUtakmice", referencedColumnName = "sifraUtakmice", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utakmica utakmica;
    @JoinColumn(name = "statusID", referencedColumnName = "statusID")
    @ManyToOne(optional = false)
    private Status statusID;

    public Tiketutakmica() {
    }

    public Tiketutakmica(TiketutakmicaPK tiketutakmicaPK) {
        this.tiketutakmicaPK = tiketutakmicaPK;
    }

    public Tiketutakmica(TiketutakmicaPK tiketutakmicaPK, int tip, double kvota) {
        this.tiketutakmicaPK = tiketutakmicaPK;
        this.tip = tip;
        this.kvota = kvota;
    }

    public Tiketutakmica(String emailIgrac, String sifraTiketa, String sifraUtakmice) {
        this.tiketutakmicaPK = new TiketutakmicaPK(emailIgrac, sifraTiketa, sifraUtakmice);
    }

    public TiketutakmicaPK getTiketutakmicaPK() {
        return tiketutakmicaPK;
    }

    public void setTiketutakmicaPK(TiketutakmicaPK tiketutakmicaPK) {
        this.tiketutakmicaPK = tiketutakmicaPK;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public double getKvota() {
        return kvota;
    }

    public void setKvota(double kvota) {
        this.kvota = kvota;
    }

    public Tiket getTiket() {
        return tiket;
    }

    public void setTiket(Tiket tiket) {
        this.tiket = tiket;
    }

    public Utakmica getUtakmica() {
        return utakmica;
    }

    public void setUtakmica(Utakmica utakmica) {
        this.utakmica = utakmica;
    }

    public Status getStatusID() {
        return statusID;
    }

    public void setStatusID(Status statusID) {
        this.statusID = statusID;
    }

    @Override
    public String toString() {
        return "domain.Tiketutakmica[ tiketutakmicaPK=" + tiketutakmicaPK + " ]";
    }
    
}
