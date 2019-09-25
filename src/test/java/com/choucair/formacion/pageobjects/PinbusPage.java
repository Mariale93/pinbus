package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yecht.Data;

@DefaultUrl("https://tiquetes.pinbus.com/")

public class PinbusPage extends PageObject {

    public String getMes() {
        String mesSalida = find(By.xpath("//label[text()='Fecha de Salida']//following::span[2]")).getText();
        return mesSalida;    }

    public String getMesS(){
        String mesRegreso = find(By.xpath("//label[text()='Fecha de Regreso']//following::span[2]")).getText();
        return mesRegreso;   }

    public void lugaresyfechas(String origen, String destino, String mesIda, String mesRegreso,String diaIda, String diaVuelta) {
        find(By.xpath("//input[@class='form-control control-origen']")).type(origen);
        find(By.xpath("//div[@class='jumbotron']")).click();
        find(By.xpath("//input[@class='form-control control-destino']")).type(destino);
        find(By.xpath("//input[@placeholder='Salida']")).click();
        getMes();
        while (true) {
            if (getMes().compareTo(mesIda) == 0) {      break;
            } else { find(By.xpath("//div[3]//div[1]//div[2]//header[1]//span[3]")).click();           }
        }
        find(By.xpath("//span[@class='cell day' and text()=" + diaIda + "]")).click();

        find(By.xpath("//input[@placeholder='Regreso (opcional)']")).click();
        getMesS();
        while (true) {
            if (getMesS().compareTo(mesRegreso) == 0) {      break;
            } else { find(By.xpath("//div[4]//div[1]//div[2]//header[1]//span[3]")).click();           }
        }
        find(By.xpath("//div[4]//div[1]//div[2]//div[1]//span[20]")).click();
        find(By.xpath("//button[@analytics-event='busqueda-pinbus']")).click();
    }


    public void filtros () {

        WebElementFacade lqs = $("//label[contains(text(),'REY DORADO LO MÁXIMO')]//input");
        waitFor(18).seconds();
        waitFor((WebElementFacade)(lqs)).waitUntilEnabled().click();
        find(By.xpath("//button[@class='btn btn-primary' and text()]")).click();
        waitFor(15).seconds();
        find(By.xpath("//span[@class='seat-number' and text()='3']")).click();

    }

    public void infoPasajero () {
        System.out.println("aqui llenaria la info del pasajero");
    }
    }


