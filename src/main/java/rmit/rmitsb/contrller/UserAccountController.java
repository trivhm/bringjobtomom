package rmit.rmitsb.contrller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rmit.rmitsb.model.UserAccount;
import rmit.rmitsb.service.UserAccountService;

import java.util.List;

@RestController
@CrossOrigin
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(path = "/useraccounts", method = RequestMethod.GET)
    public List<UserAccount> getAllUsers(){
        return userAccountService.getAllUsers();
    }

    @RequestMapping(path = "/useraccounts/{phone}/{password}", method = RequestMethod.GET)
    public String checkUser(@PathVariable(value = "phone") String phone,@PathVariable(value = "password") String password ){
        return userAccountService.checkUser(phone, password);
    }

    @RequestMapping(path = "/useraccounts", method = RequestMethod.POST)
    public void addUser(@RequestBody UserAccount userAccount){
        userAccountService.saveUser(userAccount);
    }

    @RequestMapping(path = "/useraccounts", method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserAccount userAccount){
        userAccountService.saveUser(userAccount);
    }

    @RequestMapping(path = "/useraccounts/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "id") Long id){
        userAccountService.deleteUser(id);
    }

    @RequestMapping(path = "/useraccounts/{id}", method = RequestMethod.GET)
    public UserAccount getUser(@PathVariable(value = "id") Long id){
        return userAccountService.getUser(id);
    }
}
