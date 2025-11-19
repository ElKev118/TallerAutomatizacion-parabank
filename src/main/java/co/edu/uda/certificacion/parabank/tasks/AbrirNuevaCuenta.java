package co.edu.uda.certificacion.parabank.tasks;

import co.edu.uda.certificacion.parabank.interactions.Esperar;
import co.edu.uda.certificacion.parabank.interactions.HacerClicConPausa;
import co.edu.uda.certificacion.parabank.userinterfaces.OpenAccountPage;
import co.edu.uda.certificacion.parabank.userinterfaces.ParaBankHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Tarea para abrir una nueva cuenta bancaria
 */
public class AbrirNuevaCuenta implements Performable {
    
    private final String tipoCuenta;
    
    public AbrirNuevaCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    
    public static AbrirNuevaCuenta deTipo(String tipoCuenta) {
        return new AbrirNuevaCuenta(tipoCuenta);
    }
    
    public static AbrirNuevaCuenta deAhorros() {
        return new AbrirNuevaCuenta("1"); // SAVINGS =  1
    }
    
    public static AbrirNuevaCuenta deChecking() {
        return new AbrirNuevaCuenta("0"); // CHECKING =  0
    }
    
    @Step("{0} abre una nueva cuenta {1}")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            HacerClicConPausa.en(ParaBankHomePage.OPEN_NEW_ACCOUNT_LINK),
            WaitUntil.the(OpenAccountPage.ACCOUNT_TYPE_DROPDOWN, isVisible()).forNoMoreThan(10).seconds(),
            Esperar.durante(800),
            SelectFromOptions.byValue(tipoCuenta).from(OpenAccountPage.ACCOUNT_TYPE_DROPDOWN),
            Esperar.durante(500),
            HacerClicConPausa.en(OpenAccountPage.OPEN_NEW_ACCOUNT_BUTTON).conPausaDe(3000)
        );
    }
}
