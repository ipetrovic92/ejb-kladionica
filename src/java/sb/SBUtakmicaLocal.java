package sb;

import domain.Utakmica;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Ivan Petrovic
 */
@Local
public interface SBUtakmicaLocal {
    
    Collection<Utakmica> vratiSveUtakmice();

    public String zapamtiUtakmicu(Utakmica u);
    
    public String zapamtiRezultatUtakmice(Utakmica u);
    
}
