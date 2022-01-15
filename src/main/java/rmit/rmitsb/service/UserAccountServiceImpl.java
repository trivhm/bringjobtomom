package rmit.rmitsb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.rmitsb.model.UserAccount;
import rmit.rmitsb.repository.UserAccountRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;


    public void saveUser(UserAccount userAccount){
        this.userAccountRepository.save(userAccount);
    }

    public List<UserAccount> getAllUsers(){
        return this.userAccountRepository.findAll();
    }

    public String checkUser(String phone, String password){
        UserAccount userAccount = null;
        String result = "Default";
        try {
            userAccount = this.userAccountRepository.findByPhoneIs(phone);
            if(userAccount != null){
                System.out.println(password);
                System.out.println(userAccount.getPassword());
                if(password.equals(userAccount.getPassword())){
                    result = String.valueOf(userAccount.getId());
                } else{
                    result = "Incorrect Password";
                }
            } else{
                result = "Incorrect phone/account";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "System error";
        }
        return result;
    }

    public UserAccount getUser(Long id){
        UserAccount userAccount = null;
        try {
            userAccount = this.userAccountRepository.findById(id)
                    .orElseThrow(() -> new Exception("User not found for this id :: " + id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userAccount;
    }

    public UserAccount deleteUser(Long id){

        UserAccount userAccount = getUser(id);
        this.userAccountRepository.delete(userAccount);
        return userAccount;
    }
}
