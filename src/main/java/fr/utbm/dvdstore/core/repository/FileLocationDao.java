package fr.utbm.dvdstore.core.repository;

import fr.utbm.dvdstore.core.entity.Location;
import java.io.FileWriter;

/**
 *
 * @author 
 */
public class FileLocationDao {

    public void save(Location f) {
        FileWriter fw;
        try {
            fw = new FileWriter("films.csv", true);
            fw.write(f.getCity() + ";" + "\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur");
        }
    }
}
