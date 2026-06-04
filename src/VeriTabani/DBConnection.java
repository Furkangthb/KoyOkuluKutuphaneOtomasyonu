package VeriTabani;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static final String DB_DOSYA = "kutuphane.db";

    public static String veritabaniYolu() {
        return new File(DB_DOSYA).getAbsolutePath();
    }

    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + veritabaniYolu();
            conn = DriverManager.getConnection(url);
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("PRAGMA foreign_keys = ON");
            }
        } catch (SQLException e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
        return conn;
    }
}