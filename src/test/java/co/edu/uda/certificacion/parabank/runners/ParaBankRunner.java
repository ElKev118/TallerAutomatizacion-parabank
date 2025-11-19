package co.edu.uda.certificacion.parabank.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Runner para ejecutar las pruebas de ParaBank
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/parabank/gestion_cuenta_bancaria.feature",
        glue = "co.edu.uda.certificacion.parabank.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@ParaBank"
)
public class ParaBankRunner {
}
