package com.andresortega.orm.view.customer;

import com.andresortega.controller.CustomerService;
import com.andresortega.model.Customer;
import static com.andresortega.orm.view.util.Dialog.errorMessage;
import static com.andresortega.orm.view.util.Dialog.warningMessage;

/**
 *
 * @author Andrés
 */
public class AddCustomerPanelValidator {

    private final static int DNI_LENGTH = 9;
    private final static int NAME_LENGTH = 45;
    private final static int AGE_LENGTH = 10;

    static boolean areFieldsValid(String dni, String name, String age) {
        if (!isDniValid(dni)) {
            return false;
        }
        if (!isNameValid(name)) {
            return false;
        }
        if (!isAgeValid(age)) {
            return false;
        }

        return true;
    }

    public static boolean isDniValid(String str) {
        String text = str.trim();

        if (text.isBlank()) {
            warningMessage("Introduce un dni.", "Advertencia");
            return false;
        }
        if (text.length() != DNI_LENGTH) {
            warningMessage("Número de carácteres en dni es " + DNI_LENGTH + ".", "Advertencia");
            return false;
        }

        return true;
    }

    public static boolean isNameValid(String str) {
        String text = str.trim();

        if (text.isBlank()) {
            warningMessage("Introduce un nombre.", "Advertencia");
            return false;
        }
        if (text.length() > NAME_LENGTH) {
            warningMessage("Número máximo de carácteres en nombre es " + NAME_LENGTH + ".", "Advertencia");
            return false;
        }

        return true;
    }

    public static boolean isAgeValid(String str) {
        String text = str.trim();

        if (text.isBlank()) {
            warningMessage("Introduce una edad.", "Advertencia");
            return false;
        }
        if (text.length() > AGE_LENGTH) {
            warningMessage("Número máximo de carácteres en edad es " + AGE_LENGTH + ".", "Advertencia");
            return false;
        }
        try{
            int age = Integer.parseInt(str);
            
            if (age > 0){
                return true;
            } else {
                warningMessage("La edad tiene que ser un número positivo", "Advertencia");
                return false;
            }
        } catch (NumberFormatException ex){
            warningMessage("La edad tiene que ser un número", "Advertencia");
            return false;
        }
    }

    public static boolean customerExists(String str) {
        String dni = str.trim();
        Customer customer = CustomerService.read(dni);

        if (customer != null) {
            errorMessage("El cliente ya está registrado", "Advertencia");
            return true;
        } else {
            return false;
        }
    }
}
