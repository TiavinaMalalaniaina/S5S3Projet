/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author tiavi
 */
public class DBConnection {
    private String URL = "jdbc:postgresql://172.20.3.244/meuble";
    private String USER = "postgres";
    private String PASSWORD = "malalaniaina";
    private String DRIVER = "org.postgresql.Driver";
    private Connection connection = null;
    
    
    
    private DBConnection(String propertiesFile) throws SQLException {
//        Properties properties = new Properties();
//        try (FileInputStream input = new FileInputStream(propertiesFile)) {
//            properties.load(input);
//        } catch (IOException e) {
//        }
//        URL = properties.getProperty("database.url");
//        USER = properties.getProperty("database.user");
//        PASSWORD = properties.getProperty("database.password");
//        DRIVER = properties.getProperty("database.driver");
        setting();
    }
    
    
    private void setting() throws SQLException {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Le pilote PostgreSQL n'a pas été trouvé.");
            throw new RuntimeException("Connection à la base de données échouées");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données PostgreSQL.");
            throw e;
        }
    }
    
    public static Connection getConnection() throws SQLException {
        DBConnection conn = new DBConnection("application.properties");
        return conn.connection;
    }
}
