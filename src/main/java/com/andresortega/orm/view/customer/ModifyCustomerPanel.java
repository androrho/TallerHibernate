package com.andresortega.orm.view.customer;

import com.andresortega.controller.CustomerService;
import com.andresortega.model.Customer;
import com.andresortega.model.Repair;
import static com.andresortega.orm.view.util.Dialog.infoMessage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés
 */
public class ModifyCustomerPanel extends javax.swing.JPanel {
    
    DefaultTableModel modelTable;
    
    /**
     * Creates new form mnuModifyCustomer
     */
    public ModifyCustomerPanel() {
        initTableModel();
        initComponents();
        initTableModelData();
    }
    
    private void initTableModel() {
        String[] columnNames = {"DNI", "Nombre", "Edad"};

        modelTable = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
    }

    private void initTableModelData() {
        List<Customer> customers = CustomerService.read();
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);

            String dni = customer.getDni();
            String name = customer.getName();
            String age = String.valueOf(customer.getAge());

            String[] array = {dni, name, age};

            modelTable.addRow(array);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAge = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        txtDni = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(720, 457));

        jLabel1.setText("Nombre");

        jLabel2.setText("DNI");

        jLabel3.setText("Edad");

        jTable1.setModel(modelTable);
        jScrollPane1.setViewportView(jTable1);

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClean.setText("Limpiar Campos");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .addComponent(txtAge, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnClean)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        cleanFields();
    }//GEN-LAST:event_btnCleanActionPerformed
    
    private void update() {
        if (!areFieldsValid()) {
            return;
        }
        if (!isRowSelected()) {
            return;
        }
        updateCar();
        infoMessage("Cliente actualizado", "Información");
        updateTable();
        cleanFields();
    }
    
    private boolean areFieldsValid() {
        String dni = this.txtDni.getText().trim();
        String name = this.txtName.getText().trim();
        String age = this.txtAge.getText().trim();
        return ModifyCustomerPanelValidator.areFieldsValid(dni, name, age);
    }
    
    private boolean isRowSelected() {
        return ModifyCustomerPanelValidator.isRowSelected(jTable1.getSelectedRow());
    }
    
    private void updateCar() {
        String currentDni = getCurrentDni();
        Customer customer = CustomerService.read(currentDni);
        ArrayList<Repair> a = new ArrayList<>();
        a.indexOf(a);
        customer.setDni(getUpdatedDni(customer.getDni()));
        customer.setName(getUpdatedName(customer.getName()));
        customer.setAge(getUpdatedAge(customer.getAge()));

        CustomerService.update(customer);
    }
    
    private String getCurrentDni() {
        return ((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0)).trim();
    }
    
    private String getUpdatedDni(String current) {
        String updated = txtDni.getText().trim();

        if (updated.isBlank()) {
            return current;
        } else {
            return updated;
        }
    }

    private String getUpdatedName(String current) {
        String updated = txtName.getText().trim();

        if (updated.isBlank()) {
            return current;
        } else {
            return updated;
        }
    }

    private int getUpdatedAge(int current) {
        String updated = txtAge.getText().trim();

        if (updated.isBlank()) {
            return current;
        } else {
            return Integer.parseInt(updated);
        }
    }
    
    private void updateTable(){
        deleteTableModelRows();
        initTableModelData();
    }
    
    private void deleteTableModelRows() {
        int rowCount = modelTable.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            modelTable.removeRow(i);
        }
    }
    
    private void cleanFields() {
        txtDni.setText("");
        txtName.setText("");
        txtAge.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
