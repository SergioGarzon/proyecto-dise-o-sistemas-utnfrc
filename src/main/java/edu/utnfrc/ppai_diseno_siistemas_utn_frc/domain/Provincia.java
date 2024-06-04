package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Provincia {

    private String nombre;
    private List<RegionVitivinicola> regiones;

    public void contarRegiones() {

    }

    public void getPais() {

    }

    public void mostrarRegiones() {

    }
}
