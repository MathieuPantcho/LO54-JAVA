package fr.utbm.ecole.core.service;

import fr.utbm.ecole.core.entity.Location;
import fr.utbm.ecole.core.repository.ConsoleLocationDao;
import fr.utbm.ecole.core.repository.EntityLocationDao;
import java.util.List;

/**
 *
 * @author
 */
public class LocationService {

    public void registerLocation(Location f) {
        ConsoleLocationDao cfd = new ConsoleLocationDao();
        EntityLocationDao efd = new EntityLocationDao();

        cfd.save(f);
        
 
        efd.save(f);
        List<Location> list = efd.listLocation();
        for (Location Location : list) {
            cfd.save(Location);
           
        }
       
    }
    
    public Location searchLocationById(Integer idLocation) {
        
        EntityLocationDao efd = new EntityLocationDao();
        return efd.getLocationById(idLocation);
    }
    
     public  List<Location> listLocation() {
        
        EntityLocationDao efd = new EntityLocationDao();
        return efd.listLocation();
    }
     
}
