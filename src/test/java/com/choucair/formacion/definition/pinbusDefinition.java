package com.choucair.formacion.definition;

import com.choucair.formacion.steps.PinbusSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class pinbusDefinition {
    @Steps
    PinbusSteps pinbusSteps;

    @Given("^ingreso a pinbus y realizo la busqueda de acuerdo a las especificaciones (\\d+)$")
    public void ingreso_a_pinbus_y_realizo_la_busqueda_de_acuerdo_a_las_especificaciones(int id) throws IOException {
        pinbusSteps.busqueda(id);    }

    @When("^filtro por requerimientos$")
    public void filtro_por_requerimientos()  {
        pinbusSteps.filtros();

    }

    @Then("^coloco la informacion de pasajero$")
    public void coloco_la_informacion_de_pasajero()  {

        pinbusSteps.infoPasajero();

    }

}
