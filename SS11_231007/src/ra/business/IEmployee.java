package ra.business;

import ra.businessImp.Employee;

import java.util.List;
import java.util.Scanner;

public interface IEmployee {
    float  BASIC_SALARY = 1300000;
    void inputData(Scanner scanner, List<Employee> employeeList);

    void displayData();

}
