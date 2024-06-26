package edu.utnfrc.ppai_diseno_siistemas_utn_frc.util;

import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MakeVinos {

    public static List<Vino> getResult() {

        //Creamos las regiones.
        List<RegionVitivinicola> regionVitivinicolas = new ArrayList<>();
        regionVitivinicolas.add(RegionVitivinicola.builder().nombre("Region 1").descripcion(getCadena()).build());
        regionVitivinicolas.add(RegionVitivinicola.builder().nombre("Region 2").descripcion(getCadena()).build());
        regionVitivinicolas.add(RegionVitivinicola.builder().nombre("Region 3").descripcion(getCadena()).build());
        regionVitivinicolas.add(RegionVitivinicola.builder().nombre("Region 4").descripcion(getCadena()).build());
        regionVitivinicolas.add(RegionVitivinicola.builder().nombre("Region 5").descripcion(getCadena()).build());
        regionVitivinicolas.add(RegionVitivinicola.builder().nombre("Region 6").descripcion(getCadena()).build());

        //Creamos las provincias.
        List<Provincia> provincias = new ArrayList<>();
        provincias.add(Provincia.builder().nombre("Córdoba").regiones(regionVitivinicolas.subList(0,4)).build());
        provincias.add(Provincia.builder().nombre("Mendoza").regiones(regionVitivinicolas).build());
        provincias.add(Provincia.builder().nombre("Buenos Aires").regiones(regionVitivinicolas.subList(4, regionVitivinicolas.size())).build());

        //Creamos el Pais.
        Pais pais = Pais.builder().nombre("Argentina").provincia(provincias).build();

        //Inyectamos la dependencia.
        for(RegionVitivinicola regionVitivinicola : regionVitivinicolas) {
            regionVitivinicola.setProvincia(provincias.get(numeroAleatorioEnRango(0,2)));
        }

        //Inyectamos la dependencia.
        for(Provincia provincia : provincias) {
            provincia.setPais(pais);
        }

        Bodega bodega = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(0))
                .build();

        Vino vino = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega)
                .regionVinicola(bodega.getRegion())
                .provincia(getProvincia(provincias, bodega.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList = new ArrayList<>();
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino)
                .build());
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino)
                .build());
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino)
                .build());
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino)
                .build());
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino)
                .build());
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino)
                .build());
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino)
                .build());
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino)
                .build());
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino)
                .build());
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino)
                .build());
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino)
                .build());
        reseñaList.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino)
                .build());
        vino.setReseñas(reseñaList);


        Bodega bodega1 = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(1))
                .build();

        Vino vino1 = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega1)
                .regionVinicola(bodega1.getRegion())
                .provincia(getProvincia(provincias, bodega1.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList1 = new ArrayList<>();
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino1)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino)
                .build());
        reseñaList1.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino)
                .build());
        vino1.setReseñas(reseñaList1);

        Bodega bodega2 = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(2))
                .build();

        Vino vino2 = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega2)
                .regionVinicola(bodega2.getRegion())
                .provincia(getProvincia(provincias, bodega2.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList2 = new ArrayList<>();
        reseñaList2.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino2)
                .build());
        reseñaList2.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino2)
                .build());
        reseñaList2.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino2)
                .build());
        reseñaList2.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino2)
                .build());
        reseñaList2.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino2)
                .build());
        reseñaList2.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino2)
                .build());
        reseñaList2.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino2)
                .build());
        reseñaList2.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino2)
                .build());
        reseñaList2.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino2)
                .build());
        reseñaList2.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino2)
                .build());
        vino2.setReseñas(reseñaList2);

        Bodega bodega3 = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(3))
                .build();

        Vino vino3 = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega3)
                .regionVinicola(bodega3.getRegion())
                .provincia(getProvincia(provincias, bodega3.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList3 = new ArrayList<>();
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino3)
                .build());
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino3)
                .build());
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino3)
                .build());
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino3)
                .build());
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino3)
                .build());
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino3)
                .build());
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino3)
                .build());
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino3)
                .build());
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino3)
                .build());
        reseñaList3.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino3)
                .build());
        vino3.setReseñas(reseñaList3);

        Bodega bodega4 = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(4))
                .build();

        Vino vino4 = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega4)
                .regionVinicola(bodega4.getRegion())
                .provincia(getProvincia(provincias, bodega4.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList4 = new ArrayList<>();
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino4)
                .build());
        reseñaList4.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino4)
                .build());
        vino4.setReseñas(reseñaList4);

        Bodega bodega5 = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(5))
                .build();

        Vino vino5 = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega5)
                .regionVinicola(bodega5.getRegion())
                .provincia(getProvincia(provincias, bodega5.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList5 = new ArrayList<>();
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino5)
                .build());
        reseñaList5.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino5)
                .build());
        vino5.setReseñas(reseñaList5);

        Bodega bodega6 = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(0))
                .build();

        Vino vino6 = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega6)
                .regionVinicola(bodega6.getRegion())
                .provincia(getProvincia(provincias, bodega6.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList6 = new ArrayList<>();
        reseñaList6.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino6)
                .build());
        reseñaList6.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino6)
                .build());
        reseñaList6.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino6)
                .build());
        reseñaList6.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino6)
                .build());
        reseñaList6.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino6)
                .build());
        reseñaList6.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino6)
                .build());
        reseñaList6.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino6)
                .build());
        reseñaList6.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino6)
                .build());
        reseñaList6.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino6)
                .build());
        reseñaList6.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino6)
                .build());
        vino6.setReseñas(reseñaList6);

        Bodega bodega7 = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(1))
                .build();

        Vino vino7 = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega7)
                .regionVinicola(bodega7.getRegion())
                .provincia(getProvincia(provincias, bodega7.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList7 = new ArrayList<>();
        reseñaList7.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino7)
                .build());
        reseñaList7.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino7)
                .build());
        reseñaList7.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino7)
                .build());
        reseñaList7.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino7)
                .build());
        reseñaList7.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino7)
                .build());
        reseñaList7.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino7)
                .build());
        reseñaList7.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino7)
                .build());
        reseñaList7.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino7)
                .build());
        reseñaList7.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino7)
                .build());
        reseñaList7.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino7)
                .build());
        vino7.setReseñas(reseñaList7);

        Bodega bodega8 = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(2))
                .build();

        Vino vino8 = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega8)
                .regionVinicola(bodega8.getRegion())
                .provincia(getProvincia(provincias, bodega8.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList8 = new ArrayList<>();
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino8)
                .build());
        reseñaList8.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino8)
                .build());
        vino8.setReseñas(reseñaList8);

        Bodega bodega9 = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(3))
                .build();

        Vino vino9 = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega9)
                .regionVinicola(bodega9.getRegion())
                .provincia(getProvincia(provincias, bodega9.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList9 = new ArrayList<>();
        reseñaList9.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino9)
                .build());
        reseñaList9.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino9)
                .build());
        reseñaList9.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino9)
                .build());
        reseñaList9.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino9)
                .build());
        reseñaList9.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino9)
                .build());
        reseñaList9.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino9)
                .build());
        reseñaList9.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino9)
                .build());
        reseñaList9.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino9)
                .build());
        reseñaList9.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino9)
                .build());
        vino9.setReseñas(reseñaList9);

        Bodega bodega10 = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(4))
                .build();

        Vino vino10 = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega10)
                .regionVinicola(bodega10.getRegion())
                .provincia(getProvincia(provincias, bodega10.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList10 = new ArrayList<>();
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino10)
                .build());
        reseñaList10.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino10)
                .build());
        vino10.setReseñas(reseñaList10);

        Bodega bodega11 = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(5))
                .build();

        Vino vino11 = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega11)
                .regionVinicola(bodega11.getRegion())
                .provincia(getProvincia(provincias, bodega11.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList11 = new ArrayList<>();
        reseñaList11.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino11)
                .build());
        reseñaList11.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino11)
                .build());
        reseñaList11.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino11)
                .build());
        reseñaList11.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino11)
                .build());
        reseñaList11.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino11)
                .build());
        reseñaList11.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino11)
                .build());
        reseñaList11.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino11)
                .build());
        reseñaList11.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino11)
                .build());
        reseñaList11.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino11)
                .build());
        reseñaList11.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino11)
                .build());
        vino11.setReseñas(reseñaList11);

        Bodega bodega12 = Bodega.builder()
                .coordenadasUbicacion(Collections.singletonList(getCadena().length()))
                .descripcion(getCadena())
                .historia(getCadena())
                .nombre(getCadena())
                .region(regionVitivinicolas.get(5))
                .build();

        Vino vino12 = Vino.builder()
                .nombre("Vino - ".concat(getCadena()))
                .varietal(Collections.singletonList(Varietal.builder().descripcion(getCadena()).porcentajeComposicion(getRandomFloat()).build()))
                .añada(getCadena())
                .imagenEtiqueta(getCadena())
                .precioArs(gerRandomBigDecimal())
                .bodega(bodega12)
                .regionVinicola(bodega12.getRegion())
                .provincia(getProvincia(provincias, bodega12.getRegion()))
                .pais(pais)
                .notaDeCataBodega(getCadena())
                .mridajes(getCadena())
                .build();

        List<Reseña> reseñaList12 = new ArrayList<>();
        reseñaList12.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino12)
                .build());
        reseñaList12.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino12)
                .build());
        reseñaList12.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino12)
                .build());
        reseñaList12.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino12)
                .build());
        reseñaList12.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino12)
                .build());
        reseñaList12.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino12)
                .build());
        reseñaList12.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino12)
                .build());
        reseñaList12.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino12)
                .build());
        reseñaList12.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(false)
                .vino(vino12)
                .build());
        reseñaList12.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino12)
                .build());
        reseñaList12.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino12)
                .build());
        reseñaList12.add(Reseña.builder()
                .fechaReseña(LocalDate.now())
                .comentario(getCadena())
                .puntaje(numeroAleatorioEnRango(0,5))
                .esPremium(true)
                .vino(vino12)
                .build());
        vino12.setReseñas(reseñaList12);

        return List.of(vino, vino1, vino2, vino3, vino4, vino5, vino6, vino7, vino8, vino9, vino10, vino11, vino12);
    }

    private static Provincia getProvincia(List<Provincia> provincias, RegionVitivinicola region) {
        Optional<Provincia> provincia = provincias.stream().filter(p ->
                p.getRegiones().contains(region)).findFirst();
        return provincia.orElseGet(Provincia::new);
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
