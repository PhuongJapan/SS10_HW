package ra.presentation;

import ra.business.IEmployee;
import ra.businessImp.Employee;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
    static List<Employee> employeeList = new ArrayList<>();
    static {
        employeeList.add(new Employee("1","Nguyen A",1990,3,300000,0,true));
        employeeList.add(new Employee("2","Nguyen C",2000,1,400000,0,false));
        employeeList.add(new Employee("3","Nguyen B",1995,2,200000,0,true));

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("******************MENU*****************");
            System.out.println("1. Nhập thông tin cho n nhân viên");
            System.out.println("2. Hiển thị thông tin cho các nhân viên");
            System.out.println("3. Tính lương cho các nhân viên");
            System.out.println("4. Tìm kiếm nhân viên theo tên nhân viên");
            System.out.println("5. Cập nhật thông tin nhân viên");
            System.out.println("6. Xóa thông tin nhân viên");
            System.out.println("7.  Sắp xếp nhân viên theo lương tăng dần (Comparable)");
            System.out.println("8. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)");
            System.out.println("9. Sắp xếp nhân vên theo năm sinh tăng dần (Comparator)");
            System.out.println("10. Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    EmployeeManagement. inputEmployee(scanner);
                    break;
                case 2:
                    EmployeeManagement.displayEmployeeList();
                    break;
                case 3:
                    EmployeeManagement.calSalaryOfEmployee();
                    break;
                case 4:
                    EmployeeManagement.searchEmployeeByName(scanner);
                    break;
                case 5:
                    EmployeeManagement.updateEmployeeInfo(scanner);
                    break;
                case 6:
                    EmployeeManagement.deleteEmployee(scanner);
                    break;
                case 7:
                    EmployeeManagement.sortEmployeeBySalary();
                    break;
                case 8:
                    EmployeeManagement.sortEmployeeByName();
                    break;
                case 9:
                    EmployeeManagement.sortEmployeeByYear();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-10");
            }
        } while (true);
    }

    private static void sortEmployeeByYear() {
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getYear()-o2.getYear();
            }
        });


    }

    private static void sortEmployeeByName() {
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getEmployeeName().compareTo(o1.getEmployeeName());
            }
        });
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.println("Nhập vào mã nhân viên bạn cần xóa");
        String deleteEmployeeId= scanner.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getEmployeeId().equals(deleteEmployeeId)){
                employeeList.remove(i);
            }
        }
        System.out.println("Đã xóa nhân viên có Id là: " +deleteEmployeeId);
    }

    private static void sortEmployeeBySalary() {
        Collections.sort(employeeList);
    }

    private static void updateEmployeeInfo(Scanner scanner) {
        System.out.println("Nhập mã nhân viên cần cập nhật thông tin");
        String updateEmployeeId = scanner.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {

            if(employeeList.get(i).getEmployeeId().equals(updateEmployeeId)){
                employeeList.get(i).inputData(scanner,employeeList);
            }
        }
        System.out.println("Đã cập nhật thông tin của nhân viên có Id là: " + updateEmployeeId);
    }

    private static void searchEmployeeByName(Scanner scanner) {

        System.out.println("Nhập vào tên nhân viên cần tìm");

        String searchName = scanner.nextLine();
        System.out.println("Nhân viên tìm thấy là: ");
        boolean isExist = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeName().toLowerCase().contains(searchName.toLowerCase())) {
                isExist = true;
                employeeList.get(i).displayData();
            }
        }
        if (!isExist) {
            System.out.println("Không tìm thấy nhân viên nào");
        }
    }

    private static void calSalaryOfEmployee() {
        for (Employee emp : employeeList) {
            emp.calSalary();
        }
        System.out.println("Đã tính xong lương cho tất cả nhân viên");
    }

    private static void displayEmployeeList() {
        for (int i = 0; i < employeeList.size(); i++) {
            employeeList.get(i).displayData();
        }
    }

    public static void inputEmployee(Scanner scanner) {
        System.out.println("Nhập số nhân viên cần nhập thông tin: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Employee employee = new Employee();
            employee.inputData(scanner, employeeList);
            employeeList.add(employee);
        }
    }


}
