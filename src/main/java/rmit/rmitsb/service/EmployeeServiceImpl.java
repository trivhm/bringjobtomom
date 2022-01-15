package rmit.rmitsb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.rmitsb.model.Admin;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.UserAccount;
import rmit.rmitsb.repository.AdminRepository;
import rmit.rmitsb.repository.EmployeeRepository;
import rmit.rmitsb.repository.EmployerRepository;
import rmit.rmitsb.repository.UserAccountRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private AdminRepository adminRepository;

    public String login(String phone, String password){
        Employee employee = null;
        Employer employer = null;
        Admin admin = null;
        String result = "Default";
        try {
            employee = this.employeeRepository.findByPhoneIs(phone);
            if(employee != null){
                if(password.equals(employee.getPassword())){
                    result = String.valueOf(employee.getId()) +"," + String.valueOf(employee.getRole()) ;
                } else{
                    result = "Incorrect Password";
                }
            }
            else{
                employer = this.employerRepository.findByPhoneIs(phone);
                if(employer != null){
                    if(password.equals(employer.getPassword())){
                        result = String.valueOf(employer.getId())+"," + String.valueOf(employer.getRole());
                    } else{
                        result = "Incorrect Password";
                    }
                } else{
                    admin = this.adminRepository.findByPhoneIs(phone);
                    if(admin != null){
                        if(password.equals(admin.getPassword())){
                            result = String.valueOf(admin.getId())+"," + String.valueOf(admin.getRole());
                        } else{
                            result = "Incorrect Password";
                        }
                    } else{
                        result = "Incorrect phone/account";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "System error";
        }
        return result;
    }

    public String getRole(Long id){
        Employee employee = null;
        Employer employer = null;
        Admin admin = null;
        String result = "Default";
        try {

            if(this.employeeRepository.findById(id).isPresent()){
                employee = this.employeeRepository.findById(id)
                        .orElseThrow(() -> new Exception("User not found for this id :: " + id));
                result = employee.getRole();
            } else{
                if(this.employerRepository.findById(id).isPresent()){
                    employer = this.employerRepository.findById(id)
                            .orElseThrow(() -> new Exception("User not found for this id :: " + id));
                    result = employer.getRole();
                } else{
                    if( this.adminRepository.findById(id).isPresent()){
                        admin = this.adminRepository.findById(id)
                                .orElseThrow(() -> new Exception("User not found for this id :: " + id));
                        result = admin.getRole();
                    } else{
                        result ="Invalid ID";
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void saveEmployee(Employee employee){
        this.employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return this.employeeRepository.findAll();
    }

//    public Employee getEmployeeByUser(Long id){
//        Employee employee = null;
//        String result = "Default";
//        UserAccount userAccount = null;
//        try {
//            userAccount = this.userAccountRepository.findById(id)
//                    .orElseThrow(() -> new Exception("User not found for this id :: " + id));
//            if(userAccount != null){
//                employee = this.employeeRepository.findByUserAccountIs(userAccount);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return employee;
//    }

    public Employee getEmployee(Long id){
        Employee employee = null;
        try {
            employee = this.employeeRepository.findById(id)
                    .orElseThrow(() -> new Exception("User not found for this id :: " + id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public Employee deleteEmployee(Long id){

        Employee employee = getEmployee(id);
        this.employeeRepository.delete(employee);
        return employee;
    }
}
