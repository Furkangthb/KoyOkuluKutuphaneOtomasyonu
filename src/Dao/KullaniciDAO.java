package Dao;

import Model.Kullanici;
import VeriTabani.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KullaniciDAO {

	private final String URL = "jdbc:sqlite:kutuphane.db";

	private Connection baglantiAc() throws SQLException {
		return DriverManager.getConnection(URL);
	}

	// --- MEVCUT GİRİŞ YAPMA METODUN (HİÇ DOKUNULMADI) ---
	public Kullanici girisYap(String girisNo, String sifre, String rol) {
		Kullanici aktifKullanici = null;
		String sorgu = "SELECT * FROM Kullanicilar WHERE OgrenciNo = ? AND Sifre = ? AND Rol = ?";

		try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sorgu)) {

			pstmt.setString(1, girisNo);
			pstmt.setString(2, sifre);
			pstmt.setString(3, rol);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				aktifKullanici = new Kullanici();
				aktifKullanici.setId(rs.getInt("Kullanici_ID"));
				aktifKullanici.setKullaniciNo(rs.getString("OgrenciNo"));

				aktifKullanici.setAdSoyad(rs.getString("Ad") + " " + rs.getString("Soyad"));

				aktifKullanici.setSifre(rs.getString("Sifre"));
				aktifKullanici.setRol(rs.getString("Rol"));
			}

		} catch (Exception e) {
			System.out.println("Giriş İşlemi Veritabanı Hatası: " + e.getMessage());
		}

		return aktifKullanici;
	}


	public boolean kullaniciEkle(Kullanici kullanici) {
		String sorgu = "INSERT INTO Kullanicilar (OgrenciNo, Ad, Soyad, Sifre, Rol) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sorgu)) {

			pstmt.setString(1, kullanici.getKullaniciNo());

			String tamAd = kullanici.getAdSoyad().trim();
			String ad = tamAd;
			String soyad = "";
			int sonBosluk = tamAd.lastIndexOf(" ");
			if (sonBosluk != -1) {
				ad = tamAd.substring(0, sonBosluk);
				soyad = tamAd.substring(sonBosluk + 1);
			}

			pstmt.setString(2, ad);
			pstmt.setString(3, soyad);
			pstmt.setString(4, kullanici.getSifre());
			pstmt.setString(5, kullanici.getRol());

			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Kullanıcı ekleme hatası: " + e.getMessage());
			return false;
		}
	}

	public List<Kullanici> tumKullanicilariGetir() {
		List<Kullanici> kullaniciListesi = new ArrayList<>();
		String sorgu = "SELECT * FROM Kullanicilar";

		try (Connection conn = DBConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sorgu)) {

			while (rs.next()) {
				Kullanici k = new Kullanici();
				k.setId(rs.getInt("Kullanici_ID"));
				k.setKullaniciNo(rs.getString("OgrenciNo"));
				k.setAdSoyad(rs.getString("Ad") + " " + rs.getString("Soyad"));
				k.setSifre(rs.getString("Sifre"));
				k.setRol(rs.getString("Rol"));

				kullaniciListesi.add(k);
			}
		} catch (Exception e) {
			System.out.println("Kullanıcıları getirme hatası: " + e.getMessage());
		}
		return kullaniciListesi;
	}

	public boolean kullaniciGuncelle(Kullanici kullanici) {
		String sorgu = "UPDATE Kullanicilar SET OgrenciNo = ?, Ad = ?, Soyad = ?, Sifre = ?, Rol = ? WHERE Kullanici_ID = ?";

		try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sorgu)) {

			pstmt.setString(1, kullanici.getKullaniciNo());

			String tamAd = kullanici.getAdSoyad().trim();
			String ad = tamAd;
			String soyad = "";
			int sonBosluk = tamAd.lastIndexOf(" ");
			if (sonBosluk != -1) {
				ad = tamAd.substring(0, sonBosluk);
				soyad = tamAd.substring(sonBosluk + 1);
			}

			pstmt.setString(2, ad);
			pstmt.setString(3, soyad);
			pstmt.setString(4, kullanici.getSifre());
			pstmt.setString(5, kullanici.getRol());
			pstmt.setInt(6, kullanici.getId());

			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Kullanıcı güncelleme hatası: " + e.getMessage());
			return false;
		}
	}

	public boolean kullaniciSil(int id) {
		String sorgu = "DELETE FROM Kullanicilar WHERE Kullanici_ID = ?";

		try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sorgu)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Kullanıcı silme hatası: " + e.getMessage());
			return false;
		}
	}
}