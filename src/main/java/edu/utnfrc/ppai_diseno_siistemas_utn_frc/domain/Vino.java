package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Vino {

    private String añada;
    private String imagenEtiqueta;
    private String nombre;
    private Float notaDeCataBodega;
    private BigDecimal precioArs;
    private Bodega bodega;
    private Reseña reseña;
    private Varietal varietal;

    public void calcularRanking() {

    }

    public void compararEtiqueta() {

    }

    public void esDeBodega() {

    }

    public void esDeRegionVitivinicola() {

    }

    public String getBodega() {
        //Validar si es el Objeto bodega como tal o solo el nombre (ver en secuencia).
        return bodega.getNombre();
    }

    public void getRegionYpais() {

    }

    public String getVarietal() {
        return varietal.getDescripcion();
    }

    public void tieneReseñaEnPeriodo() {

    }
}
