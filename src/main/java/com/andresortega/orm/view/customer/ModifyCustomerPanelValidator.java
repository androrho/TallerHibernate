package com.andresortega.orm.view.customer;

import static com.andresortega.orm.view.util.Dialog.warningMessage;

/**
 *
 * @author Andrés
 */
public class ModifyCustomerPanelValidator {

    final static int DNI_LENGTH = 9;
    final static int NAME_LENGTH = 45;
    final static int AGE_LENGTH = 10;

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

        if (text.length() != DNI_LENGTH) {
            warningMessage("Número de carácteres en dni es " + DNI_LENGTH + ".", "Error");
            return false;
        }

        return true;
    }

    public static boolean isNameValid(String str) {
        String text = str.trim();

        if (text.length() > NAME_LENGTH) {
            warningMessage("Número máximo de carácteres en nombre es " + NAME_LENGTH + ".", "Error");
            return false;
        }

        return true;
    }

    public static boolean isAgeValid(String str) {
        String text = str.trim();

        if (text.length() > AGE_LENGTH) {
            warningMessage("Número máximo de carácteres en edad es " + AGE_LENGTH + ".", "Error");
            return false;
        }
        try {
            int age = Integer.parseInt(str);

            if (age > 0) {
                return true;
            } else {
                warningMessage("La edad tiene que ser un número positivo", "Error");
                return false;
            }
        } catch (NumberFormatException ex) {
            if (text.length() <= 0) {
                return true;
            } else {
                warningMessage("La edad tiene que ser un número", "Error");
                return false;
            }
        }
    }

    public static boolean isRowSelected(int selectedRow) {

        if (selectedRow == -1) {
            warningMessage("Selecciona una fila en la tabla.", "Error");
            return false;
        } else {
            return true;
        }
    }
}
