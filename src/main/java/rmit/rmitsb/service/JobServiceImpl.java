package rmit.rmitsb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.rmitsb.model.*;
import rmit.rmitsb.repository.*;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobCategoryRepository jobCategoryRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    public void saveJob(Job job){
        this.jobRepository.save(job);
    }

    public List<Job> getAllJobs(){
        return this.jobRepository.findAll();
    }
    public List<Job> getJobsByCategory(Long jobCategory_id){
        JobCategory jobCategory = null;
        try {
            jobCategory = this.jobCategoryRepository.findById(jobCategory_id).orElseThrow(() -> new Exception("User not found for this id :: " + jobCategory_id));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.jobRepository.findJobsByJobCategoryIs(jobCategory);
    }

    public List<Job> searchJobByTitle(String content){
        return this.jobRepository.findJobsByTitleContainsOrDescriptionContainsOrSpecializationContainsOrLevelContainsOrLocationContains(content,content,content,content,content);
    }

    public List<Job> recommendJobsBySpecialization(Long id){
        Employee emploee = null;
        List<Job> results = null;
        try {
            emploee = this.employeeRepository.findById(id).orElseThrow(() -> new Exception("User not found for this id :: " + id));
            if(emploee != null){
                results = this.jobRepository.findJobsBySpecializationContains(emploee.getSpecialization());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<Job> searchJobByEmployer(Long id){
        Employer employer = null;
        List<Job> results = null;
        try {
            employer = this.employerRepository.findById(id).orElseThrow(() -> new Exception("User not found for this id :: " + id));
            if(employer != null){
                results = this.jobRepository.findJobsByEmployerIs(employer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }


//    public Job getJobByJobCategory(Long id){
//        Employee employee = null;
//        String result = "Default";
//        UserAccount userAccount = null;
//        try {
//            userAccount = this.userAccountRepository.findById(id)
//                    .orElseThrow(() -> new Exception("User not found for this id :: " + id));
//            if(userAccount != null){
//                employee = this.employeeRepository.findByUserAccountIs(userAccount);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return employee;
//    }

    public Job getJob(Long id){
        Job job = null;
        try {
            job = this.jobRepository.findById(id)
                    .orElseThrow(() -> new Exception("Job not found for this id :: " + id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return job;
    }

    public Job deleteJob(Long id){

        Job job = getJob(id);
        this.jobRepository.delete(job);
        return job;
    }
}
