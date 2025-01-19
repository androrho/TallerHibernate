package com.andresortega.orm.view.car;

import com.andresortega.controller.CarService;
import com.andresortega.model.Car;
import static com.andresortega.orm.view.util.Dialog.errorMessage;
import static com.andresortega.orm.view.util.Dialog.warningMessage;

/**
 *
 * @author Andrés
 */
public class ModifyCarPanelValidator {
    
    private final static int LICENSE_PLATE_LENGTH = 9;
    private final static int BRAND_LENGTH = 45;
    private final static int MODEL_LENGTH = 45;
    
    protected static boolean areFieldsValid(String licensePlate, String brand, String model, int selectedIndex) {
        if (!isLicensePlateValid(licensePlate)) {
            return false;
        }
        if (!isBrandValid(brand)) {
            return false;
        }
        if (!isModelValid(model)) {
            return false;
        }
        if (!isEngineTypeValid(selectedIndex)) {
            return false;
        }

        return true;
    }
    
    private static boolean isLicensePlateValid(String str) {
        String text = str.trim();

        if (text.length() > LICENSE_PLATE_LENGTH) {
            warningMessage("Número máximo de carácteres en matrícula es " + LICENSE_PLATE_LENGTH + ".", "Advertencia");
            return false;
        }

        return true;
    }

    private static boolean isBrandValid(String str) {
        String text = str.trim();
        
        if (text.length() > BRAND_LENGTH) {
            warningMessage("Número máximo de carácteres en marca es " + BRAND_LENGTH + ".", "Advertencia");
            return false;
        }

        return true;
    }

    private static boolean isModelValid(String str) {
        String text = str.trim();

        if (text.length() > MODEL_LENGTH) {
            warningMessage("Número máximo de carácteres en modelo es " + MODEL_LENGTH + ".", "Advertencia");
            return false;
        }

        return true;
    }

    private static boolean isEngineTypeValid(int selectedIndex) {

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

    protected static boolean carExists(String str) {
        String licensePlate = str.trim();
        Car car = CarService.read(licensePlate);

        if (car != null) {
            errorMessage("El coche ya está registrado", "Error");
            return true;
        } else {
            return false;
        }
    }
}
