package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Varietal {

    private String descripcion;
    private Float porcentajeComposicion;

    public void conocerTipoUva() {

    }

    public void esDeTipoUva() {

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void mostrarPorcentaje() {

    }
}
