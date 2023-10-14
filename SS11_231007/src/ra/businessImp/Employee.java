package ra.businessImp;

import ra.business.IEmployee;

import java.util.List;
import java.util.Scanner;

public class Employee implements IEmployee,Comparable<Employee> {
    public String employeeId;
    public String employeeName;
    public int year;
    public float rate;
    public float commission;
    public float salary;
    public boolean status;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public Employee(){

    }

    public Employee(String employeeId, String employeeName, int year, float rate, float commission, float salary, boolean status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.year = year;
        this.rate = rate;
        this.commission = commission;
        this.salary = salary;
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner, List<Employee> employeeList) {
        System.out.println("Nhập các thông tin cho nhân viên như dưới đây:");
        System.out.println("Nhập mã nhân viên");
        this.employeeId = scanner.nextLine();
        System.out.println("Nhập tên nhân viên");
        this.employeeName = scanner.nextLine();
        System.out.println("Nhập năm sinh của nhân viên");
        this.year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập hệ số lương nhân viên");
        this.rate = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập hoa hồng của nhân viên hàng tháng");
        this.commission = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập trạng thái nhân viên, chỉ nhập true hoặc false");
        this.status = Boolean.parseBoolean(scanner.nextLine());

    }

    @Override
    public void displayData() {
        System.out.printf("Mã NV: %s - Tên NV: %s - Năm sinh NV: %d - Hệ số lương: %.2f - Hoa hồng: %.2f - Lương: %.2f - Trạng thái NV: %s\n"
                , this.employeeId, this.employeeName, this.year, this.rate, this.commission, this.salary, (this.status?"Đang làm việc":"Đã nghỉ việc"));

    }
    public void calSalary(){
        salary = rate*BASIC_SALARY+commission;
    }

    @Override
    public int compareTo(Employee o) {
        return (int) (this.salary-o.salary);
    }
}
