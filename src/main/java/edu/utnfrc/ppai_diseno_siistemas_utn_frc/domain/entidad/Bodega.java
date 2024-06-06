package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    public void contarReseñas() {}

    public String getNombre() {return nombre;}

    public Map<String, Object> getRegionYPais() {
        Map<String, Object> mapita = new HashMap<>();
        mapita.put("Region", region);
        mapita.put("Pais", region.getPais());
        return mapita;
    }

    public void mostrarTodosvinos() {}
}
