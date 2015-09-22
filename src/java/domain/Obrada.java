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
@Table(name = "obrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obrada.findAll", query = "SELECT o FROM Obrada o"),
    @NamedQuery(name = "Obrada.findByObradaID", query = "SELECT o FROM Obrada o WHERE o.obradaID = :obradaID"),
    @NamedQuery(name = "Obrada.findByNazivObrade", query = "SELECT o FROM Obrada o WHERE o.nazivObrade = :nazivObrade")})
public class Obrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "obradaID")
    private Integer obradaID;
    @Size(max = 25)
    @Column(name = "nazivObrade")
    private String nazivObrade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obradaID")
    private Collection<Utakmica> utakmicaCollection;

    public Obrada() {
    }

    public Obrada(Integer obradaID) {
        this.obradaID = obradaID;
    }

    public Integer getObradaID() {
        return obradaID;
    }

    public void setObradaID(Integer obradaID) {
        this.obradaID = obradaID;
    }

    public String getNazivObrade() {
        return nazivObrade;
    }

    public void setNazivObrade(String nazivObrade) {
        this.nazivObrade = nazivObrade;
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
        return nazivObrade;
    }
    
}
