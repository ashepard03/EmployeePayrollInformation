package com.example.payroll;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EmployeePayrollInformation {
    public static void main(String[] args) {
        //read employee data from the file
        //generate pay information
        //print out employee information
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("PayDataFile");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            System.out.println("------Employee Payroll Information------");
            while ((input = bufReader.readLine()) != null) {
                String[] subStrings =
                        input.split("\\|");
                Employee e =
                        new Employee(subStrings[0], subStrings[1], Double.parseDouble(subStrings[2]), Double.parseDouble(subStrings[3]));
                System.out.printf("%s %-40s $%.2f\n", e.getEmployeeId(), e.getName(), e.getGrossPay());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
