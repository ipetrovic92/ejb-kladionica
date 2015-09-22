package sb;

import domain.Klub;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Ivan Petrovic
 */
@Local
public interface SBKlubLocal {

    public Collection<Klub> vratiSveKlubove();

    public Klub vratiKlubPoID(int id);
}
