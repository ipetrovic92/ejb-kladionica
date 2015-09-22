package sb;

import domain.Igrac;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ivan Petrovic
 */
@Stateless
public class SBIgrac implements SBIgracLocal {

    @PersistenceContext(unitName = "EJBKladionicaPU")
    private EntityManager em;

    @Override
    public Collection<Igrac> vratiSveIgrace() {
        return em.createNamedQuery("Igrac.findAll").getResultList();
    }

    @Override
    public String zapamtiUplatuNovca(Igrac i) {
        try {
            em.merge(i);
        } catch (Exception e) {
            return "uplata nije prosla";
        }
        return "uspesna uplata novca igracu";
    }

    @Override
    public String registrujIgraca(Igrac i) {
        try {
            em.persist(i);
        } catch (Exception e) {
            return "grska pri registraciji novog igraca";
        }
        return "igrac je registrovan";
    }

    @Override
    public Igrac login(Igrac i) {
        Collection<Igrac> li = vratiSveIgrace();
        for (Igrac igrac : li) {
            if (igrac.getEmailIgrac().equals(i.getEmailIgrac()) && igrac.getLozinka().equals(i.getLozinka())) {
                return igrac;
            }
        }
        return null;
    }

}
