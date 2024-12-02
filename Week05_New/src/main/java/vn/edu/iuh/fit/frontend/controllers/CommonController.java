package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.repositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.repositories.ICompanyRepository;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.services.JobService;

import java.util.List;

@Controller
@RequestMapping("")
public class CommonController {
    private ICandidateRepository candidateRepository;
    private ICompanyRepository companyRepository;
    private JobService jobService;

    @Autowired
    public CommonController(ICandidateRepository candidateRepository,
                            ICompanyRepository companyRepository,
                            JobService jobService) {
        this.candidateRepository = candidateRepository;
        this.companyRepository = companyRepository;
        this.jobService = jobService;
    }


    @GetMapping
    public String index(Model model) {
        // Lấy danh sách công việc
        List<Job> jobs = jobService.findAll(0, 10);  // Thay đổi page và size nếu cần
        model.addAttribute("jobs", jobs);
        return "index"; // Trả về trang home (index.html)
    }

    @GetMapping("/open-sign-in")
    public String openSignIn() {
        return "common/signin";
    }

    @PostMapping("/sign-in")
    public String signin(Model model , @RequestParam("username") String usename, @RequestParam("password") String password,
                         @RequestParam("role") String role, HttpServletRequest request) {
        Candidate candidate = null;
        Company company = null;
        if (role.equalsIgnoreCase("candidate")) {
            candidate = candidateRepository.findCandidateByUsernameAndPassword(usename, password).orElse(null);
        } else {
           company  = companyRepository.findCompaniesByUsernameAndPassword(usename, password).orElse(null);
        }
        if (candidate == null && company == null){
            model.addAttribute("errMsg", "Tài khoản không tồn tại!");
            return "common/signin";
        }

        HttpSession session =  request.getSession(true);
        session.setAttribute("candidateLogin", candidate);
        session.setAttribute("companyLogin", company);

        return "redirect:/";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }
}
