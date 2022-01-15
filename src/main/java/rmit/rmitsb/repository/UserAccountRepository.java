package rmit.rmitsb.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import rmit.rmitsb.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findByPhoneIs(String phone);
}
