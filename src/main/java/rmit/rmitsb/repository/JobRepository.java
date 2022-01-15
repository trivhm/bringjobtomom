package rmit.rmitsb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import rmit.rmitsb.model.*;

import javax.transaction.Transactional;
import java.util.List;
//@Repository
//@Transactional

public interface JobRepository  extends JpaRepository<Job, Long> {
    List<Job> findJobsByJobCategoryIs(JobCategory jobCategory);
    List<Job> findJobsByTitleContainsOrDescriptionContainsOrSpecializationContainsOrLevelContainsOrLocationContains(String content,String content2,String content3,String content4,String content5);
    List<Job> findJobsByEmployerIs(Employer employer);
    List<Job> findJobsBySpecializationContains(String content);
}
