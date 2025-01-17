package com.andresortega.orm.view.car;

import com.andresortega.controller.CarService;
import com.andresortega.model.Car;
import com.andresortega.model.EngineType;
import static com.andresortega.orm.view.car.AddCarPanel.infoMessage;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés
 */
public class ModifyCarPanel extends javax.swing.JPanel {

    private DefaultComboBoxModel modelCmbEngineType;
    DefaultTableModel modelTable;

    /**
     * Creates new form mnuModifyCar
     */
    public ModifyCarPanel() {
        initComboBoxModel();
        initTableModel();
        initComponents();
        initTableModelData();
        cmbEngineType.setSelectedIndex(-1);
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
        btnClean = new javax.swing.JButton();
        txtLicensePlate = new javax.swing.JTextField();
        txtBrand = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        cmbEngineType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(720, 457));

        jTable1.setModel(modelTable);
        jScrollPane1.setViewportView(jTable1);

        btnClean.setText("Limpiar Campos");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        cmbEngineType.setModel(modelCmbEngineType);
        cmbEngineType.setToolTipText("");

        jLabel1.setText("Marca");

        jLabel2.setText("Matrícula");

        jLabel3.setText("Modelo");

        jLabel4.setText("Tipo de motor");

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLicensePlate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtBrand, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtModel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cmbEngineType, javax.swing.GroupLayout.Alignment.TRAILING, 0, 110, Short.MAX_VALUE)))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLicensePlate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEngineType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnClean)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
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
        updateCar();
    }

    private void updateCar() {
        String currentLicensePlate = getCurrentLicensePlate();
        Car car = CarService.read(currentLicensePlate);

        car.setLicensePlate(getUpdatedLicensePlate(car.getLicensePlate()));
        car.setBrand(getUpdatedBrand(car.getBrand()));
        car.setModel(getUpdatedModel(car.getModel()));
        car.setEngineType(getUpdatedEngineType(car.getEngineType()));

        CarService.update(car);

        infoMessage("Coche actualizado", "Información");

        cleanFields();
        deleteTableModelRows();
        initTableModelData();

    }

    private boolean areFieldsValid() {
        String licensePlate = this.txtLicensePlate.getText().trim();
        String brand = this.txtBrand.getText().trim();
        String model = this.txtModel.getText().trim();
        int selectedIndex = this.cmbEngineType.getSelectedIndex();
        return ModifyCarPanelValidator.areFieldsValid(licensePlate, brand, model, selectedIndex);
    }

    private void initTableModel() {
        String[] columnNames = {"Matrícula", "Marca", "Modelo", "Tipo Motor"};

        modelTable = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
    }

    private void initTableModelData() {
        List<Car> cars = CarService.read();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);

            String licensePlate = car.getLicensePlate();
            String brand = car.getBrand();
            String model = car.getModel();
            EngineType engineType = car.getEngineType();

            String[] array = {licensePlate, brand, model, engineType.toString()};

            modelTable.addRow(array);
        }
    }

    private boolean isRowSelected() {
        return ModifyCarPanelValidator.isRowSelected(jTable1.getSelectedRow());
    }

    private void deleteTableModelRows() {
        int rowCount = modelTable.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            modelTable.removeRow(i);
        }
    }

    private void initComboBoxModel() {
        modelCmbEngineType = new DefaultComboBoxModel(EngineType.values());
    }

    private void cleanFields() {
        txtLicensePlate.setText("");
        txtBrand.setText("");
        txtModel.setText("");
        cmbEngineType.setSelectedIndex(-1);
    }

    private String getCurrentLicensePlate() {
        return ((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0)).trim();
    }

    private String getUpdatedLicensePlate(String current) {
        String updated = txtLicensePlate.getText().trim();

        if (updated.isBlank()) {
            return current;
        } else {
            return updated;
        }
    }

    private String getUpdatedBrand(String current) {
        String updated = txtBrand.getText().trim();

        if (updated.isBlank()) {
            return current;
        } else {
            return updated;
        }
    }

    private String getUpdatedModel(String current) {
        String updated = txtModel.getText().trim();

        if (updated.isBlank()) {
            return current;
        } else {
            return updated;
        }
    }

    private EngineType getUpdatedEngineType(EngineType current) {
        EngineType updated = (EngineType) cmbEngineType.getSelectedItem();

        if (updated == null) {
            return current;
        } else {
            return updated;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbEngineType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtLicensePlate;
    private javax.swing.JTextField txtModel;
    // End of variables declaration//GEN-END:variables
}
