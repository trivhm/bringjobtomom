package rmit.rmitsb.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String salaryRange;
    private String specialization;
    private String description;
    private String level;
    private String location;
    private int views;
    private int applies;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="jobcategory_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JobCategory jobCategory;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="employer_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Employer employer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getApplies() {
        return applies;
    }

    public void setApplies(int applies) {
        this.applies = applies;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Job() {
    }

}
