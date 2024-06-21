package edu.utnfrc.ppai_diseno_siistemas_utn_frc.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ConfirmationAlert {

    public static Boolean confirmation(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacion generacion de reporte");
        alert.setHeaderText("Success");
        alert.setContentText(mensaje);
        Optional<ButtonType> result = alert.showAndWait();
        return result.filter(buttonType -> buttonType == ButtonType.OK).isPresent();
    }
}
