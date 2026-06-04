package Dao;

import Model.Kitap;
import VeriTabani.DBConnection; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KitapDAO {

    public boolean kitapEkle(Kitap kitap) {
        String sorgu = "INSERT INTO Kitaplar (Baslik, Yazar, Kategori, Durum) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sorgu)) {
            
            pstmt.setString(1, kitap.getBaslik());
            pstmt.setString(2, kitap.getYazar());
            pstmt.setString(3, kitap.getKategori());
            pstmt.setString(4, kitap.getDurum());
            
            pstmt.executeUpdate();
            return true; 
            
        } catch (Exception e) {
            System.out.println("Kitap ekleme hatası: " + e.getMessage());
            return false; 
        }
    }

    public List<Kitap> tumKitaplariGetir() {
        List<Kitap> kitapListesi = new ArrayList<>();
        String sorgu = "SELECT * FROM Kitaplar";
        
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sorgu)) {
            
            while (rs.next()) {
                Kitap k = new Kitap();
                k.setKitapId(rs.getInt("Kitap_ID"));
                k.setBaslik(rs.getString("Baslik"));
                k.setYazar(rs.getString("Yazar"));
                k.setKategori(rs.getString("Kategori"));
                k.setDurum(rs.getString("Durum"));
                
                kitapListesi.add(k);
            }
        } catch (Exception e) {
            System.out.println("Kitapları getirme hatası: " + e.getMessage());
        }
        return kitapListesi;
    }

    public boolean kitapSil(int kitapId) {
        String aktifKontrol = "SELECT COUNT(*) AS Sayi FROM Islemler WHERE Kitap_ID = ? AND Teslim_Edildi_Mi = 0";
        String sorgu = "DELETE FROM Kitaplar WHERE Kitap_ID = ?";

        try (Connection conn = DBConnection.connect()) {
            if (conn == null)
                return false;

            try (PreparedStatement pstmtKontrol = conn.prepareStatement(aktifKontrol)) {
                pstmtKontrol.setInt(1, kitapId);
                ResultSet rs = pstmtKontrol.executeQuery();
                if (rs.next() && rs.getInt("Sayi") > 0) {
                    System.out.println("Kitap silme hatası: Kitap şu an ödünçte.");
                    return false;
                }
            }

            try (PreparedStatement pstmt = conn.prepareStatement(sorgu)) {
                pstmt.setInt(1, kitapId);
                return pstmt.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Kitap silme hatası: " + e.getMessage());
            return false;
        }
    }
    public boolean kitapGuncelle(Kitap kitap) {
        String sorgu = "UPDATE Kitaplar SET Baslik = ?, Yazar = ?, Kategori = ? WHERE Kitap_ID = ?";
        
        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sorgu)) {
            
            pstmt.setString(1, kitap.getBaslik());
            pstmt.setString(2, kitap.getYazar());
            pstmt.setString(3, kitap.getKategori());
            pstmt.setInt(4, kitap.getKitapId()); 
            
            pstmt.executeUpdate();
            return true;
            
        } catch (Exception e) {
            System.out.println("Kitap güncelleme hatası: " + e.getMessage());
            return false;
        }
    }
}