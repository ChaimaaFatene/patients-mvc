package com.chaimaa.patientsmvc;

import com.chaimaa.patientsmvc.entities.Patient;
import com.chaimaa.patientsmvc.repositories.PatientRepository;
import com.chaimaa.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
   // @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null,"Chaimaa",new Date(),false,112));
            patientRepository.save(
                    new Patient(null,"Samira",new Date(),true,150));
            patientRepository.save(
                    new Patient(null,"Khawla",new Date(),true,113));
            patientRepository.save(
                    new Patient(null,"Youssef",new Date(),false,115));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
   // @Bean
    CommandLineRunner saveUsers(SecurityService securityService){

        return args -> {
            securityService.saveNewUser("Chaimaa","1234","1234");
            securityService.saveNewUser("Samira","1234","1234");
            securityService.saveNewUser("Khawla","1234","1234");

              securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("Chaimaa","USER");
            securityService.addRoleToUser("Chaimaa","ADMIN");
            securityService.addRoleToUser("Samira","USER");
            securityService.addRoleToUser("Khawla","USER");

        };
    }
}
