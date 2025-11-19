package co.edu.uda.certificacion.parabank.questions;

import co.edu.uda.certificacion.parabank.userinterfaces.TransferFundsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/**
 * Pregunta para verificar el mensaje de confirmación de transferencia
 */
public class ConfirmacionTransferencia implements Question<String> {
    
    public static ConfirmacionTransferencia mostrada() {
        return new ConfirmacionTransferencia();
    }
    
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(TransferFundsPage.CONFIRMATION_MESSAGE).answeredBy(actor);
    }
}
