package sb;

import domain.Administrator;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ivan Petrovic
 */
@Stateless
public class SBAdmin implements SBAdminLocal {

    @PersistenceContext(unitName = "EJBKladionicaPU")
    private EntityManager em;

    @Override
    public Administrator login(Administrator a) {
        Collection<Administrator> la = vratiSveAdministratore();
        for (Administrator admin : la) {
            if (admin.getEmailAdministrator().equals(a.getEmailAdministrator()) && admin.getLozinka().equals(a.getLozinka())) {
                return admin;
            }
        }
        return null;
    }

    private Collection<Administrator> vratiSveAdministratore() {
        return em.createNamedQuery("Administrator.findAll").getResultList();
    }

}
