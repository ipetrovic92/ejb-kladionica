package sb;

import domain.Klub;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ivan Petrovic
 */
@Stateless
public class SBKlub implements SBKlubLocal {

    @PersistenceContext(unitName = "EJBKladionicaPU")
    private EntityManager em;

    @Override
    public Collection<Klub> vratiSveKlubove() {
        Collection<Klub> l = em.createNamedQuery("Klub.findAll").getResultList();
        return l;
    }

    @Override
    public Klub vratiKlubPoID(int id) {
        Klub k = em.find(Klub.class, id);
        return k;
    }
}
