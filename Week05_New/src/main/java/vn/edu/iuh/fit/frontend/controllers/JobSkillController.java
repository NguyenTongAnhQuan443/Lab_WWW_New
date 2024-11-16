package vn.edu.iuh.fit.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.repositories.IJobRepository;
import vn.edu.iuh.fit.backend.repositories.IJobSkillRepository;
import vn.edu.iuh.fit.backend.repositories.ISkillRepository;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.models.Skill;

@Controller
@RequestMapping("/job-skills")
public class JobSkillController {
    private IJobRepository jobRepository;
    private IJobSkillRepository jobSkillRepository;
    private ISkillRepository skillRepository;
    @Autowired
    public JobSkillController(IJobRepository jobRepository, IJobSkillRepository jobSkillRepository, ISkillRepository skillRepository) {
        this.jobRepository = jobRepository;
        this.jobSkillRepository = jobSkillRepository;
        this.skillRepository = skillRepository;
    }
    @PostMapping("/add")
    public String addJobSkill(@ModelAttribute("jobSkill") JobSkill jobSkill, Model model){
        System.out.println(jobSkill);
        try {
            jobSkillRepository.save(jobSkill);


        } catch (Exception e){

        }
        return "redirect:/jobs/getAllByCompany";
    }
    @GetMapping("/openAddJobSkill")
    public ModelAndView openAddJobSkill(@RequestParam("jobID") long jobID){
        Job job = jobRepository.findById(jobID).orElse(null);
        ModelAndView modelAndView = new ModelAndView();
        JobSkill jobSkill = new JobSkill();
        jobSkill.setJob(new Job());
        jobSkill.setSkill(new Skill());

        modelAndView.addObject("jobSkill", jobSkill);
        modelAndView.addObject("skillLevel", SkillLevel.values());
        modelAndView.addObject("skills", skillRepository.findAll());
        assert job != null;
        modelAndView.addObject("jobID", job.getId());
        modelAndView.setViewName("company_actions/addJobSkill");

        return modelAndView;
    }
}
