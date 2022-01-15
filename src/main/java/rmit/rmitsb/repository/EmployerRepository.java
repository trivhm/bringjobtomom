package rmit.rmitsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.UserAccount;

public interface EmployerRepository extends JpaRepository<Employer, Long>  {
    Employer findByPhoneIs(String phone);
}
