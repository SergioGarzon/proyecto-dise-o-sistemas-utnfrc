package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegionVitivinicola {

    private String descripcion;
    private String nombre;

    public void conocerBodega() {

    }

    public void contarBodegas() {

    }

    public String getNombre() {
        return nombre;
    }

    public void getPais() {

    }
}