package com.andresortega.orm.view.customer;

import com.andresortega.controller.CustomerService;
import com.andresortega.model.Customer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés
 */
public class AddCustomerPanelValidator {

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

        if (text.isBlank()) {
            errorMessage("Introduce un dni.", "Error");
            return false;
        }
        if (text.length() != DNI_LENGTH) {
            errorMessage("Número de carácteres en dni es " + DNI_LENGTH + ".", "Error");
            return false;
        }

        return true;
    }

    public static boolean isNameValid(String str) {
        String text = str.trim();

        if (text.isBlank()) {
            errorMessage("Introduce un nombre.", "Error");
            return false;
        }
        if (text.length() > NAME_LENGTH) {
            errorMessage("Número máximo de carácteres en nombre es " + NAME_LENGTH + ".", "Error");
            return false;
        }

        return true;
    }

    public static boolean isAgeValid(String str) {
        String text = str.trim();

        if (text.isBlank()) {
            errorMessage("Introduce una edad.", "Error");
            return false;
        }
        if (text.length() > AGE_LENGTH) {
            errorMessage("Número máximo de carácteres en edad es " + AGE_LENGTH + ".", "Error");
            return false;
        }
        try{
            int age = Integer.parseInt(str);
            
            if (age > 0){
                return true;
            } else {
                errorMessage("La edad tiene que ser un número positivo", "Error");
                return false;
            }
        } catch (NumberFormatException ex){
            errorMessage("La edad tiene que ser un número", "Error");
            return false;
        }
    }

    public static boolean customerExists(String str) {
        String dni = str.trim();
        Customer customer = CustomerService.read(dni);

        if (customer != null) {
            errorMessage("El cliente ya está registrado", "Error");
            return true;
        } else {
            return false;
        }
    }
    
    public static void errorMessage(String message, String title) {
        String rutaImagen = "src/images/advertencia.png";
        ImageIcon icono = new ImageIcon(rutaImagen);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE, icono);
    }
}
