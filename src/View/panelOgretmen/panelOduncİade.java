package View.panelOgretmen;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Dao.OduncDAO;

public class panelOduncİade extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtKitapId;
    private JTextField txtOgrenciNo;
    private JTextField txtArama;
    private JTable tableOdunc;

    public panelOduncİade() {
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
        gbc_ustAyirici.fill = GridBagConstraints.HORIZONTAL;
        gbc_ustAyirici.weightx = 1.0;
        gbc_ustAyirici.gridwidth = 2;
        gbc_ustAyirici.insets = new Insets(40, 16, 5, 16);
        gbc_ustAyirici.gridx = 0;
        gbc_ustAyirici.gridy = 0;
        panelSol.add(ustAyirici, gbc_ustAyirici);

        JLabel lblBaslik = new JLabel("Ödünç / İade");
        lblBaslik.setForeground(Color.WHITE);
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 18));
        GridBagConstraints gbc_lblBaslik = new GridBagConstraints();
        gbc_lblBaslik.weighty = 1.0; 
        gbc_lblBaslik.weightx = 1.0;
        gbc_lblBaslik.gridwidth = 2; 
        gbc_lblBaslik.insets = new Insets(20, 0, 20, 0);
        gbc_lblBaslik.gridx = 0; 
        gbc_lblBaslik.gridy = 1;
        panelSol.add(lblBaslik, gbc_lblBaslik);
        
        JSeparator ortaAyirici = new JSeparator();
        ortaAyirici.setForeground(new Color(92, 126, 164));
        GridBagConstraints gbc_ortaAyirici = new GridBagConstraints();
        gbc_ortaAyirici.fill = GridBagConstraints.HORIZONTAL;
        gbc_ortaAyirici.gridwidth = 2;
        gbc_ortaAyirici.insets = new Insets(0, 16, 12, 16);
        gbc_ortaAyirici.gridx = 0;
        gbc_ortaAyirici.gridy = 2;
        panelSol.add(ortaAyirici, gbc_ortaAyirici);

        JLabel lblKitapId = new JLabel("Kitap ID:");
        lblKitapId.setForeground(new Color(226, 232, 240));
        lblKitapId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        GridBagConstraints gbc_lblKitapId = new GridBagConstraints();
        gbc_lblKitapId.anchor = GridBagConstraints.EAST;
        gbc_lblKitapId.insets = new Insets(0, 10, 10, 5);
        gbc_lblKitapId.gridx = 0; 
        gbc_lblKitapId.gridy = 3;
        panelSol.add(lblKitapId, gbc_lblKitapId);

        txtKitapId = new JTextField();
        txtKitapId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtKitapId.setColumns(10);
        GridBagConstraints gbc_txtKitapId = new GridBagConstraints();
        gbc_txtKitapId.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtKitapId.insets = new Insets(0, 0, 10, 20);
        gbc_txtKitapId.gridx = 1; 
        gbc_txtKitapId.gridy = 3;
        panelSol.add(txtKitapId, gbc_txtKitapId);

        JLabel lblOgrenciNo = new JLabel("Öğrenci No:");
        lblOgrenciNo.setForeground(new Color(226, 232, 240));
        lblOgrenciNo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        GridBagConstraints gbc_lblOgrenciNo = new GridBagConstraints();
        gbc_lblOgrenciNo.anchor = GridBagConstraints.EAST;
        gbc_lblOgrenciNo.insets = new Insets(0, 10, 10, 5);
        gbc_lblOgrenciNo.gridx = 0; 
        gbc_lblOgrenciNo.gridy = 4;
        panelSol.add(lblOgrenciNo, gbc_lblOgrenciNo);

        txtOgrenciNo = new JTextField();
        txtOgrenciNo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtOgrenciNo.setColumns(10);
        GridBagConstraints gbc_txtOgrenciNo = new GridBagConstraints();
        gbc_txtOgrenciNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtOgrenciNo.insets = new Insets(0, 0, 10, 20);
        gbc_txtOgrenciNo.gridx = 1; 
        gbc_txtOgrenciNo.gridy = 4;
        panelSol.add(txtOgrenciNo, gbc_txtOgrenciNo);

        JButton btnOduncVer = new JButton("Kitabı Ödünç Ver");
        btnOduncVer.setBackground(new Color(16, 185, 129)); 
        btnOduncVer.setForeground(Color.WHITE);
        btnOduncVer.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnOduncVer.setFocusPainted(false);
        btnOduncVer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnOduncVer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kitapIdStr = txtKitapId.getText().trim();
                String ogrenciNo = txtOgrenciNo.getText().trim();
                
                if (kitapIdStr.isEmpty() || ogrenciNo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Kitap ID ve Öğrenci No boş olamaz!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                int kitapId;
                try {
                    kitapId = Integer.parseInt(kitapIdStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Kitap ID sayısal olmalıdır!", "Hata", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                OduncDAO dao = new OduncDAO();
                if (dao.oduncVer(kitapId, ogrenciNo)) {
                    JOptionPane.showMessageDialog(null, "Kitap ödünç verildi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    oduncleriYenile();
                    txtKitapId.setText("");
                    txtOgrenciNo.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "İşlem başarısız! Kitap rafta değil veya öğrenci no hatalı.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        GridBagConstraints gbc_btnOduncVer = new GridBagConstraints();
        gbc_btnOduncVer.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnOduncVer.gridwidth = 2;
        gbc_btnOduncVer.insets = new Insets(0, 20, 10, 20);
        gbc_btnOduncVer.gridx = 0; 
        gbc_btnOduncVer.gridy = 7;
        panelSol.add(btnOduncVer, gbc_btnOduncVer);

        JButton btnIadeAl = new JButton("Seçili Kitabı İade Al");
        btnIadeAl.setBackground(new Color(37, 99, 235)); 
        btnIadeAl.setForeground(Color.WHITE);
        btnIadeAl.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnIadeAl.setFocusPainted(false);
        btnIadeAl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnIadeAl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int satir = tableOdunc.getSelectedRow();
                if (satir == -1) { 
                    JOptionPane.showMessageDialog(null, "İade alınacak kaydı tablodan seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE); 
                    return; 
                }
                
                int modelSatir = tableOdunc.convertRowIndexToModel(satir);
                int islemId = Integer.parseInt(tableOdunc.getModel().getValueAt(modelSatir, 0).toString());
                int kitapId = Integer.parseInt(tableOdunc.getModel().getValueAt(modelSatir, 1).toString());
                
                OduncDAO dao = new OduncDAO();
                if (dao.iadeAl(islemId, kitapId)) {
                    JOptionPane.showMessageDialog(null, "Kitap iade alındı!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    oduncleriYenile();
                }
            }
        });
        GridBagConstraints gbc_btnIadeAl = new GridBagConstraints();
        gbc_btnIadeAl.insets = new Insets(0, 20, 20, 20);
        gbc_btnIadeAl.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnIadeAl.anchor = GridBagConstraints.NORTH;
        gbc_btnIadeAl.gridwidth = 2;
        gbc_btnIadeAl.gridx = 0; 
        gbc_btnIadeAl.gridy = 9;
        panelSol.add(btnIadeAl, gbc_btnIadeAl);


        JPanel panelIcerik = new JPanel();
        panelIcerik.setBackground(new Color(248, 250, 252));
        add(panelIcerik, BorderLayout.CENTER);
        panelIcerik.setLayout(new BorderLayout(0, 0));

        JPanel panelArama = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 10));
        panelArama.setBackground(new Color(241, 245, 249)); 
        panelArama.setBorder(new EmptyBorder(8, 12, 8, 12));
        panelIcerik.add(panelArama, BorderLayout.NORTH);

        JLabel lblArama = new JLabel("Ödünç Ara:");
        lblArama.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        panelArama.add(lblArama);

        txtArama = new JTextField(20);
        txtArama.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtArama.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                oduncFiltrele(txtArama.getText());
            }
        });
        panelArama.add(txtArama);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new EmptyBorder(0, 16, 16, 16));
        panelIcerik.add(scrollPane, BorderLayout.CENTER);

        tableOdunc = new JTable();
        tableOdunc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tableOdunc.setRowHeight(30);
        tableOdunc.setGridColor(new Color(203, 213, 225));
        tableOdunc.setSelectionBackground(new Color(219, 234, 254));
        tableOdunc.setSelectionForeground(new Color(30, 41, 59));
        tableOdunc.setBackground(Color.WHITE);
        tableOdunc.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableOdunc.getTableHeader().setBackground(new Color(226, 232, 240));
        tableOdunc.getTableHeader().setForeground(new Color(30, 41, 59));
        
        tableOdunc.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "İşlem ID", "Kitap ID", "Kitap Adı", "Öğrenci No", "Öğrenci Adı", "Alış Tarihi" }) {
            boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        
        tableOdunc.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int modelRow = table.convertRowIndexToModel(row);
                Object tarihObj = table.getModel().getValueAt(modelRow, 5);
                
                if (!isSelected) {
                    if (OduncDAO.gecikmisMi(tarihObj != null ? tarihObj.toString() : null)) {
                        setBackground(new Color(254, 202, 202));
                    } else {
                        setBackground(Color.WHITE);
                    }
                }
                return this;
            }
        });
        scrollPane.setViewportView(tableOdunc);

        oduncleriYenile();
    }


    private void oduncFiltrele(String metin) {
        DefaultTableModel model = (DefaultTableModel) tableOdunc.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tableOdunc.setRowSorter(sorter);
        
        if (metin == null || metin.trim().isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + metin, 2, 3, 4));
        }
    }

    public void oduncleriYenile() {
        tableOdunc.setRowSorter(null);
        DefaultTableModel model = (DefaultTableModel) tableOdunc.getModel();
        model.setRowCount(0);
        
        OduncDAO dao = new OduncDAO();
        for (Model.OduncIslem o : dao.aktifOduncleriGetir()) {
            model.addRow(new Object[] { 
                o.getIslemId(), 
                o.getKitapId(), 
                o.getKitapBaslik(), 
                o.getOgrenciNo(), 
                o.getUyeAdSoyad(), 
                o.getAlisTarihi() 
            });
        }
    }
}