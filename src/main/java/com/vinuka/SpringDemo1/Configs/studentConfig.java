package com.vinuka.SpringDemo1.Configs;

import com.vinuka.SpringDemo1.Models.student;
import com.vinuka.SpringDemo1.Repos.studentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentConfig {
    @Bean
   CommandLineRunner commandLineRunner(studentRepo studentRep){
        return args -> {
            student s1=new student(
               "Marium","marium.jamal@gmail.com", LocalDate.of(2000,Month.JANUARY,5)
             );
            student s2=new student(
                    "Alex","Alex.jamal@gmail.com", LocalDate.of(1998,Month.JANUARY,6)
            );
            student s3=new student(
                    "shane","shane.jamal@gmail.com", LocalDate.of(2005,Month.JANUARY,5)
            );

          studentRep.saveAll(
                  List.of(s1,s2,s3)
         );
       };
  }
}
