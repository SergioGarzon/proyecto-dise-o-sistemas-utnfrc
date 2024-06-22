package edu.utnfrc.ppai_diseno_siistemas_utn_frc.util;

import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MakeVinos {

    public static List<Vino> getResult() {

        //mappeamos los vinos.
        Vino vino = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).build()).build())
                .precioArs(gerRandomBigDecimal())
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build())
                .notaDeCataBodega(getRandomFloat())
                .build();

        List<Reseña> reseñaList = new ArrayList<>();
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino)
                .build());
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino)
                .build());
        vino.setReseña(reseñaList);


        Vino vino1 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).build()).build())
                .precioArs(gerRandomBigDecimal())
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build())
                .notaDeCataBodega(getRandomFloat())
                .build();

        List<Reseña> reseñaList1 = new ArrayList<>();
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino1)
                .build());
        vino1.setReseña(reseñaList1);

        Vino vino2 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).build()).build())
                .precioArs(gerRandomBigDecimal())
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build())
                .notaDeCataBodega(getRandomFloat())
                .build();

        List<Reseña> reseñaList2 = new ArrayList<>();
        reseñaList2.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino2)
                .build());
        reseñaList2.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino2)
                .build());
        vino2.setReseña(reseñaList2);

        Vino vino3 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).build()).build())
                .precioArs(gerRandomBigDecimal())
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build())
                .notaDeCataBodega(getRandomFloat())
                .build();

        List<Reseña> reseñaList3 = new ArrayList<>();
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino3)
                .build());
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino3)
                .build());
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino3)
                .build());
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino3)
                .build());
        vino3.setReseña(reseñaList3);

        Vino vino4 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).build()).build())
                .precioArs(gerRandomBigDecimal())
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build())
                .notaDeCataBodega(getRandomFloat())
                .build();

        List<Reseña> reseñaList4 = new ArrayList<>();
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino4)
                .build());
        vino4.setReseña(reseñaList4);

        Vino vino5 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).build()).build())
                .precioArs(gerRandomBigDecimal())
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build())
                .notaDeCataBodega(getRandomFloat())
                .build();

        List<Reseña> reseñaList5 = new ArrayList<>();
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino5)
                .build());
        vino5.setReseña(reseñaList5);

        Vino vino6 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).build()).build())
                .precioArs(gerRandomBigDecimal())
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build())
                .notaDeCataBodega(getRandomFloat())
                .build();

        List<Reseña> reseñaList6 = new ArrayList<>();
        reseñaList6.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino6)
                .build());
        vino6.setReseña(reseñaList6);

        Vino vino7 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).build()).build())
                .precioArs(gerRandomBigDecimal())
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build())
                .notaDeCataBodega(getRandomFloat())
                .build();

        List<Reseña> reseñaList7 = new ArrayList<>();
        reseñaList7.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino7)
                .build());
        reseñaList7.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino7)
                .build());
        vino7.setReseña(reseñaList7);

        Vino vino8 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).build()).build())
                .precioArs(gerRandomBigDecimal())
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build())
                .notaDeCataBodega(getRandomFloat())
                .build();

        List<Reseña> reseñaList8 = new ArrayList<>();
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino8)
                .build());
        vino8.setReseña(reseñaList8);

        Vino vino9 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).build()).build())
                .precioArs(gerRandomBigDecimal())
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build())
                .notaDeCataBodega(getRandomFloat())
                .build();

        List<Reseña> reseñaList9 = new ArrayList<>();
        reseñaList9.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino9)
                .build());
        reseñaList9.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino9)
                .build());
        reseñaList9.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino9)
                .build());
        vino9.setReseña(reseñaList9);

        Vino vino10 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).build()).build())
                .precioArs(gerRandomBigDecimal())
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build())
                .notaDeCataBodega(getRandomFloat())
                .build();

        List<Reseña> reseñaList10 = new ArrayList<>();
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino10)
                .build());
        vino10.setReseña(reseñaList10);

        Vino vino11 = Vino.builder()
                .añada(getCadena())
                .nombre(getCadena())
                .imagenEtiqueta(getCadena())
                .bodega(Bodega.builder().coordenadasUbicacion(getCadena()).descripcion(getCadena()).historia(getCadena()).nombre(getCadena()).region(RegionVitivinicola.builder().descripcion(getCadena()).nombre(getCadena()).build()).build())
                .precioArs(gerRandomBigDecimal())
                .varietal(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build())
                .notaDeCataBodega(getRandomFloat())
                .build();

        List<Reseña> reseñaList11 = new ArrayList<>();
        reseñaList11.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino11)
                .build());
        reseñaList11.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(getRandomFloat())
                .esPremium(true)
                .sosDeSomelier(false)
                .vino(vino11)
                .build());
        vino11.setReseña(reseñaList11);

        return List.of(vino, vino1, vino2, vino3, vino4, vino5, vino6, vino7, vino8, vino9, vino10, vino11);
    }

    private static String getCadena() {
        //Genera cadenas aleatorias de tamaño 15 para mappear Strings randoms.
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

    private static float getRandomFloat() {
        float max = 99.99F;
        float min = 00.00F;
        return (float) (min + Math.random() * (max - min));
    }

    private static BigDecimal gerRandomBigDecimal() {
        return new BigDecimal(BigInteger.valueOf(new Random().nextInt(100001)), 2);
    }
}
