package co.edu.uda.certificacion.parabank.tasks;

import co.edu.uda.certificacion.parabank.interactions.Esperar;
import co.edu.uda.certificacion.parabank.interactions.HacerClicConPausa;
import co.edu.uda.certificacion.parabank.interactions.IngresarTextoConPausa;
import co.edu.uda.certificacion.parabank.models.DatosRegistro;
import co.edu.uda.certificacion.parabank.userinterfaces.ParaBankHomePage;
import co.edu.uda.certificacion.parabank.userinterfaces.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Tarea para registrar un nuevo usuario en ParaBank
 */
public class RegistrarseEnParaBank implements Performable {
    
    private final DatosRegistro datosRegistro;
    
    public RegistrarseEnParaBank(DatosRegistro datosRegistro) {
        this.datosRegistro = datosRegistro;
    }
    
    public static RegistrarseEnParaBank conLosDatos(DatosRegistro datosRegistro) {
        return new RegistrarseEnParaBank(datosRegistro);
    }
    
    @Step("{0} se registra como nuevo usuario en ParaBank")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            HacerClicConPausa.en(ParaBankHomePage.REGISTER_LINK),
            WaitUntil.the(RegisterPage.FIRST_NAME_INPUT, isVisible()).forNoMoreThan(10).seconds(),
            Esperar.durante(500),
            IngresarTextoConPausa.elValor(datosRegistro.getNombre()).en(RegisterPage.FIRST_NAME_INPUT),
            IngresarTextoConPausa.elValor(datosRegistro.getApellido()).en(RegisterPage.LAST_NAME_INPUT),
            IngresarTextoConPausa.elValor(datosRegistro.getDireccion()).en(RegisterPage.ADDRESS_INPUT),
            IngresarTextoConPausa.elValor(datosRegistro.getCiudad()).en(RegisterPage.CITY_INPUT),
            IngresarTextoConPausa.elValor(datosRegistro.getEstado()).en(RegisterPage.STATE_INPUT),
            IngresarTextoConPausa.elValor(datosRegistro.getCodigoPostal()).en(RegisterPage.ZIP_CODE_INPUT),
            IngresarTextoConPausa.elValor(datosRegistro.getTelefono()).en(RegisterPage.PHONE_INPUT),
            IngresarTextoConPausa.elValor(datosRegistro.getSsn()).en(RegisterPage.SSN_INPUT),
            Esperar.durante(500),
            IngresarTextoConPausa.elValor(datosRegistro.getUsuario()).en(RegisterPage.USERNAME_INPUT),
            IngresarTextoConPausa.elValor(datosRegistro.getPassword()).en(RegisterPage.PASSWORD_INPUT),
            IngresarTextoConPausa.elValor(datosRegistro.getPassword()).en(RegisterPage.CONFIRM_PASSWORD_INPUT),
            Esperar.durante(800),
            HacerClicConPausa.en(RegisterPage.REGISTER_BUTTON).conPausaDe(3000)
        );
    }
}
