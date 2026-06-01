package VeriTabani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:kutuphane.db";
            conn = DriverManager.getConnection(url);
            System.out.println("SQLite veritabanı bağlantısı başarılı.");
        } catch (SQLException e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
        return conn;
    }
}