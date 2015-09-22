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
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findByStatusID", query = "SELECT s FROM Status s WHERE s.statusID = :statusID"),
    @NamedQuery(name = "Status.findByStatus", query = "SELECT s FROM Status s WHERE s.status = :status")})
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "statusID")
    private Integer statusID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusID")
    private Collection<Tiket> tiketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusID")
    private Collection<Tiketutakmica> tiketutakmicaCollection;

    public Status() {
    }

    public Status(Integer statusID) {
        this.statusID = statusID;
    }

    public Status(Integer statusID, String status) {
        this.statusID = statusID;
        this.status = status;
    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Tiket> getTiketCollection() {
        return tiketCollection;
    }

    public void setTiketCollection(Collection<Tiket> tiketCollection) {
        this.tiketCollection = tiketCollection;
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
        return status;
    }
    
}
