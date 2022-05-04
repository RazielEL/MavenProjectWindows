package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.EmpDetPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {

        openBrowserAndLaunchApplication();

    }

    // do logowania tutaj mozemy zrobic to samo co w LoginStepts ale nie usuwam tu bo tu jest oryginalna templatka.

    @When("user enters valid admin credentials")
    public void user_enters_valid_admin_credentials() {
        //
        WebElement usernamefield = driver.findElement(By.id("txtUsername"));
        // usernamefield.sendKeys(ConfigReader.getPropertyValue("username"));
        sendText(usernamefield, ConfigReader.getPropertyValue("username"));
        //  driver.manage().timeouts().implicitlyWait(Constans.IMPLICIT_WAIT, TimeUnit.SECONDS);
        // sendText(login.usernameBox, ConfigReader.getPropertyValue("username")); // o to jest to zajebiste niby


        WebElement passwordfield = driver.findElement(By.name("txtPassword"));

        // passwordfield.sendKeys(ConfigReader.getPropertyValue("password"));
        sendText(passwordfield, ConfigReader.getPropertyValue("password"));
        //  driver.manage().timeouts().implicitlyWait(Constans.IMPLICIT_WAIT, TimeUnit.SECONDS);
        //  sendText(login.passwordBox,ConfigReader.getPropertyValue("password"));
        // to jest zmetodowane w CommonMethods i ten wait tez tam jest
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        //  LoginPage login = new LoginPage(); // moglismy skomentowac

        //WebElement loginButton = driver.findElement(By.name("Submit"));
        //  loginButton.click(); // oryginalnie to mialem
        //click(loginButton);
        //  driver.manage().timeouts().implicitlyWait(Constans.IMPLICIT_WAIT, TimeUnit.SECONDS);
        // login.loginBtn.click();
        click(login.loginBtn);

    }

    @When("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {

        //  WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        // pimOption.click();
        //  click(pimOption);
        // driver.manage().timeouts().implicitlyWait(Constans.IMPLICIT_WAIT, TimeUnit.SECONDS);
        click(employeeSearchPage.pimOption);

        //  WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        // empListOption.click();
        click(employeeSearchPage.empListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {

        // WebElement searchId = driver.findElement(By.id("empsearch_id"));
        //  searchId.sendKeys("8510142");

        sendText(employeeSearchPage.nameField, "8510142");

    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        // WebElement searchButton = driver.findElement(By.id("searchBtn"));
        // searchButton.click();
        // click(searchButton);
        click(employeeSearchPage.searchButton);
    }

    @Then("user is able to see employee information")
    public void user_is_able_to_see_employee_information() {
        System.out.println("Result Displayed");
        tearDown();
    }


    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        //  driver.manage().timeouts().implicitlyWait(Constans.IMPLICIT_WAIT, TimeUnit.SECONDS);
        //  WebElement searchName = driver.findElement(By.xpath("(//*[@type='text'])[1]"));
        // searchName.sendKeys("Zubair");  // tam mam w EmployeeSearch.feature drugi scenario gdzie jest to employee name
        sendText(employeeSearchPage.nameField, "zubair");
    }

//    @Then("employee Janusz Maj added successfully")
//    public void employeeJanuszMajAddedSuccessfully() {
//        String empName = "Janusz Stefan Maj";
//        String emp =
////        if (EmpDetPage.EmpVerText.getText().equals(empName)) {
////            System.out.println("Dodany");
////        } else {
////            System.out.println("Nie dodany");
////        }
//
//        if(getText(EmpDetPage.EmpVerText).equals(empName)){
//            System.out.println("Tak jest");
//        } else {
//            System.out.println("Nope");
//        }
//    }

    @Then("employee {string} {string} and {string} added successfully")
    public void employeeAndAddedSuccessfully(String onename, String twoname, String threename) {
        String empName = onename + " " + twoname + " " + threename;

        if(getText(EmpDetPage.EmpVerText).equals(empName)){
            System.out.println("Tak jest");
        } else {
            System.out.println("Nope");
        }

    }
}

// tylko to sie kopiuje a nie cala konsole

// te skomentowane co mam to to w CommonMethods zrobilismy metody co juz maja te czekanie w sobie
// kolejnosc tego nie ma znaczenia tego then when etc bo to i tak leci jak w feature