package co.edu.uda.certificacion.parabank.questions;

import co.edu.uda.certificacion.parabank.userinterfaces.OpenAccountPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/**
 * Pregunta para verificar el mensaje de confirmación de creación de cuenta
 */
public class ConfirmacionCuentaCreada implements Question<String> {
    
    public static ConfirmacionCuentaCreada mostrada() {
        return new ConfirmacionCuentaCreada();
    }
    
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(OpenAccountPage.CONFIRMATION_MESSAGE).answeredBy(actor);
    }
}
