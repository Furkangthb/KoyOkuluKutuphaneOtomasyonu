
package View.panelOgretmen;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
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
import java.awt.Color;
import javax.swing.JSeparator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class panelKitapYonetim extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtBaslik;
    private JTextField txtYazar;
    private JTextField txtArama;
    private JTable table;
    private JLabel lblSistemDurumu;
    private JComboBox<String> cmbKategori;
    private JComboBox<String> cmbAramaKategori;
    private TableRowSorter<DefaultTableModel> rowSorter;

    private static final String[] KATEGORILER = {
        "Seçiniz", "Aşk (Romantik)", "Korku", "Gerilim",
        "Polisiye", "Bilimkurgu", "Fantastik", "Tarihi Roman",
        "Dram", "Mizah", "Distopya / Ütopya"
    };

    public panelKitapYonetim() {
        setLayout(new BorderLayout(0, 0));

        JPanel panelSol = new JPanel();
        panelSol.setBackground(new Color(51, 65, 85));
        panelSol.setPreferredSize(new Dimension(300, 600));
        add(panelSol, BorderLayout.WEST);

        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths  = new int[]    { 0, 0, 0 };
        gbl_panel.rowHeights    = new int[]    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
        gbl_panel.rowWeights    = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panelSol.setLayout(gbl_panel);

        JSeparator ustAyirici = new JSeparator();
        ustAyirici.setForeground(new Color(92, 126, 164));
        GridBagConstraints gbc_ustAyirici = new GridBagConstraints();
        gbc_ustAyirici.weightx = 1.0; 
        gbc_ustAyirici.ipadx = 1; 
        gbc_ustAyirici.gridwidth = 2;
        gbc_ustAyirici.fill = GridBagConstraints.HORIZONTAL;
        gbc_ustAyirici.insets = new Insets(40, 0, 5, 0);
        gbc_ustAyirici.gridx = 0; 
        gbc_ustAyirici.gridy = 0;
        panelSol.add(ustAyirici, gbc_ustAyirici);

        JLabel lblBaslik = new JLabel("Kitap Yönetim");
        lblBaslik.setForeground(Color.WHITE);
        lblBaslik.setFont(new Font("Dialog", Font.BOLD, 22)); 
        GridBagConstraints gbc_lblBaslik = new GridBagConstraints();
        gbc_lblBaslik.weighty = 1.0; 
        gbc_lblBaslik.weightx = 1.0; 
        gbc_lblBaslik.gridwidth = 2;
        gbc_lblBaslik.insets = new Insets(20, 0, 30, 0);
        gbc_lblBaslik.gridx = 0; 
        gbc_lblBaslik.gridy = 1;
        panelSol.add(lblBaslik, gbc_lblBaslik);

        JSeparator ortaAyirici = new JSeparator();
        ortaAyirici.setForeground(new Color(92, 126, 164));
        GridBagConstraints gbc_ortaAyirici = new GridBagConstraints();
        gbc_ortaAyirici.fill = GridBagConstraints.HORIZONTAL; 
        gbc_ortaAyirici.weightx = 1.0;
        gbc_ortaAyirici.gridwidth = 2; 
        gbc_ortaAyirici.insets = new Insets(0, 0, 70, 0);
        gbc_ortaAyirici.gridx = 0; 
        gbc_ortaAyirici.gridy = 2;
        panelSol.add(ortaAyirici, gbc_ortaAyirici);

        JLabel lblKitapBaslik = new JLabel("Başlık");
        lblKitapBaslik.setForeground(Color.WHITE);
        GridBagConstraints gbc_lblKitapBaslik = new GridBagConstraints();
        gbc_lblKitapBaslik.anchor = GridBagConstraints.EAST;
        gbc_lblKitapBaslik.insets = new Insets(0, 10, 5, 10);
        gbc_lblKitapBaslik.gridx = 0; 
        gbc_lblKitapBaslik.gridy = 3;
        panelSol.add(lblKitapBaslik, gbc_lblKitapBaslik);

        txtBaslik = new JTextField();
        txtBaslik.setColumns(10);
        GridBagConstraints gbc_txtBaslik = new GridBagConstraints();
        gbc_txtBaslik.weightx = 1.0; 
        gbc_txtBaslik.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtBaslik.insets = new Insets(0, 0, 10, 20);
        gbc_txtBaslik.gridx = 1; 
        gbc_txtBaslik.gridy = 3;
        panelSol.add(txtBaslik, gbc_txtBaslik);

        JLabel lblYazar = new JLabel("Yazar");
        lblYazar.setForeground(Color.WHITE);
        GridBagConstraints gbc_lblYazar = new GridBagConstraints();
        gbc_lblYazar.anchor = GridBagConstraints.EAST;
        gbc_lblYazar.insets = new Insets(0, 10, 5, 10);
        gbc_lblYazar.gridx = 0; 
        gbc_lblYazar.gridy = 4;
        panelSol.add(lblYazar, gbc_lblYazar);

        txtYazar = new JTextField();
        txtYazar.setColumns(10);
        GridBagConstraints gbc_txtYazar = new GridBagConstraints();
        gbc_txtYazar.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtYazar.insets = new Insets(0, 0, 10, 20);
        gbc_txtYazar.gridx = 1; 
        gbc_txtYazar.gridy = 4;
        panelSol.add(txtYazar, gbc_txtYazar);

        JLabel lblKategori = new JLabel("Kategori");
        lblKategori.setForeground(Color.WHITE);
        GridBagConstraints gbc_lblKategori = new GridBagConstraints();
        gbc_lblKategori.anchor = GridBagConstraints.EAST;
        gbc_lblKategori.insets = new Insets(0, 0, 20, 10);
        gbc_lblKategori.gridx = 0; 
        gbc_lblKategori.gridy = 5;
        panelSol.add(lblKategori, gbc_lblKategori);

        cmbKategori = new JComboBox<>(new DefaultComboBoxModel<>(KATEGORILER));
        cmbKategori.setBackground(new Color(147, 147, 147));
        GridBagConstraints gbc_cmbKategori = new GridBagConstraints();
        gbc_cmbKategori.fill = GridBagConstraints.HORIZONTAL;
        gbc_cmbKategori.insets = new Insets(0, 0, 10, 20);
        gbc_cmbKategori.gridx = 1; 
        gbc_cmbKategori.gridy = 5;
        panelSol.add(cmbKategori, gbc_cmbKategori);

        JButton btnEkle = new JButton("Kitap Ekle");
        btnEkle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String baslik  = txtBaslik.getText().trim();
                String yazar   = txtYazar.getText().trim();
                String kategori = (String) cmbKategori.getSelectedItem();

                if (baslik.isEmpty() || yazar.isEmpty() || "Seçiniz".equals(kategori)) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                KitapDAO kd = new KitapDAO();
                Model.Kitap yeniKitap = new Model.Kitap(baslik, yazar, kategori);
                
                if (kd.kitapEkle(yeniKitap)) {
                    JOptionPane.showMessageDialog(null, "Kitap başarıyla eklendi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    tabloyuYenile();
                    formuTemizle();
                } else {
                    JOptionPane.showMessageDialog(null, "Kitap eklenirken hata oluştu!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        GridBagConstraints gbc_btnEkle = new GridBagConstraints();
        gbc_btnEkle.fill = GridBagConstraints.HORIZONTAL; 
        gbc_btnEkle.gridwidth = 2;
        gbc_btnEkle.insets = new Insets(0, 20, 10, 20);
        gbc_btnEkle.gridx = 0; 
        gbc_btnEkle.gridy = 6;
        panelSol.add(btnEkle, gbc_btnEkle);

        JButton btnGuncelle = new JButton("Kitabı Güncelle");
        btnGuncelle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int viewRow = table.getSelectedRow();
                if (viewRow == -1) {
                    JOptionPane.showMessageDialog(null, "Güncellemek için tablodan bir kitap seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String baslik   = txtBaslik.getText().trim();
                String yazar    = txtYazar.getText().trim();
                String kategori = (String) cmbKategori.getSelectedItem();

                if (baslik.isEmpty() || yazar.isEmpty() || "Seçiniz".equals(kategori)) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int modelRow = table.convertRowIndexToModel(viewRow);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int kitapId = Integer.parseInt(model.getValueAt(modelRow, 0).toString());

                Model.Kitap guncelKitap = new Model.Kitap(baslik, yazar, kategori);
                guncelKitap.setKitapId(kitapId);

                KitapDAO kd = new KitapDAO();
                if (kd.kitapGuncelle(guncelKitap)) {
                    JOptionPane.showMessageDialog(null, "Kitap başarıyla güncellendi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    tabloyuYenile();
                    formuTemizle();
                } else {
                    JOptionPane.showMessageDialog(null, "Kitap güncellenirken hata oluştu!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        GridBagConstraints gbc_btnGuncelle = new GridBagConstraints();
        gbc_btnGuncelle.fill = GridBagConstraints.HORIZONTAL; 
        gbc_btnGuncelle.gridwidth = 2;
        gbc_btnGuncelle.insets = new Insets(0, 20, 30, 20);
        gbc_btnGuncelle.gridx = 0; 
        gbc_btnGuncelle.gridy = 7;
        panelSol.add(btnGuncelle, gbc_btnGuncelle);

        JSeparator altAyirici = new JSeparator();
        altAyirici.setForeground(new Color(92, 126, 164));
        GridBagConstraints gbc_altAyirici = new GridBagConstraints();
        gbc_altAyirici.fill = GridBagConstraints.HORIZONTAL; 
        gbc_altAyirici.ipadx = 1;
        gbc_altAyirici.gridwidth = 2; 
        gbc_altAyirici.insets = new Insets(0, 0, 35, 0);
        gbc_altAyirici.gridx = 0; 
        gbc_altAyirici.gridy = 8;
        panelSol.add(altAyirici, gbc_altAyirici);

        JPanel panelIcerik = new JPanel();
        panelIcerik.setBackground(new Color(92, 126, 164));
        panelIcerik.setLayout(new BorderLayout(0, 0));
        add(panelIcerik, BorderLayout.CENTER);

        JPanel panelArama = new JPanel();
        panelArama.setBackground(new Color(238, 238, 238));
        panelIcerik.add(panelArama, BorderLayout.NORTH);

        panelArama.add(new JLabel("Kitap Ara:"));

        txtArama = new JTextField();
        txtArama.setColumns(20);
        txtArama.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                uygulaFiltre();
            }
        });
        panelArama.add(txtArama);

        cmbAramaKategori = new JComboBox<>(new DefaultComboBoxModel<>(KATEGORILER));
        cmbAramaKategori.setBackground(new Color(147, 147, 147));
        cmbAramaKategori.setPreferredSize(new Dimension(150, 26));
        cmbAramaKategori.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uygulaFiltre();
            }
        });
        panelArama.add(cmbAramaKategori);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        panelIcerik.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setBackground(new Color(84, 100, 123));
        table.setGridColor(new Color(122, 138, 153));
        table.setRowHeight(25);
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "ID", "Kitap Adı", "Yazar", "Kategori", "Durum" }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) { 
                return false; 
            }
        });
        scrollPane.setViewportView(table);

        rowSorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
        table.setRowSorter(rowSorter);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int viewRow = table.getSelectedRow();
                if (viewRow >= 0) {
                    int modelRow = table.convertRowIndexToModel(viewRow);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    txtBaslik.setText(model.getValueAt(modelRow, 1).toString());
                    txtYazar.setText(model.getValueAt(modelRow, 2).toString());
                    cmbKategori.setSelectedItem(model.getValueAt(modelRow, 3).toString());
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

        JPanel panelDurum = new JPanel();
        panelDurum.setBackground(new Color(238, 238, 238));
        panelIcerik.add(panelDurum, BorderLayout.SOUTH);
        
        lblSistemDurumu = new JLabel("Sistem Durumu: Toplam Kitap: 0 | Ödünçte Olan: 0");
        lblSistemDurumu.setFont(new Font("Dialog", Font.BOLD, 16)); 
        panelDurum.add(lblSistemDurumu);

        JPopupMenu popupMenu = new JPopupMenu();
        table.setComponentPopupMenu(popupMenu);
        scrollPane.setComponentPopupMenu(popupMenu);

        JMenuItem mnuSil = new JMenuItem("Sil");
        mnuSil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int viewRow = table.getSelectedRow();
                if (viewRow == -1) return;

                int cevap = JOptionPane.showConfirmDialog(null,
                    "Bu kitabı silmek istediğinize emin misiniz?", "Silme Onayı",
                    JOptionPane.YES_NO_OPTION);

                if (cevap == JOptionPane.YES_OPTION) {
                    int modelRow = table.convertRowIndexToModel(viewRow);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int kitapId = Integer.parseInt(model.getValueAt(modelRow, 0).toString());

                    KitapDAO kd = new KitapDAO();
                    if (kd.kitapSil(kitapId)) {
                        JOptionPane.showMessageDialog(null, "Kitap başarıyla silindi!");
                        tabloyuYenile();
                        formuTemizle();
                    } else {
                        JOptionPane.showMessageDialog(null, "Hata oluştu!", "Hata", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        popupMenu.add(mnuSil);

        tabloyuYenile();
    }

    private void uygulaFiltre() {
        List<RowFilter<Object, Object>> filtreler = new ArrayList<>();

        String arananKelime = txtArama.getText().trim();
        if (!arananKelime.isEmpty()) {
            filtreler.add(RowFilter.regexFilter("(?i)" + arananKelime));
        }

        String secilenKategori = (String) cmbAramaKategori.getSelectedItem();
        if (secilenKategori != null && !"Seçiniz".equals(secilenKategori)) {
            filtreler.add(RowFilter.regexFilter("(?i)^" + Pattern.quote(secilenKategori) + "$", 3));
        }

        if (filtreler.isEmpty()) {
            rowSorter.setRowFilter(null);
        } else if (filtreler.size() == 1) {
            rowSorter.setRowFilter(filtreler.get(0));
        } else {
            rowSorter.setRowFilter(RowFilter.andFilter(filtreler));
        }
    }

    private void formuTemizle() {
        txtBaslik.setText("");
        txtYazar.setText("");
        cmbKategori.setSelectedIndex(0);
        table.clearSelection();
    }

    public void tabloyuYenile() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        KitapDAO kd = new KitapDAO();
        java.util.List<Model.Kitap> kitapListesi = kd.tumKitaplariGetir();

        int toplamKitap = 0, oduncteKitap = 0;
        for (Model.Kitap k : kitapListesi) {
            model.addRow(new Object[] {
                k.getKitapId(), k.getBaslik(), k.getYazar(),
                k.getKategori(), k.getDurum()
            });
            toplamKitap++;
            if (!"Rafta".equals(k.getDurum())) oduncteKitap++;
        }

        if (lblSistemDurumu != null) {
            lblSistemDurumu.setText(
                "Sistem Durumu: Toplam Kitap: " + toplamKitap +
                " | Ödünçte Olan: " + oduncteKitap);
        }

        uygulaFiltre();
    }
}

