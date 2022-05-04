package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class LoginSteps extends CommonMethods {

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        System.out.println("Admin test passed");
//        tearDown();
    }

    @When("user enters valid ESS username and password")
    public void user_enters_valid_ess_username_and_password() {

       // LoginPage login = new LoginPage();
//        WebElement usernamefield = driver.findElement(By.id("txtUsername"));

        sendText(login.usernameBox, "tts12345");
        //       WebElement passwordfield = driver.findElement(By.name("txtPassword"));
        sendText(login.passwordBox,"Hum@nhrm");  // tutaj jeszcze bardziej skomplikowany sposob na logowanie

    }
    @Then("ESS user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        System.out.println("ESS test passed");
//        tearDown();
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {

       // LoginPage login = new LoginPage();
        //    WebElement usernamefield = driver.findElement(By.id("txtUsername"));
        sendText(login.usernameBox, "tts12345");
        //       WebElement passwordfield = driver.findElement(By.name("txtPassword"));
        sendText(login.passwordBox,"Hum@nhrm");  // tutaj jeszcze bardziej skomplikowany sposob na logowanie, |||| to skopiowalem z gory
    }

    @Then("user see error message on the screen")
    public void userSeeErrorMessageOnTheScreen() {
        WebElement errorMessage = driver.findElement(By.id("spanMessage"));
      System.out.println("error message: " + errorMessage.getText());
//      tearDown();

    }
}
