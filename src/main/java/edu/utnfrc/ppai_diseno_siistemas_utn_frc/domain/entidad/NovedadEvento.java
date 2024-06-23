package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NovedadEvento {

    private String codigoDescuentoPremium;
    private String descripcion;
    private boolean isSoloPremium;
    private LocalDateTime fechaHoraEvento;
    private String nombreEvento;

    private boolean isPremium() {
        return this.isSoloPremium;
    }

    private boolean estaEnPeriodo() {
        return false;
    }

    private String mostrarDescripcion() {
        return this.descripcion;
    }

}
