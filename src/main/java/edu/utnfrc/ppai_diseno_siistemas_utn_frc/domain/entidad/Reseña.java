package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Reseña {

    private String comentario;
    private Boolean esPremium;
    private LocalDate fechaReseña;
    private Float puntaje;
    private Vino vino;
    private Boolean sosDeSomelier;

    public Boolean esDePeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        return ((fechaReseña.isEqual(fechaDesde) || fechaReseña.isAfter(fechaDesde)) && fechaReseña.isBefore(fechaHasta));
    }

    public void esPremium() {

    }

    public void sosDeEnofilo() {

    }

    public Boolean sosDeSomelier() {
        return this.sosDeSomelier;
    }
}
