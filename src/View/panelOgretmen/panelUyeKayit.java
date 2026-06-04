package View.panelOgretmen;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
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
import java.awt.Color;
import java.awt.Cursor;
import Dao.KullaniciDAO;

public class panelUyeKayit extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtUyeNo;
    private JTextField txtAdSoyad;
    private JTextField txtSifre;
    private JComboBox<String> cmbRol;
    private JTable tabloUyeler;
    private JTextField txtArama;
    private JComboBox<String> cmbRolFiltre;

    public panelUyeKayit() {
        setLayout(new BorderLayout(0, 0));
        setBackground(new Color(248, 250, 252)); 

        JPanel panelSol = new JPanel();
        panelSol.setBackground(new Color(51, 65, 85)); 
        panelSol.setPreferredSize(new Dimension(300, 600));
        add(panelSol, BorderLayout.WEST);
        
        GridBagLayout gbl_panelSol = new GridBagLayout();
        gbl_panelSol.columnWidths = new int[] { 0, 0, 0 };
        gbl_panelSol.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_panelSol.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
        gbl_panelSol.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panelSol.setLayout(gbl_panelSol);

        JSeparator ustAyirici = new JSeparator();
        ustAyirici.setForeground(new Color(92, 126, 164));
        GridBagConstraints gbc_ustAyirici = new GridBagConstraints();
        gbc_ustAyirici.weightx = 1.0;
        gbc_ustAyirici.fill = GridBagConstraints.HORIZONTAL;
        gbc_ustAyirici.gridwidth = 3;
        gbc_ustAyirici.insets = new Insets(40, 16, 5, 16);
        gbc_ustAyirici.gridx = 0;
        gbc_ustAyirici.gridy = 0;
        panelSol.add(ustAyirici, gbc_ustAyirici);

        JLabel lblUyeBaslik = new JLabel("Üye Kayıt");
        lblUyeBaslik.setForeground(Color.WHITE);
        lblUyeBaslik.setFont(new Font("Dialog", Font.BOLD, 18));
        GridBagConstraints gbc_lblUyeBaslik = new GridBagConstraints();
        gbc_lblUyeBaslik.insets = new Insets(20, 0, 20, 0);
        gbc_lblUyeBaslik.weighty = 1.0;
        gbc_lblUyeBaslik.weightx = 1.0;
        gbc_lblUyeBaslik.gridwidth = 2;
        gbc_lblUyeBaslik.gridx = 0;
        gbc_lblUyeBaslik.gridy = 1;
        panelSol.add(lblUyeBaslik, gbc_lblUyeBaslik);

        JSeparator ortaAyirici = new JSeparator();
        ortaAyirici.setForeground(new Color(92, 126, 164));
        GridBagConstraints gbc_ortaAyirici = new GridBagConstraints();
        gbc_ortaAyirici.fill = GridBagConstraints.HORIZONTAL;
        gbc_ortaAyirici.gridwidth = 3;
        gbc_ortaAyirici.weightx = 1.0;
        gbc_ortaAyirici.insets = new Insets(0, 16, 12, 16);
        gbc_ortaAyirici.gridx = 0;
        gbc_ortaAyirici.gridy = 2;
        panelSol.add(ortaAyirici, gbc_ortaAyirici);

        JLabel lblNo = new JLabel("Kullanıcı No:");
        lblNo.setForeground(new Color(226, 232, 240));
        lblNo.setFont(new Font("Dialog", Font.PLAIN, 13));
        GridBagConstraints gbc_lblNo = new GridBagConstraints();
        gbc_lblNo.anchor = GridBagConstraints.EAST;
        gbc_lblNo.insets = new Insets(0, 10, 10, 5);
        gbc_lblNo.gridx = 0;
        gbc_lblNo.gridy = 3;
        panelSol.add(lblNo, gbc_lblNo);

        txtUyeNo = new JTextField();
        txtUyeNo.setFont(new Font("Dialog", Font.PLAIN, 13));
        GridBagConstraints gbc_txtUyeNo = new GridBagConstraints();
        gbc_txtUyeNo.insets = new Insets(0, 0, 10, 20);
        gbc_txtUyeNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtUyeNo.gridx = 1;
        gbc_txtUyeNo.gridy = 3;
        panelSol.add(txtUyeNo, gbc_txtUyeNo);
        txtUyeNo.setColumns(10);

        JLabel lblAd = new JLabel("Ad Soyad:");
        lblAd.setForeground(new Color(226, 232, 240));
        lblAd.setFont(new Font("Dialog", Font.PLAIN, 13));
        GridBagConstraints gbc_lblAd = new GridBagConstraints();
        gbc_lblAd.anchor = GridBagConstraints.EAST;
        gbc_lblAd.insets = new Insets(0, 10, 10, 5);
        gbc_lblAd.gridx = 0;
        gbc_lblAd.gridy = 4;
        panelSol.add(lblAd, gbc_lblAd);

        txtAdSoyad = new JTextField();
        txtAdSoyad.setFont(new Font("Dialog", Font.PLAIN, 13));
        GridBagConstraints gbc_txtAdSoyad = new GridBagConstraints();
        gbc_txtAdSoyad.insets = new Insets(0, 0, 10, 20);
        gbc_txtAdSoyad.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtAdSoyad.gridx = 1;
        gbc_txtAdSoyad.gridy = 4;
        panelSol.add(txtAdSoyad, gbc_txtAdSoyad);
        txtAdSoyad.setColumns(10);

        JLabel lblSifre = new JLabel("Şifre:");
        lblSifre.setForeground(new Color(226, 232, 240));
        lblSifre.setFont(new Font("Dialog", Font.PLAIN, 13));
        GridBagConstraints gbc_lblSifre = new GridBagConstraints();
        gbc_lblSifre.anchor = GridBagConstraints.EAST;
        gbc_lblSifre.insets = new Insets(0, 10, 10, 5);
        gbc_lblSifre.gridx = 0;
        gbc_lblSifre.gridy = 5;
        panelSol.add(lblSifre, gbc_lblSifre);

        txtSifre = new JTextField();
        txtSifre.setFont(new Font("Dialog", Font.PLAIN, 13));
        GridBagConstraints gbc_txtSifre = new GridBagConstraints();
        gbc_txtSifre.insets = new Insets(0, 0, 10, 20);
        gbc_txtSifre.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtSifre.gridx = 1;
        gbc_txtSifre.gridy = 5;
        panelSol.add(txtSifre, gbc_txtSifre);
        txtSifre.setColumns(10);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setForeground(new Color(226, 232, 240));
        lblRol.setFont(new Font("Dialog", Font.PLAIN, 13));
        GridBagConstraints gbc_lblRol = new GridBagConstraints();
        gbc_lblRol.anchor = GridBagConstraints.EAST;
        gbc_lblRol.insets = new Insets(0, 10, 20, 5);
        gbc_lblRol.gridx = 0;
        gbc_lblRol.gridy = 6;
        panelSol.add(lblRol, gbc_lblRol);

        cmbRol = new JComboBox<>(new String[] { "Seçiniz...", "OGRENCI", "OGRETMEN" });
        cmbRol.setFont(new Font("Dialog", Font.PLAIN, 13));
        GridBagConstraints gbc_cmbRol = new GridBagConstraints();
        gbc_cmbRol.insets = new Insets(0, 0, 20, 20);
        gbc_cmbRol.fill = GridBagConstraints.HORIZONTAL;
        gbc_cmbRol.gridx = 1;
        gbc_cmbRol.gridy = 6;
        panelSol.add(cmbRol, gbc_cmbRol);

        JButton btnUyeEkle = new JButton("Yeni Üye Ekle");
        btnUyeEkle.setBackground(new Color(16, 185, 129));
        btnUyeEkle.setForeground(Color.WHITE);
        btnUyeEkle.setFont(new Font("Dialog", Font.BOLD, 13));
        btnUyeEkle.setFocusPainted(false);
        btnUyeEkle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUyeEkle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btnUyeEkle.isEnabled()) {
                    btnUyeEkle.setBackground(new Color(5, 150, 105));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (btnUyeEkle.isEnabled()) {
                    btnUyeEkle.setBackground(new Color(16, 185, 129));
                }
            }
        });
        btnUyeEkle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String no = txtUyeNo.getText().trim();
                String adSoyad = txtAdSoyad.getText().trim();
                String sifre = txtSifre.getText().trim();
                String rol = cmbRol.getSelectedItem().toString();
                
                if (no.isEmpty() || adSoyad.isEmpty() || sifre.isEmpty() || rol.equals("Seçiniz...")) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                KullaniciDAO dao = new KullaniciDAO();
                if (dao.kullaniciEkle(new Model.Kullanici(0, no, adSoyad, sifre, rol))) {
                    JOptionPane.showMessageDialog(null, "Üye başarıyla eklendi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    uyeleriYenile();
                    formuTemizle();
                } else {
                    JOptionPane.showMessageDialog(null, "Üye eklenirken hata oluştu!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        GridBagConstraints gbc_btnUyeEkle = new GridBagConstraints();
        gbc_btnUyeEkle.insets = new Insets(0, 20, 10, 20);
        gbc_btnUyeEkle.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnUyeEkle.gridwidth = 2;
        gbc_btnUyeEkle.gridx = 0;
        gbc_btnUyeEkle.gridy = 7;
        panelSol.add(btnUyeEkle, gbc_btnUyeEkle);

        JButton btnUyeGuncelle = new JButton("Üyeyi Güncelle");
        btnUyeGuncelle.setBackground(new Color(245, 158, 11)); 
        btnUyeGuncelle.setForeground(Color.WHITE);
        btnUyeGuncelle.setFont(new Font("Dialog", Font.BOLD, 13));
        btnUyeGuncelle.setFocusPainted(false);
        btnUyeGuncelle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUyeGuncelle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btnUyeGuncelle.isEnabled()) {
                    btnUyeGuncelle.setBackground(new Color(217, 119, 6)); 
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (btnUyeGuncelle.isEnabled()) {
                    btnUyeGuncelle.setBackground(new Color(245, 158, 11));
                }
            }
        });
        btnUyeGuncelle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int secili = tabloUyeler.getSelectedRow();
                if (secili == -1) {
                    JOptionPane.showMessageDialog(null, "Tablodan bir üye seçin!");
                    return;
                }
                
                String no = txtUyeNo.getText().trim();
                String adSoyad = txtAdSoyad.getText().trim();
                String sifre = txtSifre.getText().trim();
                String rol = cmbRol.getSelectedItem().toString();
                
                if (no.isEmpty() || adSoyad.isEmpty() || sifre.isEmpty() || rol.equals("Seçiniz...")) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                int id = Integer.parseInt(tabloUyeler.getModel().getValueAt(seciliModelSatir(secili), 0).toString());
                KullaniciDAO dao = new KullaniciDAO();
                
                if (dao.kullaniciGuncelle(new Model.Kullanici(id, no, adSoyad, sifre, rol))) {
                    JOptionPane.showMessageDialog(null, "Üye başarıyla güncellendi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    uyeleriYenile();
                    formuTemizle();
                }
            }
        });
        GridBagConstraints gbc_btnUyeGuncelle = new GridBagConstraints();
        gbc_btnUyeGuncelle.insets = new Insets(0, 20, 10, 20);
        gbc_btnUyeGuncelle.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnUyeGuncelle.gridwidth = 2;
        gbc_btnUyeGuncelle.gridx = 0;
        gbc_btnUyeGuncelle.gridy = 8;
        panelSol.add(btnUyeGuncelle, gbc_btnUyeGuncelle);


        JPanel panelIcerik = new JPanel();
        panelIcerik.setBackground(new Color(248, 250, 252));
        add(panelIcerik, BorderLayout.CENTER);
        panelIcerik.setLayout(new BorderLayout(0, 0));

        JPanel panelArama = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 10));
        panelArama.setBackground(new Color(241, 245, 249)); // ARAMA Paneli Rengi
        panelArama.setBorder(new EmptyBorder(8, 12, 8, 12));
        panelIcerik.add(panelArama, BorderLayout.NORTH);

        JLabel lblArama = new JLabel("Üye Ara:");
        lblArama.setFont(new Font("Dialog", Font.PLAIN, 13));
        panelArama.add(lblArama);

        txtArama = new JTextField(18);
        txtArama.setFont(new Font("Dialog", Font.PLAIN, 13));
        txtArama.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrele(txtArama.getText(), cmbRolFiltre.getSelectedItem().toString());
            }
        });
        panelArama.add(txtArama);

        cmbRolFiltre = new JComboBox<>(new String[] { "Tümü", "OGRENCI", "OGRETMEN" });
        cmbRolFiltre.setFont(new Font("Dialog", Font.PLAIN, 13));
        cmbRolFiltre.setPreferredSize(new Dimension(120, 26));
        cmbRolFiltre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filtrele(txtArama.getText(), cmbRolFiltre.getSelectedItem().toString());
            }
        });
        panelArama.add(cmbRolFiltre);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new EmptyBorder(0, 16, 16, 16));
        panelIcerik.add(scrollPane, BorderLayout.CENTER);

        tabloUyeler = new JTable();
        
        tabloUyeler.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "ID", "Kullanıcı No", "Ad Soyad", "Şifre", "Rol" }) {
            boolean[] columnEditables = new boolean[] { false, false, false, false, false };

            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });

        tabloUyeler.setFont(new Font("Dialog", Font.PLAIN, 12));
        tabloUyeler.setRowHeight(30);
        tabloUyeler.setGridColor(new Color(203, 213, 225));
        tabloUyeler.setSelectionBackground(new Color(219, 234, 254));
        tabloUyeler.setSelectionForeground(new Color(30, 41, 59));
        tabloUyeler.setBackground(Color.WHITE);
        tabloUyeler.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 12));
        tabloUyeler.getTableHeader().setBackground(new Color(226, 232, 240));
        
        tabloUyeler.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int secili = tabloUyeler.getSelectedRow();
                if (secili >= 0) {
                    DefaultTableModel model = (DefaultTableModel) tabloUyeler.getModel();
                    int modelSatir = seciliModelSatir(secili);
                    txtUyeNo.setText(model.getValueAt(modelSatir, 1).toString());
                    txtAdSoyad.setText(model.getValueAt(modelSatir, 2).toString());
                    txtSifre.setText(model.getValueAt(modelSatir, 3).toString());
                    cmbRol.setSelectedItem(model.getValueAt(modelSatir, 4).toString());
                }
            }
        });
        scrollPane.setViewportView(tabloUyeler);

        
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem mntmSil = new JMenuItem("Sil");
        mntmSil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int secili = tabloUyeler.getSelectedRow();
                if (secili == -1) return;
                
                int cevap = JOptionPane.showConfirmDialog(null, "Bu üyeyi silmek istediğinize emin misiniz?", "Silme Onayı", JOptionPane.YES_NO_OPTION);
                if (cevap == JOptionPane.YES_OPTION) {
                    int id = Integer.parseInt(tabloUyeler.getModel().getValueAt(seciliModelSatir(secili), 0).toString());
                    KullaniciDAO dao = new KullaniciDAO();
                    if (dao.kullaniciSil(id)) {
                        JOptionPane.showMessageDialog(null, "Üye başarıyla silindi!");
                        uyeleriYenile();
                        formuTemizle();
                    } else {
                        JOptionPane.showMessageDialog(null, "Üye silinemedi! İade edilmemiş kitabı olabilir.", "Hata", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        popupMenu.add(mntmSil);
        tabloUyeler.setComponentPopupMenu(popupMenu);

        uyeleriYenile();
    }


    public void uyeleriYenile() {
        tabloUyeler.setRowSorter(null);
        DefaultTableModel model = (DefaultTableModel) tabloUyeler.getModel();
        model.setRowCount(0);
        KullaniciDAO dao = new KullaniciDAO();
        for (Model.Kullanici k : dao.tumKullanicilariGetir()) {
            model.addRow(new Object[] { k.getId(), k.getKullaniciNo(), k.getAdSoyad(), k.getSifre(), k.getRol() });
        }
    }

    private void formuTemizle() {
        txtUyeNo.setText("");
        txtAdSoyad.setText("");
        txtSifre.setText("");
        cmbRol.setSelectedIndex(0);
        tabloUyeler.clearSelection();
    }

    private int seciliModelSatir(int viewSatir) {
        return tabloUyeler.convertRowIndexToModel(viewSatir);
    }

    private void filtrele(String metin, String rol) {
        DefaultTableModel model = (DefaultTableModel) tabloUyeler.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tabloUyeler.setRowSorter(sorter);

        java.util.List<RowFilter<Object, Object>> filtreler = new java.util.ArrayList<>();

        if (!metin.trim().isEmpty()) {
            filtreler.add(RowFilter.regexFilter("(?i)" + metin, 1, 2));
        }

        if (rol != null && !rol.equals("Tümü")) {
            filtreler.add(RowFilter.regexFilter("(?i)^" + java.util.regex.Pattern.quote(rol) + "$", 4));
        }

        sorter.setRowFilter(filtreler.isEmpty() ? null : RowFilter.andFilter(filtreler));
    }
}