package co.edu.uda.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Página para actualizar información de contacto del cliente
 */
public class UpdateContactInfoPage {
    private UpdateContactInfoPage(){}
    
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
    
    public static final Target UPDATE_PROFILE_BUTTON = Target.the("botón actualizar perfil")
            .located(By.cssSelector("input[value='Update Profile']"));
    
    public static final Target SUCCESS_MESSAGE = Target.the("mensaje de éxito")
            .located(By.xpath("//div[@id='updateProfileResult']//h1[@class='title'] | //div[@id='updateProfileResult']//p"));
}
