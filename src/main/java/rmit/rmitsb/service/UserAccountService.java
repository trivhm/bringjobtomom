package rmit.rmitsb.service;

import rmit.rmitsb.model.UserAccount;

import java.util.List;

public interface UserAccountService {

    public void saveUser(UserAccount userAccount);
    public String checkUser(String phone, String password);
    public List<UserAccount> getAllUsers();
    public UserAccount getUser(Long id);

    public UserAccount deleteUser(Long id);
}
