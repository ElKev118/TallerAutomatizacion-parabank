package co.edu.uda.certificacion.parabank.questions;

import co.edu.uda.certificacion.parabank.userinterfaces.ParaBankHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/**
 * Pregunta para verificar el mensaje de bienvenida después del registro
 */
public class MensajeBienvenida implements Question<String> {
    
    public static MensajeBienvenida mostrado() {
        return new MensajeBienvenida();
    }
    
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ParaBankHomePage.WELCOME_TITLE).answeredBy(actor);
    }
}
