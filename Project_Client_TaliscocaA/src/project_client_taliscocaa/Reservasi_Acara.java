/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project_client_taliscocaa;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jason Nathaniel
 */
public class Reservasi_Acara extends javax.swing.JFrame {

    public Reservasi_Acara() {
        initComponents();
        refreshTable();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAcara = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnClaim = new javax.swing.JButton();
        btnClaim2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        tableAcara.setBackground(new java.awt.Color(204, 204, 204));
        tableAcara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "tanggal_reservasi", "jumlah", "status", "user_id", "acara_id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAcara);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 80, 710, 350);

        jLabel2.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RESERVASI ACARA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(280, 10, 360, 47);

        btnClaim.setBackground(new java.awt.Color(204, 204, 204));
        btnClaim.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClaim.setForeground(new java.awt.Color(51, 51, 51));
        btnClaim.setText("Claim");
        btnClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClaimActionPerformed(evt);
            }
        });
        getContentPane().add(btnClaim);
        btnClaim.setBounds(770, 450, 100, 32);

        btnClaim2.setBackground(new java.awt.Color(204, 204, 204));
        btnClaim2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClaim2.setForeground(new java.awt.Color(51, 51, 51));
        btnClaim2.setText("Exit");
        btnClaim2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClaim2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnClaim2);
        btnClaim2.setBounds(60, 450, 100, 32);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/ACARA.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClaimActionPerformed
        int selectedRow = tableAcara.getSelectedRow();
    
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih baris yang ingin diklaim.");
            return;
        }

        int columnCount = tableAcara.getColumnCount();
        if (columnCount < 4) {
            JOptionPane.showMessageDialog(this, "Jumlah kolom di tabel tidak sesuai dengan yang diharapkan.");
            return;
        }

        String reservasiAcaraIdStr = tableAcara.getValueAt(selectedRow, 0).toString(); 
        int reservasiAcaraId = Integer.parseInt(reservasiAcaraIdStr);
        System.out.println(reservasiAcaraId);
        String statusAcara = (String) tableAcara.getValueAt(selectedRow, 3);

        if (statusAcara.equals("Not Claimed")) {
            updateDataReservasiAcara(reservasiAcaraId);
            JOptionPane.showMessageDialog(this, "Acara berhasil diklaim.");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Acara sudah diklaim.");
        }
    }//GEN-LAST:event_btnClaimActionPerformed

    private void btnClaim2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClaim2ActionPerformed
        // TODO add your handling code here:
        thankyou thanks = new thankyou();
        thanks.show();
    }//GEN-LAST:event_btnClaim2ActionPerformed
    
    public void refreshTable() {
        DefaultTableModel tableModel = (DefaultTableModel) tableAcara.getModel();
        tableModel.setRowCount(0);  
        Menu form = new Menu();
        List<String> dataList = viewListDataReservasiAcara(form.user_id);
        System.out.println("masuk");
        System.out.println(form.user_id);
        for (String data : dataList) {
            String[] splitData = data.split("%");
            tableModel.addRow(splitData);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        Menu form = new Menu();
        System.out.println(form.user_id);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reservasi_Acara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservasi_Acara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservasi_Acara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservasi_Acara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservasi_Acara().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClaim;
    private javax.swing.JButton btnClaim2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAcara;
    // End of variables declaration//GEN-END:variables


    private static void updateDataReservasiAcara(int reservasiId) {
        project_client_taliscocaa.ProjectWebservice_Service service = new project_client_taliscocaa.ProjectWebservice_Service();
        project_client_taliscocaa.ProjectWebservice port = service.getProjectWebservicePort();
        port.updateDataReservasiAcara(reservasiId);
    }

    private static java.util.List<java.lang.String> viewListDataReservasiAcara(int userId) {
        project_client_taliscocaa.ProjectWebservice_Service service = new project_client_taliscocaa.ProjectWebservice_Service();
        project_client_taliscocaa.ProjectWebservice port = service.getProjectWebservicePort();
        return port.viewListDataReservasiAcara(userId);
    }
}
