package co.edu.uda.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Página principal de ParaBank con elementos de navegación y registro
 */
public class ParaBankHomePage {
    private ParaBankHomePage(){}
    
    public static final Target REGISTER_LINK = Target.the("enlace de registro")
            .located(By.linkText("Register"));
    
    public static final Target USERNAME_INPUT = Target.the("campo de usuario")
            .located(By.xpath("//*[@id='loginPanel']/form/div[1]/input"));
    
    public static final Target PASSWORD_INPUT = Target.the("campo de contraseña")
            .located(By.xpath("//*[@id='loginPanel']/form/div[2]/input"));
    
    public static final Target LOGIN_BUTTON = Target.the("botón de login")
            .located(By.xpath("//*[@id='loginPanel']/form/div[3]/input"));
    
    public static final Target WELCOME_TITLE = Target.the("título de bienvenida")
            .located(By.xpath("//div[@id='rightPanel']//h1[@class='title'] | //div[@id='rightPanel']//p[1]"));
    
    public static final Target ACCOUNTS_OVERVIEW_LINK = Target.the("enlace resumen de cuentas")
            .located(By.xpath("//*[@id='leftPanel']/ul/li[2]/a"));
    
    public static final Target TRANSFER_FUNDS_LINK = Target.the("enlace transferir fondos")
            .located(By.xpath("//*[@id='leftPanel']/ul/li[3]/a"));
    
    public static final Target UPDATE_CONTACT_INFO_LINK = Target.the("enlace actualizar información")
            .located(By.linkText("Update Contact Info"));
    
    public static final Target OPEN_NEW_ACCOUNT_LINK = Target.the("enlace abrir nueva cuenta")
            .located(By.xpath("//*[@id='leftPanel']/ul/li[1]/a"));
    
    public static final Target LOGOUT_LINK = Target.the("enlace cerrar sesión")
            .located(By.linkText("Log Out"));
}
