package co.edu.uda.certificacion.parabank.tasks;

import co.edu.uda.certificacion.parabank.interactions.Esperar;
import co.edu.uda.certificacion.parabank.interactions.HacerClicConPausa;
import co.edu.uda.certificacion.parabank.userinterfaces.AccountsOverviewPage;
import co.edu.uda.certificacion.parabank.userinterfaces.ParaBankHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Tarea para consultar el resumen de cuentas
 */
public class ConsultarResumenCuentas implements Performable {
    
    public ConsultarResumenCuentas() {
        // Constructor vacío requerido
    }
    
    public static ConsultarResumenCuentas bancarias() {
        return new ConsultarResumenCuentas();
    }
    
    @Step("{0} consulta el resumen de sus cuentas")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            HacerClicConPausa.en(ParaBankHomePage.ACCOUNTS_OVERVIEW_LINK),
            WaitUntil.the(AccountsOverviewPage.ACCOUNTS_TABLE, isVisible()).forNoMoreThan(10).seconds(),
            Esperar.durante(1500),
            HacerClicConPausa.en(AccountsOverviewPage.FIRST_ACCOUNT_LINK),
            Esperar.durante(2000)
        );
    }
}
