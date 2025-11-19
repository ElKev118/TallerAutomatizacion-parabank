package co.edu.uda.certificacion.parabank.questions;

import co.edu.uda.certificacion.parabank.userinterfaces.ParaBankHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

/**
 * Pregunta para verificar que el usuario tiene acceso a su cuenta
 */
public class AccesoCuenta implements Question<Boolean> {
    
    public static AccesoCuenta esVisible() {
        return new AccesoCuenta();
    }
    
    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(ParaBankHomePage.ACCOUNTS_OVERVIEW_LINK).answeredBy(actor);
    }
}
