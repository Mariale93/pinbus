package com.choucair.formacion.steps;

import au.com.bytecode.opencsv.CSVReader;
import com.choucair.formacion.pageobjects.PinbusPage;
import net.thucydides.core.annotations.Step;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class PinbusSteps {
    PinbusPage pinbusPage;
    private static String[] datos;

    public static void leerCSV(String casoPrueba){
        CSVReader reader;
        try {
            reader = new CSVReader(new FileReader("src/test/resources/Datadriven/pinbus.csv"));
            String[] fila;
            while ((fila = reader.readNext())!=null){
                Logger.getLogger(fila[0]);
                if (casoPrueba.equals(fila[0].trim())){
                    datos = fila;                }
            }reader.close();
        } catch (IOException e){
            Logger.getLogger(""+e);
        }
    }

    @Step
    public void lectura(String idCaso) {
        leerCSV(idCaso);    }

    @Step
    public void busqueda(){
        pinbusPage.open();
        pinbusPage.lugaresyfechas(datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
    }

    public void filtros() {
        pinbusPage.filtros(datos[7]);
        pinbusPage.filtros2(datos[8]);
    }

    public void infoPasajero() {
        pinbusPage.infoPasajero(datos[9],datos[10],datos[11],datos[12],datos[13],datos[14],datos[15]);
        pinbusPage.validacion();
    }


}
