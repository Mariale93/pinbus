package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("https://tiquetes.pinbus.com/")
//@DefaultUrl("https://tiquetes.pinbus.com/pagos/2753210")
public class PinbusPage extends PageObject {

    @FindBy(xpath = "//button[@analytics-event='busqueda-pinbus']")
    WebElementFacade btnBuscar;

    public String getMes() {
        String mesSalida = find(By.xpath("//label[text()='Fecha de Salida']//following::span[2]")).getText();
        return mesSalida;
    }

    public String getMesS() {
        String mesRegreso = find(By.xpath("//label[text()='Fecha de Regreso']//following::span[2]")).getText();
        return mesRegreso;
    }

    public void lugaresyfechas(String origen, String destino, String mesIda, String mesRegreso, String diaIda, String diaVuelta) {
        find(By.xpath("//input[@class='form-control control-origen']")).type(origen);
        find(By.xpath("//div[@class='jumbotron']")).click();
        find(By.xpath("//input[@class='form-control control-destino']")).type(destino);
        find(By.xpath("//input[@placeholder='Salida']")).click();
        getMes();
        while (true) {
            if (getMes().compareTo(mesIda) == 0) {
                break;
            } else {
                find(By.xpath("//div[3]//div[1]//div[2]//header[1]//span[3]")).click();
            }
        }
        find(By.xpath("//span[@class='cell day' and text()=" + diaIda + "]")).click();
/*
        find(By.xpath("//input[@placeholder='Regreso (opcional)']")).click();
        getMesS();
        while (true) {
            if (getMesS().compareTo(mesRegreso) == 0) {               break;
            } else {
                find(By.xpath("//div[4]//div[1]//div[2]//header[1]//span[3]")).click();            }
        }
        find(By.xpath("//div[4]//div[1]//div[2]//div[1]//span[20]")).click();
        find(By.xpath("//button[@analytics-event='busqueda-pinbus']")).click();    }*/
        find(By.xpath("//button[@analytics-event='busqueda-pinbus']")).click();
    }

    public void filtros(String silla) {
            /*con webelemntfecade
            waitforPageLoad
            * wairforrendered...
            * waitfor----shout contains text
            * wait for----- shout be visible
            *       */

            //waitFor("//button[@analytics-event='busqueda-pinbus']").shouldBeDisplayed();
            //waitForPresenceOf("//button[@analytics-event='busqueda-pinbus']");
            //waitForAnyRenderedElementOf(By.xpath("//button[@analytics-event='busqueda-pinbus']"));
            //waitFor(btnBuscar).shouldBeVisible();
            //waitForRenderedElementsToBePresent(By.xpath("//button[@analytics-event='busqueda-pinbus']"));
            //waitFor(btnBuscar).shouldContainText("Buscar");

            WebDriverWait wait = new WebDriverWait(getDriver(), 50);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@analytics-event='busqueda-pinbus']")));
            find(By.xpath("//label[contains(text(),'REY DORADO LO MÁXIMO')]//input")).click();
            find(By.xpath("//button[@class='btn btn-primary' and text()]")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='seat-number' and text()='35']")));
            find(By.xpath("//span[@class='seat-number' and text()=" + silla + "]")).click();
            find(By.xpath("//a[@class='btn btn-primary btn-block']")).click();
    }

    public void infoPasajero (String nombre, String apellido, String tipo ,String cc, String fecha, String correo, String tel) {
        find(By.xpath("//div//input[@placeholder='Ingresa tu nombre']")).type(nombre);
        find(By.xpath("//input[@placeholder='Ingresa tu apellido']")).type(apellido);
        find(By.xpath("//select[@name='passengers[0][document_type_id]']//option["+tipo+"]")).click();
        find(By.xpath("//input[@name='passengers[0][document]']")).type(cc);
        find(By.xpath("//input[@placeholder='DD/MM/AAAA']")).type(fecha);
        find(By.xpath("//input[@id='buyer_email']")).type(correo);
        find(By.xpath("//input[@placeholder='Confirma tu email']")).type(correo);
        find(By.xpath("//input[@placeholder='Ingresa tu teléfono']")).type(tel);
    }
}



