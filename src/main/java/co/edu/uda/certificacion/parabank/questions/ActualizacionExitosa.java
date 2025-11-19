package co.edu.uda.certificacion.parabank.questions;

import co.edu.uda.certificacion.parabank.userinterfaces.UpdateContactInfoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/**
 * Pregunta para verificar el mensaje de actualización exitosa
 */
public class ActualizacionExitosa implements Question<String> {
    
    public static ActualizacionExitosa mostrada() {
        return new ActualizacionExitosa();
    }
    
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(UpdateContactInfoPage.SUCCESS_MESSAGE).answeredBy(actor);
    }
}
