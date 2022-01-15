package rmit.rmitsb.service;

import rmit.rmitsb.model.Job;
import rmit.rmitsb.model.JobCategory;


import java.util.List;

import java.util.List;

public interface JobService {
    public void saveJob(Job job);

    public List<Job> getAllJobs();
    public Job getJob(Long id);

    public Job deleteJob(Long id);
    public List<Job> getJobsByCategory(Long jobCategory_id);
    public List<Job> searchJobByTitle(String content);

    public List<Job> searchJobByEmployer(Long id);
    public List<Job> recommendJobsBySpecialization(Long id);
}