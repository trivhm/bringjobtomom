package rmit.rmitsb.service;

import rmit.rmitsb.model.JobCategory;


import java.util.List;

public interface JobCategoryService {
    public void saveJobCategory(JobCategory jobCategory);

    public List<JobCategory> getAllJobCategories();
    public JobCategory getJobCategory(Long id);

    public JobCategory deleteJobCategory(Long id);
}
