package fr.utbm.ecole.core.service;

<<<<<<< HEAD
import fr.utbm.ecole.core.entity.Course;
import fr.utbm.ecole.core.repository.ConsoleCourseDao;
import fr.utbm.ecole.core.repository.EntityCourseDao;
import java.util.List;

/**
 *
 * @author
 */
public class ClientService {

    public void registerCourse(Course f) {
        ConsoleCourseDao cfd = new ConsoleCourseDao();
        EntityCourseDao efd = new EntityCourseDao();

        cfd.save(f);
     
        efd.save(f);
        List<Course> list = efd.listCourse();
        for (Course Course : list) {
            cfd.save(Course);
=======
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
>>>>>>> a026e7a7846ac77019bca89bbd5a187f872f9a37
        }
       
    }
}
