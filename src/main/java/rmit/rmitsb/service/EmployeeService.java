package rmit.rmitsb.service;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.UserAccount;

import java.util.List;
public interface EmployeeService {
    public void saveEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployee(Long id);
//    public Employee getEmployeeByUser(Long id);
    public String login(String phone, String password);
    public String getRole(Long id);
    public Employee deleteEmployee(Long id);
}
