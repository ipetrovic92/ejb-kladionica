package domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ivan Petrovic
 */
@Entity
@Table(name = "tiket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiket.findAll", query = "SELECT t FROM Tiket t"),
    @NamedQuery(name = "Tiket.findByEmailIgrac", query = "SELECT t FROM Tiket t WHERE t.tiketPK.emailIgrac = :emailIgrac"),
    @NamedQuery(name = "Tiket.findBySifraTiketa", query = "SELECT t FROM Tiket t WHERE t.tiketPK.sifraTiketa = :sifraTiketa"),
    @NamedQuery(name = "Tiket.findByDatumIgranja", query = "SELECT t FROM Tiket t WHERE t.datumIgranja = :datumIgranja"),
    @NamedQuery(name = "Tiket.findByUplata", query = "SELECT t FROM Tiket t WHERE t.uplata = :uplata"),
    @NamedQuery(name = "Tiket.findByUkupnaKvota", query = "SELECT t FROM Tiket t WHERE t.ukupnaKvota = :ukupnaKvota"),
    @NamedQuery(name = "Tiket.findByMoguciDobitak", query = "SELECT t FROM Tiket t WHERE t.moguciDobitak = :moguciDobitak")})
public class Tiket implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TiketPK tiketPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumIgranja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumIgranja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uplata")
    private double uplata;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ukupnaKvota")
    private double ukupnaKvota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "moguciDobitak")
    private double moguciDobitak;
    @JoinColumn(name = "emailIgrac", referencedColumnName = "emailIgrac", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Igrac igrac;
    @JoinColumn(name = "statusID", referencedColumnName = "statusID")
    @ManyToOne(optional = false)
    private Status statusID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiket")
    private Collection<Tiketutakmica> tiketutakmicaCollection;

    public Tiket() {
    }

    public Tiket(TiketPK tiketPK) {
        this.tiketPK = tiketPK;
    }

    public Tiket(TiketPK tiketPK, Date datumIgranja, double uplata, double ukupnaKvota, double moguciDobitak) {
        this.tiketPK = tiketPK;
        this.datumIgranja = datumIgranja;
        this.uplata = uplata;
        this.ukupnaKvota = ukupnaKvota;
        this.moguciDobitak = moguciDobitak;
    }

    public Tiket(String emailIgrac, String sifraTiketa) {
        this.tiketPK = new TiketPK(emailIgrac, sifraTiketa);
    }

    public TiketPK getTiketPK() {
        return tiketPK;
    }

    public void setTiketPK(TiketPK tiketPK) {
        this.tiketPK = tiketPK;
    }

    public Date getDatumIgranja() {
        return datumIgranja;
    }

    public void setDatumIgranja(Date datumIgranja) {
        this.datumIgranja = datumIgranja;
    }

    public double getUplata() {
        return uplata;
    }

    public void setUplata(double uplata) {
        this.uplata = uplata;
    }

    public double getUkupnaKvota() {
        return ukupnaKvota;
    }

    public void setUkupnaKvota(double ukupnaKvota) {
        this.ukupnaKvota = ukupnaKvota;
    }

    public double getMoguciDobitak() {
        return moguciDobitak;
    }

    public void setMoguciDobitak(double moguciDobitak) {
        this.moguciDobitak = moguciDobitak;
    }

    public Igrac getIgrac() {
        return igrac;
    }

    public void setIgrac(Igrac igrac) {
        this.igrac = igrac;
    }

    public Status getStatusID() {
        return statusID;
    }

    public void setStatusID(Status statusID) {
        this.statusID = statusID;
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
        return "Tiket[ tiketPK=" + tiketPK + " ]";
    }

}
