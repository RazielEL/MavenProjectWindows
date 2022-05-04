package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before; // to jest wazne zeby to importowac bo przy dodaniu sa 2 opcje, to ta  ma byc
import utils.CommonMethods;

public class Hooks extends CommonMethods {


    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(){
        tearDown();
    }




}
