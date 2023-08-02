package lk.ijse.dep10.jdbc;

import java.sql.*;

public class EmployeeDaoImpl implements EmployeeDaoInter{
    Connection connection;


    @Override
    public void createEmployee(Employees obj2) {
        connection= DBConnection.getInstance().getConnection();
        String query="INSERT INTO employee VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm=connection.prepareStatement(query);
            pstm.setInt(1,obj2.getId());
            pstm.setString(2,obj2.getName());
            pstm.setInt(3,obj2.getSalary());
            pstm.setInt(4,obj2.getAge());
            int rst=pstm.executeUpdate();
            if(rst!=0){
                System.out.println("New Employee Data added Successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showAllEmployee() {
        connection=DBConnection.getInstance().getConnection();
        String query="SELECT * FROM employee";
        try {
            Statement stm=connection.createStatement();
            ResultSet rst=stm.executeQuery(query);
            while (rst.next()){
                int id = rst.getInt("id");
                String name = rst.getString("employee_name");
                int salary = rst.getInt("salary");
                int age = rst.getInt("age");
                System.out.println("ID :"+id+", Name :"+name+", Salary :"+salary+", Age :"+age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showEmployeeById(int id) {
        connection=DBConnection.getInstance().getConnection();
        String query="SELECT * FROM employee WHERE id="+id;
        try {
            Statement stm=connection.createStatement();
            ResultSet rst=stm.executeQuery(query);
            while (rst.next()){
                String name = rst.getString("employee_name");
                int salary = rst.getInt("salary");
                int age = rst.getInt("age");
                System.out.println("ID :"+id+", Name :"+name+", Salary :"+salary+", Age :"+age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        connection=DBConnection.getInstance().getConnection();
        String query="UPDATE employee SET employee_name=? WHERE id=?";
        try {
            PreparedStatement pstm=connection.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int rst=pstm.executeUpdate();
            if (rst!=0){
                System.out.println("Employee Name was Updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        connection=DBConnection.getInstance().getConnection();
        String query="DELETE FROM employee WHERE id="+id;
        try {
            PreparedStatement pstm=connection.prepareStatement(query);
            int rst=pstm.executeUpdate();
            if(rst!=0){
                System.out.println("One Employee details Successfully Erased!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
