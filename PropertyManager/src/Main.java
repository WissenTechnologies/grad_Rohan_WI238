import business.*;
import business.factory.*;

import java.sql.Connection;

import database.*;
import database.operations.*;

public class Main {

    public static void main(String[] args) {
        // We expect the user to pass a mode (admin, owner, or general) as a command line argument.
        if (args.length == 0) {
            System.out.println("Please specify a mode:");
            System.out.println("-a (admin), -o (owner), -g (general)");
            return;
        }

        try {
            // 1. Connect to the database
            Connection connection = DatabaseConnector.createConnection();
            
            // 2. Create Data Access Objects (DAOs) to handle database operations
            MaintenanceInterface maintenanceDao = new MaintenanceDAO(connection);
            SiteInterface siteDao = new SiteDAO(connection);
            OwnerInterface ownerDao = new OwnerDAO(connection);
            AdminInterface adminDao = new AdminDAO(connection);

            // 3. Create the Factory that helps us build the right Service
            AssignmentFactory factory = new AssignmentFactory(maintenanceDao, siteDao, ownerDao, adminDao);

            // 4. Create and run the service based on the user's input (args[0])
            Service service = factory.createService(args[0]);
            service.run();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }
}
