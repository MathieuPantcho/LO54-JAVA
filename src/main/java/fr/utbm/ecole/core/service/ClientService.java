package fr.utbm.ecole.core.service;

import fr.utbm.ecole.core.entity.Client;
import fr.utbm.ecole.core.repository.ConsoleClientDao;
import fr.utbm.ecole.core.repository.EntityClientDao;
import java.util.List;


public class ClientService {
     public void registerClient(Client c) {
        ConsoleClientDao cfd = new ConsoleClientDao();
        EntityClientDao efd = new EntityClientDao();

        cfd.save(c);
     
        efd.save(c);
        List<Client> list = efd.listClient();
        for (Client Client : list) {
            cfd.save(Client);
        }
       
    }
}
