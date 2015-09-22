package sb;

import domain.Igrac;
import domain.Tiket;
import domain.Tiketutakmica;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ivan Petrovic
 */
@Stateless
public class SBTiket implements SBTiketLocal {

    @PersistenceContext(unitName = "EJBKladionicaPU")
    private EntityManager em;

    @Override
    public Collection<Tiket> vratiSveTikete(Igrac i) {
        return em.createNamedQuery("Tiket.findByEmailIgrac").getResultList();
    }

    @Override
    public String zapamtiTiket(Tiket t) {
        try {
            em.persist(t);
            for (Tiketutakmica tu : t.getTiketutakmicaCollection()) {
                em.persist(tu);
            }
            return "Tiket je uspesno sacuvan";
        } catch (Exception e) {
            return "Tiket nije uspesno sacuvan";
        }
    }

}
