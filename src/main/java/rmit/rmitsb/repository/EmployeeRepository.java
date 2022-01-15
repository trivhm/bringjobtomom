package rmit.rmitsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.UserAccount;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {
//    Employee findByUserAccountIs(UserAccount userAccount);
    Employee findByPhoneIs(String phone);
}
