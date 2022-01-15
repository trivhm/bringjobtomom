package rmit.rmitsb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.rmitsb.model.Admin;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.UserAccount;
import rmit.rmitsb.repository.AdminRepository;
import rmit.rmitsb.repository.EmployerRepository;


import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;


    public void saveAdmin(Admin admin){
        this.adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins(){
        return this.adminRepository.findAll();
    }


    public Admin getAdmin(Long id){
        Admin admin = null;
        try {
            admin = this.adminRepository.findById(id)
                    .orElseThrow(() -> new Exception("User not found for this id :: " + id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    public Admin deleteAdmin(Long id){

        Admin admin = getAdmin(id);
        this.adminRepository.delete(admin);
        return admin;
    }
}
