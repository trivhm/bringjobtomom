package rmit.rmitsb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.rmitsb.model.JobCategory;
import rmit.rmitsb.repository.JobCategoryRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class JobCategoryServiceImpl implements JobCategoryService{
    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public void saveJobCategory(JobCategory jobCategory){
        this.jobCategoryRepository.save(jobCategory);
    }
    public List<JobCategory> getAllJobCategories(){
        return this.jobCategoryRepository.findAll();
    }

    public JobCategory getJobCategory(Long id){
        JobCategory jobCategory = null;
        try {
            jobCategory = this.jobCategoryRepository.findById(id)
                    .orElseThrow(() -> new Exception("Job Category not found for this id :: " + id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobCategory;
    }

    public JobCategory deleteJobCategory(Long id){

        JobCategory jobCategory = getJobCategory(id);
        this.jobCategoryRepository.delete(jobCategory);
        return jobCategory;
    }

}
