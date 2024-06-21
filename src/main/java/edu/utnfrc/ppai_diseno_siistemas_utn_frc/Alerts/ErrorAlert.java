package edu.utnfrc.ppai_diseno_siistemas_utn_frc.Alerts;

import javafx.scene.control.Alert;

import static edu.utnfrc.ppai_diseno_siistemas_utn_frc.util.Constants.ERROR;

public class ErrorAlert {

    public static void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("General Error");
        alert.setHeaderText(ERROR);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
