package lk.ijse.dep10.jdbc;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            EmployeeDaoInter obj=new EmployeeDaoImpl();
            String name;
            int id;
            do {
                System.out.println("Welcome to the Employee management System!");
                System.out.println("1.Create a new Employee \n" +
                        "2.Show all Emloyee \n" +
                        "3.Show Employee by Id \n" +
                        "4.Update a Employee \n" +
                        "5.Delete a Employee");
                System.out.print("Please Enter a valid choice : ");
                Scanner input = new Scanner(System.in);
                int choice= input.nextInt();

                switch (choice){
                    case 1:

                        Employees obj2=new Employees();
                        System.out.print("Enter the ID : ");
                        id= input.nextInt();
                        System.out.print("Enter the Name : ");
                        name= input.next();
                        System.out.print("Enter the Salary : ");
                        int salary=input.nextInt();
                        System.out.print("Enter the Age : ");
                        int age= input.nextInt();
                        obj2.setId(id);
                        obj2.setName(name);
                        obj2.setSalary(salary);
                        obj2.setAge(age);
                        obj.createEmployee(obj2);
                        break;
                    case 2:
                        obj.showAllEmployee();
                        break;
                    case 3:
                        System.out.print("Enter the Employee ID :");
                        id=input.nextInt();
                        obj.showEmployeeById(id);
                        break;
                    case 4:
                        System.out.print("Enter the Employee ID Which You need to update:");
                        id=input.nextInt();
                        System.out.print("Enter the Employee new Name :");
                        name=input.next();
                        obj.updateEmployee(id,name);
                        break;
                    case 5:
                        System.out.print("Enter the employee ID you want to erase :");
                        id= input.nextInt();
                        obj.deleteEmployee(id);
                        break;
                    default:
                        System.out.println("Please Enter a valid choice");
                        break;
                }


            }while(true);
        }



}
