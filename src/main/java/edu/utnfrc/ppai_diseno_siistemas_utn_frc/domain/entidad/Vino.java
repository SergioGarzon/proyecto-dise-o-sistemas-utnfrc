package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Slf4j
public class Vino {

    private String añada;
    private String imagenEtiqueta;
    private String nombre;
    private float notaDeCataBodega;
    private BigDecimal precioArs;
    @NonNull
    private Bodega bodega;
    private List<Reseña> reseña;
    @NonNull
    private Varietal varietal;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void calcularRanking() {
    }

    public void compararEtiqueta() {
    }

    public void esDeBodega() {
    }

    public void esDeRegionVitivinicola() {
    }

    public Bodega getBodega() {
        return bodega;
    }

    public List<String> getVarietal() {
        return Collections.singletonList(varietal.getDescripcion());
    }

    public boolean getReseñaEnPeriodoRealizaPorSommelier(LocalDate fechaDesde, LocalDate fechaHasta) {
        for (Reseña reseña : this.reseña) {
            if (reseña.esDePeriodo(fechaDesde, fechaHasta) && reseña.esPremium()) {
                return true;
            }
        }
        return false;
    }

    public float calcularPromedio() {
        float prom = 0F;
        for (Reseña reseña1 : this.reseña) {
            prom += reseña1.getPuntaje();
        }
        return (prom / this.reseña.size());
    }
}
