package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Bodega {

    private String coordenadasUbicacion;
    private String descripcion;
    private String historia;
    private String nombre;
    private Date periodoActualizacion;
    private RegionVitivinicola region;

    /*
    * No se agregan métodos de seteo porque hace todo @builder y @Data
    */

    public void contarReseñas() {
    }

    public String getNombre() {
        //No le gusta para nada jajajajaja xd
        return nombre;
    }

    public void getRegionYPais() {
        // TODO document why this method is empty
    }

    public void mostrarTodosvinos() {
        // TODO document why this method is empty
    }
}
