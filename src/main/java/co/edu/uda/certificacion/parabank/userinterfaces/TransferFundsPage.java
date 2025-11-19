package co.edu.uda.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Página para realizar transferencias entre cuentas
 */
public class TransferFundsPage {
    private TransferFundsPage(){}
    
    public static final Target AMOUNT_INPUT = Target.the("campo monto a transferir")
            .located(By.id("amount"));
    
    public static final Target FROM_ACCOUNT_DROPDOWN = Target.the("selector cuenta origen")
            .located(By.id("fromAccountId"));
    
    public static final Target TO_ACCOUNT_DROPDOWN = Target.the("selector cuenta destino")
            .located(By.id("toAccountId"));
    
    public static final Target TRANSFER_BUTTON = Target.the("botón transferir")
            .located(By.cssSelector("input[value='Transfer']"));
    
    public static final Target CONFIRMATION_MESSAGE = Target.the("mensaje de confirmación")
            .located(By.xpath("//div[@id='showResult']//h1[@class='title'] | //div[@id='showResult']//p"));
    
    public static final Target TRANSFER_AMOUNT_LABEL = Target.the("etiqueta monto transferido")
            .located(By.id("amount"));
}
