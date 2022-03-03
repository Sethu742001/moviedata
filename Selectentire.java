package net.sqlitejava;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Selectentire {

   
    private Connection connect() {
       
        String url = "jdbc:sqlite:C://sqlite/db/movie.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll(){
        String sql = "SELECT moviename,Actor,Actress,yearofrelease,director FROM movie";
                try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
         
            while (rs.next()) {
                System.out.println(rs.getString("moviename") +  "\t" + 
                                   rs.getString("Actor") + "\t" +
                                   rs.getString("Actress") + "\t" +
                                   rs.getInt("yearofrelease") + "\t" +
                                   rs.getString("director")
                                   );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        Selectentire app = new Selectentire();
        app.selectAll();
    }

}