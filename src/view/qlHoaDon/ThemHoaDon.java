/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.qlHoaDon;

import controller.HoaDonDAO;
import controller.KhachHangDAO;
import controller.MonAnDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.KhachHang;
import model.MonAn;

/**
 *
 * @author hung
 */
public class ThemHoaDon extends javax.swing.JDialog {

    private QLHoaDon father;
    private DefaultTableModel tableModel;
    private HoaDon hd;
    private int soLan;

    /**
     * Creates new form ThemHD
     */
    public ThemHoaDon(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.father = (QLHoaDon) parent;
        txtNgay.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        tableModel = (DefaultTableModel) tblDsMon.getModel();
        hd = new HoaDon(0, 0, new Date(), 0, 0, new TreeMap<>());
    }

    public void showDsMonAn() {
        tableModel.setRowCount(0);
        hd.getMonanList().forEach((ma, soLuong) -> {
            tableModel.addRow(new Object[]{
                ma.getMa_ma(), ma.getTen_mon(), ma.getDon_gia(), soLuong
            });
        });
        setThanhTien();
    }

    public void setKhachHang(int ma_kh) {
        try {
            txtMaKH.setText(ma_kh + "");
            hd.setMa_kh(ma_kh);
            soLan = KhachHangDAO.getSoLan(ma_kh) + 1;
            setThanhTien();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void themMon(MonAn ma, int soLuong) {
        hd.getMonanList().put(ma, soLuong);
        showDsMonAn();
    }

    private void setThanhTien() {
        int thanhTien = 0;
        Map<MonAn, Integer> maList = hd.getMonanList();
        for (MonAn ma : maList.keySet()) {
            int soLuong = maList.get(ma);
            thanhTien += ma.getDon_gia() * soLuong;
        }
        int chietKhau = 0;
        if (soLan > 0) {
            if (soLan % 10 == 0) {
                chietKhau = (int) Math.floor(thanhTien * 0.2);
            } else if (soLan % 5 == 0) {
                chietKhau = (int) Math.floor(thanhTien * 0.1);
            }
        }
        thanhTien -= chietKhau;
        txtThanhTien.setText(thanhTien + "");
        txtChietKhau.setText(chietKhau + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        btnChonKh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDsMon = new javax.swing.JTable();
        btnThemHd = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnThemMon = new javax.swing.JButton();
        btnXoaMon = new javax.swing.JButton();
        btnTang = new javax.swing.JButton();
        btnGiam = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtChietKhau = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm hoá đơn");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Ngày");

        txtNgay.setEditable(false);
        txtNgay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Mã khách hàng*");

        txtMaKH.setEditable(false);
        txtMaKH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnChonKh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnChonKh.setText("Chọn khách hàng");
        btnChonKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKhActionPerformed(evt);
            }
        });

        tblDsMon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDsMon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã món", "Tên món", "Đơn giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDsMon.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDsMon.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDsMon);
        if (tblDsMon.getColumnModel().getColumnCount() > 0) {
            tblDsMon.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        btnThemHd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThemHd.setText("Thêm hoá đơn");
        btnThemHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHdActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHuy.setText("Huỷ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnThemMon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThemMon.setText("Thêm món");
        btnThemMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMonActionPerformed(evt);
            }
        });

        btnXoaMon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnXoaMon.setText("Xoá món");
        btnXoaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMonActionPerformed(evt);
            }
        });

        btnTang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnTang.setText("+");
        btnTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTangActionPerformed(evt);
            }
        });

        btnGiam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGiam.setText("-");
        btnGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnTang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGiam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemMon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMon)
                    .addComponent(btnXoaMon)
                    .addComponent(btnTang)
                    .addComponent(btnGiam))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Thành tiền");

        txtThanhTien.setEditable(false);
        txtThanhTien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Chiết khấu");

        txtChietKhau.setEditable(false);
        txtChietKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMaKH)
                                .addGap(18, 18, 18)
                                .addComponent(btnChonKh))
                            .addComponent(txtNgay)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemHd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChietKhau)
                            .addComponent(txtThanhTien))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonKh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemHd)
                    .addComponent(btnHuy))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMonActionPerformed
        try {
            // TODO add your handling code here:
            new ChonMonAn(this, true).setVisible(true);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnThemMonActionPerformed

    private void btnThemHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHdActionPerformed
        // TODO add your handling code here:
        if (hd.getMa_kh() >= 1 && !hd.getMonanList().isEmpty()) {
            try {
                int ma_hd = HoaDonDAO.addHoaDon(hd);
                father.showHoaDon();
                JOptionPane.showMessageDialog(rootPane, "Thêm hoá đơn thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnThemHdActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXoaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMonActionPerformed
        // TODO add your handling code here:
        int row = tblDsMon.getSelectedRow();
        if (row >= 0) {
            try {
                if (JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xoá", "Xác nhận",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    int ma_ma = (int) tblDsMon.getValueAt(row, 0);
                    MonAn selectedMa = MonAnDAO.getMonAn(ma_ma);
                    hd.getMonanList().remove(selectedMa);
                    showDsMonAn();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn món muốn xoá", "Thông báo", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaMonActionPerformed

    private void btnChonKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKhActionPerformed
        try {
            // TODO add your handling code here:
            new ChonKhachHang(this, true).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChonKhActionPerformed

    private void btnTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTangActionPerformed
        // TODO add your handling code here:
        int row = tblDsMon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn vào 1 món ăn", "Thông báo", JOptionPane.PLAIN_MESSAGE);
        } else {
            try {
                int soluong = Integer.parseInt(tableModel.getValueAt(row, 3).toString()) + 1;
                tableModel.setValueAt(soluong + "", row, 3);
                MonAn ma = MonAnDAO.getMonAn((int) tableModel.getValueAt(row, 0));
                hd.getMonanList().put(ma, soluong);
                setThanhTien();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnTangActionPerformed

    private void btnGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiamActionPerformed
        // TODO add your handling code here:
        int row = tblDsMon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn vào 1 món ăn", "Thông báo", JOptionPane.PLAIN_MESSAGE);
        } else {
            try {
                int soluong = Integer.parseInt(tableModel.getValueAt(row, 3).toString()) - 1;
                if (soluong == 0) {
                    btnXoaMonActionPerformed(evt);
                    return;
                }
                tableModel.setValueAt(soluong + "", row, 3);
                MonAn ma = MonAnDAO.getMonAn((int) tableModel.getValueAt(row, 0));
                hd.getMonanList().put(ma, soluong);
                setThanhTien();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGiamActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemHoaDon dialog = new ThemHoaDon(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonKh;
    private javax.swing.JButton btnGiam;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnTang;
    private javax.swing.JButton btnThemHd;
    private javax.swing.JButton btnThemMon;
    private javax.swing.JButton btnXoaMon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDsMon;
    private javax.swing.JTextField txtChietKhau;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
