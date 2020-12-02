package fr.utbm.ecole.core.service;
import fr.utbm.ecole.core.entity.Client;
import fr.utbm.ecole.core.repository.ConsoleClientDao;
import fr.utbm.ecole.core.repository.EntityClientDao;
import java.util.List;

/**
 *
 * @author
 */
public class ClientService {

    public void registerClient(Client f) {
        ConsoleClientDao cfd = new ConsoleClientDao();
        EntityClientDao efd = new EntityClientDao();

        cfd.save(f);
     
        efd.save(f);
        List<Client> list = efd.listClient();
        for (Client Client : list) {
            cfd.save(Client);
        }
       
    }
}
