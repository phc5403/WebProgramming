package kr.ac.springboot.term.experience;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/experience/")
public class ExperienceController {
	
	// '/' ==> list
    // '/register' ==> create
    // '/{eno} ==> view
    // '/{eno}/update ==> update'
    // '/{eno}/delete ==> delete'
	
	
	@Autowired
	private ExperienceRepository  erepo;

    @GetMapping("/")
    public String resumeIndex(Model model) {
//        Resume resume = new Resume();
//        resume.setName("YourName");
        model.addAttribute("experience", erepo.findAllByOrderByRegdateDesc());
        return "experience/experience";
    }
    
    @GetMapping("/register")
    public void registerGET(@ModelAttribute("eo") Experience eo) {
    }
    
    // Create
    @PostMapping("/register")
    public String registerPOST(@ModelAttribute("eo") Experience eo) {
    	erepo.save(eo);
    	return "redirect:/experience/";
    }
    
    // Read
    @GetMapping("/{eno}")
    public String view(@PathVariable("eno") long eno, Model model) {
        if (erepo.findById(eno).isPresent()) {
            model.addAttribute("experience", erepo.findById(eno).get());
        } else if (erepo.findById(eno).isPresent() == false) {
        	return "errors/500";
        } else {
            return "errors/404";
        }
        return "experience/view";
    }
    
    // Update
    @GetMapping("/{eno}/update")
    public String editGet(@PathVariable("eno") long eno, @ModelAttribute("eo") Experience eo, Model model) {
        if (erepo.findById(eno).isPresent()) {
            model.addAttribute("eo", erepo.findById(eno).get());
        } else if (erepo.findById(eno).isPresent() == false) {
        	return "errors/500";
        } else {
            return "errors/404";
        }
        return "experience/update";
    }

    @PostMapping("/update")
    public String editPost(@ModelAttribute("eo") Experience eo) {
        Optional<Experience> experience = erepo.findById(eo.getEno());
        if (experience.isPresent()) {
        	experience.get().setRole(eo.getRole());
        	experience.get().setPname(eo.getPname());
        	experience.get().setDesc(eo.getDesc());
            experience.get().setDay(eo.getDay());
            erepo.save(experience.get());
        } else {
            erepo.save(eo);
        }
        return "redirect:/experience/";
    }
    
    // Delete
    @GetMapping("/{eno}/delete")
    public String delete(@PathVariable("eno") long eno) {
        if (erepo.findById(eno).isPresent()) {
            erepo.deleteById(eno);
        } else if (erepo.findById(eno).isPresent() == false) {
        	return "errors/500";
        } else {
            return "errors/404";
        }
        return "redirect:/experience/";
    }

}
