package com.andresortega.orm.view.repair;


import com.andresortega.controller.RepairService;
import com.andresortega.model.Repair;
import static com.andresortega.orm.view.util.Dialog.errorMessage;
import static com.andresortega.orm.view.util.Dialog.warningMessage;



/**
 *
 * @author Andrés
 */
public class ManageRepairPanelValidator {
    
    protected static boolean areFieldsValid(int selectedIndex){
        
        if (!isEngineTypeValid(selectedIndex)) {
            return false;
        }
        
        return true;
    }
    
    private static boolean isEngineTypeValid(int selectedIndex) {

        if (selectedIndex == -1) {
            warningMessage("Selecciona un estado de reparación.", "Advertencia");
            return false;
        }

        return true;
    }
    
    protected static boolean isRowSelected(int selectedRow) {
        
        if (selectedRow == -1) {
            warningMessage("Selecciona una fila en la tabla.", "Advertencia");
            return false;
        } else {
            return true;
        }
    }
    
    protected static boolean isUpdateRestricted(Repair r){
        
        if (repairIsPickedUp(r)) {
            errorMessage("El coche ya no está en el taller.", "Error");
            return true;
        }
        
        return false;
    }
    
    private static boolean repairIsPickedUp(Repair r) {
        return RepairService.repairIsPickedUp(r);
    }
}
