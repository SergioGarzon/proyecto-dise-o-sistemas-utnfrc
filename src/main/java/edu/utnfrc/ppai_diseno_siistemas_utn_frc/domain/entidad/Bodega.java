package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.AllArgsConstructor;

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
    @NonNull
    private RegionVitivinicola region;

    public void contarReseñas() {}

    public String getNombre() {return this.nombre;}

    /*
    public Map<String, Object> getRegionYPais() {
        Map<String, Object> mapita = new HashMap<>();
        mapita.put("Region", region);
        return mapita;
    }*/

    public RegionVitivinicola getRegion() {
        return this.region;
    }

    public void mostrarTodosvinos() {}
}
