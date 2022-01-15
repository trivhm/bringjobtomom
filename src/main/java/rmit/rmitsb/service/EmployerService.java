package rmit.rmitsb.service;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.UserAccount;

import java.util.List;
public interface EmployerService {
    public void saveEmployer(Employer employer);
    public List<Employer> getAllEmployers();
    public Employer getEmployer(Long id);
    public Employer deleteEmployer(Long id);
}
