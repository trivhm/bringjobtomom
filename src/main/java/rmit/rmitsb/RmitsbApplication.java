package rmit.rmitsb;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rmit.rmitsb.model.JobCategory;
import rmit.rmitsb.repository.JobCategoryRepository;
import rmit.rmitsb.service.JobCategoryService;

import java.util.List;

@SpringBootApplication
public class RmitsbApplication {
	@Autowired
	private JobCategoryRepository jobCategoryRepository;
	public static void main(String[] args) {
		SpringApplication.run(RmitsbApplication.class, args);
	}
	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			List<JobCategory> jobCategoryList = jobCategoryRepository.findAll();
			if(jobCategoryList.size() == 0){
				jobCategoryRepository.save(new JobCategory("Software/IT"));
				jobCategoryRepository.save(new JobCategory("Electrical and Electronics"));
				jobCategoryRepository.save(new JobCategory("Education"));
				jobCategoryRepository.save(new JobCategory("Banking"));
				jobCategoryRepository.save(new JobCategory("Textile and Garment"));
				jobCategoryRepository.save(new JobCategory("Aviation"));
				jobCategoryRepository.save(new JobCategory("Accounting"));
				jobCategoryRepository.save(new JobCategory("Logistics"));
				jobCategoryRepository.save(new JobCategory("Shipping"));

			}
		};
	}

}
