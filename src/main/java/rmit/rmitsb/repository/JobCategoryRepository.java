package rmit.rmitsb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import rmit.rmitsb.model.JobCategory;

public interface JobCategoryRepository  extends JpaRepository<JobCategory, Long> {

}
