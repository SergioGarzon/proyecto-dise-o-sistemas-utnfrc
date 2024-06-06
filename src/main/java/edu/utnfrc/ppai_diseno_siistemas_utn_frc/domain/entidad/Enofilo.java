package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Enofilo {

    private String apellido;
    private String imagenPerfil;
    private String nombre;
    private Vino favorito;

    public void mostrarAmigosSeguidos() {

    }

    public void mostrarColeccionFavoritos() {

    }
}
