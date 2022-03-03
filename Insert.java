package net.sqlitejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/movie.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String name, String ac , String actress , int yr ,String dir) {
        String sql = "INSERT INTO movie(moviename,Actor,Actress,yearofrelease,director) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, ac);
            pstmt.setString(3, actress);
            pstmt.setInt(4, yr);
            pstmt.setString(5, dir);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Insert app = new Insert();
        app.insert("Nanban" , "Vijay" , "Ileana" , 2012 , "Shankar");
        app.insert("Thani oruvan" , "Jayam Ravi" , "Nayanthara" , 2015 , "Mohan Raja");
        app.insert("Soorarai pottru" , "Surya" , "Aparna" , 2020 , "Sudha");
	
    }

}