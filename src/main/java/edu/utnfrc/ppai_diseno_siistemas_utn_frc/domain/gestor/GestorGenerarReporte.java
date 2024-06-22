package edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.gestor;

import edu.utnfrc.ppai_diseno_siistemas_utn_frc.Alerts.ErrorAlert;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.boundary.PantallaFx;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.Pais;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.Vino;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.RegionVitivinicola;
import javafx.event.ActionEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.utnfrc.ppai_diseno_siistemas_utn_frc.util.Constants.EXCEL;
import static edu.utnfrc.ppai_diseno_siistemas_utn_frc.util.Constants.SOMMELIER;
import static edu.utnfrc.ppai_diseno_siistemas_utn_frc.util.MakeVinos.getResult;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
@Slf4j
@Builder
public class GestorGenerarReporte {

    PantallaFx pantallaFx;

    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private String formasVisualizacion;
    private List<Pais> pais = new ArrayList<>();
    private List<RegionVitivinicola> region = new ArrayList<>();
    private List<String> varietal = new ArrayList<>();
    private List<Vino> vino = new ArrayList<>();
    private Map<Vino, Float> mapProm = new HashMap<>();
    private String tipoReseña;

    public void generarRankingDeVinos(PantallaFx pantallaGenerarReporte) {
        this.pantallaFx = pantallaGenerarReporte;
        this.pantallaFx.pedirSeleccionFechaDesde();
        this.pantallaFx.pedirSeleccionFechaHasta();
    }

    public void tomarSeleccionFechaDesdeFechaHasta(LocalDate fechaDesde, LocalDate fechaHasta) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public void validarPeriodo() {
        if (fechaDesde != null && fechaHasta != null) {
            if(fechaHasta.isBefore(fechaDesde)) {
                ErrorAlert.mostrarError("Periodo de fechas no Validas - fecha desde es mayor que fecha hasta.");
                log.error("Periodo de fechas no Validas " + "fecha desde: {} - fecha hasta: {}", fechaDesde, fechaHasta);
            } else {
                log.info("Periodo de fecha validas! " + "fecha desde: {} - fecha hasta: {}", fechaDesde, fechaHasta);
                this.pedirSeleccionTipoReseña();
            }
        }  else {
            ErrorAlert.mostrarError("Fechas Desde y Fecha hasta is null");
        }
    }

    public void pedirSeleccionTipoReseña() {
        this.pantallaFx.pedirSeleccionTipoReseña();
    }


    public void tomarSeleccionTipoReseña(String tipoReseña) {
        if (tipoReseña != null && tipoReseña.equals(SOMMELIER)) {
            this.tipoReseña = tipoReseña;
            this.mostrarFormasVisualizacion();
        } else {
            ErrorAlert.mostrarError("Disculpe, por el momento solo procesamos reseña de tipo ".concat(SOMMELIER));
        }
        log.info("Tipo de reseña seleccionada - {}", tipoReseña);
    }


    public void mostrarFormasVisualizacion() {
        this.pantallaFx.mostrarYPedirFormasVisualizacion();
    }

    public void tomarSeleccionFormasVisualizacion(String formasVisualizacion) {
        if (formasVisualizacion != null && formasVisualizacion.equals(EXCEL)) {
            this.formasVisualizacion = formasVisualizacion;
            this.solicitarConfirmacionGeneracionReporte();
        } else {
            ErrorAlert.mostrarError("Disculpe, por el momento solo procesamos visualizacion en ".concat(EXCEL));
        }
        log.info("Forma de visualizacion seleccionada - {}", formasVisualizacion);
    }

    public void solicitarConfirmacionGeneracionReporte() {
        this.pantallaFx.solicitarConfirmacionGeneracionReporte();
    }


    public void tomarConfirmacionGeneracionReporte(boolean confirmacion) {
        log.info("Boolean = {}", confirmacion);
        if (confirmacion) {
            this.buscarVinosConReseñaEnPeriodo();
        } else {
            this.pantallaFx.exitButtonOnAction(new ActionEvent());
        }
    }

    public void buscarVinosConReseñaEnPeriodo() {

        List<Vino> vinoList = getResult();
        //MAPEAR TODA LOGICA DEL PASO 11.

        this.generarExcel(vinoList);
    }

    public void generarExcel(List<Vino> vinoList) {
        String[] columns = {"Nombre", "Calificacion Sommelier", "Calificacion General", "Precio", "Bodega"
                , "Varietal", "Región", "Pais"};

        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Ranking de Vinos");
        Row row = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(columns[i]);
        }

        int initRow = 1;
        for (Vino vino : vinoList) {
            row = sheet.createRow(initRow);
            row.createCell(0).setCellValue(vino.getNombre());
            row.createCell(1).setCellValue(String.format("%.2f", vino.calcularPromedio()));
            row.createCell(2).setCellValue(String.format("%.2f", vino.getNotaDeCataBodega()));
            row.createCell(3).setCellValue(vino.getPrecioArs().toString());
            row.createCell(4).setCellValue(vino.getBodega().getNombre());
            row.createCell(5).setCellValue(vino.getVarietal().get(0));
            row.createCell(6).setCellValue(vino.getBodega().getRegion().getNombre());
            row.createCell(7).setCellValue("PaisxD");

            initRow++;
        }

        try {
            FileOutputStream excel = new FileOutputStream("ClasificacionVinos.xlsx");
            workbook.write(excel);
            workbook.close();
            log.info("Generacion Exitosa xd");
            this.informarGeneracionExitosa();
        } catch (IOException e) {
            ErrorAlert.mostrarError("Errorrrrrrrrrr Critico xd");
            throw new RuntimeException(e);
        }

    }

    public void informarGeneracionExitosa() {
        this.pantallaFx.informarGeneracionExitosa();
    }

    public void finCU() {
        this.pantallaFx.exitButtonOnAction(new ActionEvent());
    }
}
