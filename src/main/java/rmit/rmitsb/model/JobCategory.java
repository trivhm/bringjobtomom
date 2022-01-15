package rmit.rmitsb.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="jobcategory")
public class JobCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JobCategory() {
    }

    public JobCategory(String name) {
        this.name = name;
    }
}
