package fr.but3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 */
@WebServlet("/App")
public class App extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<head><title>CTP</title>");
        out.println("<META content=\"charset=UTF-8\"></head><body><center>");
        out.println("<h1>Test</h1>");
        out.println("</center></body></html>");
    }
    // public static void main(String[] args) {
    // // Simple print
    // System.out.println("Hello World!8");

    // // Connection to database
    // try {
    // String driver = "org.postgresql.Driver";
    // String url = "jdbc:postgresql://psqlserv/but3";
    // String nom = "gregoirelaunaybecueetu";
    // String mdp = "moi";

    // Class.forName(driver);
    // Connection connection = DriverManager.getConnection(url, nom, mdp);
    // System.out.println("Connexion Effective !");

    // // print table names
    // String query = "SELECT table_name FROM information_schema.tables WHERE
    // table_schema = 'public';";
    // Statement statement = connection.createStatement();
    // ResultSet resultSet = statement.executeQuery(query);
    // while (resultSet.next()) {
    // System.out.println(resultSet.getString(1));
    // }

    // connection.close();

    // } catch (Exception e) {
    // e.printStackTrace();
    // System.out.println("Connexion Impossible");
    // }

    // // Load file
    // try {
    // InputStream is = App.class.getClassLoader().getResourceAsStream("data.txt");
    // BufferedReader br = new BufferedReader(new InputStreamReader(is));
    // String line;
    // while ((line = br.readLine()) != null) {
    // System.out.println(line);
    // }
    // System.out.println("Fichier Lu");
    // } catch (IOException e) {
    // e.printStackTrace();
    // System.out.println("Impossible de lire le fichier");
    // }
    // }
}
