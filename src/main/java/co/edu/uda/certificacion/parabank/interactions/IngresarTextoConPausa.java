package co.edu.uda.certificacion.parabank.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Interacción para ingresar texto en un campo con pausa visual
 */
public class IngresarTextoConPausa implements Interaction {
    
    private final String texto;
    private final Target campo;
    private final int pausaMilisegundos;
    
    public IngresarTextoConPausa(String texto, Target campo, int pausaMilisegundos) {
        this.texto = texto;
        this.campo = campo;
        this.pausaMilisegundos = pausaMilisegundos;
    }
    
    public static IngresarTextoConPausa elValor(String texto) {
        return new IngresarTextoConPausa(texto, null, 500);
    }
    
    public IngresarTextoConPausa en(Target campo) {
        return new IngresarTextoConPausa(this.texto, campo, this.pausaMilisegundos);
    }
    
    public IngresarTextoConPausa conPausaDe(int milisegundos) {
        return new IngresarTextoConPausa(this.texto, this.campo, milisegundos);
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(campo),
            Enter.theValue(texto).into(campo)
        );
        esperarUnMomento();
    }
    
    private void esperarUnMomento() {
        try {
            Thread.sleep(pausaMilisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static Interaction en(String texto, Target campo) {
        return Tasks.instrumented(IngresarTextoConPausa.class, texto, campo, 500);
    }
}
