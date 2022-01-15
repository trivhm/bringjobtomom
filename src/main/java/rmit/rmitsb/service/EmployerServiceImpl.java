package rmit.rmitsb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.UserAccount;
import rmit.rmitsb.repository.EmployerRepository;


import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private EmployerRepository employerRepository;


    public void saveEmployer(Employer employer){
        this.employerRepository.save(employer);
    }

    public List<Employer> getAllEmployers(){
        return this.employerRepository.findAll();
    }



    public Employer getEmployer(Long id){
        Employer employer = null;
        try {
            employer = this.employerRepository.findById(id)
                    .orElseThrow(() -> new Exception("User not found for this id :: " + id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employer;
    }

    public Employer deleteEmployer(Long id){

        Employer employer = getEmployer(id);
        this.employerRepository.delete(employer);
        return employer;
    }
}
