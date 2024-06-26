package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Slf4j
public class Vino {

    private String nombre;
    @NonNull
    private List<Varietal> varietal;
    private String añada;
    private String imagenEtiqueta;
    private BigDecimal precioArs;
    @NonNull
    private Bodega bodega;
    private RegionVitivinicola regionVinicola;
    private Provincia provincia;
    private Pais pais;
    private String notaDeCataBodega;
    private String mridajes;
    private List<Reseña> reseñas;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void calcularRanking() {
    }

    public void compararEtiqueta() {
    }

    public void esDeBodega() {
    }

    public void esDeRegionVitivinicola() {
    }

    public Pais getPais() {
        return this.pais;
    }

    public RegionVitivinicola getRegion() {
        return this.regionVinicola;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public List<Varietal> getVarietal() {
        return this.varietal;
    }

    public boolean getReseñaEnPeriodoRealizaPorSommelier(LocalDate fechaDesde, LocalDate fechaHasta) {
        return this.reseñas.stream().anyMatch(reseña ->
                reseña.esDePeriodo(fechaDesde, fechaHasta)
                        && reseña.sosDeSomellier()
        );
    }

    public double getPuntajeSommelier() {
        return this.reseñas.stream()
                .filter(Reseña::sosDeSomellier)
                .mapToDouble(Reseña::getPuntaje)
                .average()
                .orElse(0.0);
    }

    public double getPuntajeGeneral() {
        return this.reseñas.stream()
                .mapToDouble(Reseña::getPuntaje)
                .average()
                .orElse(0.0);
    }
}
