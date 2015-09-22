package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ivan Petrovic
 */
@Embeddable
@Table(name = "tiket")
public class TiketPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "emailIgrac")
    private String emailIgrac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sifraTiketa")
    private String sifraTiketa;

    public TiketPK() {
    }

    public TiketPK(String emailIgrac, String sifraTiketa) {
        this.emailIgrac = emailIgrac;
        this.sifraTiketa = sifraTiketa;
    }

    public String getEmailIgrac() {
        return emailIgrac;
    }

    public void setEmailIgrac(String emailIgrac) {
        this.emailIgrac = emailIgrac;
    }

    public String getSifraTiketa() {
        return sifraTiketa;
    }

    public void setSifraTiketa(String sifraTiketa) {
        this.sifraTiketa = sifraTiketa;
    }

    @Override
    public String toString() {
        return "TiketPK[sifraTiketa=" + sifraTiketa + "]" + emailIgrac;
    }
    
}
