package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.boundary;

import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.Vino;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.gestor.GestorGenerarReporte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.time.LocalDate;

@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class PantallaGenerarReporte {

    private Boolean btnConfirmacion;
    private String comboFormasVisualizacion;
    private String comboTipoReseña;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private String lblInformarGeneracionExitosa;
    @Autowired
    private GestorGenerarReporte gestorGenerarReporte;

    public PantallaGenerarReporte(Boolean btnConfirmacion, String comboFormasVisualizacion, String comboTipoReseña, LocalDate fechaDesde, LocalDate fechaHasta, String lblInformarGeneracionExitosa) {
        this.btnConfirmacion = btnConfirmacion;
        this.comboFormasVisualizacion = comboFormasVisualizacion;
        this.comboTipoReseña = comboTipoReseña;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.lblInformarGeneracionExitosa = lblInformarGeneracionExitosa;
    }

    public void generarRankingDevinos() {
        habilitarVentana();
        this.gestorGenerarReporte = new GestorGenerarReporte();
        gestorGenerarReporte.generarRankingDeVinos(this);
    }

    public void habilitarVentana() {}

    public void pedirSeleccionFechaDesde() {}

    public void pedirSeleccionFechaHasta() {}

    public void tomarSeleccionFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
        this.gestorGenerarReporte.tomarSeleccionFechaDesde(this.fechaDesde);
    }

    public void tomarSeleccionFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
        this.gestorGenerarReporte.tomarSeleccionFechaHasta(this.fechaHasta);
    }

    public void pedirSeleccionTipoReseña() {}

    public void tomarSeleccionTipoReseña(String tipoReseña) {
        this.comboTipoReseña = tipoReseña;
        this.gestorGenerarReporte.tomarSeleccionTipoReseña(this.comboTipoReseña);
    }

    public void mostrarFormasVisualizacion() {
        this.pedirSeleccionFormasVisualizacion();
    }

    public void pedirSeleccionFormasVisualizacion() {}

    public void tomarSeleccionFormasVisualizacion(String formasVisualizacion) {
        this.comboFormasVisualizacion = formasVisualizacion;
        this.gestorGenerarReporte.tomarSeleccionFormasVisualizacion(this.comboFormasVisualizacion);
    }

    public void solicitarConfirmacionGeneracionReporte() {}

    public ArrayList<Vino> confirmarGeneracionReporte(boolean valor) {
        this.btnConfirmacion = valor;
        ArrayList<Vino> lista = this.gestorGenerarReporte.tomarConfirmacionGeneracionReporte(this.btnConfirmacion);
        return lista;
    }

    public void informarGeneracionExitosa() {}
}
