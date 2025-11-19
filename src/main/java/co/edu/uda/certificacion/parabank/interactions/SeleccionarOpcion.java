package co.edu.uda.certificacion.parabank.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Interacción para seleccionar una opción de un dropdown con pausa visual
 */
public class SeleccionarOpcion implements Interaction {
    
    private final Target dropdown;
    private final String opcion;
    private final int pausaMilisegundos;
    
    private SeleccionarOpcion(Target dropdown, String opcion, int pausaMilisegundos) {
        this.dropdown = dropdown;
        this.opcion = opcion;
        this.pausaMilisegundos = pausaMilisegundos;
    }
    
    public static SeleccionarOpcion enEl(Target dropdown) {
        return new SeleccionarOpcion(dropdown, null, 800);
    }
    
    public SeleccionarOpcion conElValor(String opcion) {
        return new SeleccionarOpcion(this.dropdown, opcion, this.pausaMilisegundos);
    }
    
    public SeleccionarOpcion conPausaDe(int milisegundos) {
        return new SeleccionarOpcion(this.dropdown, this.opcion, milisegundos);
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            SelectFromOptions.byVisibleText(opcion).from(dropdown)
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
    
    public static Interaction porTextoVisible(String opcion, Target dropdown) {
        return Tasks.instrumented(SeleccionarOpcion.class, dropdown, opcion, 800);
    }
}
