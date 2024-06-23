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
    private int puntaje;
    @NonNull
    private Vino vino;

    public boolean esDePeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        return ((fechaReseña.isEqual(fechaDesde) || fechaReseña.isAfter(fechaDesde)) && fechaReseña.isBefore(fechaHasta));
    }

    public void esPremium() {
    }

    public void sosDeEnofilo() {
    }

    public boolean sosDeSomellier() {
        return this.esPremium;
    }
}
