package rmit.rmitsb.service;
import rmit.rmitsb.model.Admin;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.UserAccount;

import java.util.List;
public interface AdminService {
    public void saveAdmin(Admin admin);
    public List<Admin> getAllAdmins();
    public Admin getAdmin(Long id);

    public Admin deleteAdmin(Long id);
}
