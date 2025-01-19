package com.andresortega.orm.view.car;

import com.andresortega.controller.CarService;
import com.andresortega.controller.RepairService;
import com.andresortega.model.Car;
import com.andresortega.model.Repair;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Andrés
 */
public class CarRepairHistoryPanel extends javax.swing.JPanel {
    
    private DefaultComboBoxModel modelCmbCars;
    private DefaultTableModel modelTable;
    
    /**
     * Creates new form mnuCarRepairHistory
     */
    public CarRepairHistoryPanel() {
        initComboBoxModel();
        initTableModel();
        initComponents();
    }
    
    private void initComboBoxModel() {
        List<Car> cars = CarService.read();
        modelCmbCars = new DefaultComboBoxModel();
        modelCmbCars.addAll(cars);
    }
    
    private void initTableModel() {
        String[] columnNames = {"Cliente", "Precio", "Fecha y hora", "Descripción"};

        modelTable = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
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
        cmbCars = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(720, 457));

        jTable1.setModel(modelTable);
        jScrollPane1.setViewportView(jTable1);

        cmbCars.setModel(modelCmbCars);
        cmbCars.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCarsItemStateChanged(evt);
            }
        });

        jLabel1.setText("Coche:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(cmbCars, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCarsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCarsItemStateChanged
        updateTable();
    }//GEN-LAST:event_cmbCarsItemStateChanged

    private void updateTable(){
        deleteTableModelRows();
        addTableModelData();
    }
    
    private void deleteTableModelRows() {
        int rowCount = modelTable.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            modelTable.removeRow(i);
        }
    }
    private void addTableModelData() {
        Car car = (Car)cmbCars.getSelectedItem();
        
        List<Repair> repairs = RepairService.findByCar(car);
        for (int i = 0; i < repairs.size(); i++) {
            Repair repair = repairs.get(i);
            
            String customer = repair.getCustomer().toString();
            String price = repair.getPrice().toString() + " €";
            String date = repair.getDate().toString();
            String description = repair.getDescription();
            
            String[] array = {customer, price, date, description};
            
            modelTable.addRow(array);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCars;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
