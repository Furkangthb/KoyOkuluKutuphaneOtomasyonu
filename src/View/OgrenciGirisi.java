package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import Model.Kullanici;
import javax.swing.JComboBox;

public class OgrenciGirisi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panelKartlar;
    private javax.swing.JTable tableKatalog;
    private javax.swing.JTextField txtArama;
    private JComboBox<String> cmbKategori;
    private Kullanici aktifOgrenci;
    private javax.swing.JTable tableKitaplarim;
    
    private JLabel lblProfilOzet;
    private JButton btnKatalog;
    private JButton btnKitaplarim;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    Kullanici testOgrenci = new Kullanici(1, "102030", "Furkan Yüksel", "1234", "OGRENCI");
                    OgrenciGirisi frame = new OgrenciGirisi(testOgrenci);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public OgrenciGirisi(Kullanici ogrenci) {
        this.aktifOgrenci = ogrenci;

        setTitle("Kütüphane — Öğrenci Paneli");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1050, 640);
        setLocationRelativeTo(null); 
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(248, 250, 252));
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(30, 41, 59));
        panelMenu.setPreferredSize(new Dimension(240, 0));
        contentPane.add(panelMenu, BorderLayout.WEST);

        GridBagLayout gbl_panelMenu = new GridBagLayout();
        gbl_panelMenu.columnWidths = new int[] { 0 };
        gbl_panelMenu.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
        gbl_panelMenu.columnWeights = new double[] { 1.0 };
        gbl_panelMenu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 }; 
        panelMenu.setLayout(gbl_panelMenu);

        JLabel lblHosgeldin = new JLabel("<html>Merhaba,<br>" + aktifOgrenci.getAdSoyad() + "</html>");
        lblHosgeldin.setForeground(Color.WHITE);
        lblHosgeldin.setFont(new Font("Z003", Font.BOLD, 20));
        GridBagConstraints gbc_lblHosgeldin = new GridBagConstraints();
        gbc_lblHosgeldin.anchor = GridBagConstraints.WEST;
        gbc_lblHosgeldin.insets = new Insets(24, 16, 4, 16);
        gbc_lblHosgeldin.gridx = 0;
        gbc_lblHosgeldin.gridy = 0;
        panelMenu.add(lblHosgeldin, gbc_lblHosgeldin);

        lblProfilOzet = new JLabel("");
        lblProfilOzet.setForeground(new Color(148, 163, 184));
        lblProfilOzet.setFont(new Font("Z003", Font.PLAIN, 18));
        GridBagConstraints gbc_lblProfil = new GridBagConstraints();
        gbc_lblProfil.anchor = GridBagConstraints.WEST;
        gbc_lblProfil.insets = new Insets(0, 16, 16, 16);
        gbc_lblProfil.gridx = 0;
        gbc_lblProfil.gridy = 1;
        panelMenu.add(lblProfilOzet, gbc_lblProfil);

        JSeparator ayirici = new JSeparator();
        ayirici.setForeground(new Color(255, 255, 255, 80));
        GridBagConstraints gbcSep = new GridBagConstraints();
        gbcSep.fill = GridBagConstraints.HORIZONTAL;
        gbcSep.insets = new Insets(0, 16, 12, 16);
        gbcSep.gridx = 0;
        gbcSep.gridy = 2;
        panelMenu.add(ayirici, gbcSep);

        Insets menuBosluk = new Insets(4, 12, 4, 12);

        // --- KATALOG BUTONU ---
        btnKatalog = new JButton("  Kütüphane Kataloğu");
        btnKatalog.setFont(new Font("Z003", Font.PLAIN, 12));
        btnKatalog.setFocusPainted(false);
        btnKatalog.setBorderPainted(false);
        btnKatalog.setContentAreaFilled(false);
        btnKatalog.setOpaque(true);
        btnKatalog.setForeground(new Color(226, 232, 240));
        btnKatalog.setBackground(new Color(30, 41, 59));
        btnKatalog.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnKatalog.setPreferredSize(new Dimension(170, 42));
        btnKatalog.setHorizontalAlignment(SwingConstants.LEFT);
        btnKatalog.setBorder(new EmptyBorder(10, 18, 10, 18));
        btnKatalog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btnKatalog.getFont().isPlain()) {
                    btnKatalog.setBackground(new Color(45, 60, 85)); 
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (btnKatalog.getFont().isPlain()) {
                    btnKatalog.setBackground(new Color(30, 41, 59));
                }
            }
        });
        btnKatalog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuSec(btnKatalog);
                CardLayout cl = (CardLayout) panelKartlar.getLayout();
                cl.show(panelKartlar, "Katalog");
                katalogYenile();
            }
        });
        GridBagConstraints gbc_btnKatalog = new GridBagConstraints();
        gbc_btnKatalog.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnKatalog.insets = menuBosluk;
        gbc_btnKatalog.gridx = 0;
        gbc_btnKatalog.gridy = 3;
        panelMenu.add(btnKatalog, gbc_btnKatalog);

        btnKitaplarim = new JButton("  Üzerimdeki Kitaplar");
        btnKitaplarim.setFont(new Font("Z003", Font.PLAIN, 12)); 
        btnKitaplarim.setFocusPainted(false);
        btnKitaplarim.setBorderPainted(false);
        btnKitaplarim.setContentAreaFilled(false);
        btnKitaplarim.setOpaque(true);
        btnKitaplarim.setForeground(new Color(226, 232, 240));
        btnKitaplarim.setBackground(new Color(30, 41, 59));
        btnKitaplarim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnKitaplarim.setPreferredSize(new Dimension(170, 42));
        btnKitaplarim.setHorizontalAlignment(SwingConstants.LEFT);
        btnKitaplarim.setBorder(new EmptyBorder(10, 18, 10, 18));
        btnKitaplarim.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btnKitaplarim.getFont().isPlain()) {
                    btnKitaplarim.setBackground(new Color(45, 60, 85)); 
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (btnKitaplarim.getFont().isPlain()) {
                    btnKitaplarim.setBackground(new Color(30, 41, 59));
                }
            }
        });
        btnKitaplarim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuSec(btnKitaplarim);
                CardLayout cl = (CardLayout) panelKartlar.getLayout();
                cl.show(panelKartlar, "Kitaplarim");
                kitaplarimiYenile();
                profilYenile();
            }
        });
        GridBagConstraints gbc_btnKitaplarim = new GridBagConstraints();
        gbc_btnKitaplarim.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnKitaplarim.insets = menuBosluk;
        gbc_btnKitaplarim.gridx = 0;
        gbc_btnKitaplarim.gridy = 4;
        panelMenu.add(btnKitaplarim, gbc_btnKitaplarim);

        JPanel bosAlan = new JPanel();
        bosAlan.setOpaque(false);
        GridBagConstraints gbcBos = new GridBagConstraints();
        gbcBos.gridx = 0;
        gbcBos.gridy = 5;
        gbcBos.weighty = 1.0;
        gbcBos.fill = GridBagConstraints.VERTICAL;
        panelMenu.add(bosAlan, gbcBos);

        JButton btnCikis = new JButton("  Çıkış Yap");
        btnCikis.setFont(new Font("Z003", Font.PLAIN, 20));
        btnCikis.setFocusPainted(false);
        btnCikis.setBorderPainted(false);
        btnCikis.setContentAreaFilled(false);
        btnCikis.setOpaque(true);
        btnCikis.setForeground(new Color(226, 232, 240));
        btnCikis.setBackground(new Color(30, 41, 59));
        btnCikis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCikis.setPreferredSize(new Dimension(170, 42));
        btnCikis.setHorizontalAlignment(SwingConstants.LEFT);
        btnCikis.setBorder(new EmptyBorder(10, 18, 10, 18));
        btnCikis.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btnCikis.getFont().isPlain()) {
                    btnCikis.setBackground(new Color(45, 60, 85)); 
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (btnCikis.getFont().isPlain()) {
                    btnCikis.setBackground(new Color(30, 41, 59));
                }
            }
        });
        btnCikis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GirisEkrani().setVisible(true);
            }
        });
        GridBagConstraints gbc_btnCikis = new GridBagConstraints();
        gbc_btnCikis.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnCikis.anchor = GridBagConstraints.SOUTH;
        gbc_btnCikis.insets = new Insets(10, 12, 28, 12);
        gbc_btnCikis.gridx = 0;
        gbc_btnCikis.gridy = 6;
        panelMenu.add(btnCikis, gbc_btnCikis);

        panelKartlar = new JPanel();
        panelKartlar.setBackground(new Color(248, 250, 252));
        contentPane.add(panelKartlar, BorderLayout.CENTER);
        panelKartlar.setLayout(new CardLayout(0, 0));

        JPanel panelKatalog = new JPanel();
        panelKatalog.setBackground(new Color(248, 250, 252));
        panelKatalog.setLayout(new BorderLayout(0, 0));
        panelKartlar.add(panelKatalog, "Katalog");

        JPanel panelKatalogUst = new JPanel(new BorderLayout());
        panelKatalogUst.setBackground(new Color(248, 250, 252));
        
        JPanel panelBaslikKatalog = new JPanel(new BorderLayout());
        panelBaslikKatalog.setBackground(new Color(248, 250, 252));
        panelBaslikKatalog.setBorder(new EmptyBorder(16, 20, 8, 20));
        JLabel lblKatalogBaslik = new JLabel("Dijital Katalog");
        lblKatalogBaslik.setFont(new Font("C059", Font.BOLD, 22));
        lblKatalogBaslik.setForeground(new Color(30, 41, 59));
        panelBaslikKatalog.add(lblKatalogBaslik, BorderLayout.WEST);
        panelKatalogUst.add(panelBaslikKatalog, BorderLayout.NORTH);

        JPanel panelArama = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 10));
        panelArama.setBackground(new Color(241, 245, 249)); 
        panelArama.setBorder(new EmptyBorder(8, 12, 8, 12));

        JLabel lblAra = new JLabel("Kitap Ara:");
        lblAra.setFont(new Font("Cantarell", Font.PLAIN, 13));
        panelArama.add(lblAra);

        txtArama = new javax.swing.JTextField(28);
        txtArama.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtArama.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                filtrele();
            }
        });
        panelArama.add(txtArama);

        JLabel lblKategori = new JLabel("  Kategori:");
        lblKategori.setFont(new Font("Cantarell", Font.PLAIN, 13));
        panelArama.add(lblKategori);

        cmbKategori = new JComboBox<>(new String[] { 
            "Tümü", "Aşk (Romantik)", "Korku", "Gerilim", "Polisiye",
            "Bilimkurgu", "Fantastik", "Tarihi Roman", "Dram", "Mizah", "Distopya / Ütopya" 
        });
        cmbKategori.setFont(new Font("Cantarell", Font.PLAIN, 13));
        cmbKategori.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filtrele();
            }
        });
        panelArama.add(cmbKategori);

        panelKatalogUst.add(panelArama, BorderLayout.CENTER);
        panelKatalog.add(panelKatalogUst, BorderLayout.NORTH);

        javax.swing.JScrollPane scrollPaneKatalog = new javax.swing.JScrollPane();
        scrollPaneKatalog.setBorder(new EmptyBorder(0, 16, 16, 16));
        panelKatalog.add(scrollPaneKatalog, BorderLayout.CENTER);

        tableKatalog = new javax.swing.JTable();
        tableKatalog.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
                new String[] { "Kitap ID", "Kitap Adı", "Yazar", "Kategori", "Durum" }) {
            boolean[] columnEditables = new boolean[] { false, false, false, false, false };

            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        
        tableKatalog.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    int modelRow = table.convertRowIndexToModel(row);
                    String durum = table.getModel().getValueAt(modelRow, 4) != null
                            ? table.getModel().getValueAt(modelRow, 4).toString()
                            : "";
                    if (durum.equals("Ödünçte"))
                        setBackground(new Color(254, 226, 226)); 
                    else if (durum.equals("Rafta"))
                        setBackground(new Color(220, 252, 231)); 
                    else
                        setBackground(row % 2 == 0 ? Color.WHITE : new Color(248, 250, 252));
                }
                return this;
            }
        });

        tableKatalog.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        tableKatalog.setRowHeight(30);
        tableKatalog.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableKatalog.getTableHeader().setBackground(new Color(226, 232, 240));
        scrollPaneKatalog.setViewportView(tableKatalog);

        JPanel panelKitaplarim = new JPanel();
        panelKitaplarim.setBackground(new Color(248, 250, 252));
        panelKitaplarim.setLayout(new BorderLayout(0, 0));
        panelKartlar.add(panelKitaplarim, "Kitaplarim");

        JPanel panelBaslikKitaplarim = new JPanel(new BorderLayout());
        panelBaslikKitaplarim.setBackground(new Color(248, 250, 252));
        panelBaslikKitaplarim.setBorder(new EmptyBorder(16, 20, 16, 20));
        JLabel lblKitaplarimBaslik = new JLabel("Ödünç Aldığım Kitaplar & Geçmişim");
        lblKitaplarimBaslik.setFont(new Font("C059", Font.BOLD, 22));
        lblKitaplarimBaslik.setForeground(new Color(30, 41, 59));
        panelBaslikKitaplarim.add(lblKitaplarimBaslik, BorderLayout.WEST);
        panelKitaplarim.add(panelBaslikKitaplarim, BorderLayout.NORTH);

        javax.swing.JScrollPane scrollKitaplarim = new javax.swing.JScrollPane();
        scrollKitaplarim.setBorder(new EmptyBorder(0, 16, 16, 16));
        panelKitaplarim.add(scrollKitaplarim, BorderLayout.CENTER);

        tableKitaplarim = new javax.swing.JTable();
        tableKitaplarim.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
                new String[] { "İşlem No", "Kitap Adı", "Alış Tarihi", "İade Tarihi", "Durum" }) {
            boolean[] columnEditables = new boolean[] { false, false, false, false, false };

            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        
        tableKitaplarim.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    int modelRow = table.convertRowIndexToModel(row);
                    String durum = table.getModel().getValueAt(modelRow, 4) != null
                            ? table.getModel().getValueAt(modelRow, 4).toString()
                            : "";
                    if (durum.contains("Okunuyor")) {
                        String alis = table.getModel().getValueAt(modelRow, 2) != null
                                ? table.getModel().getValueAt(modelRow, 2).toString()
                                : "";
                        if (Dao.OduncDAO.gecikmisMi(alis))
                            setBackground(new Color(254, 202, 202)); 
                        else
                            setBackground(new Color(254, 243, 199)); 
                    } else {
                        setBackground(row % 2 == 0 ? Color.WHITE : new Color(248, 250, 252));
                    }
                }
                return this;
            }
        });

        tableKitaplarim.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        tableKitaplarim.setRowHeight(30);
        tableKitaplarim.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableKitaplarim.getTableHeader().setBackground(new Color(226, 232, 240));
        scrollKitaplarim.setViewportView(tableKitaplarim);

        menuSec(btnKatalog);
        katalogYenile();
        kitaplarimiYenile();
        profilYenile();
    }

    private void menuSec(JButton aktif) {
        butonPasifYap(btnKatalog);
        butonPasifYap(btnKitaplarim);
        
        butonAktifYap(aktif);
    }

    private void butonAktifYap(JButton btn) {
        btn.setBackground(new Color(37, 99, 235)); 
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Z003", Font.PLAIN, 18));
    }

    private void butonPasifYap(JButton btn) {
        btn.setBackground(new Color(30, 41, 59)); 
        btn.setForeground(new Color(226, 232, 240));
        btn.setFont(new Font("Z003", Font.PLAIN, 18));
    }

    private void profilYenile() {
        Dao.OduncDAO dao = new Dao.OduncDAO();
        int okunan = dao.ogrenciOkunanKitapSayisi(aktifOgrenci.getKullaniciNo());
        int aktif = dao.ogrenciAktifOduncSayisi(aktifOgrenci.getKullaniciNo());
        lblProfilOzet.setText("<html>Okunan kitap: <b>" + okunan + "</b><br>Aktif ödünç: <b>" + aktif + "</b></html>");
    }

    private void katalogYenile() {
        DefaultTableModel model = (DefaultTableModel) tableKatalog.getModel();
        model.setRowCount(0);
        Controller.KitapController kc = new Controller.KitapController();
        for (Model.Kitap k : kc.tumKitaplariGetir()) {
            model.addRow(new Object[] { k.getKitapId(), k.getBaslik(), k.getYazar(), k.getKategori(), k.getDurum() });
        }
    }

    private void kitaplarimiYenile() {
        DefaultTableModel model = (DefaultTableModel) tableKitaplarim.getModel();
        model.setRowCount(0);
        Controller.OduncController oc = new Controller.OduncController();
        for (Model.OduncIslem o : oc.ogrencininKitaplariniGetir(aktifOgrenci.getKullaniciNo())) {
            String durum = (o.getTeslimEdildiMi() == 1) ? "İade Edildi" : "Şu an bende (Okunuyor)";
            String iadeTarihi = (o.getIadeTarihi() == null) ? "-" : o.getIadeTarihi();
            model.addRow(new Object[] { o.getIslemId(), o.getKitapBaslik(), o.getAlisTarihi(), iadeTarihi, durum });
        }
    }

    private void filtrele() {
        DefaultTableModel model = (DefaultTableModel) tableKatalog.getModel();
        javax.swing.table.TableRowSorter<DefaultTableModel> sorter = new javax.swing.table.TableRowSorter<>(model);
        tableKatalog.setRowSorter(sorter);
        
        String metin = txtArama.getText();
        String kategori = (String) cmbKategori.getSelectedItem();
        
        java.util.List<RowFilter<Object, Object>> filtreler = new java.util.ArrayList<>();
        
        if (!metin.trim().isEmpty()) {
            filtreler.add(RowFilter.regexFilter("(?i)" + metin, 1, 2));
        }
        if (kategori != null && !kategori.equals("Tümü")) {
            filtreler.add(RowFilter.regexFilter("(?i)^" + java.util.regex.Pattern.quote(kategori) + "$", 3));
        }
        
        sorter.setRowFilter(filtreler.isEmpty() ? null : RowFilter.andFilter(filtreler));
    }
}