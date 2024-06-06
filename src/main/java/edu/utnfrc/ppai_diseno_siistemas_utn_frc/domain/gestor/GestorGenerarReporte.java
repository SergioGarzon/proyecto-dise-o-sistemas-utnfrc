package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.gestor;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.controllers.controllerdsi;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.boundary.PantallaGenerarReporte;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static edu.utnfrc.ppai_diseno_siistemas_utn_frc.util.MakeVinos.getResult;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
@Slf4j
@Builder
public class GestorGenerarReporte {

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
    private static PantallaGenerarReporte pantallaGenerarReporte = new PantallaGenerarReporte();


    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final controllerdsi controller = new controllerdsi();

    public GestorGenerarReporte(LocalDate fechaDesde, LocalDate fechaHasta, List<Bodega> bodega,
                                String formasVisualizacion, List<Float> promedio, List<Pais> pais,
                                List<RegionVitivinicola> region, List<Reseña> reseña, List<String> varietal,
                                List<Vino> vino, String tipoReseña, PantallaGenerarReporte pantallaGenerarReporte) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.bodega = bodega;
        this.formasVisualizacion = formasVisualizacion;
        this.promedio = promedio;
        this.pais = pais;
        this.region = region;
        this.reseña = reseña;
        this.varietal = varietal;
        this.vino = vino;
        this.tipoReseña = tipoReseña;
        this.pantallaGenerarReporte = pantallaGenerarReporte;
    }

    private static Float apply(Vino vino1) {
        return vino1.getReseña().get(0).getPuntaje();
    }

    public void generarRankingDeVinos(PantallaGenerarReporte pantallaGenerarReporte) {
        //Inicia todo.
        this.pantallaGenerarReporte = pantallaGenerarReporte;
        this.pantallaGenerarReporte.pedirSeleccionFechaDesde();
        this.pantallaGenerarReporte.pedirSeleccionFechaHasta();
    }

    public void tomarSeleccionFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public void tomarSeleccionFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
        this.validarPeriodo(this.fechaDesde, this.fechaHasta);
    }

    public void validarPeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        if (fechaHasta.isBefore(fechaDesde)) {
            log.error("Periodo de fechas no Validas " +
                    "fecha desde: {} - fecha hasta: {}", fechaDesde, fechaHasta);
        } else {
            log.info("Periodo de fecha validas! " +
                    "fecha desde: {} - fecha hasta: {}", fechaDesde, fechaHasta);
            pedirSeleccionTipoReseña();
        }
    }

    public void pedirSeleccionTipoReseña() {
        pantallaGenerarReporte.pedirSeleccionTipoReseña();
    }

    public void tomarSeleccionTipoReseña(String tipoReseña) {
        this.tipoReseña = tipoReseña;
        log.info("Tipo de reseña seleccionada - {}", tipoReseña);
        this.mostrarFormasVisualizacion();
    }

    public void mostrarFormasVisualizacion() {
        this.pantallaGenerarReporte.mostrarFormasVisualizacion();
    }

    public void tomarSeleccionFormasVisualizacion(String formasVisualizacion) {
        this.formasVisualizacion = formasVisualizacion;
        log.info("Forma de visualizacion seleccionada - {}", formasVisualizacion);
        this.solicitarConfirmacionGeneracionReporte();
    }

    public void solicitarConfirmacionGeneracionReporte() {
        this.pantallaGenerarReporte.solicitarConfirmacionGeneracionReporte();
    }

    public void tomarConfirmacionGeneracionReporte(boolean valor) {
        if (valor) {
            log.info("Confirmacion = {}", true);
            buscarVinosConReseñaEnPeriodo();
        }
    }
    public void buscarVinosConReseñaEnPeriodo() {

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
        this.calcularRanking(this.vino);
    }

    public void calcularRanking(List<Vino> vino) {
        vino.sort(Comparator.comparing(GestorGenerarReporte::apply).reversed());
        this.generarExcel10MejoresVinos(vino);
    }

    public void generarExcel10MejoresVinos(List<Vino> vino) {
        Map<String, Object> mapita;
        List<Vino> vinoList = new ArrayList<>();
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
            //generar el excel (Todos los datos que tiene el gestor).
        }  else {
            log.error("List vinos is empty - {}", vino);
        }
    }
}
