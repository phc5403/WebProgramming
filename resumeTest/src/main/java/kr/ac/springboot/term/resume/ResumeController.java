package kr.ac.springboot.term.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {

	
	@Autowired
	private ResumeRepository  rrepo;

    @GetMapping("/")
    public String resumeIndex(Model model) {
//        Resume resume = new Resume();
//        resume.setName("YourName");
        model.addAttribute("resume", rrepo.findAllByOrderByRegdateDesc());
        return "introduce/resume";
    }



}
