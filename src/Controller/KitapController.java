package Controller;

import Dao.KitapDAO;
import Model.Kitap;
import javax.swing.JOptionPane;
import java.util.List;

public class KitapController {

	private KitapDAO dao;

	public KitapController() {
		this.dao = new KitapDAO();
	}

	public boolean kitapEkle(String baslik, String yazar, String kategori) {
		if (baslik.trim().isEmpty() || yazar.trim().isEmpty() || kategori.equals("Seçiniz")) {
			JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun ve bir kategori seçin!", "Uyarı",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		Kitap kitap = new Kitap(baslik, yazar, kategori);
		boolean basarili = dao.kitapEkle(kitap);
		if (basarili) {
			JOptionPane.showMessageDialog(null, "Kitap başarıyla eklendi!", "Başarılı",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Kitap eklenirken bir hata oluştu!", "Hata",
					JOptionPane.ERROR_MESSAGE);
		}
		return basarili;
	}

	public boolean kitapGuncelle(int kitapId, String baslik, String yazar, String kategori) {
		if (baslik.trim().isEmpty() || yazar.trim().isEmpty() || kategori.equals("Seçiniz")) {
			JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		Kitap kitap = new Kitap(baslik, yazar, kategori);
		kitap.setKitapId(kitapId);
		boolean basarili = dao.kitapGuncelle(kitap);
		if (basarili) {
			JOptionPane.showMessageDialog(null, "Kitap başarıyla güncellendi!", "Başarılı",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Kitap güncellenirken bir hata oluştu!", "Hata",
					JOptionPane.ERROR_MESSAGE);
		}
		return basarili;
	}

	public boolean kitapSil(int kitapId) {
		int cevap = JOptionPane.showConfirmDialog(null, "Bu kitabı silmek istediğinize emin misiniz?",
				"Silme Onayı", JOptionPane.YES_NO_OPTION);
		if (cevap != JOptionPane.YES_OPTION) return false;

		boolean basarili = dao.kitapSil(kitapId);
		if (basarili) {
			JOptionPane.showMessageDialog(null, "Kitap başarıyla silindi!", "Başarılı",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Kitap silinirken bir hata oluştu!", "Hata",
					JOptionPane.ERROR_MESSAGE);
		}
		return basarili;
	}

	public List<Kitap> tumKitaplariGetir() {
		return dao.tumKitaplariGetir();
	}
}
