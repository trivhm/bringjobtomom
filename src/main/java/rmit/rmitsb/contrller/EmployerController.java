package rmit.rmitsb.contrller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.UserAccount;
import rmit.rmitsb.service.EmployerService;
import rmit.rmitsb.service.UserAccountService;

import java.util.List;

@RestController
@CrossOrigin
public class EmployerController {
    @Autowired
    private EmployerService employerService;
    @Autowired
    private UserAccountService userAccountService;
    @RequestMapping(path = "/employer", method = RequestMethod.GET)
    public List<Employer> getAllEmployer(){
        return employerService.getAllEmployers();
    }

//    @RequestMapping(path = "/employer/{phone}/{password}", method = RequestMethod.GET)
//    public String checkUser(@PathVariable(value = "phone") String phone,@PathVariable(value = "password") String password ){
//        return userAccountService.checkUser(phone, password);
//    }

    @RequestMapping(path = "/employer", method = RequestMethod.POST)
    public void addEmployer(@RequestBody Employer employer){
        employer.setRole("employer");
        employerService.saveEmployer(employer);
    }

    @RequestMapping(path = "/employer", method = RequestMethod.PUT)
    public void updateEmployer(@RequestBody Employer employer){
        employerService.saveEmployer(employer);
    }

    @RequestMapping(path = "/employer/{id}", method = RequestMethod.DELETE)
    public void deleteEmployer(@PathVariable(value = "id") Long id){
        employerService.deleteEmployer(id);
    }

    @RequestMapping(path = "/employer/{id}", method = RequestMethod.GET)
    public Employer getUser(@PathVariable(value = "id") Long id){
        return employerService.getEmployer(id);
    }
}
