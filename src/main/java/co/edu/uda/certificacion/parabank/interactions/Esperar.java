package co.edu.uda.certificacion.parabank.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

/**
 * Interacción para esperar visualmente durante la automatización
 */
public class Esperar implements Interaction {
    
    private final int milisegundos;
    
    private Esperar(int milisegundos) {
        this.milisegundos = milisegundos;
    }
    
    public static Esperar unMomento() {
        return new Esperar(1000);
    }
    
    public static Esperar durante(int milisegundos) {
        return new Esperar(milisegundos);
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static Interaction unSegundo() {
        return Tasks.instrumented(Esperar.class, 1000);
    }
    
    public static Interaction dosSegundos() {
        return Tasks.instrumented(Esperar.class, 2000);
    }
}
