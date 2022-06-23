package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTU2MzE2MTEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY1NTY3NDgxMSwidXNlcklkIjoiMzg0NCJ9.Y3DKOa0W5UGYgjKfhlhPS8rLLKN3bE9oy9pqaZl7Lg0";
    static String employee_id;


@Test
public void aCreateEmployee(){

    RequestSpecification request = given().header("Content-Type","application/json").
            header("Authorization", token).body("{\n" +
                    "  \"emp_firstname\": \"Lukasz\",\n" +
                    "  \"emp_lastname\": \"Stanislawowski\",\n" +
                    "  \"emp_middle_name\": \"Andrzej\",\n" +
                    "  \"emp_gender\": \"M\",\n" +
                    "  \"emp_birthday\": \"1987-06-11\",\n" +
                    "  \"emp_status\": \"Probation\",\n" +
                    "  \"emp_job_title\": \"QA\"\n" +
                    "}");

            Response response = request.when().post("/createEmployee.php");
            response.prettyPrint();
            response.then().assertThat().statusCode(201);

            // Hamcrest Matchers:
        response.then().assertThat().body("Message", Matchers.equalTo("Employee Created"));
        response.then().assertThat().body("Employee.emp_firstname", Matchers.equalTo("Lukasz"));

        // using jsonPath()
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
}

@Test
public void bGetCreatedEmployee(){

    RequestSpecification preparedRequest = given().header("Content-Type", "application/json").
            header("Authorization", token).queryParam("employee_id", employee_id);

    Response response = preparedRequest.when().get("/getOneEmployee.php");
    response.prettyPrint();
    response.then().assertThat().statusCode(200);

    String tempID = response.jsonPath().getString("employee.employee_id");
    System.out.println(tempID);
    Assert.assertEquals(tempID, employee_id);

}

    @Test
    public void cUpdateEmployee(){
        RequestSpecification preparedRequest = given().header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "        \"employee_id\": \""+ employee_id + "\",\n" +
                        "        \"emp_firstname\": \"edward\",\n" +
                        "        \"emp_lastname\": \"sisi\",\n" +
                        "        \"emp_middle_name\": \"MS1\", \n" +
                        "        \"emp_gender\": \"M\",       \n" +
                        "        \"emp_birthday\": \"1995-06-12\", \n" +
                        "        \"emp_status\": \"confirmed\",       \n" +
                        "        \"emp_job_title\": \"Manager\"        \n" +
                        "    }");

        Response response =preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }


@Test
public void dGetUpdatedEmployee(){
    RequestSpecification request = given().header("Content-Type", "application/json").
            header("Authorization", token).queryParam("employee_id", employee_id);

    Response response = request.when().get("/getOneEmployee.php");
    response.then().assertThat().statusCode(200);
    response.prettyPrint();
}

@Test
    public void eGetAllEmployees(){

    RequestSpecification request = given().header("Content-Type", "application/json").
            header("Authorization", token);

    Response response = request.when().get("/getAllEmployees.php");

    // it returns string of response
    response.prettyPrint();
    String allEmployees = response.prettyPrint();

    // jsonPath() vs jsonPath
    // jsonPath is a class that contains method for converting the values into json object
    // jsonPath() is a method which belongs to jsonPath class

    // creating object of jsonPath class

    JsonPath js = new JsonPath(allEmployees);

    // retrievieng total number of employees

    int count = js.getInt("Employees.size()");
    System.out.println(count);

    for (int i=0; i<count; i++){
        String empID = js.getString("Employees[" + i + "].employee_id");
        System.out.println(empID);
    }

}

}
