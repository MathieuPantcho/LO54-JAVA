package fr.utbm.ecole.core.controller;

import fr.utbm.ecole.core.entity.Location;
import fr.utbm.ecole.core.service.LocationService;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class DefaultLocationController {
    
    public void registerLocationFromConsoleInput(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("City ?");
        String city = sc.nextLine();

        Location f = new Location();
        f.setCity(city);
     
        
        LocationService fs = new LocationService();
        fs.registerLocation(f);
    }
    
    public void searchLocationFromConsoleInput() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Id Location ?");
        String idLocation= sc.nextLine();

        LocationService fs = new LocationService();
        Location Location = fs.searchLocationById(Integer.parseInt(idLocation));
        System.out.println("Location : " + Location.toString());
    }
}
