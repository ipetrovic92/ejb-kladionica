package sb;

import domain.Utakmica;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ivan Petrovic
 */
@Stateless
public class SBUtakmica implements SBUtakmicaLocal {

    @PersistenceContext(unitName = "EJBKladionicaPU")
    private EntityManager em;

    @Override
    public Collection<Utakmica> vratiSveUtakmice() {
        Collection<Utakmica> ku = em.createNamedQuery("Utakmica.findAll").getResultList();
        return ku;
    }

    @Override
    public String zapamtiUtakmicu(Utakmica u) {
        try {
            em.persist(u);
            return "Sistem je uspesno zapamtio utakmicu.";
        } catch (Exception e) {
            return "Sistem nije uspeo da zapamti utakmicu.";
        }
    }

    @Override
    public String zapamtiRezultatUtakmice(Utakmica u) {
        try {
            em.merge(u);
            return "Sistem je uspesno zapamtio utakmicu.";
        } catch (Exception e) {
            return "Sistem nije uspeo da zapamti utakmicu.";
        }
    }

}
