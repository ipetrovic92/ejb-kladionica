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
@Table(name = "administrator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findByEmailAdministrator", query = "SELECT a FROM Administrator a WHERE a.emailAdministrator = :emailAdministrator"),
    @NamedQuery(name = "Administrator.findByIme", query = "SELECT a FROM Administrator a WHERE a.ime = :ime"),
    @NamedQuery(name = "Administrator.findByPrezime", query = "SELECT a FROM Administrator a WHERE a.prezime = :prezime"),
    @NamedQuery(name = "Administrator.findByLozinka", query = "SELECT a FROM Administrator a WHERE a.lozinka = :lozinka")})
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "emailAdministrator")
    private String emailAdministrator;
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
    @Size(min = 1, max = 15)
    @Column(name = "lozinka")
    private String lozinka;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emailAdministrator")
    private Collection<Utakmica> utakmicaCollection;

    public Administrator() {
    }

    public Administrator(String emailAdministrator) {
        this.emailAdministrator = emailAdministrator;
    }

    public Administrator(String emailAdministrator, String ime, String prezime, String lozinka) {
        this.emailAdministrator = emailAdministrator;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
    }

    public String getEmailAdministrator() {
        return emailAdministrator;
    }

    public void setEmailAdministrator(String emailAdministrator) {
        this.emailAdministrator = emailAdministrator;
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

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @XmlTransient
    public Collection<Utakmica> getUtakmicaCollection() {
        return utakmicaCollection;
    }

    public void setUtakmicaCollection(Collection<Utakmica> utakmicaCollection) {
        this.utakmicaCollection = utakmicaCollection;
    }

    @Override
    public String toString() {
        return "Administrator[ " + emailAdministrator + " ] " + ime + " " + prezime;
    }

}
