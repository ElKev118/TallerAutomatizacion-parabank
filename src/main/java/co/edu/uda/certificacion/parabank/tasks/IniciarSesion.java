package co.edu.uda.certificacion.parabank.tasks;

import co.edu.uda.certificacion.parabank.interactions.Esperar;
import co.edu.uda.certificacion.parabank.interactions.HacerClicConPausa;
import co.edu.uda.certificacion.parabank.interactions.IngresarTextoConPausa;
import co.edu.uda.certificacion.parabank.userinterfaces.ParaBankHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Tarea para iniciar sesión en ParaBank
 */
public class IniciarSesion implements Performable {
    
    private final String usuario;
    private final String password;
    
    public IniciarSesion(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    public static IniciarSesion conCredenciales(String usuario, String password) {
        return new IniciarSesion(usuario, password);
    }
    
    @Step("{0} inicia sesión con usuario {1}")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(ParaBankHomePage.USERNAME_INPUT, isVisible()).forNoMoreThan(10).seconds(),
            IngresarTextoConPausa.elValor(usuario).en(ParaBankHomePage.USERNAME_INPUT),
            IngresarTextoConPausa.elValor(password).en(ParaBankHomePage.PASSWORD_INPUT),
            Esperar.durante(500),
            HacerClicConPausa.en(ParaBankHomePage.LOGIN_BUTTON).conPausaDe(2000)
        );
    }
}
