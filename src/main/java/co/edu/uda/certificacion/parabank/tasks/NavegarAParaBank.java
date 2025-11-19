package co.edu.uda.certificacion.parabank.tasks;

import co.edu.uda.certificacion.parabank.interactions.Esperar;
import co.edu.uda.certificacion.parabank.userinterfaces.ParaBankHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Tarea para navegar a la página principal de ParaBank
 */
public class NavegarAParaBank implements Performable {
    
    private final String url;
    
    public NavegarAParaBank(String url) {
        this.url = url;
    }
    
    public static NavegarAParaBank enLaURL(String url) {
        return new NavegarAParaBank(url);
    }
    
    @Step("{0} navega a la plataforma ParaBank")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Open.url(url),
            Esperar.durante(2000)
        );
    }
}
