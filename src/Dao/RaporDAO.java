package Dao;

import VeriTabani.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RaporDAO {

    public List<String[]> enCokOkunanKitaplar() {
        List<String[]> liste = new ArrayList<>();
        String sorgu = "SELECT k.Baslik, COUNT(i.Islem_ID) as Sayi " +
                       "FROM Islemler i JOIN Kitaplar k ON i.Kitap_ID = k.Kitap_ID " +
                       "GROUP BY k.Kitap_ID ORDER BY Sayi DESC";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sorgu)) {
            while (rs.next()) {
                liste.add(new String[]{rs.getString("Baslik"), rs.getString("Sayi")});
            }
        } catch (Exception e) {
            System.out.println("Rapor hatası: " + e.getMessage());
        }
        return liste;
    }

    public List<String[]> kitapKurduUyeler() {
        List<String[]> liste = new ArrayList<>();
        String sorgu = "SELECT u.Ad || ' ' || u.Soyad as AdSoyad, COUNT(i.Islem_ID) as Sayi " +
                       "FROM Islemler i JOIN Kullanicilar u ON i.Kullanici_ID = u.Kullanici_ID " +
                       "WHERE u.Rol = 'OGRENCI' " +
                       "GROUP BY u.Kullanici_ID ORDER BY Sayi DESC";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sorgu)) {
            while (rs.next()) {
                liste.add(new String[]{rs.getString("AdSoyad"), rs.getString("Sayi")});
            }
        } catch (Exception e) {
            System.out.println("Rapor hatası: " + e.getMessage());
        }
        return liste;
    }

    public String ayinKitapKurdu() {
        String buAy = LocalDate.now().toString().substring(0, 7); // örn: "2026-05"
        String sorgu = "SELECT u.Ad || ' ' || u.Soyad as AdSoyad, COUNT(i.Islem_ID) as Sayi " +
                       "FROM Islemler i JOIN Kullanicilar u ON i.Kullanici_ID = u.Kullanici_ID " +
                       "WHERE u.Rol = 'OGRENCI' AND strftime('%Y-%m', i.Alis_Tarihi) = ? " +
                       "GROUP BY u.Kullanici_ID ORDER BY Sayi DESC LIMIT 1";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sorgu)) {
            pstmt.setString(1, buAy);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                return rs.getString("AdSoyad") + " (" + rs.getString("Sayi") + " kitap)";
        } catch (Exception e) {
            System.out.println("Ayın kitap kurdu hatası: " + e.getMessage());
        }
        return "Bu ay henüz kayıt yok.";
    }

    public List<String[]> ogrenciKarnesi(String ogrenciNo) {
        List<String[]> liste = new ArrayList<>();
        String buYil = String.valueOf(LocalDate.now().getYear());
        String sorgu = "SELECT k.Baslik, k.Yazar, k.Kategori, i.Alis_Tarihi, i.Iade_Tarihi " +
                       "FROM Islemler i " +
                       "JOIN Kitaplar k ON i.Kitap_ID = k.Kitap_ID " +
                       "JOIN Kullanicilar u ON i.Kullanici_ID = u.Kullanici_ID " +
                       "WHERE u.OgrenciNo = ? AND strftime('%Y', i.Alis_Tarihi) = ? " +
                       "ORDER BY i.Alis_Tarihi DESC";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sorgu)) {
            pstmt.setString(1, ogrenciNo);
            pstmt.setString(2, buYil);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String iade = rs.getString("Iade_Tarihi");
                liste.add(new String[]{
                    rs.getString("Baslik"),
                    rs.getString("Yazar"),
                    rs.getString("Kategori"),
                    rs.getString("Alis_Tarihi"),
                    iade != null ? iade : "Henüz iade edilmedi"
                });
            }
        } catch (Exception e) {
            System.out.println("Öğrenci karnesi hatası: " + e.getMessage());
        }
        return liste;
    }
}
