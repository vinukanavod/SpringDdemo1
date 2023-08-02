package com.vinuka.SpringDemo1.Services;

import com.vinuka.SpringDemo1.Models.student;
import com.vinuka.SpringDemo1.Repos.studentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component //@Service thuth daaanna puluwan methenta
public class studentService {
    private final studentRepo studentRep;
 @Autowired
    public studentService(studentRepo studentRepo) {
        this.studentRep = studentRepo;
    }

    public List<student> GetStudent() {
       return  studentRep.findAll();

    }

    public void addNewStudent(student student) throws IllegalAccessException {
       Optional<student> studentByEmail = studentRep.findstudentByEmail(student.getEmail());
       if(studentByEmail.isPresent()){
           throw new IllegalAccessException("email taken");

       }
       studentRep.save(student);

        // System.out.println(student);

    }

    public void deleteStudent(Long id) throws IllegalAccessException {
     boolean a =studentRep.existsById(id);
     if(!a){
         throw  new IllegalAccessException( id +  "  ID Does not exist");
     }
     studentRep.deleteById(id);
    }
@Transactional
    public void updateStudent(Long studentId, String name, String email) throws IllegalAccessException {
        student student = studentRep.findById(studentId)
                .orElseThrow( ()->new IllegalStateException(
                        "Student with id"+ studentId + "does not exist"
                )  );
           if(name != null && name.length()>0 && !Objects.equals(student.getName(),name)){
               student.setName(name);
           }
           if(email != null && !Objects.equals(student.getEmail(),email)){
               Optional<student> studentOptional = studentRep.findstudentByEmail(email);
               if(studentOptional.isPresent()){
                   throw new IllegalAccessException("email taken");
               }
               student.setEmail(email);

           }

    }
}
