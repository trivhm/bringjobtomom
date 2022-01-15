package rmit.rmitsb.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="useraccount")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String phone;
    private String password;
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserAccount() {
    }
}
