package VeriTabani;

import java.sql.Connection;
import java.sql.Statement;

public class DBHelper {

    public static void tablolariOlustur() {
        
        String sqlKullanicilar = "CREATE TABLE IF NOT EXISTS Kullanicilar (\n"
                + "    Kullanici_ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    Ad TEXT NOT NULL,\n"
                + "    Soyad TEXT NOT NULL,\n"
                + "    OgrenciNo TEXT UNIQUE,\n" 
                + "    Sifre TEXT NOT NULL,\n"
                + "    Rol TEXT NOT NULL,\n" // 
                + "    Tema_Rengi TEXT DEFAULT '#1e293b'\n"
                + ");";

        // 2. Kitaplar Tablosu
        String sqlKitaplar = "CREATE TABLE IF NOT EXISTS Kitaplar (\n"
                + "    Kitap_ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    Baslik TEXT NOT NULL,\n"
                + "    Yazar TEXT NOT NULL,\n"
                + "    Kategori TEXT NOT NULL,\n"
                + "    Durum TEXT DEFAULT 'Rafta'\n" 
                + ");";

        String sqlIslemler = "CREATE TABLE IF NOT EXISTS Islemler (\n"
                + "    Islem_ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    Kitap_ID INTEGER,\n"
                + "    Kullanici_ID INTEGER,\n"
                + "    Alis_Tarihi TEXT NOT NULL,\n"
                + "    Iade_Tarihi TEXT,\n"
                + "    Teslim_Edildi_Mi INTEGER DEFAULT 0,\n" 
                + "    FOREIGN KEY(Kitap_ID) REFERENCES Kitaplar(Kitap_ID),\n"
                + "    FOREIGN KEY(Kullanici_ID) REFERENCES Kullanicilar(Kullanici_ID)\n"
                + ");";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement()) {
             
            stmt.execute("PRAGMA foreign_keys = ON;");
            
            stmt.execute(sqlKullanicilar);
            stmt.execute(sqlKitaplar);
            stmt.execute(sqlIslemler);
            
            System.out.println("Tüm tablolar başarıyla oluşturuldu veya zaten mevcut.");
            
        } catch (Exception e) {
            System.out.println("Tablo oluşturma hatası: " + e.getMessage());
        }
    }
    
    public static void testKullanicilariniEkle() {
        // Öğretmen hesabı
        String ogretmenEkle = "INSERT OR IGNORE INTO Kullanicilar (Ad, Soyad, OgrenciNo, Sifre, Rol) "
                + "VALUES ('Sibel', 'Birtane Akar', 'admin', 'admin123', 'OGRETMEN');";
        String ogretmenEkle2 = "INSERT OR IGNORE INTO Kullanicilar (Ad, Soyad, OgrenciNo, Sifre, Rol) "
                + "VALUES ('1', '1', '1', '1', 'OGRETMEN');";
        // Öğrenci hesabı 
        String ogrenciEkle = "INSERT OR IGNORE INTO Kullanicilar (Ad, Soyad, OgrenciNo, Sifre, Rol) "
                + "VALUES ('Furkan', 'Yüksel', '102030', '1234', 'OGRENCI');";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(ogretmenEkle);
            stmt.execute(ogrenciEkle);
            stmt.execute(ogretmenEkle2);
            System.out.println("Test kullanıcıları (Öğretmen ve Öğrenci) başarıyla eklendi!");
            
        } catch (Exception e) {
            System.out.println("Kullanıcı ekleme hatası: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        tablolariOlustur();
        testKullanicilariniEkle();
    }
}