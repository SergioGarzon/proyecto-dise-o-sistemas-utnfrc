package edu.utnfrc.ppai_diseno_siistemas_utn_frc.Alerts;

import javafx.scene.control.Alert;

public class InformationAlert {

    public static void information(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Success");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
