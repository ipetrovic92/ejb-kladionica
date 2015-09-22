package sb;

import domain.Igrac;
import domain.Tiket;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Ivan Petrovic
 */
@Local
public interface SBTiketLocal {

    public Collection<Tiket> vratiSveTikete(Igrac i);

    public String zapamtiTiket(Tiket t);

}
