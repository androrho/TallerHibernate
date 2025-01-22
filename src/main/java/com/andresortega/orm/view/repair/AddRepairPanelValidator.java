package com.andresortega.orm.view.repair;

import com.andresortega.orm.controller.CarService;
import com.andresortega.orm.controller.CustomerService;
import com.andresortega.orm.controller.RepairService;
import com.andresortega.orm.model.Car;
import com.andresortega.orm.model.Customer;
import com.andresortega.orm.model.Repair;
import static com.andresortega.orm.view.util.Dialog.errorMessage;
import static com.andresortega.orm.view.util.Dialog.warningMessage;

/**
 *
 * @author Andrés
 */
public class AddRepairPanelValidator {

    private final static int PRICE_LENGTH = 10;
    private final static int DESCRIPTION_LENGTH = 200;

    protected static boolean areFieldsValid(Car selectedCar, Customer selectedCustomer, String price, String description) {
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

    private static boolean isCarValid(Car c) {

        if (c == null) {
            warningMessage("Selecciona un coche", "Advertencia");
            return false;
        }
        if (!carExists(c)) {
            warningMessage("El coche no existe", "Advertencia");
            return false;
        }
        return true;
    }

    private static boolean carExists(Car c) {
        Car car = CarService.read(c);

        if (car == null) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isCustomerValid(Customer c) {

        if (c == null) {
            warningMessage("Selecciona un cliente.", "Advertencia");
            return false;
        }
        if (!customerExists(c)) {
            warningMessage("El cliente no existe", "Advertencia");
            return false;
        }
        return true;
    }

    private static boolean customerExists(Customer c) {
        Customer customer = CustomerService.read(c);

        if (customer == null) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isPriceValid(String str) {
        String text = str.trim();

        if (text.isBlank()) {
            warningMessage("Introduce un precio.", "Advertencia");
            return false;
        }
        if (text.length() > PRICE_LENGTH) {
            warningMessage("Número máximo de carácteres en precio es " + PRICE_LENGTH + ".", "Advertencia");
            return false;
        }
        try {
            float price = Float.parseFloat(str);

            if (price > 0) {
                return true;
            } else {
                warningMessage("El precio tiene que ser un número positivo", "Advertencia");
                return false;
            }
        } catch (NumberFormatException ex) {
            warningMessage("El precio tiene que ser un número", "Advertencia");
            return false;
        }
    }

    private static boolean isDescriptionValid(String str) {
        String text = str.trim();

        if (text.isBlank()) {
            warningMessage("Introduce una descripción.", "Advertencia");
            return false;
        }
        if (text.length() > DESCRIPTION_LENGTH) {
            warningMessage("Número máximo de carácteres en descripción es " + DESCRIPTION_LENGTH + ".", "Advertencia");
            return false;
        }

        return true;
    }

    protected static boolean isInsertRestricted(Repair r) {
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
}
