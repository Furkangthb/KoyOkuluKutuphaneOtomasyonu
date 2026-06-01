package Controller;

import Dao.KullaniciDAO;
import Model.Kullanici;
import javax.swing.JOptionPane;
import java.util.List;

public class UyeController {

	private KullaniciDAO dao;

	public UyeController() {
		this.dao = new KullaniciDAO();
	}

	public boolean uyeEkle(String no, String adSoyad, String sifre, String rol) {
		if (no.trim().isEmpty() || adSoyad.trim().isEmpty()
				|| sifre.trim().isEmpty() || rol.equals("Seçiniz...")) {
			JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		Kullanici uye = new Kullanici(0, no, adSoyad, sifre, rol);
		boolean basarili = dao.kullaniciEkle(uye);
		if (basarili) {
			JOptionPane.showMessageDialog(null, "Üye başarıyla eklendi!", "Başarılı",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Üye eklenirken hata oluştu! (No zaten kayıtlı olabilir)",
					"Hata", JOptionPane.ERROR_MESSAGE);
		}
		return basarili;
	}

	public boolean uyeGuncelle(int id, String no, String adSoyad, String sifre, String rol) {
		if (no.trim().isEmpty() || adSoyad.trim().isEmpty()
				|| sifre.trim().isEmpty() || rol.equals("Seçiniz...")) {
			JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		Kullanici uye = new Kullanici(id, no, adSoyad, sifre, rol);
		boolean basarili = dao.kullaniciGuncelle(uye);
		if (basarili) {
			JOptionPane.showMessageDialog(null, "Üye başarıyla güncellendi!", "Başarılı",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Üye güncellenirken hata oluştu!", "Hata",
					JOptionPane.ERROR_MESSAGE);
		}
		return basarili;
	}

	public boolean uyeSil(int id) {
		int cevap = JOptionPane.showConfirmDialog(null, "Bu üyeyi silmek istediğinize emin misiniz?",
				"Silme Onayı", JOptionPane.YES_NO_OPTION);
		if (cevap != JOptionPane.YES_OPTION) return false;

		boolean basarili = dao.kullaniciSil(id);
		if (basarili) {
			JOptionPane.showMessageDialog(null, "Üye başarıyla silindi!", "Başarılı",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Üye silinirken hata oluştu!", "Hata",
					JOptionPane.ERROR_MESSAGE);
		}
		return basarili;
	}

	public List<Kullanici> tumUyeleriGetir() {
		return dao.tumKullanicilariGetir();
	}
}
