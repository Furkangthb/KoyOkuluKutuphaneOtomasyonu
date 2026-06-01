package Controller;

import Dao.KullaniciDAO;
import Model.Kullanici;
import View.GirisEkrani;
import View.OgrenciGirisi;
import View.OgretmenGirisi;

import javax.swing.JOptionPane;

public class KullaniciController {

	private GirisEkrani view;
	private KullaniciDAO dao;

	public KullaniciController(GirisEkrani view) {
		this.view = view;
		this.dao = new KullaniciDAO();
	}

	public void ogrenciGirisKontrol(String ogrenciNo, String sifre) {
		if (ogrenciNo.trim().isEmpty() || sifre.trim().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Öğrenci No ve Şifre boş bırakılamaz!", "Hata",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		Kullanici kullanici = dao.girisYap(ogrenciNo, sifre, "OGRENCI");

		if (kullanici != null) {
			view.dispose();
			OgrenciGirisi ogrenciEkrani = new OgrenciGirisi(kullanici);
			ogrenciEkrani.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(view, "Hatalı Öğrenci No veya Şifre!", "Giriş Başarısız",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void ogretmenGirisKontrol(String ogretmenNo, String sifre) {
		if (ogretmenNo.trim().isEmpty() || sifre.trim().isEmpty()) {
			JOptionPane.showMessageDialog(view, "Öğretmen No ve Şifre boş bırakılamaz!", "Hata",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		Kullanici kullanici = dao.girisYap(ogretmenNo, sifre, "OGRETMEN");

		if (kullanici != null) {
			view.dispose();
			OgretmenGirisi ogretmenEkrani = new OgretmenGirisi(kullanici);
			ogretmenEkrani.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(view, "Hatalı Öğretmen No veya Şifre!", "Giriş Başarısız",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
