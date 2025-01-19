/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andresortega.orm.view.repair;


import com.andresortega.controller.RepairService;
import com.andresortega.model.Repair;
import static com.andresortega.orm.view.util.Dialog.warningMessage;



/**
 *
 * @author Andrés
 */
public class ManageRepairPanelValidator {
    
    public static boolean areFieldsValid(int selectedIndex){
        if (!isEngineTypeValid(selectedIndex)) {
            return false;
        }
        return true;
    }
    
    public static boolean isEngineTypeValid(int selectedIndex) {

        if (selectedIndex == -1) {
            warningMessage("Selecciona un estado de reparación.", "Error");
            return false;
        }

        return true;
    }
    
    public static boolean isRowSelected(int selectedRow) {
        
        if (selectedRow == -1) {
            warningMessage("Selecciona una fila en la tabla.", "Error");
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean isUpdateRestricted(Repair r){
        
        if (repairIsPickedUp(r)) {
            warningMessage("El coche ya no está en el taller.", "Error");
            return true;
        }
        
        return false;
    }
    
    private static boolean repairIsPickedUp(Repair r) {
        return RepairService.repairIsPickedUp(r);
    }
}
