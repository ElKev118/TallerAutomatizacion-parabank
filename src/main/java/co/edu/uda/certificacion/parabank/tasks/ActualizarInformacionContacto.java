package co.edu.uda.certificacion.parabank.tasks;

import co.edu.uda.certificacion.parabank.interactions.Esperar;
import co.edu.uda.certificacion.parabank.interactions.HacerClicConPausa;
import co.edu.uda.certificacion.parabank.interactions.IngresarTextoConPausa;
import co.edu.uda.certificacion.parabank.userinterfaces.ParaBankHomePage;
import co.edu.uda.certificacion.parabank.userinterfaces.UpdateContactInfoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Tarea para actualizar la información de contacto del usuario
 */
public class ActualizarInformacionContacto implements Performable {
    
    private final Map<String, String> nuevosDatos;
    
    public ActualizarInformacionContacto(Map<String, String> nuevosDatos) {
        this.nuevosDatos = nuevosDatos;
    }
    
    public static ActualizarInformacionContacto conLosDatos(Map<String, String> nuevosDatos) {
        return new ActualizarInformacionContacto(nuevosDatos);
    }
    
    @Step("{0} actualiza su información de contacto")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            HacerClicConPausa.en(ParaBankHomePage.UPDATE_CONTACT_INFO_LINK),
            WaitUntil.the(UpdateContactInfoPage.PHONE_INPUT, isVisible()).forNoMoreThan(10).seconds(),
            Esperar.durante(800)
        );
        
        if (nuevosDatos.containsKey("telefono")) {
            actor.attemptsTo(
                IngresarTextoConPausa.elValor(nuevosDatos.get("telefono")).en(UpdateContactInfoPage.PHONE_INPUT)
            );
        }
        
        if (nuevosDatos.containsKey("direccion")) {
            actor.attemptsTo(
                IngresarTextoConPausa.elValor(nuevosDatos.get("direccion")).en(UpdateContactInfoPage.ADDRESS_INPUT)
            );
        }
        
        actor.attemptsTo(
            Esperar.durante(800),
            HacerClicConPausa.en(UpdateContactInfoPage.UPDATE_PROFILE_BUTTON).conPausaDe(2000)
        );
    }
}
