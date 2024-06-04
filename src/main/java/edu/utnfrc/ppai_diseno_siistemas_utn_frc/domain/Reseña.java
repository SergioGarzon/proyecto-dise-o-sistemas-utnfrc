package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Reseña {

    private String comentario;
    private Boolean esPremium;
    private Date fechaReseña;
    private Float puntaje;
    private Vino vino;

    public void esDePeriodo() {

    }

    public void esPremium() {

    }

    public void sosDeEnofilo() {

    }

    public void sosDeSomelier() {

    }
}
