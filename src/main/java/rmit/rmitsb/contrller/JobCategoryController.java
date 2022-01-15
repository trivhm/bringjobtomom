package rmit.rmitsb.contrller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rmit.rmitsb.model.JobCategory;
import rmit.rmitsb.service.JobCategoryService;

import java.util.List;

@RestController
@CrossOrigin
public class JobCategoryController {
    @Autowired
    private JobCategoryService jobCategoryService;

    @RequestMapping(path = "/jobcategory", method = RequestMethod.GET)
    public List<JobCategory> getAllJobCategories(){
        return jobCategoryService.getAllJobCategories();
    }

    @RequestMapping(path = "/jobcategory", method = RequestMethod.POST)
    public void addJobCategory(@RequestBody JobCategory jobCategory){
        jobCategoryService.saveJobCategory(jobCategory);
    }

    @RequestMapping(path = "/jobcategory", method = RequestMethod.PUT)
    public void updateJobCategory(@RequestBody JobCategory jobCategory){
        jobCategoryService.saveJobCategory(jobCategory);
    }

    @RequestMapping(path = "/jobcategory/{id}", method = RequestMethod.DELETE)
    public void deleteJobCategory(@PathVariable(value = "id") Long id){
        jobCategoryService.deleteJobCategory(id);
    }

    @RequestMapping(path = "/jobcategory/{id}", method = RequestMethod.GET)
    public JobCategory getJobCategory(@PathVariable(value = "id") Long id){
        return jobCategoryService.getJobCategory(id);
    }
}
