package Dao;

import Model.OduncIslem;
import VeriTabani.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OduncDAO {

	public boolean oduncVer(int kitapId, String ogrenciNo) {
		String ekleSorgu = "INSERT INTO Islemler (Kitap_ID, Kullanici_ID, Alis_Tarihi, Teslim_Edildi_Mi) "
				+ "VALUES (?, (SELECT Kullanici_ID FROM Kullanicilar WHERE OgrenciNo = ?), ?, 0)";

		String guncelleSorgu = "UPDATE Kitaplar SET Durum = 'Ödünçte' WHERE Kitap_ID = ?";

		try (Connection conn = DBConnection.connect()) {
			conn.setAutoCommit(false);

			try (PreparedStatement pstmtEkle = conn.prepareStatement(ekleSorgu);
					PreparedStatement pstmtGuncelle = conn.prepareStatement(guncelleSorgu)) {

				pstmtEkle.setInt(1, kitapId);
				pstmtEkle.setString(2, ogrenciNo);
				pstmtEkle.setString(3, LocalDate.now().toString());
				pstmtEkle.executeUpdate();

				pstmtGuncelle.setInt(1, kitapId);
				pstmtGuncelle.executeUpdate();

				conn.commit();
				return true;
			} catch (Exception ex) {
				conn.rollback();
				System.out.println("Ödünç verme hatası: " + ex.getMessage());
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public boolean iadeAl(int islemId, int kitapId) {
		String guncelleOdunc = "UPDATE Islemler SET Iade_Tarihi = ?, Teslim_Edildi_Mi = 1 WHERE Islem_ID = ?";
		String guncelleKitap = "UPDATE Kitaplar SET Durum = 'Rafta' WHERE Kitap_ID = ?";

		try (Connection conn = DBConnection.connect()) {
			conn.setAutoCommit(false);

			try (PreparedStatement pstmtOdunc = conn.prepareStatement(guncelleOdunc);
					PreparedStatement pstmtKitap = conn.prepareStatement(guncelleKitap)) {

				pstmtOdunc.setString(1, LocalDate.now().toString());
				pstmtOdunc.setInt(2, islemId);
				pstmtOdunc.executeUpdate();

				pstmtKitap.setInt(1, kitapId);
				pstmtKitap.executeUpdate();

				conn.commit();
				return true;
			} catch (Exception ex) {
				conn.rollback();
				System.out.println("İade alma hatası: " + ex.getMessage());
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public List<OduncIslem> aktifOduncleriGetir() {
		List<OduncIslem> liste = new ArrayList<>();
		String sorgu = "SELECT i.Islem_ID, i.Kitap_ID, i.Kullanici_ID, i.Alis_Tarihi, i.Teslim_Edildi_Mi, "
				+ "k.Baslik, u.Ad, u.Soyad, u.OgrenciNo " + "FROM Islemler i "
				+ "INNER JOIN Kitaplar k ON i.Kitap_ID = k.Kitap_ID "
				+ "INNER JOIN Kullanicilar u ON i.Kullanici_ID = u.Kullanici_ID " + "WHERE i.Teslim_Edildi_Mi = 0";

		try (Connection conn = DBConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sorgu)) {

			while (rs.next()) {
				OduncIslem o = new OduncIslem();
				o.setIslemId(rs.getInt("Islem_ID"));
				o.setKitapId(rs.getInt("Kitap_ID"));
				o.setKullaniciId(rs.getInt("Kullanici_ID"));
				o.setAlisTarihi(rs.getString("Alis_Tarihi"));
				o.setTeslimEdildiMi(rs.getInt("Teslim_Edildi_Mi"));

				o.setKitapBaslik(rs.getString("Baslik"));
				o.setUyeAdSoyad(rs.getString("Ad") + " " + rs.getString("Soyad"));
				o.setOgrenciNo(rs.getString("OgrenciNo"));

				liste.add(o);
			}
		} catch (Exception e) {
			System.out.println("Aktif ödünçleri getirme hatası: " + e.getMessage());
		}
		return liste;
	}
	// 4. ÖĞRENCİNİN KENDİ KİTAP GEÇMİŞİNİ GETİR
    public List<OduncIslem> ogrencininKitaplariniGetir(String ogrenciNo) {
        List<OduncIslem> liste = new ArrayList<>();
        // Sadece giriş yapan öğrencinin (WHERE u.OgrenciNo = ?) işlemlerini çekiyoruz
        String sorgu = "SELECT i.Islem_ID, k.Baslik, i.Alis_Tarihi, i.Iade_Tarihi, i.Teslim_Edildi_Mi " +
                       "FROM Islemler i " +
                       "JOIN Kitaplar k ON i.Kitap_ID = k.Kitap_ID " +
                       "JOIN Kullanicilar u ON i.Kullanici_ID = u.Kullanici_ID " +
                       "WHERE u.OgrenciNo = ? " +
                       "ORDER BY i.Islem_ID DESC"; // En son aldıkları en üstte görünsün

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sorgu)) {
             
            pstmt.setString(1, ogrenciNo);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                OduncIslem o = new OduncIslem();
                o.setIslemId(rs.getInt("Islem_ID"));
                o.setKitapBaslik(rs.getString("Baslik"));
                o.setAlisTarihi(rs.getString("Alis_Tarihi"));
                o.setIadeTarihi(rs.getString("Iade_Tarihi"));
                o.setTeslimEdildiMi(rs.getInt("Teslim_Edildi_Mi"));
                liste.add(o);
            }
        } catch (Exception e) {
            System.out.println("Öğrenci geçmişi getirme hatası: " + e.getMessage());
        }
        return liste;
    }
}