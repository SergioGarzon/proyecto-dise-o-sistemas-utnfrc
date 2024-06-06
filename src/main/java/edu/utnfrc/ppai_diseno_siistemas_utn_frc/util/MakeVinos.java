package edu.utnfrc.ppai_diseno_siistemas_utn_frc.util;

import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MakeVinos {

    public static List<Vino> getResult() {
        //mappeamos los vinos.
        Vino vino = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .reseña(Collections.singletonList(Reseña.builder().fechaReseña(LocalDate.now()).comentario(getCadena()).puntaje(1.1F).esPremium(true).sosDeSomelier(true).build()))
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).provincia(Provincia.builder().nombre(getCadena()).pais(Pais.builder().nombre(getCadena()).build()).build()).build()).build())
                .precioArs(BigDecimal.valueOf(500))
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(1.5F).build())
                .notaDeCataBodega(1.7F)
                .build();
        Vino vino1 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .reseña(Collections.singletonList(Reseña.builder().fechaReseña(LocalDate.now()).comentario(getCadena()).puntaje(2.1F).esPremium(true).sosDeSomelier(true).build()))
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).provincia(Provincia.builder().nombre(getCadena()).pais(Pais.builder().nombre(getCadena()).build()).build()).build()).build())
                .precioArs(BigDecimal.valueOf(555))
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(2.5F).build())
                .notaDeCataBodega(3.7F)
                .build();
        Vino vino2 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .reseña(Collections.singletonList(Reseña.builder().fechaReseña(LocalDate.now()).comentario(getCadena()).puntaje(4.1F).esPremium(true).sosDeSomelier(true).build()))
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).provincia(Provincia.builder().nombre(getCadena()).pais(Pais.builder().nombre(getCadena()).build()).build()).build()).build())
                .precioArs(BigDecimal.valueOf(450))
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(1.1F).build())
                .notaDeCataBodega(2.3F)
                .build();
        Vino vino3 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .reseña(Collections.singletonList(Reseña.builder().fechaReseña(LocalDate.now()).comentario(getCadena()).puntaje(5.2F).esPremium(true).sosDeSomelier(true).build()))
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).provincia(Provincia.builder().nombre(getCadena()).pais(Pais.builder().nombre(getCadena()).build()).build()).build()).build())
                .precioArs(BigDecimal.valueOf(145))
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(2.4F).build())
                .notaDeCataBodega(5.0F)
                .build();
        Vino vino4 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .reseña(Collections.singletonList(Reseña.builder().fechaReseña(LocalDate.now()).comentario(getCadena()).puntaje(4.11F).esPremium(true).sosDeSomelier(true).build()))
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).provincia(Provincia.builder().nombre(getCadena()).pais(Pais.builder().nombre(getCadena()).build()).build()).build()).build())
                .precioArs(BigDecimal.valueOf(123))
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(2.6F).build())
                .notaDeCataBodega(0.7F)
                .build();
        Vino vino5 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .reseña(Collections.singletonList(Reseña.builder().fechaReseña(LocalDate.now()).comentario(getCadena()).puntaje(5.8F).esPremium(true).sosDeSomelier(true).build()))
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).provincia(Provincia.builder().nombre(getCadena()).pais(Pais.builder().nombre(getCadena()).build()).build()).build()).build())
                .precioArs(BigDecimal.valueOf(432))
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(6.5F).build())
                .notaDeCataBodega(3.4F)
                .build();
        Vino vino6 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .reseña(Collections.singletonList(Reseña.builder().fechaReseña(LocalDate.now()).comentario(getCadena()).puntaje(2.0F).esPremium(true).sosDeSomelier(true).build()))
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).provincia(Provincia.builder().nombre(getCadena()).pais(Pais.builder().nombre(getCadena()).build()).build()).build()).build())
                .precioArs(BigDecimal.valueOf(111))
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(1.6F).build())
                .notaDeCataBodega(1.2F)
                .build();
        Vino vino7 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .reseña(Collections.singletonList(Reseña.builder().fechaReseña(LocalDate.now()).comentario(getCadena()).puntaje(3.1F).esPremium(true).sosDeSomelier(true).build()))
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).provincia(Provincia.builder().nombre(getCadena()).pais(Pais.builder().nombre(getCadena()).build()).build()).build()).build())
                .precioArs(BigDecimal.valueOf(654))
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(2.0F).build())
                .notaDeCataBodega(2.0F)
                .build();
        Vino vino8 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .reseña(Collections.singletonList(Reseña.builder().fechaReseña(LocalDate.now()).comentario(getCadena()).puntaje(0.1F).esPremium(true).sosDeSomelier(true).build()))
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).provincia(Provincia.builder().nombre(getCadena()).pais(Pais.builder().nombre(getCadena()).build()).build()).build()).build())
                .precioArs(BigDecimal.valueOf(121))
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(5.2F).build())
                .notaDeCataBodega(5.1F)
                .build();
        Vino vino9 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .reseña(Collections.singletonList(Reseña.builder().fechaReseña(LocalDate.now()).comentario(getCadena()).puntaje(4.9F).esPremium(true).sosDeSomelier(true).build()))
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).provincia(Provincia.builder().nombre(getCadena()).pais(Pais.builder().nombre(getCadena()).build()).build()).build()).build())
                .precioArs(BigDecimal.valueOf(800))
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(11.5F).build())
                .notaDeCataBodega(10.7F)
                .build();
        Vino vino10 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .reseña(Collections.singletonList(Reseña.builder().fechaReseña(LocalDate.now()).comentario(getCadena()).puntaje(5.1F).esPremium(true).sosDeSomelier(true).build()))
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).provincia(Provincia.builder().nombre(getCadena()).pais(Pais.builder().nombre(getCadena()).build()).build()).build()).build())
                .precioArs(BigDecimal.valueOf(321))
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(2.9F).build())
                .notaDeCataBodega(0.1F)
                .build();
        Vino vino11 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .reseña(Collections.singletonList(Reseña.builder().fechaReseña(LocalDate.now()).comentario(getCadena()).puntaje(3.1F).esPremium(true).sosDeSomelier(false).build()))
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).provincia(Provincia.builder().nombre(getCadena()).pais(Pais.builder().nombre(getCadena()).build()).build()).build()).build())
                .precioArs(BigDecimal.valueOf(564))
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(12.5F).build())
                .notaDeCataBodega(11.7F)
                .build();
        return List.of(vino, vino1, vino2, vino3, vino4, vino5, vino6, vino7, vino8, vino9, vino10, vino11);
    }

    private static String getCadena() {
        //Genera cadenas aleatorias de tamaño 15 para mappearStrings randoms.
        int longitud = 15;
        String cadenagrande = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        StringBuilder cadena = new StringBuilder();

        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, cadenagrande.length() - 1);
            char caracterAleatorio = cadenagrande.charAt(indiceAleatorio);
            cadena.append(caracterAleatorio);
        }
        return String.valueOf(cadena);
    }


    private static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}
