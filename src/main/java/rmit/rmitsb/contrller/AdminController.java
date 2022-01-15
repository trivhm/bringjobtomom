package rmit.rmitsb.contrller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rmit.rmitsb.model.Admin;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.UserAccount;
import rmit.rmitsb.service.AdminService;
import rmit.rmitsb.service.EmployerService;
import rmit.rmitsb.service.UserAccountService;

import java.util.List;

@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public List<Admin> getAllEmployer(){
        return adminService.getAllAdmins();
    }


    @RequestMapping(path = "/admin", method = RequestMethod.POST)
    public void addEmployer(@RequestBody Admin admin){
        admin.setRole("admin");
        adminService.saveAdmin(admin);
    }

    @RequestMapping(path = "/admin", method = RequestMethod.PUT)
    public void updateEmployer(@RequestBody Admin admin){
        adminService.saveAdmin(admin);
    }

    @RequestMapping(path = "/admin/{id}", method = RequestMethod.DELETE)
    public void deleteEmployer(@PathVariable(value = "id") Long id){
        adminService.deleteAdmin(id);
    }

    @RequestMapping(path = "/admin/{id}", method = RequestMethod.GET)
    public Admin getUser(@PathVariable(value = "id") Long id){
        return adminService.getAdmin(id);
    }
}
