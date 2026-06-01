package View.panelOgretmen;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Dao.OduncDAO;
import javax.swing.JSeparator;

public class panelOduncİade extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_2;
	private JTextField textField;

	public panelOduncİade() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(87, 227, 137));
		panel_4_1.setPreferredSize(new Dimension(300, 600));
		add(panel_4_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_4_1 = new GridBagLayout();
		gbl_panel_4_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_4_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4_1.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_4_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_4_1.setLayout(gbl_panel_4_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(92, 126, 164));
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.weightx = 1.0;
		gbc_separator_1.gridwidth = 2;
		gbc_separator_1.insets = new Insets(40, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 0;
		panel_4_1.add(separator_1, gbc_separator_1);

		JLabel lbldnIade = new JLabel("Ödünç / İade İşlemleri");
		lbldnIade.setFont(new Font("Dialog", Font.BOLD, 18));
		GridBagConstraints gbc_lbldnIade = new GridBagConstraints();
		gbc_lbldnIade.weighty = 1.0; gbc_lbldnIade.weightx = 1.0;
		gbc_lbldnIade.gridwidth = 2; gbc_lbldnIade.insets = new Insets(20, 0, 20, 0);
		gbc_lbldnIade.gridx = 0; gbc_lbldnIade.gridy = 1;
		panel_4_1.add(lbldnIade, gbc_lbldnIade);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(92, 126, 164));
		GridBagConstraints gbc_separator_1_1 = new GridBagConstraints();
		gbc_separator_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1_1.gridwidth = 2;
		gbc_separator_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1_1.gridx = 0;
		gbc_separator_1_1.gridy = 2;
		panel_4_1.add(separator_1_1, gbc_separator_1_1);

		JLabel lblKitapId = new JLabel("Kitap ID:");
		GridBagConstraints gbc_lblKitapId = new GridBagConstraints();
		gbc_lblKitapId.anchor = GridBagConstraints.EAST;
		gbc_lblKitapId.insets = new Insets(0, 10, 10, 5);
		gbc_lblKitapId.gridx = 0; gbc_lblKitapId.gridy = 3;
		panel_4_1.add(lblKitapId, gbc_lblKitapId);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.insets = new Insets(0, 0, 10, 20);
		gbc_textField_6.gridx = 1; gbc_textField_6.gridy = 3;
		panel_4_1.add(textField_6, gbc_textField_6);

		JLabel lblOgrenciNo = new JLabel("Öğrenci No:");
		GridBagConstraints gbc_lblOgrenciNo = new GridBagConstraints();
		gbc_lblOgrenciNo.anchor = GridBagConstraints.EAST;
		gbc_lblOgrenciNo.insets = new Insets(0, 10, 10, 5);
		gbc_lblOgrenciNo.gridx = 0; gbc_lblOgrenciNo.gridy = 4;
		panel_4_1.add(lblOgrenciNo, gbc_lblOgrenciNo);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.insets = new Insets(0, 0, 10, 20);
		gbc_textField_7.gridx = 1; gbc_textField_7.gridy = 4;
		panel_4_1.add(textField_7, gbc_textField_7);

		JButton btnKitabdnVer = new JButton("Kitabı Ödünç Ver");
		btnKitabdnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kitapIdStr = textField_6.getText().trim();
				String ogrenciNo = textField_7.getText().trim();
				if (kitapIdStr.isEmpty() || ogrenciNo.isEmpty()) {
					javax.swing.JOptionPane.showMessageDialog(null, "Kitap ID ve Öğrenci No boş olamaz!");
					return;
				}
				OduncDAO dao = new OduncDAO();
				if (dao.oduncVer(Integer.parseInt(kitapIdStr), ogrenciNo)) {
					javax.swing.JOptionPane.showMessageDialog(null, "Kitap ödünç verildi!");
					oduncleriYenile();
					textField_6.setText(""); textField_7.setText("");
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Hata! Kitap zaten ödünçte olabilir.");
				}
			}
		});
		GridBagConstraints gbc_btnKitabdnVer = new GridBagConstraints();
		gbc_btnKitabdnVer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKitabdnVer.gridwidth = 2;
		gbc_btnKitabdnVer.insets = new Insets(0, 20, 10, 20);
		gbc_btnKitabdnVer.gridx = 0; gbc_btnKitabdnVer.gridy = 7;
		panel_4_1.add(btnKitabdnVer, gbc_btnKitabdnVer);

		JButton btnUyeSil_1 = new JButton("Seçili Kitabı İade Al");
		btnUyeSil_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int satir = table_2.getSelectedRow();
				if (satir == -1) { javax.swing.JOptionPane.showMessageDialog(null, "İade alınacak kaydı tablodan seçin!"); return; }
				int modelSatir = table_2.convertRowIndexToModel(satir);
				int islemId = Integer.parseInt(table_2.getModel().getValueAt(modelSatir, 0).toString());
				int kitapId = Integer.parseInt(table_2.getModel().getValueAt(modelSatir, 1).toString());
				OduncDAO dao = new OduncDAO();
				if (dao.iadeAl(islemId, kitapId)) {
					javax.swing.JOptionPane.showMessageDialog(null, "Kitap iade alındı!");
					oduncleriYenile();
				}
			}
		});
		GridBagConstraints gbc_btnUyeSil_1 = new GridBagConstraints();
		gbc_btnUyeSil_1.insets = new Insets(0, 20, 20, 20);
		gbc_btnUyeSil_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUyeSil_1.anchor = GridBagConstraints.NORTH;
		gbc_btnUyeSil_1.gridwidth = 2;
		gbc_btnUyeSil_1.gridx = 0; gbc_btnUyeSil_1.gridy = 9;
		panel_4_1.add(btnUyeSil_1, gbc_btnUyeSil_1);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(248, 228, 92));
		add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBackground(new Color(248, 228, 92));
		panel_7.add(scrollPane_2, BorderLayout.CENTER);

		table_2 = new JTable();
		table_2.setBackground(new Color(248, 228, 92));
		table_2.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "İşlem ID", "Kitap ID", "Kitap Adı", "Öğrenci No", "Öğrenci Adı", "Alış Tarihi" }));
		table_2.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
			public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table,
					Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				try {
					Object tarihObj = table.getModel().getValueAt(table.convertRowIndexToModel(row), 5);
					if (tarihObj != null) {
						java.time.LocalDate alis = java.time.LocalDate.parse(tarihObj.toString());
						if (java.time.LocalDate.now().isAfter(alis.plusDays(14))) {
							setBackground(new Color(255, 180, 180));
							return this;
						}
					}
				} catch (Exception ex) {}
				setBackground(isSelected ? table.getSelectionBackground() : Color.WHITE);
				return this;
			}
		});
		scrollPane_2.setViewportView(table_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248, 228, 92));
		panel_7.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_4 = new JLabel("Kitap Ara:");
		panel_2.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setColumns(20);
		panel_2.add(textField);

		oduncleriYenile();
	}

	public void oduncleriYenile() {
		DefaultTableModel model = (DefaultTableModel) table_2.getModel();
		model.setRowCount(0);
		OduncDAO dao = new OduncDAO();
		for (Model.OduncIslem o : dao.aktifOduncleriGetir())
			model.addRow(new Object[] { o.getIslemId(), o.getKitapId(), o.getKitapBaslik(), o.getOgrenciNo(), o.getUyeAdSoyad(), o.getAlisTarihi() });
	}
}