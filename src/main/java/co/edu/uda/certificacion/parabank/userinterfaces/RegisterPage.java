package co.edu.uda.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Página de registro de nuevos usuarios
 */
public class RegisterPage {
    private RegisterPage(){}
    
    public static final Target FIRST_NAME_INPUT = Target.the("campo nombre")
            .located(By.id("customer.firstName"));
    
    public static final Target LAST_NAME_INPUT = Target.the("campo apellido")
            .located(By.id("customer.lastName"));
    
    public static final Target ADDRESS_INPUT = Target.the("campo dirección")
            .located(By.id("customer.address.street"));
    
    public static final Target CITY_INPUT = Target.the("campo ciudad")
            .located(By.id("customer.address.city"));
    
    public static final Target STATE_INPUT = Target.the("campo estado")
            .located(By.id("customer.address.state"));
    
    public static final Target ZIP_CODE_INPUT = Target.the("campo código postal")
            .located(By.id("customer.address.zipCode"));
    
    public static final Target PHONE_INPUT = Target.the("campo teléfono")
            .located(By.id("customer.phoneNumber"));
    
    public static final Target SSN_INPUT = Target.the("campo SSN")
            .located(By.id("customer.ssn"));
    
    public static final Target USERNAME_INPUT = Target.the("campo usuario")
            .located(By.id("customer.username"));
    
    public static final Target PASSWORD_INPUT = Target.the("campo contraseña")
            .located(By.id("customer.password"));
    
    public static final Target CONFIRM_PASSWORD_INPUT = Target.the("campo confirmar contraseña")
            .located(By.id("repeatedPassword"));
    
    public static final Target REGISTER_BUTTON = Target.the("botón registrar")
            .located(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input"));
    
    public static final Target WELCOME_MESSAGE = Target.the("mensaje de bienvenida")
            .located(By.xpath("//h1[@class='title']"));
    
    public static final Target SUCCESS_MESSAGE = Target.the("mensaje de éxito")
            .located(By.cssSelector("p"));
}
