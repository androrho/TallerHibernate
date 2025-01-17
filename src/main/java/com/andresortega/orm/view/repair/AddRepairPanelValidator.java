package com.andresortega.orm.view.repair;

import com.andresortega.controller.CarService;
import com.andresortega.controller.CustomerService;
import com.andresortega.controller.RepairService;
import com.andresortega.model.Car;
import com.andresortega.model.Customer;
import com.andresortega.model.Repair;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés
 */
public class AddRepairPanelValidator {

    final static int PRICE_LENGTH = 10;
    final static int DESCRIPTION_LENGTH = 200;

    static boolean areFieldsValid(Car selectedCar, Customer selectedCustomer, String price, String description) {
        if (!isCarValid(selectedCar)) {
            return false;
        }
        if (!isCustomerValid(selectedCustomer)) {
            return false;
        }
        if (!isPriceValid(price)) {
            return false;
        }
        if (!isDescriptionValid(description)) {
            return false;
        }

        return true;
    }

    public static boolean isCarValid(Car c) {

        if (c == null) {
            errorMessage("Selecciona un coche", "Error");
            return false;
        }
        if (!carExists(c)) {
            errorMessage("El coche no existe", "Error");
            return false;
        }
        return true;
    }

    public static boolean carExists(Car c) {
        Car car = CarService.read(c);

        if (car == null) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isCustomerValid(Customer c) {

        if (c == null) {
            errorMessage("Selecciona un cliente.", "Error");
            return false;
        }
        if (!customerExists(c)) {
            errorMessage("El cliente no existe", "Error");
            return false;
        }
        return true;
    }

    public static boolean customerExists(Customer c) {
        Customer customer = CustomerService.read(c);

        if (customer == null) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPriceValid(String str) {
        String text = str.trim();

        if (text.isBlank()) {
            errorMessage("Introduce un precio.", "Error");
            return false;
        }
        if (text.length() > PRICE_LENGTH) {
            errorMessage("Número máximo de carácteres en precio es " + PRICE_LENGTH + ".", "Error");
            return false;
        }
        try {
            float price = Float.parseFloat(str);

            if (price > 0) {
                return true;
            } else {
                errorMessage("El precio tiene que ser un número positivo", "Error");
                return false;
            }
        } catch (NumberFormatException ex) {
            errorMessage("El precio tiene que ser un número", "Error");
            return false;
        }
    }

    public static boolean isDescriptionValid(String str) {
        String text = str.trim();

        if (text.isBlank()) {
            errorMessage("Introduce una descripción.", "Error");
            return false;
        }
        if (text.length() > DESCRIPTION_LENGTH) {
            errorMessage("Número máximo de carácteres en descripción es " + DESCRIPTION_LENGTH + ".", "Error");
            return false;
        }

        return true;
    }

    public static boolean isInsertRestricted(Repair r) {
        if (carHasToBePickedUp(r)) {
            errorMessage("Tienes coche(s) para recoger, recógelos primero antes de reparar otro.", "Error");
            return true;
        }
        if (carIsInGarage(r)) {
            errorMessage("El coche está en el taller por reparaciones de otro cliente.", "Error");
            return true;
        }
        return false;
    }

    private static boolean carHasToBePickedUp(Repair r) {
        return RepairService.carHasToBePickedUp(r);
    }
    
    private static boolean carIsInGarage(Repair r) {
        return RepairService.carIsInGarage(r);
    }

    public static void errorMessage(String message, String title) {
        String rutaImagen = "src/images/advertencia.png";
        ImageIcon icono = new ImageIcon(rutaImagen);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE, icono);
    }
}
