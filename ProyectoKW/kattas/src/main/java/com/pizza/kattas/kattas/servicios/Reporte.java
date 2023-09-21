package com.pizza.kattas.kattas.servicios;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pizza.kattas.kattas.entidades.Insumos;
import com.pizza.kattas.kattas.repositorio.InsumosRepositorio;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("dashboard_insumos.xlsx")
public class Reporte extends AbstractXlsxView{

    @Autowired
    InsumosRepositorio insuRepo;
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            response.setHeader("Content-Disposition", "attachment; filename=\"reporte.xlsx\"");
            


    // Crear hoja.
    Sheet hoja = workbook.createSheet("Insumos");
    Row filaTitulos = hoja.createRow(0);
    
    String[] columnas = {"ID", "Nombres","Categoria","Estado","Cantidad", "Fecha Entrada", "Fecha Vencimiento"};
    for (int i = 0; i< columnas.length; i++){
        Cell celda= filaTitulos.createCell(i);
        celda.setCellValue(columnas[i]);
        
    }
    // Reporte de insumos.
    List<Insumos> insumosData = insuRepo.findAll();

    int numeroFila = 1;
    
    SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
   
    
    
    for(Insumos insumo : insumosData){
        Row filaInsumo = hoja.createRow(numeroFila);
        filaInsumo.createCell(0).setCellValue(insumo.getId());
        filaInsumo.createCell(1).setCellValue(insumo.getNombre());
        filaInsumo.createCell(2).setCellValue(insumo.getCategoria());
        filaInsumo.createCell(3).setCellValue(insumo.getEstado());
        filaInsumo.createCell(4).setCellValue(insumo.getCantidad());
        filaInsumo.createCell(5).setCellValue(fecha.format(insumo.getFecha_entrada()));
        filaInsumo.createCell(6).setCellValue(fecha.format(insumo.getFecha_vence()));
        numeroFila++;
    }

    
    }
                
    
    
}
