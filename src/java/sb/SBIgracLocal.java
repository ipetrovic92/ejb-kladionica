package sb;

import domain.Igrac;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Ivan Petrovic
 */
@Local
public interface SBIgracLocal {
    
    Collection<Igrac> vratiSveIgrace();

    public String zapamtiUplatuNovca(Igrac i);
    
    public String registrujIgraca(Igrac i);
    
    public Igrac login(Igrac i);
    
}
