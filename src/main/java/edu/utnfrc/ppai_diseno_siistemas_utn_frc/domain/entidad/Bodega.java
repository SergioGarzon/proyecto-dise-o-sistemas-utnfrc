package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Bodega {

    private List<Integer> coordenadasUbicacion;
    private String descripcion;
    private String historia;
    private String nombre;
    private Date periodoActualizacion;
    @NonNull
    private RegionVitivinicola region;
    private NovedadEvento novedad;

    public void contarReseñas() {

    }

    public String getNombre() {return this.nombre;}

    public RegionVitivinicola getRegion() {
        return this.region;
    }

    public Pais getPais() {
        return region.getPais();
    }

    public void mostrarTodosvinos() {

    }
}
