package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Slf4j
public class Vino {

    private String añada;
    private String imagenEtiqueta;
    private String nombre;
    private Float notaDeCataBodega;
    private BigDecimal precioArs;
    private Bodega bodega;
    private List<Reseña> reseña;
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

    public Map<String, Object> getRegionYpais() {
        return this.bodega.getRegionYPais();
    }

    public List<String> getVarietal() {
        return Collections.singletonList(varietal.getDescripcion());
    }

    public List<Reseña> tieneReseñaEnPeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        return this.reseña.stream().map(reseña1 -> {
            if (Boolean.FALSE.equals(reseña1.esDePeriodo(fechaDesde, fechaHasta))) {
                log.error("No es una reseña que esté en periodo");
                return null;
            } else {
                try {
                    log.info("Reseña en Periodo - {}", objectMapper.writeValueAsString(reseña1.toString()));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                return reseña1;
            }
        }).filter(Objects::nonNull).toList();
    }

    public List<Reseña> esReseñaDeSomelier(List<Reseña> reseñasEnPeriodo) {
        return reseñasEnPeriodo.stream().map(reseña -> {
            if (reseña.sosDeSomelier().equals(Boolean.FALSE)) {
                return null;
            } else {
                try {
                    log.info("Es Reseña de Sommelier = {}", objectMapper.writeValueAsString(reseña.sosDeSomelier().toString()));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                return reseña;
            }
        }).filter(Objects::nonNull).toList();
    }
}
