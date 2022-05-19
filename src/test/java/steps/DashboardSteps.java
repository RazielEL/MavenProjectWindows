package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @Then("user verifies all the dashboard tabs")
    public void user_verifies_all_the_dashboard_tabs(io.cucumber.datatable.DataTable dataTable) {
        // this data is coming from feature file
        List<String> expectedTabs = dataTable.asList();

        // this data comes from application:
        List<String> actualTabs = new ArrayList<>();

        for (WebElement ele : dashboardPage.dashboardTabs) {
            actualTabs.add(ele.getText());
        }

        System.out.println(actualTabs); // coming from execution
        System.out.println(expectedTabs); // coming from feature file

        Assert.assertEquals(actualTabs,expectedTabs);
        //or
       // Assert.assertTrue(expectedTabs.equals(actualTabs));
        
        



    }
}
