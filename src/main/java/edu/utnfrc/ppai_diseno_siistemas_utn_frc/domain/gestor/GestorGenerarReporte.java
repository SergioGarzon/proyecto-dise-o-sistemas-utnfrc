package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.gestor;

import edu.utnfrc.ppai_diseno_siistemas_utn_frc.Alerts.ErrorAlert;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.Alerts.InformationAlert;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.boundary.PantallaFx;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.Bodega;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.Pais;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.Reseña;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.Vino;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.RegionVitivinicola;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static edu.utnfrc.ppai_diseno_siistemas_utn_frc.util.Constants.EXCEL;
import static edu.utnfrc.ppai_diseno_siistemas_utn_frc.util.Constants.SOMMELIER;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
@Slf4j
@Builder
public class GestorGenerarReporte {

    PantallaFx pantallaFx;

    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private String formasVisualizacion;
    private List<Bodega> bodega = new ArrayList<>();
    private List<Float> promedio = new ArrayList<>();
    private List<Pais> pais = new ArrayList<>();
    private List<RegionVitivinicola> region = new ArrayList<>();
    private List<Reseña> reseña = new ArrayList<>();
    private List<String> varietal = new ArrayList<>();
    private List<Vino> vino = new ArrayList<>();
    private String tipoReseña;

    public void generarRankingDeVinos(PantallaFx pantallaGenerarReporte) {
        this.pantallaFx = pantallaGenerarReporte;
        this.pantallaFx.pedirSeleccionFechaDesde();
        this.pantallaFx.pedirSeleccionFechaHasta();
    }

    public void tomarSeleccionFechaDesdeFechaHasta(LocalDate fechaDesde, LocalDate fechaHasta) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public void validarPeriodo() {
        if (fechaDesde != null && fechaHasta != null) {
            if(fechaHasta.isBefore(fechaDesde)) {
                ErrorAlert.mostrarError("Periodo de fechas no Validas - fecha desde es mayor que fecha hasta.");
                log.error("Periodo de fechas no Validas " + "fecha desde: {} - fecha hasta: {}", fechaDesde, fechaHasta);
            } else {
                InformationAlert.information("Periodo de fecha validas!");
                log.info("Periodo de fecha validas! " + "fecha desde: {} - fecha hasta: {}", fechaDesde, fechaHasta);
                this.pedirSeleccionTipoReseña();
            }
        }  else {
            ErrorAlert.mostrarError("Fechas Desde y Fecha hasta is null");
        }
    }

    public void pedirSeleccionTipoReseña() {
        this.pantallaFx.pedirSeleccionTipoReseña();
    }


    public void tomarSeleccionTipoReseña(String tipoReseña) {
        if (tipoReseña != null && tipoReseña.equals(SOMMELIER)) {
            InformationAlert.information("Tipo de reseña seleccionada - ".concat(tipoReseña));
            this.tipoReseña = tipoReseña;
            this.mostrarFormasVisualizacion();
        } else {
            ErrorAlert.mostrarError("Disculpe, por el momento solo procesamos reseña de tipo ".concat(SOMMELIER));
        }
        log.info("Tipo de reseña seleccionada - {}", tipoReseña);
    }


    public void mostrarFormasVisualizacion() {
        this.pantallaFx.mostrarYPedirFormasVisualizacion();
    }

    public void tomarSeleccionFormasVisualizacion(String formasVisualizacion) {
        if (formasVisualizacion != null && formasVisualizacion.equals(EXCEL)) {
            InformationAlert.information("Forma de visualizacion seleccionada - ".concat(formasVisualizacion));
            this.formasVisualizacion = formasVisualizacion;
            this.solicitarConfirmacionGeneracionReporte();
        } else {
            ErrorAlert.mostrarError("Disculpe, por el momento solo procesamos visualizacion en ".concat(EXCEL));
        }
        log.info("Forma de visualizacion seleccionada - {}", formasVisualizacion);
    }

    public void solicitarConfirmacionGeneracionReporte() {
        this.pantallaFx.solicitarConfirmacionGeneracionReporte();
    }


    public void tomarConfirmacionGeneracionReporte(boolean confirmacion) {
        log.info("Boolean = {}", confirmacion);
    }

       /*
    public List<Vino> buscarVinosConReseñaEnPeriodo() {

        //List de vinos (pre cargados)
        List<Vino> vinoList = getResult();

        this.vino.addAll(vinoList.stream().map(vino1 -> {

            //Obtenemos reseñas en Periodo.
            List<Reseña> reseñasEnPeriodo= vino1.tieneReseñaEnPeriodo(this.fechaDesde, this.fechaHasta);

            //Obtenemos reseñas en Periodo y que sean de sommelier.
            if (!reseñasEnPeriodo.isEmpty()) {
                //Validamos que las reseñas sean de Sommelier Y si es así retornamos el vino or else null.
                int xd = this.reseña.size();
                this.reseña.addAll(vino1.esReseñaDeSomelier(reseñasEnPeriodo));
                if (this.reseña.size() > xd) {
                    log.info("Vino con reseñas en periodo y de sommeliers - {}", vino1);
                    return vino1;
                } else {
                    log.error("Tiene reseña en Periodo pero no es de Sommelier - {}", vino1);
                    return null;
                }
            } else {
                return null;
            }
        }).filter(Objects::nonNull).toList());

        //invocamos al método calcular ranking.
        return this.calcularRanking(this.vino);
    }

    public List<Vino> calcularRanking(List<Vino> vino) {
        vino.sort(Comparator.comparing(GestorGenerarReporte::apply).reversed());
        return this.generarExcel10MejoresVinos(vino);
    }

    public List<Vino> generarExcel10MejoresVinos(List<Vino> vino) {
        Map<String, Object> mapita;
        ArrayList<Vino> vinoList = new ArrayList<>();
        if (!vino.isEmpty()) {
            for (int i = 0; vinoList.size() < 10; i++) {
                Vino getVino = vino.get(i);
                this.bodega.add(getVino.getBodega());
                mapita = getVino.getRegionYpais();
                this.region.add((RegionVitivinicola) mapita.get("region"));
                this.pais.add((Pais) mapita.get("pais"));
                this.varietal.addAll(getVino.getVarietal());
                vinoList.add(getVino);
            }
        }  else {
            log.error("List vinos is empty - {}", vino);
        }

        this.informarGeneracionExitosa();
        return vinoList;
    }

    public void informarGeneracionExitosa() {
        pantallaGenerarReporte.informarGeneracionExitosa();
    } */
}
