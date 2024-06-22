package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.AllArgsConstructor;

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
    @NonNull
    private Vino vino;
    private Boolean sosDeSomelier;

    public boolean esDePeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        return ((fechaReseña.isEqual(fechaDesde) || fechaReseña.isAfter(fechaDesde)) && fechaReseña.isBefore(fechaHasta));
    }

    public boolean esPremium() {
        return esPremium;
    }

    public void sosDeEnofilo() {

    }

    public Boolean sosDeSomelier() {
        return this.sosDeSomelier;
    }
}
