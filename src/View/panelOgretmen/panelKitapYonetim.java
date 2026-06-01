package View.panelOgretmen;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Dao.KitapDAO;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import java.awt.Component;

public class panelKitapYonetim extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JLabel lblSistemDurumu;
	private JComboBox comboBox;

	public panelKitapYonetim() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(92, 126, 164));
		add(panel, BorderLayout.WEST);
		panel.setPreferredSize(new Dimension(300, 600));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(92, 126, 164));
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.weightx = 1.0;
		gbc_separator_1.ipadx = 1;
		gbc_separator_1.gridwidth = 2;
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.insets = new Insets(40, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 0;
		panel.add(separator_1, gbc_separator_1);

		JLabel lblNewLabel = new JLabel("Kitap Yönetim");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		
		
		
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weighty = 1.0;
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(20, 0, 30, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(92, 126, 164));
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.weightx = 1.0;
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 70, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		panel.add(separator, gbc_separator);

		JLabel lblNewLabel_1 = new JLabel("Başlık");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 10, 5, 10);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.weightx = 1.0;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 10, 20);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		panel.add(textField, gbc_textField);

		JLabel lblNewLabel_2 = new JLabel("Yazar");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 10, 5, 10);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 10, 20);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		panel.add(textField_1, gbc_textField_1);

		JLabel lblNewLabel_3 = new JLabel("Kategori");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 20, 10);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz", "Aşk (Romantik)", "Korku", "Gerilim",
				"Polisiye", "Bilimkurgu", "Fantastik", "Tarihi Roman", "Dram", "Mizah", "Distopya / Ütopya" }));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 10, 20);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		panel.add(comboBox, gbc_comboBox);

		JButton btnNewButton = new JButton("Kitap Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KitapDAO kd = new KitapDAO();
				String baslik = textField.getText();
				String yazar = textField_1.getText();
				String kategori = comboBox.getSelectedItem().toString();
				if (baslik.trim().isEmpty() || yazar.trim().isEmpty() || kategori.equals("Seçiniz")) {
					javax.swing.JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı",
							javax.swing.JOptionPane.WARNING_MESSAGE);
					return;
				}
				Model.Kitap yeniKitap = new Model.Kitap(baslik, yazar, kategori);
				if (kd.kitapEkle(yeniKitap)) {
					javax.swing.JOptionPane.showMessageDialog(null, "Kitap başarıyla eklendi!", "Başarılı",
							javax.swing.JOptionPane.INFORMATION_MESSAGE);
					tabloyuYenile();
					textField.setText("");
					textField_1.setText("");
					comboBox.setSelectedIndex(0);
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Kitap eklenirken hata oluştu!", "Hata",
							javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 20, 10, 20);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 6;
		panel.add(btnNewButton, gbc_btnNewButton);

		JButton btnKitabGncelle = new JButton("Kitabı Güncelle");
		btnKitabGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seciliSatir = table.getSelectedRow();
				if (seciliSatir == -1) {
					javax.swing.JOptionPane.showMessageDialog(null, "Güncellemek için tablodan bir kitap seçin!",
							"Uyarı", javax.swing.JOptionPane.WARNING_MESSAGE);
					return;
				}
				String baslik = textField.getText();
				String yazar = textField_1.getText();
				String kategori = comboBox.getSelectedItem().toString();
				if (baslik.trim().isEmpty() || yazar.trim().isEmpty() || kategori.equals("Seçiniz")) {
					javax.swing.JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı",
							javax.swing.JOptionPane.WARNING_MESSAGE);
					return;
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int kitapId = Integer.parseInt(model.getValueAt(seciliSatir, 0).toString());
				Model.Kitap guncelKitap = new Model.Kitap(baslik, yazar, kategori);
				guncelKitap.setKitapId(kitapId);
				KitapDAO kd = new KitapDAO();
				if (kd.kitapGuncelle(guncelKitap)) {
					javax.swing.JOptionPane.showMessageDialog(null, "Kitap başarıyla güncellendi!", "Başarılı",
							javax.swing.JOptionPane.INFORMATION_MESSAGE);
					tabloyuYenile();
					textField.setText("");
					textField_1.setText("");
					comboBox.setSelectedIndex(0);
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Kitap güncellenirken hata oluştu!", "Hata",
							javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnKitabGncelle = new GridBagConstraints();
		gbc_btnKitabGncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKitabGncelle.gridwidth = 2;
		gbc_btnKitabGncelle.insets = new Insets(0, 20, 30, 20);
		gbc_btnKitabGncelle.gridx = 0;
		gbc_btnKitabGncelle.gridy = 7;
		panel.add(btnKitabGncelle, gbc_btnKitabGncelle);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(92, 126, 164));
		GridBagConstraints gbc_separator_1_1 = new GridBagConstraints();
		gbc_separator_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1_1.ipadx = 1;
		gbc_separator_1_1.gridwidth = 2;
		gbc_separator_1_1.insets = new Insets(0, 0, 35, 0);
		gbc_separator_1_1.gridx = 0;
		gbc_separator_1_1.gridy = 8;
		panel.add(separator_1_1, gbc_separator_1_1);

		// Sağ taraf: arama + tablo
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(92, 126, 164));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(92, 126, 164));
		panel_1.add(panel_2, BorderLayout.NORTH);

		JLabel lblNewLabel_4 = new JLabel("Kitap Ara:");
		panel_2.add(lblNewLabel_4);

		textField_2 = new JTextField();
		textField_2.setColumns(20);
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				javax.swing.table.TableRowSorter<DefaultTableModel> aramaMotoru = new javax.swing.table.TableRowSorter<>(
						model);
				table.setRowSorter(aramaMotoru);
				String arananKelime = textField_2.getText();
				if (arananKelime.trim().length() == 0) {
					aramaMotoru.setRowFilter(null);
				} else {
					aramaMotoru.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + arananKelime));
				}
			}
		});
		panel_2.add(textField_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(92, 126, 164));
		panel_1.add(panel_3, BorderLayout.SOUTH);
		lblSistemDurumu = new JLabel("Sistem Durumu: Toplam Kitap: 0 | Ödünçte Olan: 0");
		lblSistemDurumu.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_3.add(lblSistemDurumu);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel_1.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setBackground(new Color(92, 126, 164));
		table.setGridColor(new Color(122, 138, 153));
		table.setRowHeight(25);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seciliSatir = table.getSelectedRow();
				if (seciliSatir >= 0) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					textField.setText(model.getValueAt(seciliSatir, 1).toString());
					textField_1.setText(model.getValueAt(seciliSatir, 2).toString());
					comboBox.setSelectedItem(model.getValueAt(seciliSatir, 3).toString());
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int r = table.rowAtPoint(e.getPoint());
				if (r >= 0 && r < table.getRowCount()) {
					table.setRowSelectionInterval(r, r);
				}
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Kitap Adı", "Yazar", "Kategori", "Durum" }));
		scrollPane.setViewportView(table);

		JPopupMenu popupMenu = new JPopupMenu();
		table.setComponentPopupMenu(popupMenu);
		scrollPane.setComponentPopupMenu(popupMenu);

		JMenuItem mnıtmNewMenuItem = new JMenuItem("Sil");
		mnıtmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seciliSatir = table.getSelectedRow();
				if (seciliSatir != -1) {
					int cevap = javax.swing.JOptionPane.showConfirmDialog(null,
							"Bu kitabı silmek istediğinize emin misiniz?", "Silme Onayı",
							javax.swing.JOptionPane.YES_NO_OPTION);

					if (cevap == javax.swing.JOptionPane.YES_OPTION) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						int kitapId = Integer.parseInt(model.getValueAt(seciliSatir, 0).toString());

						KitapDAO kd = new KitapDAO();
						if (kd.kitapSil(kitapId)) {
							javax.swing.JOptionPane.showMessageDialog(null, "Kitap başarıyla silindi!");
							tabloyuYenile();
						} else {
							javax.swing.JOptionPane.showMessageDialog(null, "Hata oluştu!", "Hata",
									javax.swing.JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		popupMenu.add(mnıtmNewMenuItem);

		tabloyuYenile();
	}

	public void tabloyuYenile() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		KitapDAO kd = new KitapDAO();
		java.util.List<Model.Kitap> kitapListesi = kd.tumKitaplariGetir();
		int toplamKitap = 0, oduncteKitap = 0;
		for (Model.Kitap k : kitapListesi) {
			model.addRow(new Object[] { k.getKitapId(), k.getBaslik(), k.getYazar(), k.getKategori(), k.getDurum() });
			toplamKitap++;
			if (!k.getDurum().equals("Rafta"))
				oduncteKitap++;
		}
		if (lblSistemDurumu != null)
			lblSistemDurumu.setText("Sistem Durumu: Toplam Kitap: " + toplamKitap + " | Ödünçte Olan: " + oduncteKitap);
	}
}