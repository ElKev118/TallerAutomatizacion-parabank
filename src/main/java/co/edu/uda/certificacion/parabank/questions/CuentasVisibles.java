package co.edu.uda.certificacion.parabank.questions;

import co.edu.uda.certificacion.parabank.userinterfaces.AccountsOverviewPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

/**
 * Pregunta para verificar que las cuentas son visibles o que estamos en detalles de cuenta
 */
public class CuentasVisibles implements Question<Boolean> {
    
    public static CuentasVisibles enElResumen() {
        return new CuentasVisibles();
    }
    
    @Override
    public Boolean answeredBy(Actor actor) {
        // Verificar si la tabla de cuentas está visible
        return Visibility.of(AccountsOverviewPage.ACCOUNTS_TABLE).answeredBy(actor);
    }
}
