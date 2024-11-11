package Task_11A;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/";
        String username = "postgres";
        String password = "Rushank";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();

           
            statement.executeUpdate("CREATE DATABASE Student");
            System.out.println("Database created successfully!");

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Student", username, password);
            statement = connection.createStatement();

            String createTableSQL = "CREATE TABLE Registration " +
                    "(id SERIAL PRIMARY KEY, " +
                    " name VARCHAR(50), " +
                    " address VARCHAR(100), " +
                    " program VARCHAR(50))";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully!");

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
