package sb;

import domain.Administrator;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Ivan Petrovic
 */
@Local
public interface SBAdminLocal {
    
    public Administrator login(Administrator a);
    
}
