package fr.but3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Simple print
        System.out.println("Hello World!8");

        // Connection to database
        try {
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://psqlserv/but3";
            String nom = "gregoirelaunaybecueetu";
            String mdp = "moi";

            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, nom, mdp);
            System.out.println("Connexion Effective !");

            // print table names
            String query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connexion Impossible");
        }

        // Load file
        try {
            InputStream is = App.class.getClassLoader().getResourceAsStream("data.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Fichier Lu");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Impossible de lire le fichier");
        }
    }
}
