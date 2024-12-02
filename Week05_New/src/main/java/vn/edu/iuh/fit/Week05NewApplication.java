package vn.edu.iuh.fit;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.repositories.IAddressRepository;
import vn.edu.iuh.fit.backend.repositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.repositories.ICompanyRepository;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Week05NewApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week05NewApplication.class, args);
	}

//    @Autowired
//    private ICandidateRepository candidateRepository;
//
//    @Autowired
//    private IAddressRepository addressRepository;
//
//    @Autowired
//    private ICompanyRepository companyRepository;
//
//    @Bean
//    CommandLineRunner initData(){
//        return args -> {
//            Random rnd = new Random();
//            for (int i = 0; i < 1000; i++) {
////                Tạo ra Address
//               Address address = new Address(CountryCode.VN, "HCM", "700000", "Nguyen Van Linh", "123");
//                addressRepository.save(address);
//                // Tạo ra Candidate
//                Candidate candidate = new Candidate("Nguyen Van A" + i, "0123456789", "username" + i, "password" + i, "email" + i + "@example.com", LocalDate.now(), address);
//                candidateRepository.save(candidate);
//            }
//
//            for (int i = 0; i < 10; i++) {
////                Tạo ra Company
//                Company company = new Company("Company" + i, "About Company" + i, new Address(CountryCode.VN, "HCM", "700000", "Nguyen Van Linh", "123"), "0123456789", "http://example.com", "company" + i + "@example.com", "company" + i, "password" + i);
//                companyRepository.save(company);
////                Tạo ra Skill
//
//            }
//        };
//    }
}
