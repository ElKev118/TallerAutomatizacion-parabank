package co.edu.uda.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Página de resumen de cuentas bancarias
 */
public class AccountsOverviewPage {
    private AccountsOverviewPage(){}
    
    public static final Target ACCOUNTS_TABLE = Target.the("tabla de cuentas")
            .located(By.id("accountTable"));
    
    public static final Target FIRST_ACCOUNT_LINK = Target.the("enlace primera cuenta")
            .located(By.xpath("//table[@id='accountTable']/tbody/tr[1]/td[1]/a"));
    
    public static final Target ACCOUNT_LINKS = Target.the("enlaces de cuentas")
            .located(By.cssSelector("#accountTable tbody tr td:first-child a"));
    
    public static final Target BALANCE_AMOUNTS = Target.the("montos de saldo")
            .located(By.cssSelector("#accountTable tbody tr td:nth-child(2)"));
    
    public static final Target AVAILABLE_AMOUNTS = Target.the("montos disponibles")
            .located(By.cssSelector("#accountTable tbody tr td:nth-child(3)"));
    
    public static final Target ACCOUNT_DETAILS_TITLE = Target.the("título detalles de cuenta")
            .located(By.xpath("//div[@id='showActivity']//h1[@class='title']"));
    
    public static final Target ACCOUNT_BALANCE = Target.the("balance de la cuenta")
            .located(By.xpath("//table[@id='accountTable']//td[contains(text(),'Balance')]/following-sibling::td"));
}
