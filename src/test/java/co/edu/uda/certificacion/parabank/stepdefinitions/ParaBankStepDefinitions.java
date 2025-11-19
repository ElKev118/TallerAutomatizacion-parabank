package co.edu.uda.certificacion.parabank.stepdefinitions;

import co.edu.uda.certificacion.parabank.models.DatosRegistro;
import co.edu.uda.certificacion.parabank.questions.*;
import co.edu.uda.certificacion.parabank.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class ParaBankStepDefinitions {
    
    @Before
    public void configurarEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }
    
    @Given("{word} navigates to ParaBank platform")
    public void navigatesToParaBankPlatform(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        String url = "https://parabank.parasoft.com/";
        actor.attemptsTo(
            NavegarAParaBank.enLaURL(url)
        );
    }
    
    @When("{word} registers with the following information")
    public void registersWithTheFollowingInformation(String actorName, io.cucumber.datatable.DataTable dataTable) {
        Actor actor = OnStage.theActorCalled(actorName);
        Map<String, String> datos = dataTable.asMap(String.class, String.class);
        
        DatosRegistro datosRegistro = new DatosRegistro();
        datosRegistro.setNombre(datos.get("nombre"));
        datosRegistro.setApellido(datos.get("apellido"));
        datosRegistro.setDireccion(datos.get("direccion"));
        datosRegistro.setCiudad(datos.get("ciudad"));
        datosRegistro.setEstado(datos.get("estado"));
        datosRegistro.setCodigoPostal(datos.get("codigo"));
        datosRegistro.setTelefono(datos.get("telefono"));
        datosRegistro.setSsn(datos.get("ssn"));
        datosRegistro.setUsuario(datos.get("usuario"));
        datosRegistro.setPassword(datos.get("password"));
        
        actor.attemptsTo(
            RegistrarseEnParaBank.conLosDatos(datosRegistro)
        );
    }
    
    @Then("{word} should see the welcome message")
    public void shouldSeeTheWelcomeMessage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.should(
            seeThat("the welcome message", MensajeBienvenida.mostrado(), containsString("Welcome"))
        );
    }
    
    @And("{word} should have access to his account")
    public void shouldHaveAccessToHisAccount(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.should(
            seeThat("account access", AccesoCuenta.esVisible(), is(true))
        );
    }
    
    @Given("{word} has logged in with username {string} and password {string}")
    public void hasLoggedInWithUsernameAndPassword(String actorName, String username, String password) {
        Actor actor = OnStage.theActorCalled(actorName);
        String url = "https://parabank.parasoft.com/";
        actor.attemptsTo(
            NavegarAParaBank.enLaURL(url),
            IniciarSesion.conCredenciales(username, password)
        );
    }
    
    @When("{word} requests to create a new savings account")
    public void requestsToCreateANewSavingsAccount(String actorName) {
        OnStage.theActorCalled(actorName);
    }
    
    @And("{word} selects the source account for initial funds")
    public void selectsTheSourceAccountForInitialFunds(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.attemptsTo(
            AbrirNuevaCuenta.deAhorros()
        );
    }
    
    @Then("{word} should see the account creation confirmation")
    public void shouldSeeTheAccountCreationConfirmation(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.should(
            seeThat("the confirmation", ConfirmacionCuentaCreada.mostrada(), 
                    anyOf(containsString("Account Opened"), containsString("Congratulations")))
        );
    }
    
    @And("{word} should view the new account number")
    public void shouldViewTheNewAccountNumber(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.should(
            seeThat("account access", AccesoCuenta.esVisible(), is(true))
        );
    }
    
    @When("{word} checks his accounts summary")
    public void checksHisAccountsSummary(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.attemptsTo(
            ConsultarResumenCuentas.bancarias()
        );
    }
    
    @Then("{word} should view the list of all his accounts")
    public void shouldViewTheListOfAllHisAccounts(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.should(
            seeThat("visible accounts", CuentasVisibles.enElResumen(), is(true))
        );
    }
    
    @And("{word} should see the available balance of each account")
    public void shouldSeeTheAvailableBalanceOfEachAccount(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.should(
            seeThat("visible accounts", CuentasVisibles.enElResumen(), is(true))
        );
    }
    
    @When("{word} makes a transfer of {int} dollars to another account")
    public void makesATransferOfDollarsToAnotherAccount(String actorName, int amount) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.attemptsTo(
            RealizarTransferencia.porMonto(amount)
        );
    }
    
    @Then("{word} should see the successful transfer message")
    public void shouldSeeTheSuccessfulTransferMessage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.should(
            seeThat("transfer confirmation", ConfirmacionTransferencia.mostrada(), 
                    anyOf(containsString("Transfer Complete"), containsString("complete")))
        );
    }
    
    @And("{word} should see the updated balance in his account")
    public void shouldSeeTheUpdatedBalanceInHisAccount(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.should(
            seeThat("the confirmation", ConfirmacionTransferencia.mostrada(), notNullValue())
        );
    }
    
    @When("{word} updates his contact information")
    public void updatesHisContactInformation(String actorName, io.cucumber.datatable.DataTable dataTable) {
        Actor actor = OnStage.theActorCalled(actorName);
        Map<String, String> nuevosDatos = dataTable.asMap(String.class, String.class);
        
        actor.attemptsTo(
            ActualizarInformacionContacto.conLosDatos(nuevosDatos)
        );
    }
    
    @Then("{word} should see the successful update message")
    public void shouldSeeTheSuccessfulUpdateMessage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.should(
            seeThat("update message", ActualizacionExitosa.mostrada(), 
                    anyOf(containsString("Profile Updated"), containsString("updated")))
        );
    }
    
    @And("{word} should view the updated information in his profile")
    public void shouldViewTheUpdatedInformationInHisProfile(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.should(
            seeThat("the update", ActualizacionExitosa.mostrada(), notNullValue())
        );
    }
}
