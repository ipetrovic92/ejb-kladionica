package domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "igrac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Igrac.findAll", query = "SELECT i FROM Igrac i"),
    @NamedQuery(name = "Igrac.findByEmailIgrac", query = "SELECT i FROM Igrac i WHERE i.emailIgrac = :emailIgrac"),
    @NamedQuery(name = "Igrac.findByIme", query = "SELECT i FROM Igrac i WHERE i.ime = :ime"),
    @NamedQuery(name = "Igrac.findByPrezime", query = "SELECT i FROM Igrac i WHERE i.prezime = :prezime"),
    @NamedQuery(name = "Igrac.findByDatumRodjenja", query = "SELECT i FROM Igrac i WHERE i.datumRodjenja = :datumRodjenja"),
    @NamedQuery(name = "Igrac.findByLozinka", query = "SELECT i FROM Igrac i WHERE i.lozinka = :lozinka"),
    @NamedQuery(name = "Igrac.findByStanjeRacuna", query = "SELECT i FROM Igrac i WHERE i.stanjeRacuna = :stanjeRacuna")})
public class Igrac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "emailIgrac")
    private String emailIgrac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumRodjenja")
    @Temporal(TemporalType.DATE)
    private Date datumRodjenja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lozinka")
    private String lozinka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stanjeRacuna")
    private double stanjeRacuna;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "igrac")
    private Collection<Tiket> tiketCollection;

    public Igrac() {
    }

    public Igrac(String emailIgrac) {
        this.emailIgrac = emailIgrac;
    }

    public Igrac(String emailIgrac, String ime, String prezime, Date datumRodjenja, String lozinka, double stanjeRacuna) {
        this.emailIgrac = emailIgrac;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.lozinka = lozinka;
        this.stanjeRacuna = stanjeRacuna;
    }

    public String getEmailIgrac() {
        return emailIgrac;
    }

    public void setEmailIgrac(String emailIgrac) {
        this.emailIgrac = emailIgrac;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public double getStanjeRacuna() {
        return stanjeRacuna;
    }

    public void setStanjeRacuna(double stanjeRacuna) {
        this.stanjeRacuna = stanjeRacuna;
    }

    @XmlTransient
    public Collection<Tiket> getTiketCollection() {
        return tiketCollection;
    }

    public void setTiketCollection(Collection<Tiket> tiketCollection) {
        this.tiketCollection = tiketCollection;
    }

    @Override
    public String toString() {
        return "Igrac[ emailIgrac=" + emailIgrac + " ], " + ime + " " + prezime;
    }

}
