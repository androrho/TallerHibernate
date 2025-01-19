/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.andresortega.orm.view.repair;

import com.andresortega.controller.RepairService;
import com.andresortega.model.Repair;
import com.andresortega.model.RepairState;
import com.andresortega.orm.view.car.ModifyCarPanelValidator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Andrés
 */
public class ManageRepairPanel extends javax.swing.JPanel {
    private DefaultComboBoxModel modelCmbRepairState;
    DefaultTableModel modelTableRepairs;
    /**
     * Creates new form ManageRepairPanle
     */
    public ManageRepairPanel() {
        initComboBoxModel();
        initTableModel();
        initComponents();
        initTableModelData();
        cmbRepairState.setSelectedIndex(-1);
        setColumnWidths(jTable1,-1, 70, 70, 70, 100, 400, 70);
    }

    private void initComboBoxModel(){
        modelCmbRepairState = new DefaultComboBoxModel(RepairState.values());
    }
    
    private void initTableModel(){        
        String[] columnNames = {"Id","Cliente", "Coche", "Precio", "Fecha y hora", "Descripción", "Estado"};

        modelTableRepairs = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
    }
    
    private void initTableModelData(){
        List<Repair> repairs = RepairService.read();
        for (int i = 0; i < repairs.size(); i++) {
            Repair repair = repairs.get(i);
            
            String id = String.valueOf(repair.getRepairId());
            String customer = repair.getCustomer().toString();
            String car = repair.getCar().toString();
            String price = String.valueOf(repair.getPrice());
            String timeStamp = repair.getDate().toString();
            String description = repair.getDescription();
            String repairState = repair.getRepairState().toString();

            String[] array = {id, customer, car, price, timeStamp, description, repairState};

            modelTableRepairs.addRow(array);
        }
    }
    
    private void setColumnWidths(JTable table, int... widths) {
    TableColumnModel columnModel = table.getColumnModel();
    for (int i = 0; i < widths.length; i++) {
        columnModel.getColumn(i).setMaxWidth(widths[i]);
    }
    
    jTable1.getColumn("Id").setMinWidth(0); // Must be set before maxWidth!!
    jTable1.getColumn("Id").setMaxWidth(0);
    jTable1.getColumn("Id").setWidth(0);
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbRepairState = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();

        jTable1.setModel(modelTableRepairs);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Estado de reparación");

        cmbRepairState.setModel(modelCmbRepairState);

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClean.setText("Limpiar");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmbRepairState, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRepairState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnClean))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        cleanFields();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    
    private void update() {
        if (!areFieldsValid()) {
            return;
        }
        if (!isRowSelected()) {
            return;
        }
        if (isUpdateRestricted()){
            return;
        }
        updateRepair();
        updateTable();
    }
    
    private boolean areFieldsValid() {
        int selectedIndex = cmbRepairState.getSelectedIndex();
        return ManageRepairPanelValidator.areFieldsValid(selectedIndex);
    }
    
    private boolean isRowSelected() {
        return ManageRepairPanelValidator.isRowSelected(jTable1.getSelectedRow());
    }
    
    private boolean isUpdateRestricted() {
        int repairId = getRepairId();
        Repair repair = RepairService.read(repairId);

        return ManageRepairPanelValidator.isUpdateRestricted(repair);
    }
    
    private int getRepairId(){
        return Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
    }
    
    private void updateRepair(){
        int repairId = getRepairId();
        Repair repair = RepairService.read(repairId);
        RepairState repairState = (RepairState)cmbRepairState.getSelectedItem();
        
        repair.setRepairState(repairState);
        
        RepairService.update(repair);
    }
    
    private void updateTable(){
        deleteTableModelRows();
        initTableModelData();
    }
    
    private void deleteTableModelRows(){
        int rowCount = modelTableRepairs.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            modelTableRepairs.removeRow(i);
        }
    }
    
    private void cleanFields(){
        cmbRepairState.setSelectedIndex(-1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbRepairState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
