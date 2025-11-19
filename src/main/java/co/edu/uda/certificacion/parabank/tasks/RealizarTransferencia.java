package co.edu.uda.certificacion.parabank.tasks;

import co.edu.uda.certificacion.parabank.interactions.Esperar;
import co.edu.uda.certificacion.parabank.interactions.HacerClicConPausa;
import co.edu.uda.certificacion.parabank.interactions.IngresarTextoConPausa;
import co.edu.uda.certificacion.parabank.userinterfaces.ParaBankHomePage;
import co.edu.uda.certificacion.parabank.userinterfaces.TransferFundsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Tarea para realizar una transferencia entre cuentas
 */
public class RealizarTransferencia implements Performable {
    
    private final String monto;
    
    public RealizarTransferencia(String monto) {
        this.monto = monto;
    }
    
    public static RealizarTransferencia porMonto(String monto) {
        return new RealizarTransferencia(monto);
    }
    
    public static RealizarTransferencia porMonto(int monto) {
        return new RealizarTransferencia(String.valueOf(monto));
    }
    
    @Step("{0} realiza una transferencia por {1} dólares")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            HacerClicConPausa.en(ParaBankHomePage.TRANSFER_FUNDS_LINK),
            WaitUntil.the(TransferFundsPage.AMOUNT_INPUT, isVisible()).forNoMoreThan(10).seconds(),
            Esperar.durante(1000),
            IngresarTextoConPausa.elValor(monto).en(TransferFundsPage.AMOUNT_INPUT),
            Esperar.durante(800),
            SelectFromOptions.byIndex(1).from(TransferFundsPage.TO_ACCOUNT_DROPDOWN),
            Esperar.durante(800),
            HacerClicConPausa.en(TransferFundsPage.TRANSFER_BUTTON).conPausaDe(3000)
        );
    }
}
