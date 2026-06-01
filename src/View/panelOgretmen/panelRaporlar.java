
package View.panelOgretmen;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Dao.RaporDAO;

public class panelRaporlar extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable table_3;
	private JTextField txtOgrenciNo;
	private JTable tableKarne;
	private DefaultTableModel karneModel;

	public panelRaporlar() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		add(panel_6, BorderLayout.NORTH);

		JButton btnNewButton_4 = new JButton("En Çok Okunanlar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m = (DefaultTableModel) table_3.getModel();
				m.setRowCount(0);
				for (String[] satir : new RaporDAO().enCokOkunanKitaplar())
					m.addRow(satir);
			}
		});
		panel_6.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Kitap Kurdu Üyeler");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m = (DefaultTableModel) table_3.getModel();
				m.setRowCount(0);
				for (String[] satir : new RaporDAO().kitapKurduUyeler())
					m.addRow(satir);
			}
		});
		panel_6.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Ayın Kitap Kurdu");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kurdu = new RaporDAO().ayinKitapKurdu();
				javax.swing.JOptionPane.showMessageDialog(null,
						"Bu Ayın Kitap Kurdu: " + kurdu, "Ayın Kitap Kurdu",
						javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panel_6.add(btnNewButton_6);

		JPanel panelKarne = new JPanel();
		panelKarne.setLayout(new BorderLayout(0, 0));
		add(panelKarne, BorderLayout.CENTER);

		JPanel panelKarneUst = new JPanel();
		panelKarne.add(panelKarneUst, BorderLayout.NORTH);

		JLabel lblKarneBaslik = new JLabel("Öğrenci Karnesi - No:");
		panelKarneUst.add(lblKarneBaslik);

		txtOgrenciNo = new JTextField(10);
		panelKarneUst.add(txtOgrenciNo);

		JButton btnKarneGetir = new JButton("Getir");
		panelKarneUst.add(btnKarneGetir);

		JButton btnTxtExport = new JButton("TXT Aktar");
		panelKarneUst.add(btnTxtExport);

		JButton btnCsvExport = new JButton("CSV Aktar");
		panelKarneUst.add(btnCsvExport);

		karneModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Kitap Adı", "Yazar", "Kategori", "Alış Tarihi", "İade Tarihi" }) {
			public boolean isCellEditable(int r, int c) { return false; }
		};
		tableKarne = new JTable(karneModel);
		tableKarne.setRowHeight(24);
		JScrollPane scrollKarne = new JScrollPane(tableKarne);
		panelKarne.add(scrollKarne, BorderLayout.CENTER);

		btnKarneGetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no = txtOgrenciNo.getText().trim();
				if (no.isEmpty()) {
					javax.swing.JOptionPane.showMessageDialog(null, "Öğrenci No girin!", "Uyarı",
							javax.swing.JOptionPane.WARNING_MESSAGE);
					return;
				}
				karneModel.setRowCount(0);
				java.util.List<String[]> liste = new RaporDAO().ogrenciKarnesi(no);
				if (liste.isEmpty()) {
					javax.swing.JOptionPane.showMessageDialog(null, "Bu öğrenciye ait kayıt bulunamadı.", "Bilgi",
							javax.swing.JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				for (String[] satir : liste)
					karneModel.addRow(satir);
			}
		});

		btnTxtExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (karneModel.getRowCount() == 0) {
					javax.swing.JOptionPane.showMessageDialog(null, "Aktarılacak veri yok!", "Uyarı",
							javax.swing.JOptionPane.WARNING_MESSAGE);
					return;
				}
				javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
				fc.setSelectedFile(new java.io.File("karne_" + txtOgrenciNo.getText().trim() + ".txt"));
				if (fc.showSaveDialog(null) != javax.swing.JFileChooser.APPROVE_OPTION) return;
				try (java.io.PrintWriter pw = new java.io.PrintWriter(
						new java.io.FileWriter(fc.getSelectedFile(), java.nio.charset.StandardCharsets.UTF_8))) {
					pw.println("Öğrenci Karnesi - No: " + txtOgrenciNo.getText().trim());
					pw.println("=".repeat(60));
					for (int i = 0; i < karneModel.getRowCount(); i++)
						pw.printf("%-35s %-20s %-10s %s -> %s%n",
								karneModel.getValueAt(i, 0), karneModel.getValueAt(i, 1),
								karneModel.getValueAt(i, 2), karneModel.getValueAt(i, 3),
								karneModel.getValueAt(i, 4));
					javax.swing.JOptionPane.showMessageDialog(null, "TXT dosyası oluşturuldu!", "Başarılı",
							javax.swing.JOptionPane.INFORMATION_MESSAGE);
				} catch (java.io.IOException ex) {
					javax.swing.JOptionPane.showMessageDialog(null, "Hata: " + ex.getMessage(), "Hata",
							javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnCsvExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (karneModel.getRowCount() == 0) {
					javax.swing.JOptionPane.showMessageDialog(null, "Aktarılacak veri yok!", "Uyarı",
							javax.swing.JOptionPane.WARNING_MESSAGE);
					return;
				}
				javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
				fc.setSelectedFile(new java.io.File("karne_" + txtOgrenciNo.getText().trim() + ".csv"));
				if (fc.showSaveDialog(null) != javax.swing.JFileChooser.APPROVE_OPTION) return;
				try (java.io.PrintWriter pw = new java.io.PrintWriter(
						new java.io.FileWriter(fc.getSelectedFile(), java.nio.charset.StandardCharsets.UTF_8))) {
					pw.println("Kitap Adı,Yazar,Kategori,Alış Tarihi,İade Tarihi");
					for (int i = 0; i < karneModel.getRowCount(); i++)
						pw.printf("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"%n",
								karneModel.getValueAt(i, 0), karneModel.getValueAt(i, 1),
								karneModel.getValueAt(i, 2), karneModel.getValueAt(i, 3),
								karneModel.getValueAt(i, 4));
					javax.swing.JOptionPane.showMessageDialog(null, "CSV dosyası oluşturuldu!", "Başarılı",
							javax.swing.JOptionPane.INFORMATION_MESSAGE);
				} catch (java.io.IOException ex) {
					javax.swing.JOptionPane.showMessageDialog(null, "Hata: " + ex.getMessage(), "Hata",
							javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// ---- Alt: Genel Rapor Tablosu ----
		JPanel panel_8 = new JPanel();
		add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		panel_8.add(scrollPane_3, BorderLayout.CENTER);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Bilgi", "Sayı" }));
		scrollPane_3.setViewportView(table_3);
	}
}
