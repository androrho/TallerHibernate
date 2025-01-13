/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.andresortega.orm.view;

/**
 *
 * @author Andrés
 */
public class MainWindow extends javax.swing.JFrame {

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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuAddRepair = new javax.swing.JMenuItem();
        mnuModifyRepair = new javax.swing.JMenuItem();
        mnuDeleteRepair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuAddCustomer = new javax.swing.JMenuItem();
        mnuCustomerRepairHistory = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuAddCar = new javax.swing.JMenuItem();
        mnuCarRepairHistory = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Reparaciones");

        mnuAddRepair.setText("Añadir Reparaciones");
        jMenu1.add(mnuAddRepair);

        mnuModifyRepair.setText("Modificar Reparaciones");
        jMenu1.add(mnuModifyRepair);

        mnuDeleteRepair.setText("Eliminar Reparaciones");
        jMenu1.add(mnuDeleteRepair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clientes");

        mnuAddCustomer.setText("Añadir Cliente");
        jMenu2.add(mnuAddCustomer);

        mnuCustomerRepairHistory.setText("Histórico Reparaciones");
        jMenu2.add(mnuCustomerRepairHistory);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Coches");

        mnuAddCar.setText("Añadir Coche");
        jMenu3.add(mnuAddCar);

        mnuCarRepairHistory.setText("Histórico Reparaciones");
        jMenu3.add(mnuCarRepairHistory);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    /*
    private void deletePanels() {
        try {
            remove(gerenteAlta);
            pack();
        } catch (java.lang.NullPointerException ex) {
        }
        try {
            remove(gerenteConsulta);
            pack();
        } catch (java.lang.NullPointerException ex) {
        }
        try {
            remove(gerenteModificacion);
            pack();
        } catch (java.lang.NullPointerException ex) {
        }
        try {
            remove(gerenteAperturaCuentas);
            pack();
        } catch (java.lang.NullPointerException ex) {
        }
        try {
            remove(gerentePrestamos);
            pack();
        } catch (java.lang.NullPointerException ex) {
        }
        try {
            remove(cajeroTransacciones);
            pack();
        } catch (java.lang.NullPointerException ex) {
        }
        try {
            remove(cajeroPrestamos);
            pack();
        } catch (java.lang.NullPointerException ex) {
        }
    }
    */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnuAddCar;
    private javax.swing.JMenuItem mnuAddCustomer;
    private javax.swing.JMenuItem mnuAddRepair;
    private javax.swing.JMenuItem mnuCarRepairHistory;
    private javax.swing.JMenuItem mnuCustomerRepairHistory;
    private javax.swing.JMenuItem mnuDeleteRepair;
    private javax.swing.JMenuItem mnuModifyRepair;
    // End of variables declaration//GEN-END:variables
}
