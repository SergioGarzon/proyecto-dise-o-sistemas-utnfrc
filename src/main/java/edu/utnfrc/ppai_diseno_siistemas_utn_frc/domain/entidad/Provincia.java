package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

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
    private Pais pais;

    public void contarRegiones() {}

    public Pais getPais() {return pais;}

    public void mostrarRegiones() {}
}
