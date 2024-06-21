package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.boundary;

import edu.utnfrc.ppai_diseno_siistemas_utn_frc.Alerts.ConfirmationAlert;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.PpaiDisenoSiistemasUtnFrcApplication;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.gestor.GestorGenerarReporte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static edu.utnfrc.ppai_diseno_siistemas_utn_frc.PpaiDisenoSiistemasUtnFrcApplication.primaryStage;

@Component
@Slf4j
public class PantallaFx implements Initializable {

    //Atributos propios.
    @Autowired
    GestorGenerarReporte gestorGenerarReporte;
    private LocalDate fechaHasta = null;
    private LocalDate fechaDesde = null;


    //Atributos front.
    @FXML
    public ComboBox<String> comboTipoReseña;
    @FXML
    public ComboBox<String> comboFormasVisualizacion;
    @FXML
    public Button btnGenerarRankingvinos;
    @FXML
    public Button btnExit;
    @FXML
    public Button btnRegresarView;
    @FXML
    public Button btnGeneralExcel;
    @FXML
    public Button btnValidar;
    @FXML
    public DatePicker dateFechaDesde;
    @FXML
    public DatePicker dateFechaHasta;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO document why this method is empty
    }


    private void habilitarVentana(Stage preStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/scene1.fxml"));
        fxmlLoader.setControllerFactory(PpaiDisenoSiistemasUtnFrcApplication.getContext()::getBean);
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Filtros");
        stage.show();
        preStage.close();
    }

    public void generarRankingVinos(MouseEvent mouseEvent) throws IOException {
        habilitarVentana((Stage) btnGenerarRankingvinos.getScene().getWindow());
        this.gestorGenerarReporte = new GestorGenerarReporte();
        this.gestorGenerarReporte.generarRankingDeVinos(this);
    }

    public void pedirSeleccionFechaDesde() {
        this.tomarSeleccionFechaDesde();
    }

    @FXML
    public void tomarSeleccionFechaDesde() {
        this.dateFechaDesde.valueProperty().addListener((obs, oldDate, newDate) -> {
            this.fechaDesde = newDate;
            log.info("Fecha desde - {}", newDate.toString());
        });
    }

    public void pedirSeleccionFechaHasta() {
        this.tomarSeleccionFechaHasta();
    }

    @FXML
    public void tomarSeleccionFechaHasta() {
        this.dateFechaHasta.valueProperty().addListener((obs, oldDate, newDate) -> {
            this.fechaHasta = newDate;
            log.info("Fecha Hasta - {}", newDate.toString());
        });
    }

    @FXML
    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void backToPreView(ActionEvent event) {
        Stage actualStage = (Stage) btnRegresarView.getScene().getWindow();
        actualStage.close();
        primaryStage.show();
    }

    @FXML
    private void btnValidarOnAction() {
        this.gestorGenerarReporte.tomarSeleccionFechaDesdeFechaHasta(fechaDesde, fechaHasta);
        this.gestorGenerarReporte.validarPeriodo();
    }

    public void pedirSeleccionTipoReseña() {
        this.comboTipoReseña.setDisable(false);
    }

    @FXML
    public void tomarSeleccionTipoReseña() {
        String tipoReseña = this.comboTipoReseña.valueProperty().getValue();
        this.gestorGenerarReporte.tomarSeleccionTipoReseña(tipoReseña);
    }

    public void setComboTipoReseña(){
        this.comboTipoReseña.getItems().addAll("Reseña Normal", "Reseña de Sommelier", "Reseña de Amigos");
    }

    public void mostrarYPedirFormasVisualizacion() {
        this.comboFormasVisualizacion.setDisable(false);
    }

    @FXML
    public void tomarSeleccionFormasVisualizacion() {
        String formaVisualizacion = this.comboFormasVisualizacion.valueProperty().getValue();
        this.gestorGenerarReporte.tomarSeleccionFormasVisualizacion(formaVisualizacion);
    }

    public void setComboFormasVisualizacion(){
        this.comboFormasVisualizacion.getItems().addAll("PDF", "Archivo Excel", "Pantalla");
    }

    public void solicitarConfirmacionGeneracionReporte() {
        this.btnGeneralExcel.setDisable(false);
    }

    public void tomarConfirmacionGeneracionReporte(ActionEvent event) {
        boolean confirmacion = ConfirmationAlert.confirmation("Desea confirmar?");
        this.gestorGenerarReporte.tomarConfirmacionGeneracionReporte(confirmacion);
    }
}
