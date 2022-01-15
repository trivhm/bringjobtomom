package rmit.rmitsb.contrller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.Job;
import rmit.rmitsb.model.JobCategory;
import rmit.rmitsb.model.UserAccount;
import rmit.rmitsb.service.EmployerService;
import rmit.rmitsb.service.JobCategoryService;
import rmit.rmitsb.service.JobService;
import rmit.rmitsb.service.UserAccountService;

import java.util.List;

@RestController
@CrossOrigin
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private JobCategoryService jobCategoryService;
    @Autowired
    private EmployerService employerService;
    @RequestMapping(path = "/job", method = RequestMethod.GET)
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

//    @RequestMapping(path = "/employee/{phone}/{password}", method = RequestMethod.GET)
//    public String checkUser(@PathVariable(value = "phone") String phone,@PathVariable(value = "password") String password ){
//        return userAccountService.checkUser(phone, password);
//    }

    @RequestMapping(path = "/job/{useraccount_id}/{jobcategory_id}", method = RequestMethod.POST)
    public void addJob(@RequestBody Job job, @PathVariable Long useraccount_id, @PathVariable Long jobcategory_id){
        Employer employer = employerService.getEmployer(useraccount_id);
        JobCategory jobCategory = jobCategoryService.getJobCategory(jobcategory_id);
        job.setEmployer(employer);
        job.setJobCategory(jobCategory);
        job.setViews(0);
        job.setApplies(0);
        jobService.saveJob(job);
    }

    @RequestMapping(path = "/job", method = RequestMethod.PUT)
    public void updateJob(@RequestBody Job job){
        jobService.saveJob(job);
    }

    @RequestMapping(path = "/job/{id}", method = RequestMethod.DELETE)
    public void deleteJob(@PathVariable(value = "id") Long id){
        jobService.deleteJob(id);
    }

    @RequestMapping(path = "/job/search/{content}", method = RequestMethod.GET)
    public List<Job> searchJobsByTitle(@PathVariable(value = "content") String content){
        return jobService.searchJobByTitle(content);
    }

    @RequestMapping(path = "/job/employer/{id}", method = RequestMethod.GET)
    public List<Job> searchJobsByEmployer(@PathVariable(value = "id") Long id){
        return jobService.searchJobByEmployer(id);
    }

    @RequestMapping(path = "/job/recommend/{id}", method = RequestMethod.GET)
    public List<Job> recommendJobsBySpecialization(@PathVariable(value = "id") Long id) {
        return jobService.recommendJobsBySpecialization(id);
    }

    @RequestMapping(path = "/job/category/{id}", method = RequestMethod.GET)
    public List<Job> getJobsByCategory(@PathVariable(value = "id") Long id){
        return jobService.getJobsByCategory(id);
    }

    @RequestMapping(path = "/job/{id}", method = RequestMethod.GET)
    public Job getJob(@PathVariable(value = "id") Long id){
        return jobService.getJob(id);
    }
//
//    @RequestMapping(path = "/jobs/byUser/{id}", method = RequestMethod.GET)
//    public Job getEmployeeByUser(@PathVariable(value = "id") Long id){
//        return jobService.get(id);
//    }
}
