package kr.ac.springboot.term;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ResumeRepository rrepo;
	
	@Autowired
	private ExperienceRepository erepo;
	
	
    @Override
    public void run(ApplicationArguments args) {
        // 초기 데이터 입력
    	Resume resume = new Resume("박희찬", "2013551067", "KSU-SoftWare", "phc5403@gmail", "Hello World!");
    	rrepo.save(resume);
    	erepo.save(new Experience("역할", "기간", "프로젝트 이름", "프로젝트 설명", resume));

    }

}