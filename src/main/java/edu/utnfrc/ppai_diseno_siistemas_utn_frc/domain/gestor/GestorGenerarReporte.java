package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.gestor;

import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.boundary.PantallaGenerarReporte;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
@Slf4j
public class GestorGenerarReporte {

    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private String formasVisualizacion;
    private List<Bodega> bodega;
    private List<Float> promedio;
    private List<Pais> pais;
    private List<RegionVitivinicola> region;
    private List<Reseña> reseña = new ArrayList<>();
    private List<Varietal> varietal;
    private List<Vino> vino = new ArrayList<>();
    private String tipoReseña;
    private static PantallaGenerarReporte pantallaGenerarReporte = new PantallaGenerarReporte();

    public GestorGenerarReporte(LocalDate fechaDesde, LocalDate fechaHasta, List<Bodega> bodega,
                                String formasVisualizacion, List<Float> promedio, List<Pais> pais,
                                List<RegionVitivinicola> region, List<Reseña> reseña, List<Varietal> varietal,
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
            //Integrar Modelview - Error
            System.out.println("Error");
        } else {
            System.out.println("Paso, felicidat");
            pedirSeleccionTipoReseña();
        }
    }

    public void pedirSeleccionTipoReseña() {
        pantallaGenerarReporte.pedirSeleccionTipoReseña();
    }

    public void tomarSeleccionTipoReseña(String tipoReseña) {
        this.tipoReseña = tipoReseña;
        this.mostrarFormasVisualizacion();
    }

    public void mostrarFormasVisualizacion() {
        this.pantallaGenerarReporte.mostrarFormasVisualizacion();
    }

    public void tomarSeleccionFormasVisualizacion(String formasVisualizacion) {
        this.formasVisualizacion = formasVisualizacion;
        this.solicitarConfirmacionGeneracionReporte();
    }

    public void solicitarConfirmacionGeneracionReporte() {
        this.pantallaGenerarReporte.solicitarConfirmacionGeneracionReporte();
    }

    public void tomarConfirmacionGeneracionReporte(boolean valor) {
        if (valor) {
            buscarVinosConReseñaEnPeriodo();
        }
    }
    public void buscarVinosConReseñaEnPeriodo() {

        List<Vino> vinoList = new ArrayList<>();

        Vino vino = Vino.builder()
                .nombre("vino1")
                .reseña(Collections.singletonList(Reseña.builder()
                        .fechaReseña(LocalDate.now())
                        .comentario("Reseña 1")
                        .puntaje(3.1F)
                        .esPremium(true)
                                .sosDeSomelier(false)
                        .build()))
                .añada("Añada1")
                .bodega(Bodega.builder()
                        .descripcion("Bodega1")
                        .nombre("NombreBodega")
                        .build())
                .imagenEtiqueta("Img1")
                .precioArs(BigDecimal.valueOf(500))
                .varietal(Varietal.builder()
                        .descripcion("Varietal1")
                        .porcentajeComposicion(1.5F)
                        .build())
                .notaDeCataBodega(1.7F)
                .build();
        Vino vino2 = Vino.builder()
                .nombre("vino2")
                .reseña(Collections.singletonList(Reseña.builder()
                        .fechaReseña(LocalDate.now())
                        .comentario("Reseña 2")
                        .puntaje(4.1F)
                        .esPremium(true)
                                .sosDeSomelier(true)
                        .build()))
                .añada("Añada2")
                .bodega(Bodega.builder()
                        .descripcion("Bodega2")
                        .nombre("NombreBodega2")
                        .build())
                .imagenEtiqueta("Img2")
                .precioArs(BigDecimal.valueOf(350))
                .varietal(Varietal.builder()
                        .descripcion("Varietal2")
                        .porcentajeComposicion(1.7F)
                        .build())
                .notaDeCataBodega(1.1F)
                .build();

        vinoList.add(vino2);
        vinoList.add(vino);

        this.vino.addAll(vinoList.stream().map(vino1 -> {
            //Obtenemos reseñas en Periodo.
            List<Reseña> reseñasEnPeriodo= vino1.tieneReseñaEnPeriodo(this.fechaDesde, this.fechaHasta);

            //Obtenemos reseñas en Periodo y que esan de sommelier.
            if (!reseñasEnPeriodo.isEmpty()) {
                int xd = this.reseña.size();
                this.reseña.addAll(reseñasEnPeriodo.stream().map(reseña -> {
                    if (reseña.sosDeSomelier().equals(Boolean.FALSE)) {
                        return null;
                    } else {
                        return reseña;
                    }
                }).filter(Objects::nonNull).toList());
                if (this.reseña.size() > xd) {
                    return vino1;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }).filter(Objects::nonNull).toList());
    }
}
