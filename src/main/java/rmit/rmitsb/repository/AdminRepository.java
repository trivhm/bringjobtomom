package rmit.rmitsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.rmitsb.model.Admin;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.UserAccount;

public interface AdminRepository extends JpaRepository<Admin, Long>  {
    Admin findByPhoneIs(String phone);
}
