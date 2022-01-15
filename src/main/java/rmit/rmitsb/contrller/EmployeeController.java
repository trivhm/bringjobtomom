package rmit.rmitsb.contrller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.UserAccount;
import rmit.rmitsb.service.EmployeeService;
import rmit.rmitsb.service.UserAccountService;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserAccountService userAccountService;
    @RequestMapping(path = "/employee", method = RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

//    @RequestMapping(path = "/employee/{phone}/{password}", method = RequestMethod.GET)
//    public String checkUser(@PathVariable(value = "phone") String phone,@PathVariable(value = "password") String password ){
//        return userAccountService.checkUser(phone, password);
//    }

    @RequestMapping(path = "/employee", method = RequestMethod.POST)
    public void addEmployee(@RequestBody Employee employee){
        employee.setRole("employee");
        employeeService.saveEmployee(employee);
    }

    @RequestMapping(path = "/login/{phone}/{password}", method = RequestMethod.GET)
    public String loginUser(@PathVariable(value = "phone") String phone,@PathVariable(value = "password") String password ){
        return employeeService.login(phone, password);
    }
    @RequestMapping(path = "/getrole/{id}", method = RequestMethod.GET)
    public String getRole(@PathVariable(value = "id") Long id){
        return employeeService.getRole(id);
    }

    @RequestMapping(path = "/employee", method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @RequestMapping(path = "/employee/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable(value = "id") Long id){
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(path = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable(value = "id") Long id){
        return employeeService.getEmployee(id);
    }

//    @RequestMapping(path = "/employee/byUser/{id}", method = RequestMethod.GET)
//    public Employee getEmployeeByUser(@PathVariable(value = "id") Long id){
//        return employeeService.getEmployeeByUser(id);
//    }
}
