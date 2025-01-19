package com.andresortega.orm.view.util;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés
 */
public class Dialog {
    
    final static String WARNING_IMAGE_PATH = "src/main/resources/images/warning.png";
    final static String INFO_IMAGE_PATH = "src/main/resources/images/info.png";
    final static String ERROR_IMAGE_PATH = "src/main/resources/images/error.png";
    
    public static void errorMessage(String message, String title) {
        ImageIcon icon = new ImageIcon(ERROR_IMAGE_PATH);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE, icon);
    }
    
    public static void warningMessage(String message, String title) {
        ImageIcon icon = new ImageIcon(WARNING_IMAGE_PATH);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE, icon);
    }
    
    public static void infoMessage(String message, String title) {
        ImageIcon icono = new ImageIcon(INFO_IMAGE_PATH);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icono);
    }
    
}
