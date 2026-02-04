package database.operations;

import java.sql.*;

public class DatabaseConnector {
    /**
     * Establishes a connection to the database.
     * We use JDBC (Java Database Connectivity) to talk to the PostgreSQL database.
     * 
     * @return A connection object if successful, or null if it fails.
     */
    public static Connection createConnection() {
      Connection connection = null;
      try {
            // "jdbc:postgresql://..." is the URL where our database lives.
            // "postgres" is the username, and "hydroarchon" is the password.
            // You should change these if your database setup is different!
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Fontaine", "postgres", "hydroarchon");
            // System.out.println("Connected to the database successfully!");
      } 
      catch (SQLException e) {
            // If something goes wrong (like wrong password), we print the error here.
            System.out.println("Could not connect to the database: " + e.getMessage());
            e.printStackTrace();
      }
      return connection;
   }
}
