package com.andresortega.orm.view.main;

import com.andresortega.orm.view.car.AddCarPanel;
import com.andresortega.orm.view.car.CarRepairHistoryPanel;
import com.andresortega.orm.view.car.ModifyCarPanel;
import com.andresortega.orm.view.customer.AddCustomerPanel;
import com.andresortega.orm.view.customer.ModifyCustomerPanel;
import com.andresortega.orm.view.repair.AddRepairPanel;
import com.andresortega.orm.view.repair.ManageRepairPanel;
import com.andresortega.orm.view.repair.ModifyRepairPanel;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Andrés
 */
public class MainWindow extends javax.swing.JFrame {

    JPanel panel;
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuAddRepair = new javax.swing.JMenuItem();
        mnuManageRepair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuAddCustomer = new javax.swing.JMenuItem();
        mnuModifyCustomer = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuAddCar = new javax.swing.JMenuItem();
        mnuModifyCar = new javax.swing.JMenuItem();
        mnuCarRepairHistory = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Reparaciones");

        mnuAddRepair.setText("Añadir Reparaciones");
        mnuAddRepair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAddRepairActionPerformed(evt);
            }
        });
        jMenu1.add(mnuAddRepair);

        mnuManageRepair.setText("Gestionar Reparaciones");
        mnuManageRepair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuManageRepairActionPerformed(evt);
            }
        });
        jMenu1.add(mnuManageRepair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clientes");

        mnuAddCustomer.setText("Añadir Cliente");
        mnuAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAddCustomerActionPerformed(evt);
            }
        });
        jMenu2.add(mnuAddCustomer);

        mnuModifyCustomer.setText("Modificar Cliente");
        mnuModifyCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModifyCustomerActionPerformed(evt);
            }
        });
        jMenu2.add(mnuModifyCustomer);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Coches");

        mnuAddCar.setText("Añadir Coche");
        mnuAddCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAddCarActionPerformed(evt);
            }
        });
        jMenu3.add(mnuAddCar);

        mnuModifyCar.setText("Modificar Coche");
        mnuModifyCar.setToolTipText("");
        mnuModifyCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModifyCarActionPerformed(evt);
            }
        });
        jMenu3.add(mnuModifyCar);

        mnuCarRepairHistory.setText("Histórico Reparaciones");
        mnuCarRepairHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCarRepairHistoryActionPerformed(evt);
            }
        });
        jMenu3.add(mnuCarRepairHistory);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAddRepairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAddRepairActionPerformed
        deletePanels();
        panel = new AddRepairPanel();
        addPanel(panel);
    }//GEN-LAST:event_mnuAddRepairActionPerformed

    private void mnuManageRepairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuManageRepairActionPerformed
        deletePanels();
        panel = new ManageRepairPanel();
        addPanel(panel);
    }//GEN-LAST:event_mnuManageRepairActionPerformed

    private void mnuAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAddCustomerActionPerformed
        deletePanels();
        panel = new AddCustomerPanel();
        addPanel(panel);
    }//GEN-LAST:event_mnuAddCustomerActionPerformed

    private void mnuModifyCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModifyCustomerActionPerformed
        deletePanels();
        panel = new ModifyCustomerPanel();
        addPanel(panel);
    }//GEN-LAST:event_mnuModifyCustomerActionPerformed

    private void mnuAddCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAddCarActionPerformed
        deletePanels();
        panel = new AddCarPanel();
        addPanel(panel);
    }//GEN-LAST:event_mnuAddCarActionPerformed

    private void mnuModifyCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModifyCarActionPerformed
        deletePanels();
        panel = new ModifyCarPanel();
        addPanel(panel);
    }//GEN-LAST:event_mnuModifyCarActionPerformed

    private void mnuCarRepairHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCarRepairHistoryActionPerformed
        deletePanels();
        panel = new CarRepairHistoryPanel();
        addPanel(panel);
    }//GEN-LAST:event_mnuCarRepairHistoryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            for (LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                System.out.println(info.getClassName());
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                } else if ("GTK+".equals(info.getName()))
                    UIManager.setLookAndFeel(info.getClassName());
            }
        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex){
            
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    private void addPanel(JPanel jpanel){
        add(jpanel).setVisible(true);
        revalidate();
        repaint();
        pack();
    }
    
    private void deletePanels() {
        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof JPanel) {
                getContentPane().remove(comp);
            }
        }
        revalidate();
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem mnuAddCar;
    private javax.swing.JMenuItem mnuAddCustomer;
    private javax.swing.JMenuItem mnuAddRepair;
    private javax.swing.JMenuItem mnuCarRepairHistory;
    private javax.swing.JMenuItem mnuManageRepair;
    private javax.swing.JMenuItem mnuModifyCar;
    private javax.swing.JMenuItem mnuModifyCustomer;
    // End of variables declaration//GEN-END:variables
}
