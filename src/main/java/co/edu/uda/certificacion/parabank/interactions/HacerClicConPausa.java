package co.edu.uda.certificacion.parabank.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Interacción para hacer clic en un elemento con pausa visual
 */
public class HacerClicConPausa implements Interaction {
    
    private final Target elemento;
    private final int pausaMilisegundos;
    
    public HacerClicConPausa(Target elemento, int pausaMilisegundos) {
        this.elemento = elemento;
        this.pausaMilisegundos = pausaMilisegundos;
    }
    
    public static HacerClicConPausa en(Target elemento) {
        return new HacerClicConPausa(elemento, 800);
    }
    
    public HacerClicConPausa conPausaDe(int milisegundos) {
        return new HacerClicConPausa(this.elemento, milisegundos);
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(elemento));
        esperarUnMomento();
    }
    
    private void esperarUnMomento() {
        try {
            Thread.sleep(pausaMilisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static Interaction sobreEl(Target elemento) {
        return Tasks.instrumented(HacerClicConPausa.class, elemento, 800);
    }
}
