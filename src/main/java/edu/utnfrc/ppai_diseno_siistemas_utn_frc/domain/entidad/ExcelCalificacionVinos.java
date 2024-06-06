package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ExcelCalificacionVinos {

    private String nombre;

    public void generarExcel() {

    }
}
