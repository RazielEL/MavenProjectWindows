package steps;

import pages.AddEmployeePage;
import pages.EmpDetPage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageInitializers {

    public static LoginPage login;
    public static EmployeeSearchPage employeeSearchPage;
    public static AddEmployeePage addEmployeePage;
    public static EmpDetPage empDetPage;


    public  static void initializePageObjects(){
        login = new LoginPage();
        employeeSearchPage = new EmployeeSearchPage();
        addEmployeePage = new AddEmployeePage();
        empDetPage = new EmpDetPage();
    }
}
