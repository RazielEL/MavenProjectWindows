package utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String createEmployeePayload(){
        String createEmployee = "{\n" +
                "  \"emp_firstname\": \"Arelka\",\n" +
                "  \"emp_lastname\": \"Stanislawowska\",\n" +
                "  \"emp_middle_name\": \"Ewelina\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1987-06-11\",\n" +
                "  \"emp_status\": \"Probation\",\n" +
                "  \"emp_job_title\": \"QA\"\n" +
                "} ";

        return createEmployee;
    }

    //passing the body from json object
    public static String createEmployeePayloadViaJson(){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Arelka");
        obj.put("emp_lastname","Stanislawowska");
        obj.put("emp_middle_name","Ewelina");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","1987-06-11");
        obj.put("emp_status","Probation");
        obj.put("emp_job_title","QA");


    return obj.toString();

    }

    public static String createEmployeeDynamic(String firstname, String lastname, String middlename, String gender, String dob, String status, String jobTitle){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstname);
        obj.put("emp_lastname", lastname);
        obj.put("emp_middle_name", middlename);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status", status);
        obj.put("emp_job_title", jobTitle);

        return obj.toString();

    }
}
