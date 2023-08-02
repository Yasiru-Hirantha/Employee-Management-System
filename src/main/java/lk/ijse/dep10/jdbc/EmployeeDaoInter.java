package lk.ijse.dep10.jdbc;

public interface EmployeeDaoInter {
    public void createEmployee(Employees obj2);
    public void showAllEmployee();
    public void showEmployeeById(int id);
    public void updateEmployee(int id,String name);
    public void deleteEmployee(int id);

}
