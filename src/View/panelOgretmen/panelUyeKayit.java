package View.panelOgretmen;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Dao.KullaniciDAO;
import javax.swing.JSeparator;
import java.awt.Color;

public class panelUyeKayit extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtUyeNo;
	private JTextField txtAdSoyad;
	private JTextField txtSifre;
	private JComboBox cmbRol;
	private JTable tabloUyeler;
	private JTextField textField;

	public panelUyeKayit() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(300, 600));
		add(panel_4, BorderLayout.WEST);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(92, 126, 164));
		GridBagConstraints gbc_separator_1_1 = new GridBagConstraints();
		gbc_separator_1_1.weightx = 1.0;
		gbc_separator_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1_1.gridwidth = 3;
		gbc_separator_1_1.insets = new Insets(40, 0, 5, 0);
		gbc_separator_1_1.gridx = 0;
		gbc_separator_1_1.gridy = 0;
		panel_4.add(separator_1_1, gbc_separator_1_1);

		JLabel lblUyeBaslik = new JLabel("Üye Kayıt İşlemleri");
		lblUyeBaslik.setFont(new Font("Dialog", Font.BOLD, 18));
		GridBagConstraints gbc_lblUyeBaslik = new GridBagConstraints();
		gbc_lblUyeBaslik.insets = new Insets(20, 0, 20, 0);
		gbc_lblUyeBaslik.weighty = 1.0;
		gbc_lblUyeBaslik.weightx = 1.0;
		gbc_lblUyeBaslik.gridwidth = 2;
		gbc_lblUyeBaslik.gridx = 0;
		gbc_lblUyeBaslik.gridy = 1;
		panel_4.add(lblUyeBaslik, gbc_lblUyeBaslik);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(92, 126, 164));
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.gridwidth = 3;
		gbc_separator_1.weightx = 1.0;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 2;
		panel_4.add(separator_1, gbc_separator_1);

		JLabel lblNo = new JLabel("Kullanıcı No:");
		GridBagConstraints gbc_lblNo = new GridBagConstraints();
		gbc_lblNo.anchor = GridBagConstraints.EAST;
		gbc_lblNo.insets = new Insets(0, 10, 10, 5);
		gbc_lblNo.gridx = 0; gbc_lblNo.gridy = 3;
		panel_4.add(lblNo, gbc_lblNo);

		txtUyeNo = new JTextField();
		GridBagConstraints gbc_txtUyeNo = new GridBagConstraints();
		gbc_txtUyeNo.insets = new Insets(0, 0, 10, 20);
		gbc_txtUyeNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUyeNo.gridx = 1; gbc_txtUyeNo.gridy = 3;
		panel_4.add(txtUyeNo, gbc_txtUyeNo);
		txtUyeNo.setColumns(10);

		JLabel lblAd = new JLabel("Ad Soyad:");
		GridBagConstraints gbc_lblAd = new GridBagConstraints();
		gbc_lblAd.anchor = GridBagConstraints.EAST;
		gbc_lblAd.insets = new Insets(0, 10, 10, 5);
		gbc_lblAd.gridx = 0; gbc_lblAd.gridy = 4;
		panel_4.add(lblAd, gbc_lblAd);

		txtAdSoyad = new JTextField();
		GridBagConstraints gbc_txtAdSoyad = new GridBagConstraints();
		gbc_txtAdSoyad.insets = new Insets(0, 0, 10, 20);
		gbc_txtAdSoyad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdSoyad.gridx = 1; gbc_txtAdSoyad.gridy = 4;
		panel_4.add(txtAdSoyad, gbc_txtAdSoyad);
		txtAdSoyad.setColumns(10);

		JLabel lblSifre = new JLabel("Şifre:");
		GridBagConstraints gbc_lblSifre = new GridBagConstraints();
		gbc_lblSifre.anchor = GridBagConstraints.EAST;
		gbc_lblSifre.insets = new Insets(0, 10, 10, 5);
		gbc_lblSifre.gridx = 0; gbc_lblSifre.gridy = 5;
		panel_4.add(lblSifre, gbc_lblSifre);

		txtSifre = new JTextField();
		GridBagConstraints gbc_txtSifre = new GridBagConstraints();
		gbc_txtSifre.insets = new Insets(0, 0, 10, 20);
		gbc_txtSifre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSifre.gridx = 1; gbc_txtSifre.gridy = 5;
		panel_4.add(txtSifre, gbc_txtSifre);
		txtSifre.setColumns(10);

		JLabel lblRol = new JLabel("Rol:");
		GridBagConstraints gbc_lblRol = new GridBagConstraints();
		gbc_lblRol.anchor = GridBagConstraints.EAST;
		gbc_lblRol.insets = new Insets(0, 10, 20, 5);
		gbc_lblRol.gridx = 0; gbc_lblRol.gridy = 6;
		panel_4.add(lblRol, gbc_lblRol);

		cmbRol = new JComboBox();
		cmbRol.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz...", "Öğrenci", "Öğretmen" }));
		GridBagConstraints gbc_cmbRol = new GridBagConstraints();
		gbc_cmbRol.insets = new Insets(0, 0, 20, 20);
		gbc_cmbRol.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbRol.gridx = 1; gbc_cmbRol.gridy = 6;
		panel_4.add(cmbRol, gbc_cmbRol);

		JButton btnUyeEkle = new JButton("Yeni Üye Ekle");
		btnUyeEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no = txtUyeNo.getText(), adSoyad = txtAdSoyad.getText();
				String sifre = txtSifre.getText(), rol = cmbRol.getSelectedItem().toString();
				if (no.trim().isEmpty() || adSoyad.trim().isEmpty() || sifre.trim().isEmpty() || rol.equals("Seçiniz...")) {
					javax.swing.JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı", javax.swing.JOptionPane.WARNING_MESSAGE);
					return;
				}
				KullaniciDAO dao = new KullaniciDAO();
				if (dao.kullaniciEkle(new Model.Kullanici(0, no, adSoyad, sifre, rol))) {
					javax.swing.JOptionPane.showMessageDialog(null, "Üye başarıyla eklendi!", "Başarılı", javax.swing.JOptionPane.INFORMATION_MESSAGE);
					uyeleriYenile(); formuTemizle();
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Üye eklenirken hata oluştu!", "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnUyeEkle = new GridBagConstraints();
		gbc_btnUyeEkle.insets = new Insets(0, 20, 10, 20);
		gbc_btnUyeEkle.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUyeEkle.gridwidth = 2; gbc_btnUyeEkle.gridx = 0; gbc_btnUyeEkle.gridy = 7;
		panel_4.add(btnUyeEkle, gbc_btnUyeEkle);

		JButton btnUyeGuncelle = new JButton("Seçili Üyeyi Güncelle");
		btnUyeGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secili = tabloUyeler.getSelectedRow();
				if (secili == -1) { javax.swing.JOptionPane.showMessageDialog(null, "Tablodan bir üye seçin!"); return; }
				String no = txtUyeNo.getText(), adSoyad = txtAdSoyad.getText();
				String sifre = txtSifre.getText(), rol = cmbRol.getSelectedItem().toString();
				if (no.trim().isEmpty() || adSoyad.trim().isEmpty() || sifre.trim().isEmpty() || rol.equals("Seçiniz...")) {
					javax.swing.JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı", javax.swing.JOptionPane.WARNING_MESSAGE);
					return;
				}
				int id = Integer.parseInt(tabloUyeler.getValueAt(secili, 0).toString());
				KullaniciDAO dao = new KullaniciDAO();
				if (dao.kullaniciGuncelle(new Model.Kullanici(id, no, adSoyad, sifre, rol))) {
					javax.swing.JOptionPane.showMessageDialog(null, "Üye başarıyla güncellendi!", "Başarılı", javax.swing.JOptionPane.INFORMATION_MESSAGE);
					uyeleriYenile(); formuTemizle();
				}
			}
		});
		GridBagConstraints gbc_btnUyeGuncelle = new GridBagConstraints();
		gbc_btnUyeGuncelle.insets = new Insets(0, 20, 10, 20);
		gbc_btnUyeGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUyeGuncelle.gridwidth = 2; gbc_btnUyeGuncelle.gridx = 0; gbc_btnUyeGuncelle.gridy = 8;
		panel_4.add(btnUyeGuncelle, gbc_btnUyeGuncelle);

		JButton btnUyeSil = new JButton("Seçili Üyeyi Sil");
		btnUyeSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secili = tabloUyeler.getSelectedRow();
				if (secili == -1) { javax.swing.JOptionPane.showMessageDialog(null, "Tablodan bir üye seçin!"); return; }
				int cevap = javax.swing.JOptionPane.showConfirmDialog(null, "Bu üyeyi silmek istediğinize emin misiniz?", "Silme Onayı", javax.swing.JOptionPane.YES_NO_OPTION);
				if (cevap == javax.swing.JOptionPane.YES_OPTION) {
					int id = Integer.parseInt(tabloUyeler.getValueAt(secili, 0).toString());
					KullaniciDAO dao = new KullaniciDAO();
					if (dao.kullaniciSil(id)) {
						javax.swing.JOptionPane.showMessageDialog(null, "Üye başarıyla silindi!", "Başarılı", javax.swing.JOptionPane.INFORMATION_MESSAGE);
						uyeleriYenile(); formuTemizle();
					}
				}
			}
		});
		GridBagConstraints gbc_btnUyeSil = new GridBagConstraints();
		gbc_btnUyeSil.anchor = GridBagConstraints.NORTH;
		gbc_btnUyeSil.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUyeSil.gridwidth = 2;
		gbc_btnUyeSil.insets = new Insets(0, 20, 20, 20);
		gbc_btnUyeSil.gridx = 0; gbc_btnUyeSil.gridy = 9;
		panel_4.add(btnUyeSil, gbc_btnUyeSil);

		JPanel panel_5 = new JPanel();
		add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_5.add(scrollPane_1, BorderLayout.CENTER);

		tabloUyeler = new JTable();
		tabloUyeler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int secili = tabloUyeler.getSelectedRow();
				if (secili >= 0) {
					DefaultTableModel model = (DefaultTableModel) tabloUyeler.getModel();
					txtUyeNo.setText(model.getValueAt(secili, 1).toString());
					txtAdSoyad.setText(model.getValueAt(secili, 2).toString());
					txtSifre.setText(model.getValueAt(secili, 3).toString());
					cmbRol.setSelectedItem(model.getValueAt(secili, 4).toString());
				}
			}
		});
		tabloUyeler.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Kullanıcı No", "Ad Soyad", "Şifre", "Rol" }));
		scrollPane_1.setViewportView(tabloUyeler);
		
		JPanel panel_2 = new JPanel();
		panel_5.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_4 = new JLabel("Kitap Ara:");
		panel_2.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setColumns(20);
		panel_2.add(textField);

		uyeleriYenile();
	}

	public void uyeleriYenile() {
		DefaultTableModel model = (DefaultTableModel) tabloUyeler.getModel();
		model.setRowCount(0);
		KullaniciDAO dao = new KullaniciDAO();
		for (Model.Kullanici k : dao.tumKullanicilariGetir())
			model.addRow(new Object[] { k.getId(), k.getKullaniciNo(), k.getAdSoyad(), k.getSifre(), k.getRol() });
	}

	private void formuTemizle() {
		txtUyeNo.setText(""); txtAdSoyad.setText(""); txtSifre.setText(""); cmbRol.setSelectedIndex(0);
	}
}