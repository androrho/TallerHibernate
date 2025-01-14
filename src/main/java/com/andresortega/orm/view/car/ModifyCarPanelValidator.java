package com.andresortega.orm.view.car;

import com.andresortega.database.CarService;
import com.andresortega.model.Car;
import static com.andresortega.orm.view.car.AddCarPanelValidator.BRAND_LENGTH;
import static com.andresortega.orm.view.car.AddCarPanelValidator.LICENSE_PLATE_LENGTH;
import static com.andresortega.orm.view.car.AddCarPanelValidator.MODEL_LENGTH;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés
 */
public class ModifyCarPanelValidator {
    static boolean areFieldsValid(String licensePlate, String brand, String model, int selectedIndex) {
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
    
    public static boolean isLicensePlateValid(String str) {
        String text = str.trim();

        if (text.length() > LICENSE_PLATE_LENGTH) {
            errorMessage("Número máximo de carácteres en matrícula es " + LICENSE_PLATE_LENGTH + ".", "Error");
            return false;
        }

        return true;
    }

    public static boolean isBrandValid(String str) {
        String text = str.trim();
        
        if (text.length() > BRAND_LENGTH) {
            errorMessage("Número máximo de carácteres en marca es " + BRAND_LENGTH + ".", "Error");
            return false;
        }

        return true;
    }

    public static boolean isModelValid(String str) {
        String text = str.trim();

        if (text.length() > MODEL_LENGTH) {
            errorMessage("Número máximo de carácteres en modelo es " + MODEL_LENGTH + ".", "Error");
            return false;
        }

        return true;
    }

    public static boolean isEngineTypeValid(int selectedIndex) {

        return true;
    }

    public static boolean isRowSelected(int selectedRow) {
        
        if (selectedRow == -1) {
            errorMessage("Selecciona una fila en la tabla.", "Error");
            return false;
        } else {
            return true;
        }
    }
    
    public static void errorMessage(String message, String title) {
        String rutaImagen = "src/images/advertencia.png";
        ImageIcon icono = new ImageIcon(rutaImagen);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE, icono);
    }

    public static boolean carExists(String str) {
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
