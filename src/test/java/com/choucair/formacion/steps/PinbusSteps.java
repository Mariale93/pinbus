package com.choucair.formacion.steps;

import au.com.bytecode.opencsv.CSVReader;
import com.choucair.formacion.pageobjects.PinbusPage;
import net.thucydides.core.annotations.Step;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PinbusSteps {
    PinbusPage pinbusPage;
    @Step

    //lectura de datos

    public void busqueda(int id) throws IOException {
        pinbusPage.open();

        String CSV_file = "src/test/resources/Datadriven/pinbus.csv";
        FileReader filereader = new FileReader(CSV_file);
        CSVReader reader;
        reader = new CSVReader(filereader);
        String[] cell = reader.readNext();
        while ((cell = reader.readNext()) != null) {
            if (id == Integer.parseInt(cell[0])) {
                pinbusPage.lugaresyfechas(cell[1],cell[2],cell[3],cell[4],cell[5],cell[6]);
            }
        }reader.close();
    }


    public void filtros() {
        pinbusPage.filtros();
    }

    public void infoPasajero() {

        pinbusPage.infoPasajero();
    }
}
