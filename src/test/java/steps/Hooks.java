package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before; // to jest wazne zeby to importowac bo przy dodaniu sa 2 opcje, to ta  ma byc
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {


    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(Scenario scenario){
        byte[] pic;
        // scenario class from cucumber holds the complete information of our execution
        if(scenario.isFailed()){
           pic = takeScreenshot("failed/" + scenario.getName());
        } else {
            pic = takeScreenshot("passed/" + scenario.getName());
        }
    // adding picture to the report
        scenario.attach(pic, "image/png", scenario.getName());




        tearDown();
    }




}
