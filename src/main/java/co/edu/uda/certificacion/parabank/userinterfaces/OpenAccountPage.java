package co.edu.uda.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Página para abrir nuevas cuentas bancarias
 */
public class OpenAccountPage {
    private OpenAccountPage(){}
    
    public static final Target ACCOUNT_TYPE_DROPDOWN = Target.the("selector tipo de cuenta")
            .located(By.id("type"));
    
    public static final Target FROM_ACCOUNT_DROPDOWN = Target.the("selector cuenta origen")
            .located(By.id("fromAccountId"));
    
    public static final Target OPEN_NEW_ACCOUNT_BUTTON = Target.the("botón abrir nueva cuenta")
            .located(By.xpath("//*[@id='openAccountForm']/form/div/input"));
    
    public static final Target ACCOUNT_ID = Target.the("número de cuenta creada")
            .located(By.id("newAccountId"));
    
    public static final Target CONFIRMATION_MESSAGE = Target.the("mensaje de confirmación")
            .located(By.xpath("//div[@id='openAccountResult']//h1[@class='title'] | //div[@id='openAccountResult']//p"));
}
