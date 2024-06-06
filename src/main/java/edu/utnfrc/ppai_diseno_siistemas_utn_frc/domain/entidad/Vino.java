package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Vino {

    private String añada;
    private String imagenEtiqueta;
    private String nombre;
    private Float notaDeCataBodega;
    private BigDecimal precioArs;
    private Bodega bodega;
    private List<Reseña> reseña;
    private Varietal varietal;

    public void calcularRanking() {

    }

    public void compararEtiqueta() {

    }

    public void esDeBodega() {

    }

    public void esDeRegionVitivinicola() {

    }

    public String getBodega() {
        return bodega.getNombre();
    }

    public void getRegionYpais() {

    }

    public String getVarietal() {
        return varietal.getDescripcion();
    }

    public List<Reseña> tieneReseñaEnPeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
       return this.reseña.stream().map(reseña1 -> {
            if (Boolean.FALSE.equals(reseña1.esDePeriodo(fechaDesde, fechaHasta))) {
                System.out.print("No es de periodo");
                return null;
            } else {
                return reseña1;
            }
        }).filter(Objects::nonNull).toList();
    }
}
